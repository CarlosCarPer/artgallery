package com.carlos.artgallery.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.artgallery.models.entities.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario,Integer>{

}
