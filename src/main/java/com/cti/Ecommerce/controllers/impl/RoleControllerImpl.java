package com.cti.Ecommerce.controllers.impl;

import com.cti.Ecommerce.controllers.RoleController;
import com.cti.Ecommerce.models.dto.requestDto.RoleRequestDto;
import com.cti.Ecommerce.models.entities.Permission;
import com.cti.Ecommerce.models.entities.Role;
import com.cti.Ecommerce.request_setting.RequestResult;
import com.cti.Ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleControllerImpl implements RoleController {

    @Autowired
    private  RoleService service;


    @Override
    public RequestResult<Role> createRole(RoleRequestDto request) {
        return service.createRole(request);
    }

    @Override
    public RequestResult<Role> updateRole(String id, RoleRequestDto request) {
        return service.updateRole(id,request);
    }

    @Override
    public RequestResult<Role> findRoleById(String id) {
        return service.findRoleById(id);
    }

    @Override
    public RequestResult<List<Role>> findAllRoles() {
        return service.findAllRoles();
    }

    @Override
    public RequestResult<Void> deleteRole(String id) {
        return service.deleteRole(id);
    }

    @Override
    public RequestResult<Void> deleteRoles(List<String> ids) {
        return service.deleteRoles(ids);
    }

    @Override
    public RequestResult<List<Permission>> findAllPermissions() {
        return service.findAllPermissions();
    }
}
