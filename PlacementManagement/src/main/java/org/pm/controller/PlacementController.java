package org.pm.controller;

import org.pm.entites.Placement;
import org.pm.service.IPlacementService;
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
@RequestMapping("placement/")
public class PlacementController {
	
	@Autowired
	IPlacementService servicePlacement;
	
	
	@GetMapping("/getPlacement")
	public String getPlacement() {
		return "get of placementController";
	}
	
	@PostMapping("/addPlacement")
	public String adderPlacement(@RequestBody Placement placement) {
		Placement p = servicePlacement.addPlacement(placement);
		
		if(p != null) {
			return "Placement added \n"+p;
		}
		return "couldn't add placement";
	}
	
	@PutMapping("/updatePlacement")
	public String updaterPlacement(@RequestBody Placement placement) {
		Placement p = servicePlacement.updatePlacement(placement);
		
		if(p != null) {
			return "Placement updated \n"+p;
		}
		return "couldn't add placement";
	}
	
	@GetMapping("/getPlacement/{id}")
	public String getPlacement(@PathVariable long id) {
		Placement p = servicePlacement.searchPlacement(id);
		
		if(p != null) {
			return "Placement \n" + p;
		}
		return "placement not found";
	}
	
	@DeleteMapping("/deletePlacement/{id}")
	public String deletePlacement(@PathVariable long id) {
		Placement p = servicePlacement.searchPlacement(id);
		if(p != null) {
			servicePlacement.cancelPlacement(p.getId());
			return "deleted placement -\n"+ p;
		}
		return "cant found or deleted placement";
	}
}
