package com.carlos.artgallery.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.artgallery.models.entities.Account;

public interface IAccountDao extends JpaRepository<Account,Integer> {

}
