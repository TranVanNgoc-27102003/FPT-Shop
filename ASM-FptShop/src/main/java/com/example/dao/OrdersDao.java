package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bean.Orders;
import com.example.report.NguoiMuaNhieuNhat;
import com.example.report.NguoiMuaTheoNam;
import com.example.report.Report;

public interface OrdersDao extends JpaRepository<Orders, Integer>{

	@Query("select new NguoiMuaNhieuNhat(or.account.FullName, or.account.PhoneNumber, COUNT(or.OrderId), SUM(or.TotalAmount)) " +
		       "from Orders or " +
		       "group by or.account.FullName, or.account.PhoneNumber")
	List<NguoiMuaNhieuNhat> NguoiMuaNhieuNhat();
	
	@Query("select new NguoiMuaTheoNam(or.account.FullName, or.account.PhoneNumber, or.OrderDate, "
			+ "od.Product.ProductName, od.Product.Image) "
			+ "from Orders or join or.OrderDetail od "
			+ "group by or.account.FullName, or.account.PhoneNumber, or.OrderDate, "
			+ "od.Product.ProductName, od.Product.Image")
List<NguoiMuaTheoNam> NguoiMuaTheoNamFullAll();
	
	@Query("select new NguoiMuaTheoNam(or.account.FullName, or.account.PhoneNumber, or.OrderDate, "
			+ "od.Product.ProductName, od.Product.Image) "
			+ "from Orders or join or.OrderDetail od  where or.OrderDate =?1 "
			+ "group by or.account.FullName, or.account.PhoneNumber, or.OrderDate, "
			+ "od.Product.ProductName, od.Product.Image")
List<NguoiMuaTheoNam> NguoiMuaTheoNam(Date date);
}
