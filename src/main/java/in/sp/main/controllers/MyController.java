package in.sp.main.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUserDetails() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserDetails(@PathVariable int id) {
		User user = userService.getUserDetails(id).orElse(null);
		if(user != null) {
			return ResponseEntity.ok().body(user);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
