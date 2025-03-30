package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.User;
import com.example.batchmaster.model.request.UserCreateRequest;
import com.example.batchmaster.model.updaterequest.UserUpdateRequest;
import com.example.batchmaster.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/create")
    public ApiResponse<User> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.createUser(userCreateRequest);
        return new ApiResponse<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ApiResponse<User> login(String email, String password) {
        User user = userService.login(email, password);
        return new ApiResponse<>(user, HttpStatus.OK);
    }

    // Update an existing user
    @PutMapping("/update/userId")
    public ApiResponse<User> updateUser(@RequestParam String userId, @Valid @RequestBody UserUpdateRequest userUpdateRequest) {
        User updatedUser = userService.updateUser(userId, userUpdateRequest);
        return new ApiResponse<>(updatedUser, HttpStatus.OK);
    }

    // Get user details by  ID
    @GetMapping("/userId")
    public ApiResponse<User> getUserById(@RequestParam String userId) {
        User user = userService.getUserById(userId);
        return new ApiResponse<>(user, HttpStatus.OK);
    }

    // Get all users
    @GetMapping("/getAllUsers")
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ApiResponse<>(users, HttpStatus.OK);
    }

}
