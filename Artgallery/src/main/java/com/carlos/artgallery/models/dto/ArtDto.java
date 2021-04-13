package com.carlos.artgallery.models.dto;

import java.io.Serializable;


import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlos.artgallery.models.entities.Art;

public class ArtDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private String image;
	private double price;
	private String date;
	private UsuarioDto creator;
	
	public int getArtId() {
		return id;
	}
	public void setArtId(int i) {
		this.id = i;
	}
	public String getTitle() {
		return name;
	}
	public void setTitle(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return image;
	}
	public void setUrl(String image) {
		this.image = image;
	}
	public double getLikes() {
		return price;
	}
	public void setLikes(double price) {
		this.price = price;
	}
	public String getArtdate() {
		return date;
	}
	public void setArtdate(String date) {
		this.date = date;
	}
	public UsuarioDto getCreator() {
		return creator;
	}
	public void setCreator(UsuarioDto creator) {
		this.creator = creator;
	}
	
	public static ArtDto fromEntity(Art art) {
		ArtDto dto = new ArtDto();
		dto.setArtdate(art.getArtDate());
		dto.setArtId(art.getArtId());
		dto.setDescription(art.getDescription());
		dto.setTitle(art.getTitle());
		dto.setLikes(art.getLikes());
		dto.setUrl(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + '/' + art.getUrl());
		dto.setCreator(UsuarioDto.fromEntity(art.getUsuario()));
		
		return dto;
	}
}
