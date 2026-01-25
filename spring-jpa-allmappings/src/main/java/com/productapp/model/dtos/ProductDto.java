package com.productapp.model.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
	
	private String productName;
	private Integer productId;
	private double price;
	private double ratings;
	private FeaturesDto features;
	private List<OffersDto> offers;
	
}












