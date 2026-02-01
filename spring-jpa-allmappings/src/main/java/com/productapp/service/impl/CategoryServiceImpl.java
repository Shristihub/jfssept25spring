package com.productapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productapp.model.dtos.CategoryDto;
import com.productapp.model.entities.Category;
import com.productapp.repository.ICategoryRepository;
import com.productapp.service.ICategoryService;
import com.productapp.util.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService{
	private final ICategoryRepository categoryRepository;
	private final ProductMapper productMapper;

	@Override
	public void addCategory(CategoryDto categoryDto) {
		Category category = productMapper.converttoCategoryEntity(categoryDto);
		categoryRepository.save(category);
		
	}

	@Override
	public void updateCategory(CategoryDto categoryDto) {
		Category category = productMapper.converttoCategoryEntity(categoryDto);
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}

	@Override
	public List<CategoryDto> getAll() {
		return null;
	}

	@Override
	public CategoryDto getById(int categoryId) {
		Optional<Category> optcategory = categoryRepository.findById(categoryId);
		if(optcategory.isPresent()) {
			Category category = optcategory.get();
			return productMapper.converttoCategoryDto(category);
		}
		return null;
	}

}
