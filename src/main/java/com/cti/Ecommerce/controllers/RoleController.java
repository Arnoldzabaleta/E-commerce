package com.cti.Ecommerce.controllers;

import com.cti.Ecommerce.models.dto.requestDto.RoleRequestDto;
import com.cti.Ecommerce.models.entities.Permission;
import com.cti.Ecommerce.models.entities.Role;
import com.cti.Ecommerce.request_setting.RequestResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "RoleController SESSION  REST CONTROLLER", description = "This is rest controllers of workout session")
@RequestMapping("/api/admin/roles")
public interface RoleController {

    @Operation(summary = "Endpoint to create a role")
    @PostMapping("/createRole")
    RequestResult<Role> createRole(@RequestBody RoleRequestDto request);

    @Operation(summary = "Endpoint to update a role")
    @PutMapping("/updateRole/{id}")
    RequestResult<Role> updateRole(@PathVariable String id, @RequestBody RoleRequestDto request);

    @Operation(summary = "Endpoint to find a role by it's id")
    @GetMapping("/getRole/{id}")
    RequestResult<Role> findRoleById(@PathVariable String id);

    @Operation(summary = "Endpoint to find all roles")
    @GetMapping("/allRoles")
    RequestResult<List<Role>> findAllRoles();

    @Operation(summary = "Endpoint to delete a role by it's id")
    @DeleteMapping("/deleteRole/{id}")
    RequestResult<Void> deleteRole(@PathVariable String id);

    @Operation(summary = "Endpoint to delete a list of roles by specifying their ids")
    @DeleteMapping("/deleteRoles")
    RequestResult<Void> deleteRoles(@RequestBody List<String> ids);

    @Operation(summary = "Endpoint to find all permissions")
    @GetMapping("/allPermissions")
    RequestResult<List<Permission>> findAllPermissions();
}
