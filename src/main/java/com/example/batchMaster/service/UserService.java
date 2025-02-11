package com.example.batchMaster.service;

import com.example.batchMaster.model.User;
import com.example.batchMaster.model.request.UserCreateRequest;
import com.example.batchMaster.model.updateRequest.UserUpdateRequest;

import java.util.List;

public interface UserService {
    User createUser(UserCreateRequest userCreateRequest);

    User updateUser(String userId, UserUpdateRequest userUpdateRequest);

    User getUserById(String userId);

    List<User> getAllUsers();


}
