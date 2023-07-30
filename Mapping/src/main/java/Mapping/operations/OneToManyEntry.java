package Mapping.operations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mapping.entity.Customer;
import Mapping.entity.Vendor;
import Mapping.repo.VendorRepo;
import lombok.extern.slf4j.Slf4j;



// contains CRUD options which can be toogled

@Service
@Slf4j
public class OneToManyEntry {
	
	@Autowired
	VendorRepo vendorRepo;
	
	public int addVendor() {
		
		log.info("Inside AddVendor");
		
		Vendor v = new Vendor(); 
		v.setVendorName("vendor1");
		
		Customer c1 = new Customer();
		c1.setCustomerName("customer1");
		
		Customer c2 = new Customer();
		c2.setCustomerName("customer2");
		
		Customer c3 = new Customer();
		c3.setCustomerName("customer3");
		
//		(c1,c2,c3))
		
		Set<Customer> s = new HashSet<>();
		

		v.setCustomers(new HashSet<Customer>(Arrays.asList(c1,c2,c3)));
		
		
		
		if(vendorRepo.save(v) != null) {
			log.info("Added vendor with customer {}", v );
			return 1;
		}		
		log.info("couldn't add vendor with customer {}", v );
		return 0;
	}
	
	

}
