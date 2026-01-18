package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Restaurant;

public interface IRestaurantRespository extends JpaRepository<Restaurant, Integer>{

	//derived query
	List<Restaurant> findByCity(String city);
	List<Restaurant> findByCityAndCuisine(String city,String cuisine);//chennai, chinese
	List<Restaurant> findByCategory(Category category); //veg
	@Query(
		"""
			select r from Restaurant r join fetch r.menuItems mi where mi.itemType=?1 
			 and r.cuisine=?2
			""")	
	List<Restaurant> findByItemTypeCuisine(String itemType,String cuisine);  //chinese starters
		
	@Query(
			"""
				select r from Restaurant r join r.menuItems mi where mi.itemType=?2 
				 and r.category=?1
				""")	
		
	List<Restaurant> findByCategoryItemType(Category category,String itemType); //veg starters
//	
//	List<Restaurant> findByCategoryItemName(Category category,String itemName);//veg, paneer
	
	@Query("select r from Restaurant r join r.menuItems mi where mi.itemName like ?1")	
	List<Restaurant> findByItemNameContains(String itemName);// paneer
	
	@Query(
			"""
				select r from Restaurant r join r.menuItems mi where mi.itemName=?1 
				 and mi.price=?2
				""")	
	List<Restaurant> findByItemNameLessPrice(String itemName,double price);
	
}
