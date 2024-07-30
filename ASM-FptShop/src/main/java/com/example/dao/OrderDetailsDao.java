package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bean.OrderDetails;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer>{
	@Query("select ord from OrderDetails ord where ord.Order.OrderId =?1")
 List<OrderDetails> findByOrderId (Integer OrderId);
	
	@Query("select ord from OrderDetails ord where ord.Order.AcountId = ?1")
	List<OrderDetails> historyBuy(Integer AccountId);
	
	
}
