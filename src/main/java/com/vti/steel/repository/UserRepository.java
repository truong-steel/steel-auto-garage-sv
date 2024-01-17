package com.vti.steel.repository;

import com.vti.steel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);
}
