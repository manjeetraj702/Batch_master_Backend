package com.example.batchmaster.service.impl;

import com.example.batchmaster.model.User;
import com.example.batchmaster.model.request.UserCreateRequest;
import com.example.batchmaster.model.updaterequest.UserUpdateRequest;
import com.example.batchmaster.repository.UserRepository;
import com.example.batchmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        if (userCreateRequest == null) {
            throw new IllegalArgumentException("UserCreateRequest cannot be null");
        }
        User user = new User();
        user.setUsername(userCreateRequest.getUsername());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword())); // Encode password here
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String userId, UserUpdateRequest userUpdateRequest) {
        if (userUpdateRequest == null) {
            throw new IllegalArgumentException("UserUpdateRequest cannot be null");
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setUsername(userUpdateRequest.getUsername());
        user.setEmail(userUpdateRequest.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        System.out.println(user.getUsername());
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) { // Use matches() for comparing
            throw new IllegalArgumentException("Invalid email or password");
        }
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList() // You can add roles or authorities here if needed
        );
    }


}
