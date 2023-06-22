package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.spring.entities.KichThuoc;
import com.spring.entities.Product;

public interface ProductService {
	public Page<Product> getAll(Integer pageNum , Integer pageSize);
	public List<Product> count();
	public Optional<Product> getById(Integer id);
	public Product add(Product product);
	public Product update(Product product);
	public Product delete(Product product);
	public Product getProductbyId(Integer id);
	public Page<Product> getAllbyCate(Integer pageNum , Integer pageSize , Integer id);
	public List<Product> countbyCate(Integer id);
}
