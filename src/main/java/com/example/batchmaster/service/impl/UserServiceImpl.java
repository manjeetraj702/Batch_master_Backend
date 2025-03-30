package com.example.batchmaster.service.impl;

import com.example.batchmaster.model.User;
import com.example.batchmaster.model.request.UserCreateRequest;
import com.example.batchmaster.model.updaterequest.UserUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.batchmaster.repository.UserRepository;
import com.example.batchmaster.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
// Code fixed based on review requirements

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        if (userCreateRequest == null) {
            throw new IllegalArgumentException("UserCreateRequest cannot be null");
        }
        User user = new User();
        user.setUsername(userCreateRequest.getUsername());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(userCreateRequest.getPassword());
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
        return null;
    }


}
