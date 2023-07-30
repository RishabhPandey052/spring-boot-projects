package Mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Mapping.entity.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer> {

}
