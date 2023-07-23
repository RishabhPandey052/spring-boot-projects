package org.pm.repository;

import org.pm.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	
}
