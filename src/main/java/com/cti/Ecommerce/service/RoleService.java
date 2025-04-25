package com.cti.Ecommerce.service;

import com.cti.Ecommerce.models.dto.requestDto.RoleRequestDto;
import com.cti.Ecommerce.models.entities.Permission;
import com.cti.Ecommerce.models.entities.Role;
import com.cti.Ecommerce.request_setting.RequestResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {


    RequestResult<Role> createRole(RoleRequestDto request);

    RequestResult<Role> findRoleById(String id);

    RequestResult<Role> updateRole(String id, RoleRequestDto request);

    RequestResult<List<Role>> findAllRoles();

    RequestResult<Void> deleteRole(String id);

    RequestResult<Void> deleteRoles(List<String> ids);


    RequestResult<List<Permission>> findAllPermissions();
}
