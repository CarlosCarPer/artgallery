package com.carlos.artgallery.models.services;

import java.util.List;

import com.carlos.artgallery.models.entities.User;

public interface IUserService {

	public List<User> findAll();
	public User findById(Integer id);
	public User save(User user);
	public void delete(User user);
	public void deleteById(int id);
	
}
