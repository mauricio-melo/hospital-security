package com.mmelo.hospitalsecurity.web.controller;

import com.mmelo.hospitalsecurity.domain.UserDTO;
import com.mmelo.hospitalsecurity.service.UserService;
import com.mmelo.hospitalsecurity.web.request.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(UserController.USER_ENDPOINT)
public class UserController {

    public static final String USER_ENDPOINT = "/user";
    private final UserService service;
    private final ModelMapper modelMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody final UserRequestDTO requestDTO) {
        final UserDTO dto = this.service.save(modelMapper.map(requestDTO, UserDTO.class), requestDTO.getProfileType());
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
