package com.example.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.service.AccountService;

public class CustomAccount implements UserDetails{
private  Collection<? extends GrantedAuthority> authorities;
private Account account;
	public CustomAccount() {
		// TODO Auto-generated constructor stub
	}

	public CustomAccount(Collection<? extends GrantedAuthority> authorities, Account account) {
		super();
		this.authorities = authorities;
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return account.getPassWord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return account.getEmail();
	}

}
