package com.wecp.progressive.service.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wecp.progressive.dto.UserRegistrationDTO;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.repository.UserRepository;

public class UserLoginServiceImpl {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void registerUser(UserRegistrationDTO userRegistrationDTO) throws Exception {

    }

    public User getUserDetails(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
    }
}
