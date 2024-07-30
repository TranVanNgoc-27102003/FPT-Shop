package com.example.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.OrderDetails;
import com.example.bean.Orders;
import com.example.dao.OrdersDao;
import com.example.report.NguoiMuaNhieuNhat;
import com.example.report.NguoiMuaTheoNam;
import com.example.service.OrderService;
@Service
public class OrerServiceIplm implements OrderService{
@Autowired OrdersDao ordao;
	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return ordao.findAll();
	}

	@Override
	public Optional<Orders> findById(Integer id) {
		// TODO Auto-generated method stub
		return ordao.findById(id);
	}

	@Override
	public Orders Save(Orders order) {
		// TODO Auto-generated method stub
		return ordao.save(order);
	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		ordao.deleteById(Id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		ordao.deleteAll();
	}

	@Override
	public List<NguoiMuaNhieuNhat> NguoiMuaNhieuNhat() {
		// TODO Auto-generated method stub
		return ordao.NguoiMuaNhieuNhat();
	}

	@Override
	public List<NguoiMuaTheoNam> NguoiMuaTheoNamFullAll() {
		// TODO Auto-generated method stub
		return ordao.NguoiMuaTheoNamFullAll();
	}

	@Override
	public List<com.example.report.NguoiMuaTheoNam> NguoiMuaTheoNam(Date date) {
		// TODO Auto-generated method stub
		return ordao.NguoiMuaTheoNam(date);
	}

	


	

}
