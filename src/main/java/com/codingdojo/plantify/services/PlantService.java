package com.codingdojo.plantify.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.plantify.models.Plant;
import com.codingdojo.plantify.repositories.PlantRepository;

@Service
public class PlantService {
	@Autowired
	private PlantRepository plantRepo;
	public Plant getById(Long id) {
		Optional<Plant> optPlant = plantRepo.findById(id);
		if (optPlant.isPresent()) {
			return optPlant.get();
		}
		return null;
	}
	public ArrayList<Plant> getAll(){
		return plantRepo.findAll();
	}
	public ArrayList<Plant> getAll(String keyword){
		if (keyword != null) {
			return plantRepo.findAll();
		}
		return plantRepo.findAll();
	}
	public Plant create(Plant p) {
		return plantRepo.save(p);
	}
	public Plant edit(Plant p) {
		return plantRepo.save(p);
	}
	public void delete(Long id) {
		plantRepo.deleteById(id);
	}
}
