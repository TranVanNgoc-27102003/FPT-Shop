package com.example.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.report.NguoiMuaNhieuNhat;
import com.example.report.NguoiMuaTheoNam;
import com.example.report.Report;
import com.example.service.OrderService;
import com.example.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class RestReportController {
	@Autowired ProductService prService;
	@Autowired OrderService orService;
@GetMapping("/report/show")
public ResponseEntity<List<Report>> sanPhamMuaNhieuNhat()
{
	return ResponseEntity.ok(prService.getOrderDetailsByProduct());
}
@GetMapping("/report/nguoi-mua-nhieu-nhat")
public ResponseEntity<List<NguoiMuaNhieuNhat>> nguoiMuaNhieuNhat()
{
	return ResponseEntity.ok(orService.NguoiMuaNhieuNhat());
}
@GetMapping("/report/nguoi-mua-theo-nam/{year}")
public ResponseEntity<List<NguoiMuaTheoNam>> nguoiMuaTheoNam(@PathVariable("year")String date)
{
	java.sql.Date dateString = java.sql.Date.valueOf(date);
	List<NguoiMuaTheoNam> list=orService.NguoiMuaTheoNam(dateString);
	return ResponseEntity.ok(list);
}
@GetMapping("/report/nguoi-mua-cac-nam")
public ResponseEntity<List<NguoiMuaTheoNam>> NguoiMuaCacNam()
{ 
	List<NguoiMuaTheoNam> list=orService.NguoiMuaTheoNamFullAll();
	return ResponseEntity.ok(list);
}
}
