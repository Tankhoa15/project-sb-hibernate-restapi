package com.ntkhoa.jpa.controller;

import com.ntkhoa.jpa.dto.UserCreationRequest;
import com.ntkhoa.jpa.entity.User;
import com.ntkhoa.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUse(request);
    }
}
