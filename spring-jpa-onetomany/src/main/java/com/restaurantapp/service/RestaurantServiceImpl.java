package com.restaurantapp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantapp.config.RestaurantMapper;
import com.restaurantapp.model.Category;
import com.restaurantapp.model.MenuItem;
import com.restaurantapp.model.MenuItemDto;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.repository.IRestaurantRespository;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	private RestaurantMapper mapper;
	@Autowired
	private IRestaurantRespository restaurantRepository;

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = mapper.convertToRestEntity(restaurantDto);
		restaurantRepository.save(restaurant);

	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = mapper.convertToRestEntity(restaurantDto);
		restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);

	}

	@Override
	public List<RestaurantDto> getAll() {
		return restaurantRepository.findAll().stream().map(restaurant -> mapper.convertToRestDto(restaurant)).toList();
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		Optional<Restaurant> optRestaurant = restaurantRepository.findById(restaurantId);
		if (optRestaurant.isPresent()) {
			Restaurant restaurant = optRestaurant.get();
			RestaurantDto  restaurantDto = mapper.convertToRestDto(restaurant);
			return restaurantDto;
		}
		return null;
	}

	@Override
	public List<RestaurantDto> getByCity(String city) {
		List<Restaurant> restaurants = restaurantRepository.findByCity(city);
		//convert restaurants to stream
		List<RestaurantDto> restaurantsDto = restaurants.stream()
		       //use map method of streams api to call mapper class
		       .map(restaurant->mapper.convertToRestDto(restaurant))
		       .toList();
		return restaurantsDto;
	}

	@Override
	public List<RestaurantDto> getByItemTypeCuisine(String itemType, String cuisine) {
		List<Restaurant> restaurants = restaurantRepository.findByItemTypeCuisine(itemType, cuisine);
		//convert restaurants to stream
		List<RestaurantDto> restaurantsDto = restaurants.stream()
		       //use map method of streams api to call mapper class
		       .map(restaurant->mapper.convertToRestDto(restaurant))
		       .toList();
		return restaurantsDto;
	}

	@Override
	public List<RestaurantDto> getByCityAndCuisine(String city, String cuisine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategory(Category category) {
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemType(Category category, String itemType) {
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(Category category, String itemName) {
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemNameContains(String itemName) {
		List<Restaurant> restaurants = restaurantRepository.findByItemNameContains("%"+itemName+"%");
		//convert restaurants to stream
		List<RestaurantDto> restaurantsDto = restaurants.stream()
		       //use map method of streams api to call mapper class
		       .map(restaurant->mapper.convertToRestDto(restaurant))
		       .toList();
		return restaurantsDto;
//		return null;
	}

	@Override
	public List<RestaurantDto> getByItemNameLessPrice(String itemName, double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
