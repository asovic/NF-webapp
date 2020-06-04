package com.andrej.test.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
  	  auth.jdbcAuthentication().dataSource(dataSource)
  		.usersByUsernameQuery(
  			"select username,password, enabled from users where username=?")
  		.authoritiesByUsernameQuery(
  			"select username, role from user_roles where username=?").passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/").permitAll()
          .antMatchers("/newOrder**").authenticated()
          .antMatchers("/userpage**").authenticated()
          .antMatchers("/admin/**").hasRole("ADMIN")
          .antMatchers("/login*").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginProcessingUrl("/login")
          .defaultSuccessUrl("/userpage", true)
          .and()
          .logout()
          .logoutUrl("/perform_logout")
          .deleteCookies("JSESSIONID");
        http.headers().frameOptions().sameOrigin();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
