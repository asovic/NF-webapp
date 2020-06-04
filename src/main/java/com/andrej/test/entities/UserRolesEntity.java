package com.andrej.test.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRolesEntity {
	
	@Id
	private Long user_role_id;
	
	private String username;
	
	private String role;

	public Long getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(Long user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
