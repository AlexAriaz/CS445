package edu.iit.cs445.vin;

import java.time.*;
import java.util.List;
import java.util.ArrayList;

public class AR extends MonthlySelection {
	List<Wine> ms=new ArrayList<Wine>();
	
	public AR(String ym, MonthlySelectionType mst, List<Wine> wine) {
		super(ym, mst, wine);
		
	}
	
	@Override
	void addWine(Wine w) {
		// Make sure only red wines are added

	}

}