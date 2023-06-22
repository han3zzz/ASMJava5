package com.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entities.Product_KichThuoc;
import com.spring.repository.ProductKichThuocRepository;
import com.spring.services.ProductKichThuocService;

@Service
public class IProductKichThuocService implements ProductKichThuocService{
	@Autowired
	private ProductKichThuocRepository repo;

	@Override
	public List<Product_KichThuoc> count(Integer id) {
		// TODO Auto-generated method stub
		return repo.getAllByIdProduct(id);
	}
	@Override
	public Product_KichThuoc add(Product_KichThuoc product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public Product_KichThuoc update(Product_KichThuoc product) {
		// TODO Auto-generated method stub
		Product_KichThuoc p = repo.getByIdProduct(product.getProduct().getId() , product.getKichThuoc().getIdKichThuoc());
		p.setSoLuong(product.getSoLuong());
		return repo.save(p);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);;
	}

	@Override
	public Product_KichThuoc getByIdProduct(Integer id , Integer idKt) {
		// TODO Auto-generated method stub
		return repo.getByIdProduct(id, idKt);
	}
	
}
