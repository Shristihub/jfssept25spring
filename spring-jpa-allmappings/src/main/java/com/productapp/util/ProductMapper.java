package com.productapp.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productapp.model.dtos.BrandDto;
import com.productapp.model.dtos.CategoryDto;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.entities.Brand;
import com.productapp.model.entities.Category;
import com.productapp.model.entities.Product;

@Component
public class ProductMapper {
	
	@Autowired
	private ModelMapper mapper;

	//product
	public ProductDto converttoDto(Product product){
		return mapper.map(product, ProductDto.class);
	}
	
	public Product converttoEntity(ProductDto productDto){
		return mapper.map(productDto, Product.class);
	}
	
	//category
	public Category converttoCategoryEntity(CategoryDto categoryDto){
		return mapper.map(categoryDto,Category.class);
	}
	
	public CategoryDto converttoCategoryDto(Category category){
		return mapper.map(category,CategoryDto.class);
	}

	//brand
	public Brand converttoBrandEntity(BrandDto brandDto) {
		return mapper.map(brandDto,Brand.class);
	}

	public BrandDto converttoBrandDto(Brand brand) {
		return mapper.map(brand, BrandDto.class);
	}
}
