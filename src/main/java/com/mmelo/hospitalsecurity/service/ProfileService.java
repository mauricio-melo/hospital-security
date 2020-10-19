package com.mmelo.hospitalsecurity.service;

import com.mmelo.hospitalsecurity.domain.ProfileDTO;
import com.mmelo.hospitalsecurity.enumerator.ProfileType;
import com.mmelo.hospitalsecurity.exception.ResourceNotFoundException;
import com.mmelo.hospitalsecurity.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository repository;
    private final ModelMapper modelMapper;

    public List<ProfileDTO> findAll() {
        return repository.findAll().stream()
                .map(profile -> modelMapper.map(profile, ProfileDTO.class))
                .collect(Collectors.toList());
    }

    public ProfileDTO findByDescription(final ProfileType profileType) {
        return modelMapper.map(repository.findByDescription(profileType.toString())
                .orElseThrow(ResourceNotFoundException::new), ProfileDTO.class);
    }
}
