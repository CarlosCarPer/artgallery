package com.carlos.artgallery.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.artgallery.models.entities.Art;

@Repository
public interface ArtsRepository extends CrudRepository<Art, Long> {

}
