package com.ntkhoa.jpa.controller;

import com.ntkhoa.jpa.dto.request.ApiResponse;
import com.ntkhoa.jpa.dto.request.PermissionRequest;
import com.ntkhoa.jpa.dto.request.RoleRequest;
import com.ntkhoa.jpa.dto.response.PermissionResponse;
import com.ntkhoa.jpa.dto.response.RoleResponse;
import com.ntkhoa.jpa.service.PermissionService;
import com.ntkhoa.jpa.service.RoleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request){
        return ApiResponse.<RoleResponse>builder()
            .result(roleService.create(request))
            .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll(){
        return ApiResponse.<List<RoleResponse>>builder()
            .result(roleService.getAll())
            .build();
    }

}

