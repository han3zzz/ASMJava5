package com.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.entities.Category;
import com.spring.repository.CategoryRepository;
import com.spring.services.CategoryService;
@Service
public class ICategoryService implements CategoryService{
	@Autowired
	private CategoryRepository repo;
	@Override
	public Page<Category> getAll(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return repo.phantrang(pageable);
	}

	@Override
	public List<Category> count() {
		// TODO Auto-generated method stub
		return repo.countPhanTrang();
	}

	@Override
	public Optional<Category> getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Category add(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		Category cate = repo.getById(category.getId());
		cate.setTen(category.getTen());
		return repo.save(cate);
		
	}

	@Override
	public Category delete(Category category) {
		// TODO Auto-generated method stub
		Category cate = repo.getById(category.getId());
		cate.setTrangThai(1);
		return repo.save(cate);
	}


	@Override
	public Category getCatebyId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

}
