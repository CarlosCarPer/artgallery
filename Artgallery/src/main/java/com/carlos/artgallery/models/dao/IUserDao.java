package com.carlos.artgallery.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.artgallery.models.entities.User;

public interface IUserDao extends JpaRepository<User,Integer>{

}
