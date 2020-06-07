package com.andrej.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrej.test.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
}
