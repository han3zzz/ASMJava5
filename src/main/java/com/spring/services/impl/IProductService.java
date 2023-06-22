package com.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entities.Product;
import com.spring.repository.ProductRepository;
import com.spring.services.ProductService;

@Service
public class IProductService implements ProductService{
	@Autowired
	private ProductRepository repo;

	@Override
	public Page<Product> getAll(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return repo.phantrang(pageable);
	}

	@Override
	public List<Product> count() {
		// TODO Auto-generated method stub
		return repo.countPhanTrang();
	}

	@Override
	public Optional<Product> getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		Product pro = repo.getById(product.getId());
		pro.setAnh(product.getAnh());
		pro.setTieuDe(product.getTieuDe());
		pro.setMoTa(product.getMoTa());
		pro.setGia(product.getGia());
		pro.setGiamGia(product.getGiamGia());
		pro.setThietKe(product.getThietKe());
		pro.setChatLieu(product.getChatLieu());
		pro.setCategory(product.getCategory());
		
		
		return repo.save(pro);
	}

	@Override
	public Product delete(Product product) {
		Product pro = repo.getById(product.getId());
		pro.setTrangThai(1);
		return repo.save(pro);
	}

	@Override
	public Product getProductbyId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public Page<Product> getAllbyCate(Integer pageNum, Integer pageSize, Integer id) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return repo.phantrangbyCate(pageable, id);
	}

	@Override
	public List<Product> countbyCate(Integer id) {
		// TODO Auto-generated method stub
		return repo.countPhanTrangbyCate(id);
	}
	
	
	

	

}
