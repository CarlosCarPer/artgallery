package com.carlos.artgallery.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.artgallery.models.dao.IArtDao;
import com.carlos.artgallery.models.entities.Art;

@Service
public class ArtServiceImpl implements IArtService {

	@Autowired
	private IArtDao artDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Art> findAll() {
		return (List<Art>) artDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Art findById(Integer id) {
		return artDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Art save(Art art) {
		return artDao.save(art);
	}
	
	@Override
	@Transactional
	public void delete(Art art) {
		artDao.delete(art);		
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		artDao.deleteById(id);		
	}
	
}
