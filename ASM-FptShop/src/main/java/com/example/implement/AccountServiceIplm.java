package com.example.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Account;
import com.example.dao.AccountDao;
import com.example.service.AccountService;
@Service
public final class AccountServiceIplm implements AccountService{
@Autowired AccountDao acdao;

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return acdao.findAll();
	}

	@Override
	public Optional<Account> findById(Integer id) {
		// TODO Auto-generated method stub
		return acdao.findById(id);
	}

	@Override
	public Account Save(Account account) {
		// TODO Auto-generated method stub
		return acdao.save(account);
	}

	@Override
	public Account Update(Account account) {
		// TODO Auto-generated method stub
		return acdao.save(account);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		acdao.deleteById(id);
	}

	@Override
	public Account findEmailAndPassword(String Email, String passWord) {
		// TODO Auto-generated method stub
		return acdao.findEmailAndPassword(Email, passWord);
	}

	@Override
	public Account findByEmail(String email) {
		// TODO Auto-generated method stub
		return acdao.findByEmail(email);
	}

	
	

}
