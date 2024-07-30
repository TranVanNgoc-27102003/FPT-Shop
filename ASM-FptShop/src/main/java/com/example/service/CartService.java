package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bean.Cart;

public interface CartService {
List<Cart> findAll();
Optional<Cart> findById(Integer id);
Cart update(Cart cart);
Cart save(Cart cart);
void deleteById(Integer id);
void deleteAll();
Cart findByProductId(Integer id);
Integer countItemsInCart(Integer id);
Double getTotalCartAmount();
List<Cart> fillCartByAccountId(Integer id);
void deleteByAcoountId(Integer id);
Boolean existsById(Integer id);
} 
