package com.productapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.dtos.BrandDto;
import com.productapp.model.dtos.CategoryDto;
import com.productapp.model.dtos.FeaturesDto;
import com.productapp.model.dtos.OffersDto;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.enums.Delivery;
import com.productapp.model.enums.OffersType;
import com.productapp.model.enums.Payment;
import com.productapp.service.IBrandService;
import com.productapp.service.ICategoryService;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringJpaAllmappingsApplication implements CommandLineRunner{

    public static void main(String[] args) {
		SpringApplication.run(SpringJpaAllmappingsApplication.class, args);
	}
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IBrandService brandService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// 1 to 1
		FeaturesDto featuresDto = new FeaturesDto(null,"Thiscan be used by kids", "rubber", "maroon");
		// 
		OffersDto offersDto1 = new OffersDto(null, OffersType.BO.getOfferName(), "upto 5% offer");
		OffersDto offersDto2 = new OffersDto(null, OffersType.CB.getOfferName(), "upto 1200 rs off");
		OffersDto offersDto3 = new OffersDto(null, OffersType.NCE.getOfferName(), "no cost emi available");
		
		//1 to many
		//add the offers to a list
		List<OffersDto> offersList =  Arrays.asList(offersDto1,offersDto2,offersDto3);
		
		//many to many
		//create 2 categories
		CategoryDto categoryDto1 =  new CategoryDto("Sports", null);
		CategoryDto categoryDto2 =  new CategoryDto("Kids", null);
		CategoryDto categoryDto3 =  new CategoryDto("Electronics", null);
		//save them
		categoryService.addCategory(categoryDto1);
		categoryService.addCategory(categoryDto2);
		categoryService.addCategory(categoryDto3);
		
		// get category by id
		CategoryDto categoryDto11 = categoryService.getById(150);
		CategoryDto categoryDto12 = categoryService.getById(151);
		//create a list and add the list to the product
		List<CategoryDto> categories = Arrays.asList(categoryDto11,categoryDto12);
		
		//create 2 brands
		BrandDto brandDto1 = new BrandDto("Adidas", null);
		BrandDto brandDto2 = new BrandDto("Samsung", null);
		//save them
		brandService.addBrand(brandDto1);
		brandService.addBrand(brandDto2);
		
		//get Brand by Id
		BrandDto brandDto11 = brandService.getById(20);
		
		List<String> deliveryTypes = Arrays.asList(Delivery.PRIME.name(),Delivery.STANDARD.name());
		List<String> paymentModes = Arrays.asList(Payment.CARD.name(),Payment.UPI.name());
		
		
		ProductDto productDto = new ProductDto
				("Basketball", null, 1200, 4.5, featuresDto,offersList,categories,brandDto11,deliveryTypes,paymentModes);
		productService.addProduct(productDto);
		
		ProductDto productDto11 = new ProductDto
				("Mobile", null, 120000, 4.5, featuresDto,
						        Arrays.asList(offersDto1,offersDto2),
						        Arrays.asList(categoryService.getById(152)),
						        brandService.getById(21),
						        deliveryTypes,
						        Arrays.asList(Payment.CARD.name(),Payment.UPI.name(),Payment.COD.name()));
		productService.addProduct(productDto11);
		
		
		System.out.println();
		System.out.println(productService.getById(1));
		System.out.println();
		System.out.println();
		productService.getAll().forEach(System.out::println);
		
		
		
		
		
		
		
		
	}

}
