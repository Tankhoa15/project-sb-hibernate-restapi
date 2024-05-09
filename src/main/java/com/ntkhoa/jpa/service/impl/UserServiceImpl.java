package com.ntkhoa.jpa.service.impl;

import com.ntkhoa.jpa.dto.UserCreationRequest;
import com.ntkhoa.jpa.dto.UserUpdateRequest;
import com.ntkhoa.jpa.entity.User;
import com.ntkhoa.jpa.repository.UserRepository;
import com.ntkhoa.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUse(UserCreationRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUser(Long id){
        return userRepo.findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
    }


    @Override
    public User updateUse(Long id, UserUpdateRequest request) {
        User user = getUser(id);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepo.save(user);
    }
}
