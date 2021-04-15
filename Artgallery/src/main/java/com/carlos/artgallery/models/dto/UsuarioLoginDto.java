package com.carlos.artgallery.models.dto;

import java.io.Serializable;

public class UsuarioLoginDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String pass;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
}
