package edu.iit.cs445.vin;

import org.json.*;
import java.io.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Path("/admin")
public class AddAdmin {
	private static List<Admin> mins =  new ArrayList<Admin>();
	private Admin A;
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postAdmin(InputStream input){
		
		BufferedReader br= new BufferedReader(new InputStreamReader(input));
		String line="";
		String pj = "";
		
		try{	
			
			while ((line = br.readLine()) != null) {
				pj += line + "\n";
			}
			JSONObject j = new JSONObject(pj);
			String n=j.getString("name");
			Admin min=new Admin(n);
			mins.add(min);
			
			JSONObject jResponse = new JSONObject(new JSONStringer().object().
					key("id").value(min.getID()).endObject().toString());
			
			return Response.status(201).entity(jResponse.toString()).build();	
		}catch(JSONException | IOException e){
			return Response.status(404).entity(e.toString()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdmins(){
		try{
			JSONArray jArray=new JSONArray();
			Iterator <Admin> ad = mins.iterator();
			while (ad.hasNext()){
				A = (Admin) ad.next();
				jArray.put(new JSONObject().put("id", A.getID()).put("name",A.getName()));
			}
			JSONObject job = new JSONObject(new JSONStringer().object().key("admins").value(jArray).endObject().toString());
			return Response.status(201).entity(job.toString()).build();

			}catch(JSONException e){
				return Response.status(404).entity(e.toString()).build();
			}
		
	}
	
	//just getting one based on aid
		@GET
		@Path("/{aid}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAdmin(@PathParam("aid")String aid){
			Iterator<Admin> i= mins.iterator();
			JSONObject j = null;
			while (i.hasNext()){
				A=(Admin)i.next();
				if(A.getID()==Integer.parseInt(aid)){
					try{
					j=new JSONObject(new JSONStringer().object().key("name").value(A.getName()).endObject().toString());
					}catch(JSONException e){
						return Response.status(404).entity(e.toString()).build();
					}
				}
			}
			return Response.status(200).entity(j.toString()).build();
		}
		
	/*	@POST   //Will finish later
		@Path("/monthly_selection")
		@Produces(MediaType.APPLICATION_JSON)
		public Response postMS(InputStream input){
			try{
			BufferedReader br= new BufferedReader(new InputStreamReader(input));
			String line="";
			String pj = "";
			while ((line = br.readLine()) != null) {
				pj += line + "\n";
			}
			JSONObject j=new JSONObject(input);
			
			String type = j.getString("type");
			String selection_month = j.getString("selection_month");
			JSONArray a = 
			JSONObject w = j.getJSONObject("");
			String variety = w.getString("variety");
			String wine_type = w.getString("wine_type");
			String label_name = w.getString("label_name");
			String grape = w.getString("grape");
			String region = w.getString("region");
			String country = w.getString("country");
			String maker = w.getString("maker");
			String year = w.getString("year");
			
			
			
			}catch(JSONException | IOException e){
				return Response.status(404).entity(e.toString()).build();
			}
			return Response.status(404).entity("404 not found scrub").build();
		}
		*/
		
	}