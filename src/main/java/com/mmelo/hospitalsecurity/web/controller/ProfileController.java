package com.mmelo.hospitalsecurity.web.controller;

import com.mmelo.hospitalsecurity.domain.ProfileDTO;
import com.mmelo.hospitalsecurity.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(ProfileController.PROFILE_ENDPOINT)
public class ProfileController {

    public static final String PROFILE_ENDPOINT = "/profile";
    private final ProfileService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ProfileDTO> findAll() {
        return service.findAll();
    }
}
