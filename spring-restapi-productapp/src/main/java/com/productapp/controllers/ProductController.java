package com.productapp.controllers;

import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dtos.ProductDto;
import com.productapp.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product-api/v1")
@RequiredArgsConstructor
public class ProductController {

	private final IProductService productService;

	// http://localhost:8081/product-api/v1products
	@PostMapping( "/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		//wrap it in ResponseEntity<Void>
//		this returns the status as created and no body
		return ResponseEntity.status(HttpStatus.CREATED.value()).build();
	}

	// http://localhost:8081/product-api/v1/products
	@PutMapping("/products")
	ResponseEntity<Void>  updateProduct(@RequestBody ProductDto productDto) {
		productService.updateProduct(productDto);
		return ResponseEntity.accepted().build();
	}

//	http://localhost:8081/product-api/v1/products/productId/1
	@DeleteMapping("/products/productId/{productId}")
	ResponseEntity<Void>  deleteProduct(@PathVariable int productId) {
		HttpHeaders headers =  new HttpHeaders();
		headers.add("info", "delete one product");
		headers.add("timestamp", LocalTime.now().toString());
		productService.deleteProduct(productId);
		return ResponseEntity.ok().build();
	}

//	http://localhost:8081/product-api/v1/products
	@GetMapping("/products")
	ResponseEntity<List<ProductDto>> getAll() {
		List<ProductDto> products = productService.getAll();
		// create headers
		HttpHeaders headers =  new HttpHeaders();
		headers.add("info", "returns a list of products");
		headers.add("timestamp", LocalTime.now().toString());
		//add status
		// create a ReponseEntity Object and return it
		return ResponseEntity.status(HttpStatusCode.valueOf(200))
		              .headers(headers).body(products);
	}

//	http://localhost:8081/product-api/v1/products/productId/1
	@GetMapping("/products/productId/{productId}")
	ResponseEntity<ProductDto> getById(@PathVariable int productId) {
		HttpHeaders headers =  new HttpHeaders();
		headers.add("info", "returns one product by id");
		ProductDto productDto =  productService.getById(productId);
		return new ResponseEntity<>(productDto,headers, 200);
	}
}







