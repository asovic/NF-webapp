package com.andrej.NFwebapp.service;

import com.andrej.NFwebapp.entities.UserEntity;

public interface UserService {
    void save(UserEntity user);

    UserEntity findByUsername(String username);
}
