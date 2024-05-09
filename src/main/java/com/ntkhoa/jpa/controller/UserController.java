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

    // build add user RESTfull api
    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUse(request);
    }

    // build get all user RESTfull api
    @GetMapping
    List<User> getAllUser(){
        return userService.getUsers();
    }

    /*
    // get all user = annotation @PostMapping
    @PostMapping("/getAll")
    List<User> getAllUser(){
        return userService.getUser();
    }
     */

    // build get user by id RESTfull api
    @GetMapping("/{id}")
    User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

}
