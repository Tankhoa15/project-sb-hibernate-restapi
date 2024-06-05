package com.ntkhoa.jpa.mapper;

import com.ntkhoa.jpa.dto.request.UserCreationRequest;
import com.ntkhoa.jpa.dto.request.UserUpdateRequest;
import com.ntkhoa.jpa.dto.response.UserResponse;
import com.ntkhoa.jpa.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    /*
        method toUser : nhận request kiểu UserCreationRequest
            và trả về class User


     */
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
