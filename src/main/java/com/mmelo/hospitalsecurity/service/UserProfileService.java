package com.mmelo.hospitalsecurity.service;

import com.mmelo.hospitalsecurity.repository.UserProfileRepository;
import com.mmelo.hospitalsecurity.repository.entities.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository repository;

    public UserProfile save(final UserProfile userProfile) {
        return repository.save(userProfile);
    }

    public List<UserProfile> findByEmail(final String email) {
        return repository.findByUser_emailIgnoreCase(email);
    }
}
