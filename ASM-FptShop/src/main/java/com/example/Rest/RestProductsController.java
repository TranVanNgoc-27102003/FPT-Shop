package com.example.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.web.server.ServerHttpSecurity.HeaderSpec.CrossOriginResourcePolicySpec;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Products;
import com.example.dao.ProductsDao;
import com.example.report.Report;
import com.example.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class RestProductsController {
	@Autowired
	ProductService prductService;
	@Autowired ProductService prService;
	@GetMapping("/products/findAll")
	public ResponseEntity<List<Products>> findAll() {
		return ResponseEntity.ok(prductService.findAll());
	}
	@GetMapping("/products/fillByComputer")
	public ResponseEntity<List<Products>> showComputer() {
		return ResponseEntity.ok(prductService.fillAllProductsWhereComputer());
	}

	@GetMapping("/products/fillByphone")
	public ResponseEntity<List<Products>> showPhone() {
		return ResponseEntity.ok(prductService.fillAllProductsphone());
	}

	@GetMapping("/products/details/{id}")
	public ResponseEntity<Products> GetProductDetails(@PathVariable("id") Integer id) {
		if (!prductService.ExitById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(prductService.findById(id).get());
	}
	@PostMapping("/products/post")
	public ResponseEntity<Products> postProducts(@RequestBody Products products)
	{
		//nếu đã có id trong product thì ko dc thêm mới
		if(prductService.ExitById(products.getProductId()))
		{
			System.out.println(products+"đây là gía trị trả về");
			return ResponseEntity.badRequest().build();
			
		}
		System.out.println("thanh công");
		prductService.Save(products);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id)
	{
		if(!prductService.ExitById(id))
		{
			return ResponseEntity.notFound().build();
		}
		prductService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping("/products/put/{id}")
	public ResponseEntity<Products> put(@RequestBody Products product,@PathVariable("id")Integer id)
	{
		
		if(!prductService.ExitById(id))
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(prductService.Save(product));
	}
	@GetMapping("/user/test")
	public ResponseEntity<List<Report>> repot()
	{
		List<Report> list=prService.getOrderDetailsByProduct();
		System.out.println(list);
		return ResponseEntity.ok(prService.getOrderDetailsByProduct());
	}
}
