package com.bikas23m.thinkify.service;

import com.bikas23m.thinkify.entity.User;
import com.bikas23m.thinkify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.addUser(user);
    }

}
