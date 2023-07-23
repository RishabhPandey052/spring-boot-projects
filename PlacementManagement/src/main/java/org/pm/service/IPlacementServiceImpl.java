package org.pm.service;

import org.pm.entites.Placement;
import org.pm.repository.IPlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPlacementServiceImpl implements IPlacementService {
	
	@Autowired
	IPlacementRepository repoPlacement;
	
	@Override
	public Placement addPlacement(Placement placement) {
		Placement p = repoPlacement.save(placement);
		return p;
	}

	@Override
	public Placement updatePlacement(Placement placement) {
		Placement p = repoPlacement.save(placement);
		return p;
	}

	@Override
	public Placement searchPlacement(long id) {
		Placement p = repoPlacement.findById(id).get();
		if ( p != null) {
			return p;
		}
		return null;
	}

	@Override
	public boolean cancelPlacement(long id) {
		Placement p = repoPlacement.findById(id).get();
		if( p != null) {
			repoPlacement.delete(p);
			return true;
		}
		return false;
	}

}
