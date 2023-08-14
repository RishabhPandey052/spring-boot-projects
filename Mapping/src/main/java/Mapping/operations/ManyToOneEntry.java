package Mapping.operations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mapping.entity.Project;
import Mapping.entity.Student;
import Mapping.repo.ProjectRepo;
import Mapping.repo.StudentRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManyToOneEntry {
	
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	StudentRepo studentRepo;

	public void addProject() {
		log.info("Inside adding project");
		
		if(projectRepo.count() != 0) {
			
			log.warn("Project Entity already exists");
			log.info("Exiting adding project");
			return;
		}
		
		try {
			
//			create a project
			Project p = new Project(null, "project1" );
			
			Student s1 = new Student(null,"student1",p);
			Student s2 = new Student(null,"student2",p);
			Student s3 = new Student(null,"student3",p);
			
			studentRepo.saveAll(Arrays.asList(s1,s2,s3));
			
			log.info("saved Entities {} ", Arrays.asList(s1,s2,s3));
			
			
			System.out.println(projectRepo.findAll());
			
			
			
		} catch(Exception e) {
			
			log.error("Couldn't add project entity" + e.getMessage());
		}
		
		log.info("Exiting adding project");
		
	}

}
