package com.example.secureddbrecreated.security.service.impl;

import com.example.secureddbrecreated.security.dto.UserRequestDTO;
import com.example.secureddbrecreated.security.dto.UserResponseDTO;
import com.example.secureddbrecreated.security.entity.Member;
import com.example.secureddbrecreated.security.mapper.UserMapper;
import com.example.secureddbrecreated.security.service.UserService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.secureddbrecreated.security.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponseDTO create(final UserRequestDTO rq) {
        final Member member = UserMapper.toEntity(rq);
        final Member result = this.repository.save(member);
        return UserMapper.toResponse(result);
    }
}
