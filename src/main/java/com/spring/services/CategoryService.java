package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.spring.entities.Category;



public interface CategoryService {
	public Page<Category> getAll(Integer pageNum , Integer pageSize);
	public List<Category> count();
	public Optional<Category> getById(Integer id);
	public Category add(Category category);
	public Category update(Category category);
	public Category delete(Category category);
	public Category getCatebyId(Integer id);
}
