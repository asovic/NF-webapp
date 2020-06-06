package com.andrej.test.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.andrej.test.entities.UserEntity;
import com.andrej.test.repository.UserRepository;
import com.andrej.test.repository.UserRolesRepository;

public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolesRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Override
	public void save(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
	}

	@Override
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
