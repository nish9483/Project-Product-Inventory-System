package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceimpl implements ProductService {
	
	@Autowired
	private ProductRepo pr;
	
	
	@Override
	public Product saveProduct(Product product)
	{
		return pr.save(product);
	}
	
	@Override
	public List<Product> getAllProduct()
	{
		return pr.findAll();
	}
	
	@Override
	public Page<Product>findAll(Pageable p)
	{
		Page<Product> r=pr.findAll(p);
		return r;
	}
	
	@Override
	public Product getProductById(int id)
	{
		Optional<Product> h=pr.findById(id);
		return h.get();
		
	}
	
	@Override
	public Product updateProduct(Product product)
	{
		Product t=pr.findById(product.getId()).get();
		t.setProductname(product.getProductname());
		t.setPrice(product.getPrice());
		Product v=pr.save(t);
		return v;
		
	}
	@Override
	public void deleteProduct(int id)
	{
		pr.deleteById(id);
	}

	
	

}
