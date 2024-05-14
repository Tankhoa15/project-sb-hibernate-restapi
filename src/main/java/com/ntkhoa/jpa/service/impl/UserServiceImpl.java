package com.ntkhoa.jpa.service.impl;

import com.ntkhoa.jpa.dto.request.UserCreationRequest;
import com.ntkhoa.jpa.dto.request.UserUpdateRequest;
import com.ntkhoa.jpa.dto.response.UserResponse;
import com.ntkhoa.jpa.entity.User;
import com.ntkhoa.jpa.exception.AppException;
import com.ntkhoa.jpa.exception.ErrorCode;
import com.ntkhoa.jpa.mapper.UserMapper;
import com.ntkhoa.jpa.repository.UserRepository;
import com.ntkhoa.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse createUse(UserCreationRequest request) {
        if(userRepo.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);

        return userMapper.toUserResponse(userRepo.save(user));
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public UserResponse getUser(Long id){
        return userMapper.toUserResponse(userRepo.findById(id).
                orElseThrow(() -> new RuntimeException("User not found")));
    }


    @Override
    public UserResponse updateUse(Long id, UserUpdateRequest request) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepo.save(user));
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
