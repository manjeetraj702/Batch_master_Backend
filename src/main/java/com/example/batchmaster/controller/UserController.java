package com.example.batchmaster.controller;

import com.example.batchmaster.base.ApiResponse;
import com.example.batchmaster.model.User;
import com.example.batchmaster.model.request.UserCreateRequest;
import com.example.batchmaster.model.updaterequest.UserUpdateRequest;
import com.example.batchmaster.service.UserService;
import com.example.batchmaster.service.impl.UserDetailService;
import com.example.batchmaster.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailService userDetailService;

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailService userDetailService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailService = userDetailService;
    }

    // Create a new user
    @PostMapping("/create")
    public ApiResponse<User> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.createUser(userCreateRequest);
        return new ApiResponse<>(user, HttpStatus.CREATED);
    }

    // User Login
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestParam String email, @RequestParam String password) throws AuthenticationException {
        System.out.println("hello");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            System.out.println(email);
            final UserDetails userDetails = userDetailService.loadUserByUsername(email);
            System.out.println(userDetails.getUsername());// Make sure this is implemented correctly
            final String jwt = jwtUtil.generateToken(userDetails);
            return new ApiResponse<>(jwt, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ApiResponse<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    // Update an existing user
    @PutMapping("/update/{userId}")
    public ApiResponse<User> updateUser(@PathVariable String userId, @Valid @RequestBody UserUpdateRequest userUpdateRequest) {
        User updatedUser = userService.updateUser(userId, userUpdateRequest);
        return new ApiResponse<>(updatedUser, HttpStatus.OK);
    }

    // Get user details by ID
    @GetMapping("/get/{userId}")
    public ApiResponse<User> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return new ApiResponse<>(user, HttpStatus.OK);
    }

    // Get all users
    @GetMapping("/getAllUsers")
    public ApiResponse<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        return new ApiResponse<>(users, HttpStatus.OK);
    }

    @PutMapping("/updatePassword")
    public void updatePassword(@RequestParam String email, @RequestParam String password) {
        userService.updatePassword(email, password);
    }
}
