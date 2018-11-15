package edu.iit.cs445.vin;

import java.util.ArrayList;
import java.util.List;

public class RW extends MonthlySelection {
	List<Wine> ms=new ArrayList<Wine>();
	
	public RW(String ym, MonthlySelectionType mst, List<Wine> wine) {
		super(ym, mst, wine);
		
	}
	
	@Override
	void addWine(Wine w) {
		// red and white wines are added

	}

}