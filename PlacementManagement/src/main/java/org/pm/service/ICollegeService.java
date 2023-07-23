package org.pm.service;

import org.pm.entites.College;
import org.pm.entites.Placement;

public interface ICollegeService {
	
	public College addCollege(College college);
	public College updateCollege(College college);
	public College searchCollege(long id);
	public boolean deleteCollege(long id);
	
	public boolean schedulePlacement(Placement placement);
	
}
