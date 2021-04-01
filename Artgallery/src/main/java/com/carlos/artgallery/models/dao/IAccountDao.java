package com.carlos.artgallery.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.carlos.artgallery.models.entities.Account;

public interface IAccountDao extends CrudRepository<Account,Integer> {

}
