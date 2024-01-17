package com.vti.steel.dto;

import com.vti.steel.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    private Long id;
    private Role.Type type;
}
