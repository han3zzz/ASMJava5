package com.spring.beans;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.spring.entities.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryForm {
	private Integer id;
	@NotBlank(message = "{NotBlank.category.ten}")
	@Length(max = 100, message = "{Length.category.ten}")
	private String ten;
	
	public Category data(Category category) {
		if (category == null) {
			category = new Category();
		}
		category.setId(this.getId());
		category.setTen(this.getTen());
		return category;
	}
}
