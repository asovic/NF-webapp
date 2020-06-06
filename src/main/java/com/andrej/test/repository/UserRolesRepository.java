package com.andrej.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrej.test.entities.UserRolesEntity;

public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long>{
	
}
