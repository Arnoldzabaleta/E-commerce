package com.cti.Ecommerce.service.impl;

import com.cti.Ecommerce.exceptionHandler.exceptions.ResourceNotFoundException;
import com.cti.Ecommerce.models.dto.requestDto.RoleRequestDto;
import com.cti.Ecommerce.models.entities.Permission;
import com.cti.Ecommerce.models.entities.Role;
import com.cti.Ecommerce.repository.PermissionRepository;
import com.cti.Ecommerce.repository.RoleRepository;
import com.cti.Ecommerce.request_setting.RequestResult;
import com.cti.Ecommerce.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.cti.Ecommerce.request_setting.RequestResultConstant.RESULT_CODE_ALL_IS_CORRECT;

@Component
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);


@Autowired
private PermissionRepository permissionRepository;

@Autowired
private  RoleRepository roleRepository;

    @Override
    public RequestResult<Role> createRole(RoleRequestDto request) {
        logger.info("Attempting to create a new role");

        List<Permission> permissions = findPermissions(request.getPermissionIds());
        var role = Role.builder()
                .id("Role_" + System.currentTimeMillis())
                .name(request.getName())
                .description(request.getDescription())
                .permissions(permissions)
                .build();
        var savedRole = roleRepository.save(role);

        logger.info("Role successfully created with name: {}", savedRole.getName());
        return RequestResult.success(savedRole, RESULT_CODE_ALL_IS_CORRECT);
    }

    @Override
    public RequestResult<Role> findRoleById(String id){
        var role =  roleRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Role not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Role",
                            "RoleId",
                            id
                    );
                });
        return RequestResult.success(role, RESULT_CODE_ALL_IS_CORRECT);
    }

    @Override
    public RequestResult<Role> updateRole(String id,RoleRequestDto request) {
        logger.info("Attempting to update Role with id: {}", id);

        var role =  findRoleById(id).getData();
        role.setName(request.getName());

        List<Permission> permissions = findPermissions(request.getPermissionIds());
        role.setPermissions(permissions);
        var savedRole = roleRepository.save(role);

        logger.info("Role with id {} successfully updated", id);
        return RequestResult.success(savedRole, RESULT_CODE_ALL_IS_CORRECT);
    }

    @Override
    public RequestResult<List<Role>> findAllRoles() {

        return RequestResult.success(roleRepository.findAll(), RESULT_CODE_ALL_IS_CORRECT);
    }

    @Override
    public RequestResult<Void> deleteRole(String id) {

        roleRepository.deleteById(id);
        logger.info("Role with id {} successfully deleted", id);
        return RequestResult.success(null, RESULT_CODE_ALL_IS_CORRECT);
    }

    @Override
    public RequestResult<Void> deleteRoles(List<String> ids) {
        roleRepository.deleteAllById(ids);
        logger.info("Roles with specified id successfully deleted");
        return RequestResult.success(null, RESULT_CODE_ALL_IS_CORRECT);
    }

    private List<Permission> findPermissions(List<String> permissionIds){
        return permissionRepository.findByIdIn(permissionIds);
    }

    @Override
    public RequestResult<List<Permission>> findAllPermissions(){

        return RequestResult.success(permissionRepository.findAll(), RESULT_CODE_ALL_IS_CORRECT);
    }

}
