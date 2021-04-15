package com.carlos.artgallery.models.dto;

import java.io.Serializable;

public class UsuarioRegisterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String pass;
	private String avatar;
	private String description;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPassw(String pass) {
		this.pass = pass;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}

