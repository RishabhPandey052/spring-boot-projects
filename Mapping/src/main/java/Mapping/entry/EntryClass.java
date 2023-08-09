package Mapping.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import Mapping.operations.OneToManyEntry;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EntryClass implements ApplicationRunner {
	
	@Autowired
	OneToManyEntry oneToManyEntry;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		vendorOperations();
		
	}
	
	public  void  vendorOperations() {
		log.info("Inside vendor operations");
//		adding vendor operation
		oneToManyEntry.addVendor(); 
		oneToManyEntry.addVendor(); 
		
		
//		get  specific vendor  and all vendors
		oneToManyEntry.getVendor();
		
//		add Customer To Vendor
		oneToManyEntry.addCustomerToVendor();
		
	}
	
}
