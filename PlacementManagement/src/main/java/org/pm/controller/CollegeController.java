package org.pm.controller;

import org.pm.entites.College;
import org.pm.entites.Placement;
import org.pm.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("college/")
public class CollegeController {
	
	@Autowired
	ICollegeService serviceCollege;
	
	@GetMapping("/getCollege")
	public String getCollege() {
		return "Working College";
	}
	
	@PostMapping("/addCollege")
	public String adderCollege(@RequestBody College college) {
		College c = serviceCollege.addCollege(college);
		if( c != null) {
			return "add college " + c;
		}
		return "Error Occurred";	
	}
	
	@PutMapping("/updateCollege")
	public String updaterCollege(@RequestBody College college) {
		College c = serviceCollege.updateCollege(college);
		if( c != null) {
			return "add college " + c;
		}
		return "Error Occurred";	
	}
	
	
	@GetMapping("/getCollege/{id}")
	public String getCollege(@PathVariable long id) {
		College c = serviceCollege.searchCollege(id);
		if(c != null) {
			return "College " + c;
		}
		return "CollegeNotFound";
	}
	
	@DeleteMapping("/deleteCollege/{id}")
	public String deleteCollege(@PathVariable long id) {
		College c = serviceCollege.searchCollege(id);
		if(c != null) {
			serviceCollege.deleteCollege(c.getId());
			return "College deleted " + c;
		}
		return "CollegeNotFound";
	}
	
	@PostMapping("/schedulePlacement")
	public String schedulerPlacement(@RequestBody Placement placement ) {
		boolean p = serviceCollege.schedulePlacement(placement);
		if(p == true) {
			return "Placement Scheduled -\n"+ placement;
		}
		return "Couldn't scheduled placement";
	}
}

//2022-09-12T15:55:03.667692
