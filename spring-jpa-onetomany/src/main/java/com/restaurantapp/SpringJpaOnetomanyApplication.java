package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.restaurantapp.config.AppConfig;
import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.ItemType;
import com.restaurantapp.model.MenuItemDto;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.repository.IRestaurantRespository;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringJpaOnetomanyApplication implements CommandLineRunner{

    private final IRestaurantRespository IRestaurantRespository;

    private final AppConfig appConfig;

    SpringJpaOnetomanyApplication(AppConfig appConfig, IRestaurantRespository IRestaurantRespository) {
        this.appConfig = appConfig;
        this.IRestaurantRespository = IRestaurantRespository;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetomanyApplication.class, args);
	}
	
	@Autowired
	private IRestaurantService restaurantService;

	@Override
	public void run(String... args) throws Exception {
		//create MenuItemsDto - menuItem1, menuItem2, menuItem3
		MenuItemDto item1 = new MenuItemDto("Masala Dosa",null,100,ItemType.BREAKFAST.name());
		MenuItemDto item2 = new MenuItemDto("Chicken Fried Rice",null,150,ItemType.LUNCH.name());
		MenuItemDto item3 = new MenuItemDto("Chicken Soup",null,80,ItemType.SOUPS.name());
		// convert to a Set
		Set<MenuItemDto> menuItems = new HashSet<>(Arrays.asList(item1,item2,item3));
		//create RestaurantDto object by add
		RestaurantDto restaurantDto =  
				new RestaurantDto("Anjappar", null, "Chennai", Cuisine.SI.getCuisineType(), Category.NONVEG,menuItems);
		//call the method of service
		restaurantService.addRestaurant(restaurantDto);
		
		item1 = new MenuItemDto("veg Momos",null,200,ItemType.STARTER.name());
		item2 = new MenuItemDto("Chicken Fried Rice",null,350,ItemType.LUNCH.name());
		item3 = new MenuItemDto("chicken lollipop",null,480,ItemType.STARTER.name());
		
		menuItems = new HashSet<MenuItemDto>(Arrays.asList(item1,item2,item3));
		
		restaurantDto =  
		new RestaurantDto("Mainland China", null, "Bengaluru", Cuisine.CHINESE.name(), Category.NONVEG,menuItems);
		
		restaurantService.addRestaurant(restaurantDto);

		System.out.println();
		restaurantService.getAll().forEach(System.out::println);
		
		System.out.println();
		RestaurantDto restDto = restaurantService.getById(1);
		System.out.println(restDto);
		
		restaurantService.getByCity("Bengaluru").forEach(System.out::println);
		
		
		
		
		// get restaurant byId;
		//create 2 new menuItems add to this restaurant by calling setMenuItems method
		
		
		
		
		
		
	}

}
