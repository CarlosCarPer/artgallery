package com.carlos.artgallery.models.dto;

import java.io.Serializable;

public class UsuarioRegisterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String joinDate;
	
	public String getName() {
		return username;
	}
	
	public void setName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAvatar() {
		return joinDate;
	}
	
	public void setAvatar(String joinDate) {
		this.joinDate = joinDate;
	}
}
