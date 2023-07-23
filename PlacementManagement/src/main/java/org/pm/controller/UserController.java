package org.pm.controller;

import org.pm.entites.User;
import org.pm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class UserController {

	@Autowired
	IUserService serviceUser;
	
	@GetMapping("/getUser")
	public String getUser() {
		return "get of UserController";
	}
	
	@PostMapping("/addUser")
	public String adderUser(@RequestBody User user) {
		User u = serviceUser.addUser(user);
		if(u != null) {
			return "added user " + u;
		}
		return "";
	}

	@PutMapping("/updateUser")
	public String updaterUser(@RequestBody User user) {
		User u = serviceUser.updateUser(user);
		if(u != null) {
			return "update user " + u;
		}
		return "";
	}
}

