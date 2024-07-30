package com.example.controller;

import java.util.List;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Account;
import com.example.bean.Products;
import com.example.dao.AccountDao;
import com.example.dao.ProductsDao;
import com.example.service.AccountService;
import com.example.service.CartService;
import com.example.service.ProductService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("User")
public class ProductsController {
@Autowired ProductService prService;
@Autowired AccountService acService;
@Autowired CartService cartService;	
@Autowired HttpSession session;
	@RequestMapping("/Products/Show")
	public String index(Model model)
	{
		Integer AccountId=(Integer) session.getAttribute("AccountId");
		List<Products> list=prService.fillAllProductsWhereComputer();
		model.addAttribute("list",list);
		
		List<Products> listPhone=prService.fillAllProductsphone();
		model.addAttribute("listPhone",listPhone);
		// số lượng sản phâm trong giỏ hàng
		Integer countItemsCart=cartService.countItemsInCart(AccountId);
		model.addAttribute("count",countItemsCart);
		return "/User/Products";
	}
	
	
	@RequestMapping("/Products/details/{id}")
	public String ProductsDetails(Model model,@PathVariable("id") Integer id) {
		Integer AccountId=(Integer) session.getAttribute("AccountId");
		Products prDetails=prService.findById(id).get();
		// số lượng sản phâm trong giỏ hàng
		Integer countItemsCart=cartService.countItemsInCart(AccountId);
		model.addAttribute("count",countItemsCart);
		if(prDetails != null)
		{
			
			model.addAttribute("prDetails",prDetails);
		
		}
		else {
			System.out.println("Null");
		}
		return "/User/ProductDetails";
	}


	@RequestMapping("/find")
	public String find(@RequestParam("timkiem") String find,Model model)
	{
		List<Products> listPhone=prService.findByCategory(find);
		model.addAttribute("listPhone",listPhone);
		return "/User/Products";
	}

}
