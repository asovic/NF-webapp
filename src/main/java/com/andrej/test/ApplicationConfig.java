package com.andrej.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.andrej.test.service.UserServiceImpl;
import com.andrej.test.validator.UserValidator;

@Configuration
@EnableJpaRepositories
public class ApplicationConfig {
	
    @Bean
    public UserServiceImpl userservice() {
        return new UserServiceImpl();
    }
    
    @Bean
    public BCryptPasswordEncoder encoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authManage() {
    	return new AuthenticationManager() {
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				// TODO Auto-generated method stub
				return null;
			}
		};
    }
    
    @Bean
    public UserValidator uservalid() {
    	return new UserValidator();
    }

}
