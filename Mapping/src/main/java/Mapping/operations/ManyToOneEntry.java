package Mapping.operations;

import java.util.Arrays;
import java.util.List;

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
			
	
			
		} catch(Exception e) {
			
			log.error("Couldn't add project entity" + e.getMessage());
		}
		
		log.info("Exiting adding project");
		
	}
	
	
	public void getStudentsWithProject() {
		
		
		try {
			
//			getting only student without project;
			
			int studentId = 1;
			
			Student s = studentRepo.findById(studentId).get();
			
			
			try {
//			throws exception because of default toString will try to print project which not got fetched due to lazy loading  
				System.out.println(s);
			} catch (Exception e) {
				log.info("couldn't fetch student with id "+ studentId );
			}
			
//			doesn't throw exception because not printing any project feilds other than projectId
			log.info("Fetched student with id "+ studentId + " " + s.getStudentId() + " " + s.getStudentName() + " " + s.getAssignedProject().getProjectId());
			
			
//			now fetching all student with project by using  PROJECTION
			List<Student> stuList =  studentRepo.getAllStudentsWithProject();
			
			int index = 0;
			
			for(Student temp : stuList) {
				log.info( ""+ (++index) +".{}", temp);
			};
			
			
//			if need particular student with project add comparison with that id in query
		} catch(Exception e) {
			
			log.error("couldn't fetch student "+e.getMessage() );
		}
	}

}
