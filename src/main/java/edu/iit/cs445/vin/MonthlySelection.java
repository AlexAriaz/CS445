package edu.iit.cs445.vin;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public abstract class MonthlySelection {
	protected MonthlySelectionType mst;
	private YearMonth ym;
	private List<MonthlySelection> mss=new ArrayList<MonthlySelection>();
	private List<Wine> ms = new ArrayList<Wine>();
	private int ID;
	private static int msID=800;
	
	abstract void addWine(Wine w);
	
	public boolean isMatch(String kw) {
		Iterator<Wine> it = this.ms.iterator();
		while (it.hasNext()) {
			Wine w = it.next();
			if (w.isMatch(kw)) return true;
		}
		return false;
	}
	
	public MonthlySelection() {
		this.ym = YearMonth.now().plusMonths(1);// next month's selection
		ID=msID;
		msID++;
		mss.add(this);
	}
	
	public MonthlySelection(String ym,MonthlySelectionType type, List<Wine> wine) {	// Must be in the yyyy-mm format
		this.ym = YearMonth.parse(ym);
		this.ms=wine;
		this.mst=type;
		ID=msID;
		msID++;
		mss.add(this);
	}
	
	public List<MonthlySelection> getMonthlySelections(){
		return this.mss;
	}
	
	public List<Wine> getWine(){
		return ms;
	}
}
