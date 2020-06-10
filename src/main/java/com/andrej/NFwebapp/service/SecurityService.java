package com.andrej.NFwebapp.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
