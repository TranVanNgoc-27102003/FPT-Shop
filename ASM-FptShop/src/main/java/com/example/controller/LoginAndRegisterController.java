package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bean.Account;
import com.example.dao.AccountDao;
import com.example.dao.ProductsDao;
import com.example.report.Report;
import com.example.service.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("Account")
public class LoginAndRegisterController {
@Autowired AccountService acService;
@Autowired HttpSession session;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder; 
	@RequestMapping("/login/show")
	public String show(@ModelAttribute("form") Account account)
	{
		
		return "Login&&Register/Login";
	}
//	@RequestMapping("/login")
//	public String login(@RequestParam("email") String email, @RequestParam("password") String password,Model model)
//	{
//		Account ac=acService.findEmailAndPassword(email,password);
//		if(ac != null)
//		{
//			model.addAttribute("messages","đăng nhập thành công");
//			session.setAttribute("Role", ac.getRole());
//		Boolean role=(Boolean)	session.getAttribute("Role");
//		model.addAttribute("role",role);
//		System.out.println(role);
//		System.out.println(email);
//		
//			return "redirect:/User/Products/Show";
//		}
//		model.addAttribute("messages","Sai thông tin đăng nhập");
//		return "/Login&&Register/Login";					
//	}
	@RequestMapping("/Register/show")
	public String RegisterShow(@ModelAttribute("Account") Account account)
	{
	
		return "/Login&&Register/Register";
	}
	@RequestMapping("/register")
	public String Register(@ModelAttribute("Account") Account account,Model model,@RequestParam("configPassword") String configPassword)
	{
		Account accountByEmail=acService.findByEmail(account.getEmail());
		if(accountByEmail != null)
		{
			model.addAttribute("messages","Email đã đăng ký tài khoản");
			System.out.println("đã có trong account");
			return "/Login&&Register/Register";
		}
		
		 if(account.getPassWord().equals(configPassword) )
		{
			String encodedPassword=bCryptPasswordEncoder.encode(account.getPassWord());
			account.setPassWord(encodedPassword);
			account.setRole(false);
			acService.Save(account);
			System.out.println("đã đăng kí thành công");
			model.addAttribute("messages","Đã đăng kí thành công");
		}
		
		return "/Login&&Register/Register";
	}
	
}
