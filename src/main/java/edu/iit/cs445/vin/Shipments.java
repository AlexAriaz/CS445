package edu.iit.cs445.vin;


import java.util.List;
import java.time.YearMonth;
import java.util.ArrayList;

public class Shipments {
	private String tod, dow, status;
	private YearMonth ym;
	private List<Wine> ms;
	private List<MonthlySelection> mss=new ArrayList<MonthlySelection>();
	private MonthlySelection m;
	private int subID;
	private int ID;
	private static int shipID=600;
	
	public Shipments(){
		this.status="Pending";
		this.dow="Mon";
		this.tod="AM";
		ID=shipID;
		shipID++;
	}
	
	public Shipments(String stat, String ym, int uid){
		this.status=stat;
		this.ym = YearMonth.parse(ym);
		this.subID=uid;
		//mss=m.getMonthlySelections();
		ID=shipID;
		shipID++;
	}
	
	public int getSubID(){return this.subID;}
	public String getStatus(){return this.status;}
	public String getTOD(){return this.tod;}
	public String getDOW(){return this.dow;}
	
	
	public void setSubID(int i){this.subID=i;}
	public void setStatus(String s){this.status=s;}
    public void setTOD(String t){this.tod=t;}
    public void setDOW(String d){this.dow=d;}
}
