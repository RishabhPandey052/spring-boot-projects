package org.pm.service;

import org.pm.entites.College;
import org.pm.entites.Placement;
import org.pm.repository.ICollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICollegeServiceImpl implements ICollegeService{
	
	@Autowired
	ICollegeRepository repoCollege;
	
	@Autowired
	IPlacementService servicePlacement;
	
	@Override
	public College addCollege(College college) {
		College c = repoCollege.save(college);
		return c;
	}

	@Override
	public College updateCollege(College college) {
		College c = repoCollege.save(college);
		return c;
	}

	@Override
	public College searchCollege(long id) {
		College c = repoCollege.findById(id).get();
		if( c != null) {
			return c;
		}
		return null;
	}

	@Override
	public boolean deleteCollege(long id) {
		College c = repoCollege.findById(id).get();
		if(c != null) {
			repoCollege.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean schedulePlacement(Placement placement) {
		Placement p = servicePlacement.addPlacement(placement);
		if(p != null) {
			return true;
		}
		return false;
	}

}
