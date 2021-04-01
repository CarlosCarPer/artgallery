package com.carlos.artgallery.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.carlos.artgallery.models.entities.Art;

public interface IArtDao extends CrudRepository<Art,Integer> {

}
