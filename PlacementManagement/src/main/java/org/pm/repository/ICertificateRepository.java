package org.pm.repository;

import org.pm.entites.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICertificateRepository extends JpaRepository<Certificate, Long>{

}
