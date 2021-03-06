package com.carlos.artgallery.models.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.carlos.artgallery.models.dto.UsuarioRegisterDto;
import com.carlos.artgallery.models.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Integer id);
	public Usuario save(Usuario user);
	public Usuario login(String username, String password) throws NoSuchAlgorithmException;
	public void register(UsuarioRegisterDto userDto) throws NoSuchAlgorithmException;
	public void delete(Usuario user);
	public void deleteById(int id);
	
}
