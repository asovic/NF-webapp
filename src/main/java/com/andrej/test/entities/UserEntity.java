package com.andrej.test.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
public class UserEntity {
	
	private Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	public UserEntity() {
		super();
		this.username = auth.getName();
	}
	@Id
	private String username;

	private String password;
	
	private int enabled;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}