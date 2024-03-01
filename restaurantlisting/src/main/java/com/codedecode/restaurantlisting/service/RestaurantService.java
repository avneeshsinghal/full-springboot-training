package com.codedecode.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codedecode.restaurantlisting.dto.RestuarantDTO;
import com.codedecode.restaurantlisting.entity.Restuarant;
import com.codedecode.restaurantlisting.mapper.RestaurantMapper;
import com.codedecode.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	public List<RestuarantDTO> fetchAllRestaurants() {
		
		List<Restuarant>  RestaurantList = restaurantRepo.findAll();
        return RestaurantList.stream().map(RestaurantMapper.INSTANCE::mapRestauranttoRestaurantDTO).collect(Collectors.toList());
	}

	public RestuarantDTO createRestaurant(RestuarantDTO restDTO) {

		Restuarant addedRestaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOtoRestaurant(restDTO);
        return RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(restaurantRepo.save(addedRestaurant));
	}


	public ResponseEntity<RestuarantDTO> fetchRestaurantById(Integer id) {


		Optional<Restuarant> restaurant = restaurantRepo.findById(id) ;

		if(restaurant.isPresent()){
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(restaurant.get()), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

	}

	public RestuarantDTO editRestaurant(RestuarantDTO restaurantDTO) {
		Restuarant addedRestaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOtoRestaurant(restaurantDTO);
		return RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(restaurantRepo.save(addedRestaurant));
	}
}
