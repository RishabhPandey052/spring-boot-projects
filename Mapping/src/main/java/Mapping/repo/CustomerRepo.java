package Mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Mapping.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
