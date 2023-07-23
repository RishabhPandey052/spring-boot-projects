package org.pm.controller;

import org.pm.entites.Certificate;
import org.pm.service.ICertificateService;
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
@RequestMapping("certificate/")
public class CertificateController {
	
	@Autowired
	ICertificateService serviceCertificate;
	
	
	@GetMapping("/getCertificate")
	public String getCertificate()
	{
		return "get of certificatecontroller";
	}
	
	@PostMapping("/addCertificate")
	public String adderCertificate(@RequestBody Certificate certificate) {
		
		Certificate c = serviceCertificate.addCertificate(certificate);
		if(c != null) {
			return "Certificate  added \n"+c;
		}
		return "couldn't add certificate";
		
	}
	
	@PutMapping("/updatePlacement")
	public String updaterPlacement(@RequestBody Certificate certificate) {
		
		Certificate c = serviceCertificate.updateCertificate(certificate);
		if(c != null) {
			return "Certificate  update \n"+c;
		}
		return "couldn't update certificate";
	}
	
	@GetMapping("/getCertificate/{id}")
	public String getPlacement(@PathVariable long id) {
		Certificate p = serviceCertificate.searchCertificate(id);
		
		if(p != null) {
			return "Certificate \n" + p;
		}
		return "Certificate not found";
	}
	
	@DeleteMapping("/deleteCertificate/{id}")
	public String deleteCertificate(@PathVariable long id) {
		Certificate p = serviceCertificate.searchCertificate(id);
		if(p != null) {
			serviceCertificate.deleteCertificate(id);
			return "deleted Certificate -\n"+ p;
		}
		return "cant found or deleted Certificate";
	}
	
}
