package com.ntkhoa.jpa.service;

import com.ntkhoa.jpa.dto.request.UserCreationRequest;
import com.ntkhoa.jpa.dto.request.UserUpdateRequest;
import com.ntkhoa.jpa.dto.response.UserResponse;

public interface UserService {

    UserResponse createUse(UserCreationRequest request);

    UserResponse updateUse(Long id, UserUpdateRequest request);
}
