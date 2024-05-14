package com.ntkhoa.jpa.controller;

import com.ntkhoa.jpa.dto.request.ApiResponse;
import com.ntkhoa.jpa.dto.request.UserCreationRequest;
import com.ntkhoa.jpa.dto.request.UserUpdateRequest;
import com.ntkhoa.jpa.dto.response.UserResponse;
import com.ntkhoa.jpa.entity.User;
import com.ntkhoa.jpa.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
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
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUse(request));
        return apiResponse;
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
    UserResponse getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    // build update user RESTful api
    @PutMapping("/{id}")
    UserResponse updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateRequest request){
        return userService.updateUse(id,request);
    }

    // build delete user RESTful api
    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "Delete success";
    }
}
