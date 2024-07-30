package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.config.VNPAYConfig;
import com.example.service.VNPAYService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PaymentController {
	@Autowired
	private VNPAYService vnPayService;

	// Chuyển hướng người dùng đến cổng thanh toán VNPAY
	@PostMapping("/submitOrder")
	public String submidOrder(@RequestParam("amount") int orderTotal, @RequestParam("orderInfo") String orderInfo,
			HttpServletRequest request) {
		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		String vnpayUrl = vnPayService.createOrder(request, orderTotal, orderInfo, baseUrl);
		return "redirect:" + vnpayUrl;
	}

	// Sau khi hoàn tất thanh toán, VNPAY sẽ chuyển hướng trình duyệt về URL này
	@GetMapping("/vnpay-payment-return")
	public String paymentCompleted(HttpServletRequest request, Model model) {
		int paymentStatus = vnPayService.orderReturn(request);

		String orderInfo = request.getParameter("vnp_OrderInfo");
		String paymentTime = request.getParameter("vnp_PayDate");
		String transactionId = request.getParameter("vnp_TransactionNo");
		String totalPrice = request.getParameter("vnp_Amount");

		model.addAttribute("orderId", orderInfo);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("paymentTime", paymentTime);
		model.addAttribute("transactionId", transactionId);

		return paymentStatus == 1 ? "/User/ordersuccess" : "/User/orderfail";
	}
}