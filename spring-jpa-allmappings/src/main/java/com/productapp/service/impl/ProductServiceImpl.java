package com.productapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.productapp.config.AppConfig;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.entities.Product;
import com.productapp.repository.IProductRepository;
import com.productapp.service.IProductService;
import com.productapp.util.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productRepository;
	private final ProductMapper productMapper;

	@Override
	public void addProduct(ProductDto productDto) {
		Product product = productMapper.converttoEntity(productDto);
		productRepository.save(product);

	}

	@Override
	public void updateProduct(ProductDto productDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<ProductDto> getAll() {
		List<Product> products = productRepository.findAll();
		System.out.println(products);
		return products.stream().map(product -> productMapper.converttoDto(product)).toList();
		// check if empty throw exception
		// sort by name and return it
//		return null;
	}

	@Transactional
	@Override
	public ProductDto getById(int productId) throws ProductNotFoundException {
		Optional<Product> productOpt = productRepository.findById(productId);
		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			return productMapper.converttoDto(product);
		}
		return null;
	}

}
