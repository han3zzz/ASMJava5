package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.spring.entities.Account;
public interface AccountService {
	public List<Account> getAll();
	public Page<Account> getAll(Integer pageNum , Integer pageSize);
	public List<Account> count();
	public Optional<Account> getById(Integer id);
	public Account add(Account account);
	public Account update(Account account);
	public Account delete(Account account);
	public Account getAccountById(Integer id);
	public Account getByUsername(String username);
	public Account authention(String username , String password);
}
