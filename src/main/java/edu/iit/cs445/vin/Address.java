package edu.iit.cs445.vin;

public class Address {
    private String street, city, state, zip;
    
    public Address() {
        this.street = "123 Main ST, Apt 2F";
        this.city = "Anytown";
        this.state = "Anystate";
        this.zip = "12345";
    }
    
    public Address(String street, String city, String state, String zip) {
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zip = zip;
    }
    
    public void setStreet(String st){this.street=st;}
	public void setCity(String c){this.city=c;}
	public void setState(String s){this.state=s;}
	public void setZip(String z){this.zip=z;}
	
	public String getStreet(){return this.street;}
	public String getCity(){return this.city;}
	public String getState(){return this.state;}
	public String getZip(){return this.zip;}
}
