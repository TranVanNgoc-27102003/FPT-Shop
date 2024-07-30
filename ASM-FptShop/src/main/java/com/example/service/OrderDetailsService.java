package com.example.service;

import java.util.List;

import com.example.bean.OrderDetails;

public interface OrderDetailsService {
List<OrderDetails> findAll();
OrderDetails save(OrderDetails orderDetails);
void deleteById(Integer id);
List<OrderDetails> findByOrderId(Integer id);
List<OrderDetails> historyBuy(Integer Account);
Boolean ExitById(Integer id);
}
