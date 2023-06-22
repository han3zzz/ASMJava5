package com.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entities.Account;
import com.spring.repository.AccountRepository;
import com.spring.services.AccountService;

@Service
public class IAccountService implements AccountService{
	@Autowired
	private HashPassword hashPassword;
	@Autowired
	private AccountRepository repo;
	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Page<Account> getAll(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return repo.phantrang(pageable);
	}
	@Override
	public List<Account> count() {
		// TODO Auto-generated method stub
		return repo.countPhanTrang();
	}
	@Override
	public Optional<Account> getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	@Override
	public Account add(Account account) {
		// TODO Auto-generated method stub
		account.setPassword(HashPassword.hash(account.getPassword()));
		return repo.save(account);
	}
	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		Account acc = repo.getByUsername(account.getUsername());
		acc.setEmail(account.getEmail());
		acc.setPassword(HashPassword.hash(account.getPassword()));
		acc.setRole(account.getRole());
		return repo.save(acc);
	}
	@Override
	public Account delete(Account account) {
		Account acc = repo.getByUsername(account.getUsername());
		acc.setActive(1);
		return repo.save(acc);
	}
	@Override
	public Account getAccountById(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}
	@Override
	public Account getByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.getByUsername(username);
	}
	@Override
	public Account authention(String username, String password) {
		// TODO Auto-generated method stub
		
		Account account = repo.getByUsername(username);
	
		if (account == null) {
			return null;
		}
		if(HashPassword.check(password, account.getPassword()) == false) {
			return null;
		}
		return account;
	}

}
