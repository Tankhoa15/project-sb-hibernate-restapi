package com.ntkhoa.jpa.service.impl;

import com.ntkhoa.jpa.dto.request.UserCreationRequest;
import com.ntkhoa.jpa.dto.request.UserUpdateRequest;
import com.ntkhoa.jpa.dto.response.UserResponse;
import com.ntkhoa.jpa.entity.User;
import com.ntkhoa.jpa.enums.Role;
import com.ntkhoa.jpa.exception.AppException;
import com.ntkhoa.jpa.exception.ErrorCode;
import com.ntkhoa.jpa.mapper.UserMapper;
import com.ntkhoa.jpa.repository.UserRepository;
import com.ntkhoa.jpa.service.UserService;
import java.util.HashSet;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepo;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        if(userRepo.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        //hash password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());

        user.setRoles(roles);

        return userMapper.toUserResponse(userRepo.save(user));
    }

    public List<UserResponse> getUsers(){
        return userRepo.findAll().stream()
            .map(userMapper::toUserResponse).toList();
    }


    public UserResponse getUser(Long id){
        return userMapper.toUserResponse(userRepo.findById(id).
                orElseThrow(() -> new RuntimeException("User not found")));
    }


    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest request) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepo.save(user));
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
