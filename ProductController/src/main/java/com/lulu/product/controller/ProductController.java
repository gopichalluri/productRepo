package com.lulu.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lulu.product.model.Product;
import com.lulu.product.service.ProductService;

@RestController 
@RequestMapping("api/products")// order
public class ProductController {
	@Autowired
	ProductService productService;
	@RequestMapping("/all")
	public List<Product> getAllProducts() // read or fetch info from db
	{
		// return all products
		return productService.findAllProducts();
	}
	
	@RequestMapping("/{id}") // 1
	public Optional<Product> getProductById(@PathVariable Long id)
	{
		return productService.findProductById(id);
	}
	
	@RequestMapping
	 Product createProduct( @RequestBody Product p)
	 {
		Product pNew=productService.createProduct(p.getName(), p.getPrice());
		 return pNew;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
