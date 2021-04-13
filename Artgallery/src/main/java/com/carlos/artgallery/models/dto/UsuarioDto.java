package com.carlos.artgallery.models.dto;

import java.io.Serializable;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlos.artgallery.models.entities.Usuario;


public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String avatar;
	
	public int getUserId() {
		return id;
	}
	
	public void setUserId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public static UsuarioDto fromEntity(Usuario user) {
		UsuarioDto dto = new UsuarioDto();
		dto.setUserId(user.getUserId());
		dto.setUsername(user.getUsername());
		dto.setAvatar(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + '/' + user.getAvatar());
		
		return dto;
	}
}
