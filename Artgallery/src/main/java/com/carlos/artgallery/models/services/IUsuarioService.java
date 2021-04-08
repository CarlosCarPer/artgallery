package com.carlos.artgallery.models.services;

import java.util.List;

import com.carlos.artgallery.models.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Integer id);
	public Usuario save(Usuario user);
	public void delete(Usuario user);
	public void deleteById(int id);
	
}
