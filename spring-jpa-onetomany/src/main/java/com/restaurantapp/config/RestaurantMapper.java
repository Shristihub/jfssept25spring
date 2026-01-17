package com.restaurantapp.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurantapp.model.MenuItem;
import com.restaurantapp.model.MenuItemDto;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.RestaurantDto;

@Component
public class RestaurantMapper {

	@Autowired
	private ModelMapper mapper;

	public RestaurantDto convertToRestDto(Restaurant restaurant) {
		//convert entity to dto
		RestaurantDto restaurantDto = mapper.map(restaurant, RestaurantDto.class);
		// get menuItems from restaurant
		Set<MenuItem> menuItems = restaurant.getMenuItems();
		//convert menuItems to menuItemsDto
		Set<MenuItemDto> menuItemsDto =  menuItems.stream()
		          		.map(menuItem->convertToItemDto(menuItem))
		          		.collect(Collectors.toSet());
		//set the menuItemsDto to restaurantDto
		restaurantDto.setMenuItems(menuItemsDto);
		return restaurantDto;
		
		
	}

	public Restaurant convertToRestEntity(RestaurantDto restaurantDto) {
		return mapper.map(restaurantDto, Restaurant.class);
	}

	public MenuItemDto convertToItemDto(MenuItem menuItem) {
		return mapper.map(menuItem, MenuItemDto.class);
	}

	public MenuItem convertToItemEntity(MenuItemDto menuItemDto) {
		return mapper.map(menuItemDto, MenuItem.class);
	}
}
