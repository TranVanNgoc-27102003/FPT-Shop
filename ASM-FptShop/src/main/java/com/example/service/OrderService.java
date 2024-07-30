package com.example.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.bean.Orders;
import com.example.report.NguoiMuaNhieuNhat;
import com.example.report.NguoiMuaTheoNam;

public interface OrderService {
	List<Orders> findAll();

	Optional<Orders> findById(Integer id);

	Orders Save(Orders order);

	void deleteById(Integer Id);

	void deleteAll();
	
List<NguoiMuaNhieuNhat> NguoiMuaNhieuNhat();
List<NguoiMuaTheoNam> NguoiMuaTheoNamFullAll();
List<NguoiMuaTheoNam> NguoiMuaTheoNam(Date date);
}
