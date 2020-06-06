package com.andrej.test.service;

import com.andrej.test.entities.UserEntity;

public interface UserService {
    void save(UserEntity user);

    UserEntity findByUsername(String username);
}
