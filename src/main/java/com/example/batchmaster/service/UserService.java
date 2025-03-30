package com.example.batchmaster.service;

import com.example.batchmaster.model.User;
import com.example.batchmaster.model.request.UserCreateRequest;
import com.example.batchmaster.model.updaterequest.UserUpdateRequest;

import java.util.List;

public interface UserService {
    User createUser(UserCreateRequest userCreateRequest);

    User updateUser(String userId, UserUpdateRequest userUpdateRequest);

    User getUserById(String userId);

    List<User> getAllUsers();

    User login(String email, String password);


}
