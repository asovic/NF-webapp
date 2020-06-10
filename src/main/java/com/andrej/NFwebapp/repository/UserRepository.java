package com.andrej.NFwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrej.NFwebapp.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
	UserEntity findByUsername(String username);
}
