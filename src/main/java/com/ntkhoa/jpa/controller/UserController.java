package com.ntkhoa.jpa.controller;

import com.ntkhoa.jpa.dto.UserCreationRequest;
import com.ntkhoa.jpa.entity.User;
import com.ntkhoa.jpa.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUse(request);
    }

    @GetMapping
    List<User> getAllUser(){
        return userService.getUser();
    }

}
