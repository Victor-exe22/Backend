package com.example.demo.service;

import com.example.demo.data.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<UserEntity> getUser(Long id);

    UserEntity saveUser(UserEntity user);

    UserEntity deleteUser(Long id);

    List<UserEntity> getAllUsers();
}
