package com.carlos.artgallery.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.artgallery.models.dao.IAccountDao;
import com.carlos.artgallery.models.entities.Account;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	private IAccountDao accountDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> findAll() {
		return (List<Account>) accountDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return accountDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Account save(Account account) {
		return accountDao.save(account);
	}
	
	@Override
	@Transactional
	public void delete(Account account) {
		accountDao.delete(account);		
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		accountDao.deleteById(id);		
	}
	
}
