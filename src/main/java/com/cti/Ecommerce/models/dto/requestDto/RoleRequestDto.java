package com.cti.Ecommerce.models.dto.requestDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestDto {

    @NotEmpty
    private String name;
    private String description;
    private List<String> permissionIds;
}
