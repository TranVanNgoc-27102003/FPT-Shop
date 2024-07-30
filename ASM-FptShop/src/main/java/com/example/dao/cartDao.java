package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bean.Cart;

import jakarta.transaction.Transactional;

public interface cartDao extends JpaRepository<Cart, Integer>{
	@Query("select c from Cart c where c.ProductId = ?1")
	public Cart findByProductId(Integer ProductId);
	
	@Query("select COUNT(*) from Cart c where c.accountId=?1")
	Integer countItemsInCart( Integer id);
	
	@Query("SELECT SUM(p.Price * c.Quantity) FROM Cart c JOIN c.product p")
	Double getTotalCartAmount();
	
	@Query("select c from Cart c where c.accountId=?1")
	List<Cart> fillCartByAccountId(Integer id);
	@Transactional
	@Modifying
	@Query("delete from Cart c where c.accountId=?1")
	void deleteByAcoountId(Integer id);
}

