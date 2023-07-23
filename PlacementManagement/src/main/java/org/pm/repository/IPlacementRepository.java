package org.pm.repository;

import org.pm.entites.Placement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlacementRepository extends JpaRepository<Placement,Long> {

}
