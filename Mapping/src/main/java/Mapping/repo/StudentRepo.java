package Mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Mapping.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
