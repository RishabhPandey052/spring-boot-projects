package Mapping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Mapping.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query("""
			select 
			
				new Mapping.entity.Student( s.studentId, s.studentName, p)
				
				from Student s
				
				join Project p
				
				on s.assignedProject.projectId = p.projectId
			
			""")
	List<Student> getAllStudentsWithProject();

}
