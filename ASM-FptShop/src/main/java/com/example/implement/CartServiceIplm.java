package com.example.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Cart;
import com.example.dao.cartDao;
import com.example.service.CartService;
@Service
public class CartServiceIplm implements CartService{
@Autowired cartDao crdao;;
	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return crdao.findAll();
	}

	@Override
	public Optional<Cart> findById(Integer id) {
		// TODO Auto-generated method stub
		return crdao.findById(id);
	}

	@Override
	public Cart update(Cart cart) {
		// TODO Auto-generated method stub
		return crdao.save(cart);
	}

	@Override
	public Cart save(Cart cart) {
		// TODO Auto-generated method stub
		return  crdao.save(cart);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		crdao.deleteById(id);
	}

	@Override
	public Cart findByProductId(Integer id) {
		// TODO Auto-generated method stub
		return crdao.findByProductId(id);
	}



	@Override
	public Double getTotalCartAmount() {
		// TODO Auto-generated method stub
		return crdao.getTotalCartAmount();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		crdao.deleteAll();
	}

	@Override
	public List<Cart> fillCartByAccountId(Integer id) {
		// TODO Auto-generated method stub
		return crdao.fillCartByAccountId(id);
	}

	@Override
	public Integer countItemsInCart(Integer id) {
		// TODO Auto-generated method stub
		return crdao.countItemsInCart(id);
	}

	@Override
	public void deleteByAcoountId(Integer id) {
		// TODO Auto-generated method stub
		crdao.deleteByAcoountId(id);
	}

	@Override
	public Boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return crdao.existsById(id);
	}

}
