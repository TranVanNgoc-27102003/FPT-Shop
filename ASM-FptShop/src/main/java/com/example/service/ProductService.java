package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.bean.Products;
import com.example.report.Report;

public interface ProductService {
List<Products> findAll();
Optional<Products> findById(Integer id);
Products Save(Products product);
void deleteById(Integer id);
Products Update(Products product);
List<Products> fillAllProductsWhereComputer();
List<Products> fillAllProductsphone();
List<Products> findByCategory(String category);
Boolean ExitById(Integer id);
List<Report> getOrderDetailsByProduct();
}
