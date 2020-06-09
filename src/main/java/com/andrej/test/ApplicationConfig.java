package com.andrej.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.andrej.test.repository.Ddmenu;
import com.andrej.test.validator.UserValidator;

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
    
//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//         
//        mailSender.setUsername("nektar.fog@gmail.com");
//        mailSender.setPassword("@nektarf0g");
//         
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//         
//        return mailSender;
//    }

}
