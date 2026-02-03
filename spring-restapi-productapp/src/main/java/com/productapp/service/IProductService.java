package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.dtos.ProductDto;

public interface IProductService {
	// crud operation
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(int productId);
	List<ProductDto> getAll();
	ProductDto getById(int productId) throws ProductNotFoundException;
	
	
	
	

}
