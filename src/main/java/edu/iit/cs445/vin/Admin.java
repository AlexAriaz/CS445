package edu.iit.cs445.vin;

public class Admin {
	private String name;
	private int ID;
	private static int adminID=500;
	
	public Admin(){
		name="Default Admin";
		ID=adminID;
		adminID++;
	}
	
	public Admin(String n){
		name=n;
		ID=adminID;
		adminID++;
	}
	
	public String getName(){return this.name;}
	public int getID(){return this.ID;}
	
	public void setName(String n){this.name=n;}

}
