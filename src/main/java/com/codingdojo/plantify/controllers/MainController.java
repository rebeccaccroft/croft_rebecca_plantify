package com.codingdojo.plantify.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.plantify.models.LoginUser;
import com.codingdojo.plantify.models.Plant;
import com.codingdojo.plantify.models.User;
import com.codingdojo.plantify.services.PlantService;
import com.codingdojo.plantify.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private PlantService plantServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "loginReg.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		//update to one to many assoc.
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.getOne(userId));
		model.addAttribute("allPlants", plantServ.getAll());
		return "dashboard.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
		userServ.register(user, result);
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "loginReg.jsp";
		}
		User createdUser = userServ.create(user);
		session.setAttribute("userId", createdUser.getId());
		return "redirect:/dashboard";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginUser") LoginUser logUser, BindingResult result, HttpSession session, Model model) {
		User loggedUser = userServ.login(logUser, result);
		if(loggedUser == null) {
			model.addAttribute("user", new User());
			return "loginReg.jsp";
		}
		session.setAttribute("userId", loggedUser.getId());
		return "redirect:/dashboard";
	}

//	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}


	
	
}
	