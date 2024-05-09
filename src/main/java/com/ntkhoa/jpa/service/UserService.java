package com.ntkhoa.jpa.service;

import com.ntkhoa.jpa.dto.UserCreationRequest;
import com.ntkhoa.jpa.dto.UserUpdateRequest;
import com.ntkhoa.jpa.entity.User;

public interface UserService {

    User createUse(UserCreationRequest request);

    User updateUse(Long id, UserUpdateRequest request);
}
