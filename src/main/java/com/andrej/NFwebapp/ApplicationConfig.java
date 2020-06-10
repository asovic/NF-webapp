package com.andrej.NFwebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.andrej.NFwebapp.repository.Ddmenu;
import com.andrej.NFwebapp.validator.UserValidator;

@Configuration
@EnableJpaRepositories
public class ApplicationConfig {
    
    @Bean
    public BCryptPasswordEncoder encoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserValidator uservalid() {
    	return new UserValidator();
    }
    
    @Bean
    public Ddmenu menu() {
    	return new Ddmenu();
    }
    
    @Bean(name="messageSource")
    public ResourceBundleMessageSource bundleMessageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("validation");
    return messageSource;
    }

}
