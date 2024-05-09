package com.example.secureddbrecreated.security.service;

import com.example.secureddbrecreated.security.dto.UserRequestDTO;
import com.example.secureddbrecreated.security.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO create(final UserRequestDTO rq);
}
