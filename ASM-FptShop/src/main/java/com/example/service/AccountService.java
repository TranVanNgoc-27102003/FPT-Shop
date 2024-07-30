package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.bean.Account;

public interface AccountService {

	List<Account> findAll();
	Optional<Account> findById(Integer id);
	Account	Save(Account account);
	Account Update(Account account);
	void deleteById (Integer id);
	Account findEmailAndPassword(String Email,String passWord);
	Account findByEmail(String email);
}
