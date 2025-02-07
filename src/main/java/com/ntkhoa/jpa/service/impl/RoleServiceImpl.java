package com.ntkhoa.jpa.service.impl;

import com.ntkhoa.jpa.dto.request.RoleRequest;
import com.ntkhoa.jpa.dto.response.RoleResponse;
import com.ntkhoa.jpa.mapper.RoleMapper;
import com.ntkhoa.jpa.repository.PermissionRepository;
import com.ntkhoa.jpa.repository.RoleRepository;
import com.ntkhoa.jpa.service.PermissionService;
import com.ntkhoa.jpa.service.RoleService;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final PermissionRepository permissionRepository;

    @Override
    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
            .stream()
            .map(roleMapper::toRoleResponse)
            .toList();
    }
}
