package com.andrej.test.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class UserEntity {
	
	//private Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
//	public UserEntity(String logged) {
//		super();
//		this.username = auth.getName();
//	}
	@Id
	private String username;

	private String password;
	
    @Transient
    private String passwordConfirm;
	
	private int enabled;
	
    @ManyToMany
    private Set<UserRolesEntity> roles;
	
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set<UserRolesEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRolesEntity> roles) {
		this.roles = roles;
	}

}