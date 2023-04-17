package com.example.demo.config;

import com.example.demo.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthUserUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new AuthUserUserDetails(
                repository.findByUsername(username)
                        .orElseThrow(()-> new UsernameNotFoundException("User Name Not Found"))
        );
    }
}
