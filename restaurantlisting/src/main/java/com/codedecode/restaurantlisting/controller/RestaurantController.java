package com.codedecode.restaurantlisting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codedecode.restaurantlisting.dto.RestuarantDTO;
import com.codedecode.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestuarantDTO>> fetchAllRestaurants(){
		List<RestuarantDTO>  restaurantList = restaurantService.fetchAllRestaurants() ;
		return new ResponseEntity<>(restaurantList, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/createRestaurant")
	public ResponseEntity<RestuarantDTO> createRestaurant(@RequestBody RestuarantDTO restDTO){
		RestuarantDTO  restaurant = restaurantService.createRestaurant(restDTO) ;
		return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
	}

	@GetMapping("/fetchById/{Id}")
	public ResponseEntity<RestuarantDTO> fetchRestaurantById(@PathVariable Integer Id){
		return restaurantService.fetchRestaurantById(Id) ;
	}


	@PutMapping("/updateRestaurant")
	public ResponseEntity<RestuarantDTO> fetchRestaurantById(@RequestBody RestuarantDTO restaurantDTO){
		RestuarantDTO  restaurant = restaurantService.editRestaurant(restaurantDTO) ;
		return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
	}


	@PutMapping("/updateRestaurant")
	public ResponseEntity<RestuarantDTO> fetchRestaurantById(@RequestBody RestuarantDTO restaurantDTO){
		RestuarantDTO  restaurant = restaurantService.editRestaurant(restaurantDTO) ;
		return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
	}
	
}
