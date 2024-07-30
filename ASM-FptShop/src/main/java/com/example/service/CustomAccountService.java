package com.example.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bean.Account;
import com.example.bean.CustomAccount;

import jakarta.servlet.http.HttpSession;
@Service
public class CustomAccountService implements UserDetailsService{
@Autowired AccountService accountService;
@Autowired HttpSession session;
	public CustomAccountService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Account account=accountService.findByEmail(username);
		if(account == null)
		{
			System.out.println("lỗi không tìm thấy tái khoản");
			throw new UsernameNotFoundException("Sai");
			
			
		}
//		
		Collection<GrantedAuthority> grantedAuthoritySet=new HashSet<>();
		Boolean Role=account.getRole();
		System.out.println("thông tin tài khảon account"+account);
		String role= Role ?"Admin":"User";
		System.out.println("Role là:"+role);
		session.setAttribute("checkrole", role);
		session.setAttribute("AccountId", account.getAcountId());
		grantedAuthoritySet.add(new SimpleGrantedAuthority(role));
		return new CustomAccount(grantedAuthoritySet, account);
	}

}
