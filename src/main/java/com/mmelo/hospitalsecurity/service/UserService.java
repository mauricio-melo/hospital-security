package com.mmelo.hospitalsecurity.service;

import com.mmelo.hospitalsecurity.domain.UserDTO;
import com.mmelo.hospitalsecurity.enumerator.ProfileType;
import com.mmelo.hospitalsecurity.repository.UserRepository;
import com.mmelo.hospitalsecurity.repository.entities.Profile;
import com.mmelo.hospitalsecurity.repository.entities.User;
import com.mmelo.hospitalsecurity.repository.entities.UserProfile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final UserProfileService userProfileService;
    private final ProfileService profileService;
    private final ModelMapper modelMapper;

    public UserDTO save(final UserDTO userDTO, final ProfileType type) {
        final User user = repository.save(User.builder()
                .email(userDTO.getEmail())
                .password(new BCryptPasswordEncoder().encode(userDTO.getPassword()))
                .build());

        userProfileService.save(UserProfile.builder()
                .user(user)
                .profile(modelMapper.map(profileService.findByDescription(type), Profile.class))
                .build());

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(final String emailUser) throws UsernameNotFoundException {
        log.info("m=loadUserByUsername, status=authenticate, username={}", emailUser);
        final List<UserProfile> userProfiles = userProfileService.findByEmail(emailUser);
        if(userProfiles.isEmpty()) {
            log.info("m=loadUserByUsername, status=not-found, username={}", emailUser);
            throw new BadCredentialsException("Bad credentials");
        }

        final org.springframework.security.core.userdetails.User user = createUserDetails(userProfiles);
        log.info("m=loadUserByUsername, username={}, user-details={}, status=success", emailUser, user);

        return user;
    }

    private org.springframework.security.core.userdetails.User createUserDetails(final List<UserProfile> userProfiles) {
        final Optional<User> user = userProfiles.stream().findFirst().map(UserProfile::getUser);
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),
                user.get().getPassword(),
                AuthorityUtils.createAuthorityList(getAuthorities(userProfiles)));
    }

    private String[] getAuthorities(final List<UserProfile> userProfiles) {
        return userProfiles
                .stream().map(userProfile -> userProfile.getProfile().getDescription())
                .toArray(String[]::new);
    }
}
