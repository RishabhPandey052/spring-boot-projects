package Mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project") 
@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer projectId;
	
	private String projectName;
	
	
}
