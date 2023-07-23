package org.pm.repository;

import org.pm.entites.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICollegeRepository  extends JpaRepository<College, Long>{

}
