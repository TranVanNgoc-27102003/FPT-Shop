package com.example.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.OrderDetails;
import com.example.dao.OrderDetailsDao;
import com.example.service.OrderDetailsService;
@Service
public class OrderDetailServiceIplm implements OrderDetailsService{
@Autowired OrderDetailsDao dao;
	@Override
	public List<OrderDetails> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public OrderDetails save(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return dao.save(orderDetails);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<OrderDetails> findByOrderId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByOrderId(id);
	}

	@Override
	public List<OrderDetails> historyBuy(Integer Account) {
		// TODO Auto-generated method stub
		return dao.historyBuy(Account);
	}

	@Override
	public Boolean ExitById(Integer id) {
		// TODO Auto-generated method stub
		return dao.existsById(id);
	}

}
