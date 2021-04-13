package com.carlos.artgallery.models.dto;

import java.util.List;

public class ResponseArtsDto {
	private List<ArtDto> arts;

	public ResponseArtsDto(List<ArtDto> arts) {
		this.arts = arts;
	}

	public List<ArtDto> getArts() {
		return arts;
	}

	public void setArts(List<ArtDto> arts) {
		this.arts = arts;
	}
}
