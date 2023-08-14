package Mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Mapping.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
