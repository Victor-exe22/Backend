package com.example.demo.service;

import com.example.demo.data.entities.UserEntity;
import com.example.demo.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> getUser(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user;
        }
        return null;
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity deleteUser(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


}
