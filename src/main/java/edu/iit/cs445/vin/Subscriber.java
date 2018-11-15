package edu.iit.cs445.vin;

public class Subscriber {
    private String name, email, phone, twitter, facebook, tod, dow;
    private Address address;
    private MonthlySelectionType mst;
    private int ID;
    private static int subID=1;
    
    public Subscriber() {
    	this.name = "Jane Doe";
    	this.email = "jane.doe@example.com";
    	this.phone = "1234567890";
    	this.address = new Address();
    	this.mst = MonthlySelectionType.RW;
    	this.dow="Mon";
    	this.tod="AM";
    	this.ID = subID;
    	subID++;
    }
    public Subscriber (String name, String email, String phone, Address address) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	this.address = address;
    	this.mst = MonthlySelectionType.RW;
    	this.ID = subID;
    	subID++;
    }
    public Subscriber (String name, String email, String phone, Address address, String fb, String tw) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	this.address = address;
    	this.twitter = tw;
    	this.facebook = fb;
    	this.mst = MonthlySelectionType.RW;
    	this.ID = subID;
    	subID++;
    }

    private boolean isMatchName(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.name.matches(regex);
    }

    private boolean isMatchEmail(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.email.matches(regex);
    }

    private boolean isMatchPhone(String kw) {
    	String s = kw.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters from search string
    	String regex = "(?i).*" + s + ".*";
    	return this.phone.matches(regex);
    }
    public boolean isMatch(String kw) {
    	if (isMatchName(kw) || isMatchEmail(kw) || isMatchPhone(kw)) {
    		return true;
    	} else return false;
    }

    public int getID() {
    	return this.ID;
    }

    public void updateInfo(String name, String email, String phone, Address address) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone;
    	this.address = address;
    }
    
    public MonthlySelectionType getPreference() {
    	return mst;
    }
    
    public void setPreference(MonthlySelectionType t) {
    	this.mst = t;
    }

    public void setName(String n){this.name=n;}
	public void setEmail(String e){this.email=e;}
	public void setPhone(String p){this.phone=p;}
	public void setFB(String fb){this.facebook=fb;}
	public void setTwitter(String t){this.twitter=t;}
	public void setAddress(Address a){this.address=a;}
    public void setTOD(String t){this.tod=t;}
    public void setDOW(String d){this.dow=d;}
    
	public String getName(){return this.name;}
	public String getEmail(){return this.email;}
	public String getPhone(){return this.phone;}
	public String getFB(){return this.facebook;}
	public String getTwitter(){return this.twitter;}
	public Address getAddress(){return this.address;}
	public String getTOD(){return this.tod;}
	public String getDOW(){return this.dow;}
	
}
