package org.pm.service;

import org.pm.entites.Placement;

public interface IPlacementService {
	
	public Placement addPlacement(Placement placement);
	public Placement updatePlacement(Placement placement);
	public Placement searchPlacement(long id);
	public boolean cancelPlacement(long id);

}
