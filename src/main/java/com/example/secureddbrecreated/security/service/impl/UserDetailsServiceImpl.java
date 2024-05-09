package com.example.secureddbrecreated.security.service.impl;

import com.example.secureddbrecreated.security.entity.MyUserDetails;
import com.example.secureddbrecreated.security.entity.Member;
import com.example.secureddbrecreated.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Member member = this.repository.findByUsername(username);
        if(member == null) {
            throw new UsernameNotFoundException("Unknown user "+ username);
        }

         UserDetails x = new MyUserDetails("user");
        System.out.println(x);
        return x;
    }

}
