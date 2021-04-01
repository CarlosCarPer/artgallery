package com.carlos.artgallery.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.artgallery.models.dao.IUserDao;
import com.carlos.artgallery.models.entities.User;



@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(null);
	}
	
}
