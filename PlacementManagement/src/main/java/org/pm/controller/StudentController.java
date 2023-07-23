package org.pm.controller;

import org.pm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	IStudentService  serviceStudent;
	
	@GetMapping("/getStudent")
	public String getStudent() {
		return "Working";
	}
	
	
}
