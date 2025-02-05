package com.ntkhoa.jpa.service.impl;

import com.ntkhoa.jpa.dto.request.PermissionRequest;
import com.ntkhoa.jpa.dto.response.PermissionResponse;
import com.ntkhoa.jpa.entity.Permission;
import com.ntkhoa.jpa.mapper.PermissionMapper;
import com.ntkhoa.jpa.repository.PermissionRepository;
import com.ntkhoa.jpa.service.PermissionService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }



/*

permissions.stream(): Chuyển đổi danh sách permissions thành một Stream,
                            giúp xử lý dữ liệu theo kiểu lập trình hàm.
.map(permissionMapper::toPermissionResponse): map() áp dụng một hàm (toPermissionResponse)
trên từng phần tử trong permissions.
permissionMapper::toPermissionResponse là một method reference đến
                phương thức toPermissionResponse() của permissionMapper,
               dùng để chuyển đổi một đối tượng Permission thành PermissionResponse.
.toList(): Chuyển đổi lại Stream<PermissionResponse> thành một
    List<PermissionResponse> để trả về kết quả.
 */
}
