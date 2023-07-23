package org.pm.repository;

import org.pm.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IStudentRepository  extends JpaRepository<Student, Long>{

}
