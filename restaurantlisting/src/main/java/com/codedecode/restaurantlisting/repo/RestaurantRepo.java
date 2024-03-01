package com.codedecode.restaurantlisting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.restaurantlisting.entity.Restuarant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restuarant, Integer> {
	
	

}
