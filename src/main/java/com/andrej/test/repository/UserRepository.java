package com.andrej.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrej.test.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
	UserEntity findByUsername(String username);
}
