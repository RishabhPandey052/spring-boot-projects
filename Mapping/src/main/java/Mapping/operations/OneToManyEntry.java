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
		
		log.info("Exiting AddVendor");
		
		
	}

	
	
	
	
	public void getVendor() {
		
		log.info("Getting vendor");
		
		try {
			log.info("Getting specific vendor");
			
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
		
		log.info("Exiting getting vendor");
	}





	public void addCustomerToVendor() {
		
		log.info("Inside Add Customer To Vendor");
		
//		saving a vendor
		
		Vendor v = new Vendor(null, "vendor4",
				
				new HashSet<Customer>(
					Arrays.asList(						
						new Customer(null, "Customer10"),
						new Customer(null, "Customer11"),
						new Customer(null, "Customer12")
					)					
				));
		
		int vendorid = vendorRepo.save(v).getVendorId();
		
		log.info("Vendor Id for updating "+vendorid);
		
//		START - Update Operation 
		
		try {
			Vendor existingVendor =  vendorRepo.findById(vendorid).get();
			
			
			log.info("Before Updating {}", existingVendor);
//			new Customer
			Customer c = new Customer(null, "Customer13-N");
			
			
//			upating parent
			existingVendor.setVendorName(existingVendor.getVendorName()+"-U");
			
//			updating all childs			
			existingVendor.getCustomers().stream()
											.forEach(e->{
//												System.out.println(e);
												
												e.setCustomerName(e.getCustomerName()+"-U");
												}
											);
//			adding one more child
			existingVendor.getCustomers().add(c);
			
			log.info("After Updating {}", existingVendor);
			
			
			vendorRepo.save(existingVendor);
			
			
			Vendor fetchedUpdatedVendor =  vendorRepo.findById(vendorid).get();
						
			log.info("Fetching from repo after saving updated object  {}", fetchedUpdatedVendor);
			
		}catch(Exception e) {
			log.info("error in updating ");
		}
		
		log.info("Exiting Add Customer To Vendor");
		
//		END - Update Operation   
		
		
	}





	public void removeCustomerFromVendor() {
		
		log.info("Inside Remove Customer To Vendor");
		
//		saving a vendor
		
		Vendor v = new Vendor(null, "vendor5",
				
				new HashSet<Customer>(
					Arrays.asList(						
						new Customer(null, "Customer20"),
						new Customer(null, "Customer21"),
						new Customer(null, "Customer22")
					)					
				));
		
		int vendorId = vendorRepo.save(v).getVendorId();
		
		log.info("Vendor Id for deleting child "+vendorId);
		
		
//		START Delete child operation
		
		try {
			Vendor existingVendor =  vendorRepo.findById(vendorId).get();
			
			log.info("Before deleting customer {}", existingVendor);
			Customer c = ( Customer )existingVendor.getCustomers().toArray()[0];
			

//			doesn't remove child object just set foreign key to null
//			to delete child too set (orphanRemoval = true) in relationship from parent class 
			existingVendor.getCustomers().remove(c);
			
			
			vendorRepo.save(existingVendor);
			
			Vendor fetchedUpdatedVendor =  vendorRepo.findById(vendorId).get();
			
			log.info("Fetching from repo after saving deleting customer {}", fetchedUpdatedVendor);
			
			
		} catch (Exception e) {
			
			
			log.error("error in delete operation " + e.getMessage());
		}
		
//		END   Delete child operation
		
		log.info("Exiting Remove Customer To Vendor");
		
	}





	public void removeVendor() {
		
		log.info("Inside Remove Vendor");
		
//		saving a vendor
		Vendor v = new Vendor(null, "vendor6",
				
				new HashSet<Customer>(
					Arrays.asList(						
						new Customer(null, "Customer31"),
						new Customer(null, "Customer32")
					)					
				));
		
		int vendorId = vendorRepo.save(v).getVendorId();
		
		log.info("Vendor Id for deleting parent "+vendorId);
		
		
//		START Delete parent operation
		
		try {
			Vendor existingVendor =  vendorRepo.findById(vendorId).get();
			
			
			vendorRepo.delete(existingVendor);
//			delete all childs first then parent
			
			
			
		} catch (Exception e) {
			
			log.error("error in deleting vendor " + e.getMessage());
		}
		
//		END   Delete parent operation
		
		log.info("Exiting Remove Customer To Vendor");
		
	}
	
	

}
