package com.carlos.artgallery.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.artgallery.models.entities.Usuario;


@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Long> {
	@Query("select u from Usuario u where username = ?1 and pass = ?2")
	public Usuario login(String username, String pass);
}
