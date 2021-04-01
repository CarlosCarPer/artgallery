package com.carlos.artgallery.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.carlos.artgallery.models.entities.User;

public interface IUserDao extends CrudRepository<User,Integer>{

}
