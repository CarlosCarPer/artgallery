package com.carlos.artgallery.models.dto;

import java.util.List;

public class ResponseArtsDto {
	private List<ArtDto> eventos;

	public ResponseArtsDto(List<ArtDto> eventos) {
		this.eventos = eventos;
	}

	public List<ArtDto> getArts() {
		return eventos;
	}

	public void setArts(List<ArtDto> eventos) {
		this.eventos = eventos;
	}
}
