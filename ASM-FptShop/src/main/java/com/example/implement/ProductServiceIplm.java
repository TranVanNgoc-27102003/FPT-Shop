package com.example.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Products;
import com.example.dao.ProductsDao;
import com.example.report.Report;
import com.example.service.ProductService;
@Service
public class ProductServiceIplm implements ProductService{
@Autowired ProductsDao prdao;
	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return prdao.findAll();
	}

	@Override
	public Optional<Products> findById(Integer id) {
		// TODO Auto-generated method stub
		return prdao.findById(id);
	}

	@Override
	public Products Save(Products product) {
		// TODO Auto-generated method stub
		return prdao.save(product);
	}


	@Override
	public Products Update(Products product) {
		// TODO Auto-generated method stub
		return prdao.save(product);
	}

	@Override
	public List<Products> fillAllProductsWhereComputer() {
		// TODO Auto-generated method stub
		return prdao.fillAllProductsWhereComputer();
	}

	@Override
	public List<Products> fillAllProductsphone() {
		// TODO Auto-generated method stub
		return prdao.fillAllProductsphone();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		prdao.deleteById(id);
	}

	@Override
	public Boolean ExitById(Integer id) {
		// TODO Auto-generated method stub
		return prdao.existsById(id);
	}

	@Override
	public List<Report> getOrderDetailsByProduct() {
		// TODO Auto-generated method stub
		return prdao.getOrderDetailsByProduct();
	}

	@Override
	public List<Products> findByCategory(String category) {
		// TODO Auto-generated method stub
		return prdao.findByCategory(category);
	}

}
