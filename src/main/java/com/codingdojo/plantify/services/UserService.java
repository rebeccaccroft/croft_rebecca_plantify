package com.codingdojo.plantify.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.plantify.models.LoginUser;
import com.codingdojo.plantify.models.User;
import com.codingdojo.plantify.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public User getById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}

	public User create(User u) {
		return userRepo.save(u);
	}

	public User getOne(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isEmpty()) {
			return null;
		}
		return user.get();
	}

	public User register(User createdUser, BindingResult result) {
		if (!createdUser.getPassword().equals(createdUser.getConfirmPass())) {
			result.rejectValue("confirmPass", "Match", "Passwords must match.");
		}
	
		if (!result.hasErrors()) {
			createdUser.setPassword(BCrypt.hashpw(createdUser.getPassword(), BCrypt.gensalt()));
			return this.create(createdUser);
		}
		return null;
	}

	public User login(LoginUser loginUser, BindingResult result) {
		Optional<User> user = userRepo.findByUsername(loginUser.getUsername());
		if (user.isPresent() && BCrypt.checkpw(loginUser.getPassword(), user.get().getPassword())) {
			return user.get();
		}
		result.rejectValue("password", "invalid", "invalid credentials");
		return null;
	}
	public User setGoal(User u) {
		return userRepo.save(u);
	}
}