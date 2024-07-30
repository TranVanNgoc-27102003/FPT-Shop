package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.OrderDetails;
import com.example.dao.OrderDetailsDao;
import com.example.dao.OrdersDao;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("User")
public class HistoryController {
	@Autowired HttpSession session;
	@Autowired OrderDetailsDao orddao;
	@Autowired OrdersDao ordao;
	@RequestMapping("/history")
	public String history(Model model)
	{
		Integer AccountId=(Integer) session.getAttribute("AccountId");
		List<OrderDetails> historyBuy=orddao.historyBuy(AccountId);		
		model.addAttribute("historyBuy",historyBuy);		
		return "/User/History";
	}
	@RequestMapping("/delete/history/{id}")
	public String delete(@PathVariable("id") Integer id)
	{
		orddao.deleteById(id);
		return "redirect:/User/history";
	}
}
