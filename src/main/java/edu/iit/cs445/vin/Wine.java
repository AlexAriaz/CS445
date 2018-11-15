package edu.iit.cs445.vin;

import org.json.*;
import java.io.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.time.Year;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Wine {
	private List<Wine> cellar=new ArrayList<Wine>();
	private WineVariety wv;
	private WineType wt;
	private String labelName;
	private String grape;	// e.g. Merlot, Chardonnay, Riesling, etc.
	private String region;	// e.g. Napa, Russian Valley, etc.
	private String country; // e.g. France, USA, Australia, Chile
	private String maker;	// the wine maker, e.g. Sterling, Krupp Brother, etc.
	private Year year;		// Vintage year
	private static int numberOfRatings;
	private static float rating = 0;
	private int ID;
	private static int wineID=100;

	public Wine() {
		this.wv = WineVariety.RED;
		this.wt = WineType.TABLE;
		this.labelName = "The Mission";
		this.grape = "Cabernet Sauvignon";
		this.region = "Napa";
		this.country = "USA";
		this.maker = "Sterling";
		this.year = Year.parse("2011");
		this.ID = wineID;
		wineID++;
		cellar.add(this);
	}

	public Wine(WineVariety v, WineType t, String ln, String g, String r, String c, String m, Year y) {
		this.wv = v;
		this.wt = t;
		this.labelName = ln;
		this.grape = g;
		this.region = r;
		this.country = c;
		this.maker = m;
		this.year = y;
		this.ID = wineID;
		wineID++;
		cellar.add(this);
	}

	@Path("/wines/{wid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWines(@PathParam("wid")String wid){
		Wine vine;
		Iterator<Wine> i= cellar.iterator();
		JSONObject j= new JSONObject();
		while (i.hasNext()){
			vine=(Wine)i.next();
			if(vine.getID()==Integer.parseInt(wid)){
				try{
					j.put("id", vine.getID());
					j.put("variety", vine.getVariety());
					j.put("wine_type", vine.getType());
					j.put("label_name", vine.getLabelName());
					j.put("grape", vine.getGrape());
					j.put("region", vine.getRegion());
					j.put("country", vine.getCountry());
					j.put("maker", vine.getMaker());
					j.put("year", vine.getYear());
					j.put("rating_count", vine.getNumberOfRatings());
					j.put("rating", vine.getRating());
					
					return Response.status(200).entity(j.toString()).build();
					
				}catch(JSONException e){
					return Response.status(404).entity(e.toString()).build();
				}
			}
		}
		return Response.status(200).entity(j.toString()).build();
	}
		
	
	public WineVariety getVariety() {
		return this.wv;
	}
	
	public WineType getType() {
		return this.wt;
	}

	public String getLabelName() {
		return this.labelName;
	}

	public String getGrape() {
		return this.grape;
	}

	public String getRegion() {
		return this.region;
	}
	
	public String getCountry() {
		return this.country;
	}

	public String getMaker() {
		return this.maker;
	}
	
	public String getYear() {
		return this.year.toString();
	}

	public int getNumberOfRatings() {
		return this.numberOfRatings;
	}
	
	public float getRating() {
		return this.rating;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public void addRating(int r) {
		numberOfRatings = numberOfRatings + 1;
		rating = rating*((float)(numberOfRatings - 1)/numberOfRatings) + (float)r/numberOfRatings;
	}
	
	public boolean isMatch(String kw) {
        if (isMatchVariety(kw) || isMatchType(kw) || isMatchLabel(kw) || isMatchGrape(kw) || isMatchRegion(kw) || isMatchCountry(kw) || isMatchMaker(kw) || isMatchYear(kw)) {
                return true;
        } else return false;
	}
	    
    private boolean isMatchVariety(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.wv.name().matches(regex);
    }

    private boolean isMatchType(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.wt.name().matches(regex);
    }
    
    private boolean isMatchLabel(String kw) {
        String regex = "(?i).*" + kw + ".*";
        return this.labelName.matches(regex);
    }
    
    private boolean isMatchGrape(String kw) {
    	return false;
    }
    
    private boolean isMatchRegion(String kw) {
    	return false;
    }

    private boolean isMatchCountry(String kw) {
    	return false;
    }

    private boolean isMatchMaker(String kw) {
    	return false;
    }

    private boolean isMatchYear(String kw) {
    	return false;
    }

}
