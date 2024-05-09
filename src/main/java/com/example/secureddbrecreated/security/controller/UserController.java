package com.example.secureddbrecreated.security.controller;

import com.example.secureddbrecreated.security.dto.UserRequestDTO;
import com.example.secureddbrecreated.security.dto.UserResponseDTO;
import com.example.secureddbrecreated.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(final @Valid @RequestBody UserRequestDTO rq) {
        return new ResponseEntity<>(this.service.create(rq), HttpStatus.CREATED);
    }
}
