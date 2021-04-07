package com.carlos.artgallery.models.services;

import java.util.List;

import com.carlos.artgallery.models.entities.Art;

public interface IArtService {

	public List<Art> findAll();
	public Art findById(Integer id);
	
}
