package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategoryService {

	 CategoryDto createCategory(CategoryDto categoryDto);
	 CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	 void deleteCategory(Integer categoryId);
	 CategoryDto getCategoryId(Integer categoryId);
	 List<CategoryDto> getCategories();
}
