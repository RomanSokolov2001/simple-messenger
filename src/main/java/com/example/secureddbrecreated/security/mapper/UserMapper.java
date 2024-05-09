package com.example.secureddbrecreated.security.mapper;

import com.example.secureddbrecreated.security.dto.UserRequestDTO;
import com.example.secureddbrecreated.security.dto.UserResponseDTO;
import com.example.secureddbrecreated.security.entity.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static Member toEntity(final UserRequestDTO dto) {
        return Member.builder()
                .username(dto.getUsername())
                .password(encoder.encode(dto.getPassword()))
                .build();
    }

    public static UserResponseDTO toResponse(final Member entity) {
        return UserResponseDTO.builder()
                .username(entity.getUsername())
                .build();
    }
}
