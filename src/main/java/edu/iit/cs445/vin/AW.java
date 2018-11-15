package edu.iit.cs445.vin;

import java.util.ArrayList;
import java.util.List;

public class AW extends MonthlySelection {
	List<Wine> ms=new ArrayList<Wine>();
	
	public AW(String ym, MonthlySelectionType mst, List<Wine> wine) {
		super(ym, mst, wine);
		
	}
	
	@Override
	void addWine(Wine w) {
		// Make sure only white wines are added

	}

}
