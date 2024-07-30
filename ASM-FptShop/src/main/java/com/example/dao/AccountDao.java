package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bean.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

	@Query("select ac from Account ac where ac.Email = :Email and ac.PassWord = :PassWord")
	Account findEmailAndPassword(@Param("Email") String email, @Param("PassWord") String password);
	@Query("select ac from Account ac where ac.Email =?1")
	Account findByEmail(String Email);
	
}
