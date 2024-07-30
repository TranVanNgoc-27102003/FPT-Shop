package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bean.Products;
import com.example.report.Report;

public interface ProductsDao extends JpaRepository<Products, Integer>{
	
	
	@Query("SELECT pr FROM Products pr WHERE pr.Category = 'Máy tính'")
	  List<Products> fillAllProductsWhereComputer();
	   
	@Query("SELECT pr from Products pr WHERE pr.Category = 'Phone'")
	List<Products> fillAllProductsphone();
	@Query("select pr from Products pr where pr.Category=?1")
	List<Products> findByCategory(String category);
	 
	@Query("SELECT new Report(od.Product.ProductName, od.Product.Image, COUNT(od.productId), SUM(od.Total)) " +
		       "FROM OrderDetails od " +
		       "GROUP BY od.Product.ProductName, od.Product.Image " +
		       "ORDER BY COUNT(od.productId) DESC")
		List<Report> getOrderDetailsByProduct();
}
