package com.carlos.artgallery.models.dto;

public class ResponseArtDto {
	private ArtDto evento;

	public ResponseArtDto(ArtDto evento) {
		this.evento = evento;
	}

	public ArtDto getArt() {
		return evento;
	}

	public void setArt(ArtDto evento) {
		this.evento = evento;
	}
}
