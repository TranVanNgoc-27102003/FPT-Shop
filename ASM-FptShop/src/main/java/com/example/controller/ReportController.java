package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.report.NguoiMuaNhieuNhat;
import com.example.report.NguoiMuaTheoNam;
import com.example.report.Report;
import com.example.service.OrderService;
import com.example.service.ProductService;

@Controller
@RequestMapping("/Admin")
public class ReportController {
@Autowired ProductService prService;
@Autowired OrderService orService;
	@RequestMapping("/report/show")
	public String report(Model model)
	{
		List<Report> list=prService.getOrderDetailsByProduct();
		model.addAttribute("list",list);
		
		return "/Admin/ReportLayout/SanPhamBanChay";
	}
	@RequestMapping("/report/nguoi-mua-nhieu-nhat")
	public String nguoiMuaNhieuNhat(Model model)
	{
		List<NguoiMuaNhieuNhat> list=orService.NguoiMuaNhieuNhat();
		System.out.println(list);
		model.addAttribute("NguoiMuaNhieuNhat",list);
		return "/Admin/ReportLayout/NguoiMuaNhieuNhat";
	}
	@RequestMapping("/report/nguoi-mua-theo-nam")
	public String nguoiMuaTheoNam(Model model,@RequestParam("year") String dateString)
	{
		
		
			java.sql.Date date = java.sql.Date.valueOf(dateString);
			List<NguoiMuaTheoNam> listnguoiMua=orService.NguoiMuaTheoNam(date);
			model.addAttribute("NguoiMuaTheoNam",listnguoiMua);
			return "/Admin/ReportLayout/NguoiMuaTheoNam";
	}
	
	@RequestMapping("/report/nguoi-mua-cac-nam")
	public String NguoiMuaCacNam(Model model)
	{
		List<NguoiMuaTheoNam> list=orService.NguoiMuaTheoNamFullAll();
		model.addAttribute("NguoiMuaTheoNam",list);
		return "/Admin/ReportLayout/NguoiMuaTheoNam";
	}
}
