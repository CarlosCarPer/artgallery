package com.carlos.artgallery.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.artgallery.models.dao.IUsuarioDao;
import com.carlos.artgallery.models.entities.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return (List<Usuario>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Usuario save(Usuario user) {
		return userDao.save(user);
	}
	
	@Override
	@Transactional
	public void delete(Usuario user) {
		userDao.delete(user);		
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		userDao.deleteById(id);		
	}
	
}
