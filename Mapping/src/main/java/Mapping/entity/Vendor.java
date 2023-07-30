package Mapping.entity;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vendor")
@Entity
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Integer vendorId;
	
	
	private String vendorName; 
	
	
	@OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "vendorId")  // imp otherwise hibernate create third table, name attribute signifies name of foriegnkeyColumn in child Table
	private Set<Customer> customers;
	
	

}
