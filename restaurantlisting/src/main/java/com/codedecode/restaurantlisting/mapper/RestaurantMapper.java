package com.codedecode.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.restaurantlisting.dto.RestuarantDTO;
import com.codedecode.restaurantlisting.entity.Restuarant;

@Mapper
public interface RestaurantMapper {
	
	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	Restuarant mapRestaurantDTOtoRestaurant(RestuarantDTO restaurantDTO);
	
	RestuarantDTO mapRestauranttoRestaurantDTO(Restuarant restaurant);
}
