package com.wecp.progressive.service.impl;

import com.wecp.progressive.dto.UserRegistrationDTO;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.repository.StudentRepository;
import com.wecp.progressive.repository.TeacherRepository;
import com.wecp.progressive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserLoginServiceImpl(UserRepository userRepository,
                                StudentRepository studentRepository,
                                TeacherRepository teacherRepository,
                                PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegistrationDTO userRegistrationDTO) throws Exception {

    }


    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserDetails(int userId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        return null;
    }
}
