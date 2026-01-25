package com.productapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.dtos.FeaturesDto;
import com.productapp.model.dtos.OffersDto;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.enums.OffersType;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringJpaAllmappingsApplication implements CommandLineRunner{

    public static void main(String[] args) {
		SpringApplication.run(SpringJpaAllmappingsApplication.class, args);
	}
	@Autowired
	private IProductService productService;

	@Override
	public void run(String... args) throws Exception {
		// 1 to 1
		FeaturesDto featuresDto = new FeaturesDto(null,"Thiscan be used by kids", "rubber", "maroon");
		// 
		OffersDto offersDto1 = new OffersDto(null, OffersType.BO.getOfferName(), "upto 5% offer");
		OffersDto offersDto2 = new OffersDto(null, OffersType.CB.getOfferName(), "upto 1200 rs off");
		OffersDto offersDto3 = new OffersDto(null, OffersType.NCE.getOfferName(), "no cost emi available");
		
		//add the offers to a list
		List<OffersDto> offersList =  Arrays.asList(offersDto1,offersDto2,offersDto3);
		
		ProductDto productDto = new ProductDto("Basketball", null, 1200, 4.5, featuresDto,offersList);
		productService.addProduct(productDto);
		
		System.out.println();
		System.out.println(productService.getById(1));
		System.out.println();
		productService.getAll().forEach(System.out::println);
		
		
		
		
		
		
		
		
	}

}
