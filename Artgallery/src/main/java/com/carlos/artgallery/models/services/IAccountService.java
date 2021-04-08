package com.carlos.artgallery.models.services;

import java.util.List;

import com.carlos.artgallery.models.entities.Account;

public interface IAccountService {

	public List<Account> findAll();
	public Account findById(Integer id);
	public Account save(Account Account);
	public void delete(Account Account);
	public void deleteById(int id);
	
}
