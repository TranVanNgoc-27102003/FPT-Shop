package com.example.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Cart;
import com.example.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/rest")
public class RestShoppingController {
@Autowired CartService cartService;
	@GetMapping("/cart/findAll")
	public ResponseEntity<List<Cart>>  findAll()
	{
		return ResponseEntity.ok(cartService.findAll());
	}
	@PostMapping("/cart/add")
	public ResponseEntity<Cart> addProduct(@RequestBody Cart cart)
	{
		//nếu đã có trong dử liệu thì ko được thêm mới
		if(cartService.existsById(cart.getCartId())) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(cartService.save(cart));
	}
	@PutMapping("/cart/update/{id}")
	public ResponseEntity<Cart> update(@RequestBody Cart cart,@PathVariable("id")Integer id)
	{
		//nếu không có trong cart thì ko dc update
		
		if(!cartService.existsById(id))
		{
			
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok(cartService.update(cart));
	}
	@DeleteMapping("/cart/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id)
	{
		
		if(!cartService.existsById(id))
		{
			return ResponseEntity.notFound().build();
		}
		cartService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
