package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	/*@GetMapping("/productshop")
	public List<Product> getAllProduct(Model model) {
		List<Product> e= ps.getAllProduct();
		return e;
	}*/
	
	//post
	@GetMapping("/productshop")
	public String createPage()
	{
		return "create";
	}
	@PostMapping("/productshop")
	public String save(@ModelAttribute Product product)
	{
		Product r= ps.saveProduct(product);
		return "redirect:/productshop";
	}
	//update
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable int id)
	{
		Product g=ps.getProductById(id);
		return "edit";
	}
	@PostMapping("/edit/{id}")
	public String update(@ModelAttribute Product product,@PathVariable int id)
	{
		product.setId(id);
		Product f=ps.updateProduct(product);
		return "redirect:/edit/{id}";
	}
	
	//delete
	@GetMapping("/delete/{id}")
			public String deletepp(@PathVariable int id)
			{
		ps.deleteProduct(id);
		return "redirect:/productshop";
			}
	
	
	
	//---------------------------------
	@PostMapping("/product")
	public ResponseEntity<Product>saveProduct(@RequestBody Product product)
	{
		Product e=ps.saveProduct(product);
		return new ResponseEntity<Product>(e,HttpStatus.CREATED);
	}
	
	@GetMapping("/product")
	public List<Product>getPageOne()
	{
		Pageable p=PageRequest.of(0, 5 ,Sort.by("id").ascending());
		Page<Product>g=ps.findAll(p);
		return g.getContent();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product>getProductById(@PathVariable int id)
	{
		Product u=ps.getProductById(id);
		return new ResponseEntity<Product>(u,HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product>updateProduct(@PathVariable int id,@RequestBody Product product)
	{
		product.setId(id);
		Product m=ps.updateProduct(product);
		return new ResponseEntity<Product>(m,HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void>deleteProduct(@PathVariable int id)
	{
		ps.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
