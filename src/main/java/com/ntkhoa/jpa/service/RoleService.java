package com.ntkhoa.jpa.service;

import com.ntkhoa.jpa.dto.request.RoleRequest;
import com.ntkhoa.jpa.dto.response.RoleResponse;
import java.util.List;

public interface RoleService {
    RoleResponse create(RoleRequest request);
    List<RoleResponse> getAll();
}
