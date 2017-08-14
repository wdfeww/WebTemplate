package com.project.webtemplate.config.jwt.service;

import com.project.webtemplate.config.jwt.JwtUserFactory;
import com.project.webtemplate.entities.User;
import com.project.webtemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user != null){
            return JwtUserFactory.create(user);
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
