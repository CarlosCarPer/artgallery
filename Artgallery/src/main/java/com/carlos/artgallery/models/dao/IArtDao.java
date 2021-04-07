package com.carlos.artgallery.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.artgallery.models.entities.Art;

public interface IArtDao extends JpaRepository<Art,Integer> {

}
