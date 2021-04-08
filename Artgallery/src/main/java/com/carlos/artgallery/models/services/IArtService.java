package com.carlos.artgallery.models.services;

import java.util.List;

import com.carlos.artgallery.models.entities.Art;

public interface IArtService {

	public List<Art> findAll();
	public Art findById(Integer id);
	public Art save(Art art);
	public void delete(Art art);
	public void deleteById(int id);
	
}
