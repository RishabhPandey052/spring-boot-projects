package Mapping.operations;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
	
	public void addVendor() {
		
		int saveMethod = 1; 
		
		log.info("Inside AddVendor");
		
		if(vendorRepo.count() != 0){
			
			log.warn("Vendor entities already exists ");
			return;
		}
		
//		Vendors
		Vendor v = new Vendor();
		v.setVendorName("vendor1");
		
		
		Vendor v1 = new Vendor();
		v1.setVendorName("vendor2");
		
		Vendor v2 = new Vendor();
		v2.setVendorName("vendor3");
		
		
//		Customers
		Customer c1 = new Customer();
		c1.setCustomerName("customer1");
		
		Customer c2 = new Customer();
		c2.setCustomerName("customer2");
		
		Customer c3 = new Customer();
		c3.setCustomerName("customer3");
		
//		Relations
		v.setCustomers(new HashSet<Customer>(Arrays.asList(c1,c2,c3)));
		v1.setCustomers(new HashSet<Customer>(Arrays.asList(new Customer(null,"customer4"))));
		v2.setCustomers(new HashSet<Customer>(Arrays.asList(c3)));
		
		
		
		
		if (saveMethod == 2) {
			
//		START Saving 1stType 
			
			log.info("indiviual save");
			
			
			try {
				vendorRepo.save(v);
				log.info("Added vendor with customer {}", v);
			} catch (Exception e1) {
				log.error("couldn't add vendor with customer {}", v);
				log.error("Due to " + e1.getMessage());

			}
			try {
				vendorRepo.save(v1);
				log.info("Added vendor with customer {}", v1);
			} catch (Exception e2) {
				log.error("couldn't add vendor with customer {}", v1);
				log.error("Due to " + e2.getMessage());

			}
			try {

				vendorRepo.save(v2);
				log.info("Added vendor with customer {}", v2);

			} catch (Exception e3) {

				log.error("couldn't add vendor with customer {}", v2);
				log.error("Due to " + e3.getMessage());

			} 
			
			/* EXPLATION 
			 * Third One object insertion  gives Exceptions beacuse of child Object already got saved
			 * save 2 entity then update relation for each vendor and their customers
			 * 	
				insert into vendor (vendor_name,vendor_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				update customer set vendor_id=? where customer_id=?
				update customer set vendor_id=? where customer_id=?
				update customer set vendor_id=? where customer_id=?
	-->		Added vendor with customer Vendor(vendorId=1, vendorName=vendor1, customers=[Customer(customerId=1, customerName=customer2), Customer(customerId=2, customerName=customer3), Customer(customerId=3, customerName=customer1)])
				insert into vendor (vendor_name,vendor_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				update customer set vendor_id=? where customer_id=?
	-->		Added vendor with customer Vendor(vendorId=2, vendorName=vendor2, customers=[Customer(customerId=4, customerName=customer4)])
				insert into vendor (vendor_name,vendor_id) values (?,default)
	-->		couldn't add vendor with customer Vendor(vendorId=3, vendorName=vendor3, customers=[Customer(customerId=3, customerName=customer1)])
	-->		due to detached entity passed to persist: Mapping.entity.Customer
			 */
			
//			END Saving 1stType 
		} 
		
		else {
			
			
//			START Saving 2stType
			
			
			log.info("saveAll");
			
			try {
				vendorRepo.saveAll(Arrays.asList(v,v1,v2));
				log.info("Added vendor with customer {}", Arrays.asList(v,v1,v2) );
				
			} catch(Exception e) {
				
				log.error("couldn't add vendor with customer {}", Arrays.asList(v,v1,v2));
				log.error("Due to " + e.getMessage());
				
			}
			
			/* EXPLATION -- In console refer customerName
			 * Insertion happens succesfully
			 * save 3 vendor, 4 customer, and update relation all at once, so common one get Updated
			 * 
			  	insert into vendor (vendor_name,vendor_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				insert into vendor (vendor_name,vendor_id) values (?,default)
				insert into customer (customer_name,customer_id) values (?,default)
				insert into vendor (vendor_name,vendor_id) values (?,default)
				update customer set vendor_id=? where customer_id=?
				update customer set vendor_id=? where customer_id=?
				update customer set vendor_id=? where customer_id=?
				update customer set vendor_id=? where customer_id=?
				update customer set vendor_id=? where customer_id=?
	-->		  Added vendor with customer [Vendor(vendorId=1, vendorName=vendor1, customers=[Customer(customerId=1, customerName=customer2), Customer(customerId=2, customerName=customer3), Customer(customerId=3, customerName=customer1)]), Vendor(vendorId=2, vendorName=vendor2, customers=[Customer(customerId=4, customerName=customer4)]), Vendor(vendorId=3, vendorName=vendor3, customers=[Customer(customerId=3, customerName=customer1)])]
			 */
			
//			END Saving 2stType
			
		}
		
			
		
		
	}

	
	
	
	
	public void getVendor() {
		
		try {
			
			int vendorId = 1;
			Vendor vendor = vendorRepo.findById(vendorId).get();
			log.info("Fetched with id "+vendorId +" {}",vendor);
						
		} catch (Exception e) {
			log.error("Value doesn't exist, Try changing id");
		}
		
		
		try {
			List<Vendor> temp = vendorRepo.findAll();
			log.info("All vendors");
			int index = 0;
			for(Vendor e : temp) {
				log.info("" + (++index)+ ". " + e);
			}
			
		}catch(Exception e) {
			log.error("Error in fetching all vendors "+ e.getMessage());
		}
	}





	public void addCustomerToVendor() {
		
//		saving a vendor
		
		Vendor v = new Vendor(null, "vendor5",
				
				new HashSet<Customer>(
					Arrays.asList(						
						new Customer(null, "Customer10"),
						new Customer(null, "Customer11"),
						new Customer(null, "Customer12")
					)					
				));
		
		int vendorid = vendorRepo.save(v).getVendorId();
		
		log.info("Vendor Id for updating"+vendorid);
		
//		START - Update Operation 
		
		try {
			Vendor exisitingVendor =  vendorRepo.findById(vendorid).get();
			
			
			log.info("Before Updating {}", exisitingVendor);
//			new Customer
			Customer c = new Customer(null, "Customer13");
			
			
//			upating parent
			exisitingVendor.setVendorName(exisitingVendor.getVendorName()+"-U");
			
//			updating all childs			
			exisitingVendor.getCustomers().stream()
											.forEach(e->{
//												System.out.println(e);
												
												e.setCustomerName(e.getCustomerName()+"-U");
												}
											);
//			adding one more child
			exisitingVendor.getCustomers().add(c);
			
			log.info("After Updating {}", exisitingVendor);
			
			
			vendorRepo.save(exisitingVendor);
			
			
			Vendor fetchedUpdatedVendor =  vendorRepo.findById(vendorid).get();
						
			log.info("Fetching from repo after saving updated object  {}", fetchedUpdatedVendor);
			
		}catch(Exception e) {
			
		}
		
//		END - Update Operation   
		
		
	}
	
	

}
