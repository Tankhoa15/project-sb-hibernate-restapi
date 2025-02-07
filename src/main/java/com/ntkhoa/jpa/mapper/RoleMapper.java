package com.ntkhoa.jpa.mapper;

import com.ntkhoa.jpa.dto.request.PermissionRequest;
import com.ntkhoa.jpa.dto.request.RoleRequest;
import com.ntkhoa.jpa.dto.response.PermissionResponse;
import com.ntkhoa.jpa.dto.response.RoleResponse;
import com.ntkhoa.jpa.entity.Permission;
import com.ntkhoa.jpa.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
