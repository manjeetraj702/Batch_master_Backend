package com.example.batchmaster.service.impl;

import com.example.batchmaster.exception.BatchMasterException;
import com.example.batchmaster.model.User;
import com.example.batchmaster.model.request.UserCreateRequest;
import com.example.batchmaster.model.updaterequest.UserUpdateRequest;
import com.example.batchmaster.repository.UserRepository;
import com.example.batchmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; // Injected via constructor
    }

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        if (userCreateRequest == null) {
            throw new BatchMasterException("UserCreateRequest cannot be null");
        }

        // Check if a user with the same email already exists
        if (userRepository.findByEmail(userCreateRequest.getEmail()) != null) {
            throw new BatchMasterException("User with email '" + userCreateRequest.getEmail() + "' already exists");
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
        if (!passwordEncoder.matches(password, user.getPassword())) { // Use matches() for comparing
            throw new BatchMasterException("Invalid email or password");
        }
        return user;
    }

    @Override
    public void updatePassword(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new BatchMasterException("Invalid email");
        }
        user.setPassword(passwordEncoder.encode(password)); // Encode password here
        userRepository.save(user);
    }


}
