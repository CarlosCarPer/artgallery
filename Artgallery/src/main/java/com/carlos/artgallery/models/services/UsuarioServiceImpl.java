package com.carlos.artgallery.models.services;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.artgallery.models.dao.IUsuarioDao;
import com.carlos.artgallery.models.dto.UsuarioRegisterDto;
import com.carlos.artgallery.models.entities.Usuario;
import com.carlos.artgallery.models.repositories.UsuariosRepository;
import com.carlos.artgallery.models.utilities.ImageUtils;
import com.carlos.artgallery.models.utilities.SecurityUtils;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao userDao;
	@Autowired
	public ImageUtils imageUtils;
	@Autowired
	public SecurityUtils securityUtils;
	@Autowired
	private UsuariosRepository usersRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return (List<Usuario>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Integer id) {
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

	@Override
	public Usuario login(String username, String password) throws NoSuchAlgorithmException{
		return this.usersRepository.login(username, securityUtils.encodePassword(password));
		//return this.usersRepository.login(username, password);
	}
	
	@Override
	public void register(UsuarioRegisterDto userDto) throws NoSuchAlgorithmException {
		Usuario user = new Usuario();
		user.setJoinDate(new Date().toString());
		user.setPass(securityUtils.encodePassword(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		
		this.usersRepository.save(user);
	}
	
}
