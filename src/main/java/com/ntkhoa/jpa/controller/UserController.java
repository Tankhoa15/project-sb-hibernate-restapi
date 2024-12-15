package com.ntkhoa.jpa.controller;

import com.ntkhoa.jpa.dto.request.ApiResponse;
import com.ntkhoa.jpa.dto.request.UserCreationRequest;
import com.ntkhoa.jpa.dto.request.UserUpdateRequest;
import com.ntkhoa.jpa.dto.response.UserResponse;
import com.ntkhoa.jpa.entity.User;
import com.ntkhoa.jpa.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {

    UserServiceImpl userService;

    // build add user RESTfull api
    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        return ApiResponse.<UserResponse>builder()
            .result(userService.createUser(request))
            .build();
    }

    // build get all user RESTfull api
    @GetMapping
    ApiResponse<List<UserResponse>> getUsers(){

        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
            .result(userService.getUsers())
            .build();
    }

    // build get user by id RESTfull api
    @GetMapping("/{id}")
    ApiResponse<UserResponse> getUser(@PathVariable("id") Long id){
        //return userService.getUser(id);
        return ApiResponse.<UserResponse>builder()
            .result(userService.getUser(id))
            .build();
    }

    // build update user RESTful api
    @PutMapping("/{id}")
    ApiResponse<UserResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateRequest request){
        return ApiResponse.<UserResponse>builder()
            .result(userService.updateUser(id, request))
            .build();
    }

    // build delete user RESTful api
    @DeleteMapping("/{id}")
    ApiResponse<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ApiResponse.<String>builder()
            .result("User has been deleted")
            .build();
    }
}
