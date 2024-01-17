package com.vti.steel.repository;

import com.vti.steel.entity.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccessoryRepository extends JpaRepository<Accessory,Long>, JpaSpecificationExecutor<Accessory> {
}
