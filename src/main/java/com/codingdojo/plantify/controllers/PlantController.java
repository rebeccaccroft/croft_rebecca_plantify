package com.codingdojo.plantify.controllers;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.plantify.models.Plant;
import com.codingdojo.plantify.models.User;
import com.codingdojo.plantify.services.PlantService;
import com.codingdojo.plantify.services.UserService;

@Controller
@RequestMapping("/plant")
public class PlantController {
	@Autowired
	private PlantService plantServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/form/create")
	public String add(@ModelAttribute("plant") Plant plant ,Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("plant", new Plant());
		List<String> typesOfPlants = Arrays.asList("fruit", "fungi", "legume", "vegetable");
		model.addAttribute("typesOfPlants",typesOfPlants);
		return "addPlant.jsp";
	}
	@GetMapping("/form/{id}/update")
	public String edit(@PathVariable("id")Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("plant", plantServ.getById(id));
		List<String> typesOfPlants = Arrays.asList("fruit", "fungi", "legume", "vegetable");
		model.addAttribute("typesOfPlants",typesOfPlants);
		return "editPlant.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("plant") Plant plant, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return "addPlant.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		User loginUser = userServ.getById(userId);
		plant.setCreatedBy(loginUser);
		plantServ.create(plant);
		return "redirect:/dashboard";
	}
	@PutMapping("/{id}/update")
	public String update(@Valid @ModelAttribute("plant") Plant plant,  BindingResult result, @PathVariable("id")Long id, Model model , HttpSession session) {
		if (result.hasErrors()) {
			return "editPlant.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		User loginUser = userServ.getById(userId);
		plant.setCreatedBy(loginUser);
		plantServ.edit(plant);
		return "redirect:/dashboard";
	}
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id")Long id) {
		plantServ.delete(id);
		return "redirect:/dashboard";
	}
	
}
