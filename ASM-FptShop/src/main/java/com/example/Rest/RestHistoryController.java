package com.example.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.OrderDetails;
import com.example.dao.OrderDetailsDao;
import com.example.dao.OrdersDao;
import com.example.service.ProductService;
import com.example.service.uploadFileServices;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest")
public class RestHistoryController {
	@Autowired HttpSession session;
	@Autowired OrderDetailsDao orddao;
	@Autowired OrdersDao ordao;
	
	@GetMapping("/history/{id}")
	public ResponseEntity<List<OrderDetails> > history(@PathVariable ("id") Integer id)
	{
		return ResponseEntity.ok(orddao.historyBuy(id));
	}
	@DeleteMapping("/delete/{OrderId}")
	public ResponseEntity<Void> delete(@PathVariable("OrderId") Integer id)
	{
		if(!orddao.existsById(id))
		{
			System.out.println("bad");
			return ResponseEntity.notFound().build();
		}
		orddao.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
