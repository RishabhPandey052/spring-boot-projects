package Mapping.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import Mapping.operations.ManyToOneEntry;
import Mapping.operations.OneToManyEntry;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EntryClass implements ApplicationRunner {
	
	@Autowired
	OneToManyEntry oneToManyEntry;
	
	@Autowired
	ManyToOneEntry  manyToOneEntry;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		vendorOperations();
		
		projectOperations();
		
	}
	
	public  void  vendorOperations() {
		log.info("Inside --> One to Many (Vendor operations)");
//		adding vendor operation
		oneToManyEntry.addVendor(); 
		oneToManyEntry.addVendor(); 
		
		
//		get  specific vendor  and all vendors
		oneToManyEntry.getVendor();
		
//		add Customer To Vendor
		oneToManyEntry.addCustomerToVendor();
		
//		removing customer from Vendor
		oneToManyEntry.removeCustomerFromVendor();
		
//		removing a vendor
		oneToManyEntry.removeVendor();
		
		
		log.info("Exiting --> One to Many (Vendor operations)");
		
			
	}
	
	public void projectOperations() {
		
		log.info("Inside  --> Many to One (Project operations");
		
//		save a project
		manyToOneEntry.addProject();
		
		log.info("Exiting --> Many to One (Project operations");
	}
	
}
