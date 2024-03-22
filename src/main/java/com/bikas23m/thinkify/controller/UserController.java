package com.bikas23m.thinkify.controller;

import com.bikas23m.thinkify.dtos.UserDto;
import com.bikas23m.thinkify.entity.User;
import com.bikas23m.thinkify.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        return ResponseEntity.ok(userService.createUser(user));

    }
}
