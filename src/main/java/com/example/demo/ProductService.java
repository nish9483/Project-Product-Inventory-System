package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAllProduct();
	       Product getProductById(int id);
	       Product updateProduct(Product product);
	      void deleteProduct(int id);
	       Page<Product>findAll(Pageable p);
	      
	   }
