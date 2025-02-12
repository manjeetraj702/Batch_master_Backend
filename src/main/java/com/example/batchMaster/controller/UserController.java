package com.example.batchMaster.controller;

import com.example.batchMaster.model.User;
import com.example.batchMaster.model.request.UserCreateRequest;
import com.example.batchMaster.model.updateRequest.UserUpdateRequest;
import com.example.batchMaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return userService.createUser(userCreateRequest);
    }

    @PutMapping("/update/userId")
    public User updateUser(@RequestParam String userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.updateUser(userId, userUpdateRequest);
    }

    @GetMapping("/userId")
    public User getUserById(@RequestParam String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
