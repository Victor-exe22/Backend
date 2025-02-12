package com.example.demo.controllers;


import com.example.demo.data.entities.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Optional<UserEntity> getUser(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.saveUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(user);
    }

    @DeleteMapping("/deleteUser")
    public UserEntity deleteUser(@RequestBody UserEntity user) {
        return userService.deleteUser(user.getId());
    }

    @GetMapping("/users")
    private List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }




}
