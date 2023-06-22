package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.spring.entities.Product_KichThuoc;



public interface ProductKichThuocService {
	public List<Product_KichThuoc> count(Integer id);
	public Product_KichThuoc add(Product_KichThuoc product);
	public Product_KichThuoc update(Product_KichThuoc product);
	public void delete(Integer id);
	public Product_KichThuoc getByIdProduct(Integer id , Integer idKT);
}
