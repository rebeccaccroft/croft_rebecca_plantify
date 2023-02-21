package com.codingdojo.plantify.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.plantify.models.Plant;


public interface PlantRepository extends CrudRepository<Plant, Long> {
//		@Query("SELECT p from Plant p WHERE p.plant_name LIKE %?1%;")
//		public ArrayList<Plant> findAll(String keyword);
		
		public ArrayList<Plant> findAll();
		
}
