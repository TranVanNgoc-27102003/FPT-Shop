package com.example.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.VNPAYService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RequestMapping("rest")
public class RestPaymentController {

@Autowired
private VNPAYService vnPayService;

@PostMapping("/submitOrder")
public String submidOrder(@RequestParam("amount") int orderTotal, @RequestParam("orderInfo") String orderInfo,
		HttpServletRequest request) {
	String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	String vnpayUrl = vnPayService.createOrder(request, orderTotal, orderInfo, baseUrl);
	return "redirect:" + vnpayUrl;
}
}
