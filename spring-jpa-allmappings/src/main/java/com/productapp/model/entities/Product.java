package com.productapp.model.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Product {
	
	@Column(length = 30)
	private String productName;
	@Id
	@GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1,allocationSize = 1)
	private Integer productId;
	private double price;
	private double ratings;
	
	// child entity is persisted before the parent entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="features_id") // to give a different column anme
	private Features features;
	
	@OneToMany(cascade = CascadeType.ALL)//fetch=FetchType.EAGER)
	@JoinColumn(name="product_id") // to add the foreign key to the many side
	private List<Offers> offers;
	
}












