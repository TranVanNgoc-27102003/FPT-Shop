package com.example.controller;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Cart;
import com.example.bean.OrderDetails;
import com.example.bean.Orders;
import com.example.bean.Products;
import com.example.dao.OrderDetailsDao;
import com.example.dao.OrdersDao;
import com.example.dao.ProductsDao;
import com.example.dao.cartDao;
import com.example.service.CartService;
import com.example.service.OrderDetailsService;
import com.example.service.OrderService;
import com.example.service.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ShoppingCartController {
	@Autowired ProductService prdao;
	@Autowired CartService cartdao;
	@Autowired OrderService ordao;
	@Autowired OrderDetailsService ordetaildao;
	@Autowired HttpSession session;
	

	
	@RequestMapping("/cart/view")
	public String view(Model model) {
		Integer AccountId=(Integer) session.getAttribute("AccountId");
		List<Cart> listCart=cartdao.fillCartByAccountId(AccountId);
//		System.out.println("account id là:"+AccountId);
		model.addAttribute("cart", listCart);
		// số lượng sản phâm trong giỏ hàng
		Integer countItemsCart=cartdao.countItemsInCart(AccountId);
		model.addAttribute("count",countItemsCart);
		// tổng số tiền tất cả
		Double SumItemsTotal=cartdao.getTotalCartAmount();
		model.addAttribute("SumTotal",SumItemsTotal);
		return "/cart/cart";
	}

	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Integer id,Model model) {
		//nếu có trong giỏ hàng rồi thì tăng số lượng lên 1
		Integer AccountId=(Integer) session.getAttribute("AccountId");
		Cart listCart=cartdao.findByProductId(id);
		if(listCart != null)
		{
			
			listCart.setQuantity(listCart.getQuantity()+1);	
			listCart.setAccountId(AccountId);
			cartdao.save(listCart);
		}
		//chưa có thì thêm vào giỏ hàng
		else {
			
			Cart cart=new Cart();
			cart.setProductId(id);
			cart.setAccountId(AccountId);
			cart.setQuantity(1);
			cartdao.save(cart);
			
		}
		
		return  "redirect:/cart/view"; // hiển thị giỏ hàng
	}

	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		cartdao.deleteById(id);
		System.out.println("đã xóa");
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/-/{id}")
	public String tru(@PathVariable("id") Integer id) {
		Cart listCart=cartdao.findById(id).get();
		Cart cart =listCart;
		cart.setQuantity(cart.getQuantity()-1);
		cartdao.save(cart);
		//nếu quantity =0 thì xóa khỏi giỏ hàng
		if(cart.getQuantity()==0)
		{
			cartdao.deleteById(id);
		}
		return "redirect:/cart/view";
	}
	@RequestMapping("/cart/+/{id}")
	public String cong(@PathVariable("id") Integer id) {
		Cart listCart=cartdao.findById(id).get();
		Cart cart =listCart;
		cart.setQuantity(cart.getQuantity()+1);
		cartdao.save(cart);
		return "redirect:/cart/view";
	}


	@RequestMapping("/cart/clear")
	public String clear() {
		Integer AccountId=(Integer) session.getAttribute("AccountId");
		cartdao.deleteByAcoountId(AccountId);
		return "redirect:/cart/view";
	}
	
	@RequestMapping("/cart/pay")
	public String pay(@RequestParam("SumTotal") Double sumToTal,Model model)
	{
		Integer AccountId=(Integer) session.getAttribute("AccountId");
		// thêm dử liệu vào bảng order
		Orders order=new Orders();
		order.setOrderDate(new Date());
		order.setAcountId(AccountId);
		order.setTotalAmount(sumToTal);
		ordao.Save(order);
		
		
		
//		 // Lưu thông tin vào bảng OrderDetail
		List<Cart> listCart=cartdao.findAll();
		for (Cart cart : listCart) {
	        OrderDetails orderDetail = new OrderDetails();
	        orderDetail.setOrderId(order.getOrderId());
	        orderDetail.setProductId(cart.getProductId());
	        orderDetail.setQuantity(cart.getQuantity());
	        orderDetail.setTotal(cart.getProduct().getPrice()* cart.getQuantity());
	        ordetaildao.save(orderDetail);
	    }
//		 ép kiểu double về int
		int SumTotal = (int) sumToTal.doubleValue();
		model.addAttribute("SumTotal",SumTotal);
		System.out.println(sumToTal);
		//orderdetail vừa mới thanh toán
		List<OrderDetails> listOrderDetail = ordetaildao.findByOrderId(order.getOrderId());
		model.addAttribute("listOrderDetail",listOrderDetail);
		
//		
		cartdao.deleteByAcoountId(AccountId);
		
		return "User/createOrder";
	}
}
