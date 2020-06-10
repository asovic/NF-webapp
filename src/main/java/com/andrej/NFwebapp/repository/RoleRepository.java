package com.andrej.NFwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andrej.NFwebapp.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
	@Query(value="select r from role r where r.id = '1'")
	List<RoleEntity> userRole();
}