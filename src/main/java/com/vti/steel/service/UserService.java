package com.vti.steel.service;

import com.vti.steel.dto.UserDto;
import com.vti.steel.form.UserCreateForm;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto create(UserCreateForm form);

}
