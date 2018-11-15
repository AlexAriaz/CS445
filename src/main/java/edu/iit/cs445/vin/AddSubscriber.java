package edu.iit.cs445.vin;

import org.json.*;
import java.io.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Path("/sub")
public class AddSubscriber {
	private Address add;
	private Subscriber s;
	
	private static List<Subscriber> subs =  new ArrayList<Subscriber>();
	
	public int addSubscriber(String street, String city, String state, String zip, String name, String email, String phone, String tw, String fb) {
		add=new Address(street, city, state, zip);
		s=new Subscriber(name, email, phone, add, fb, tw);
		if(badState(state)){
			return 0;			
		}
		if(userHasAccount(subs,s)){
			return 0;
		}
		subs.add(s);
		return s.getID();
	}
	
	
	
	public boolean userHasAccount(List<Subscriber> subs, Subscriber s) {
		Iterator<Subscriber> it = subs.iterator();
		while (it.hasNext()) {
			Subscriber su = it.next();
			if (su.getEmail().equals(s.getEmail())){ return true;}
		}
		return false;	
	}
	
	private boolean badState(String s) {
		if(s.equals("AR")||s.equals("AL")||s.equals("DE")
				||s.equals("KY")||s.equals("MA")||s.equals("MS")
				||s.equals("SD")||s.equals("UT")){
			return true;			
		}
		return false;
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postSubcriber(InputStream input){
		
		try{
		BufferedReader br= new BufferedReader(new InputStreamReader(input));
		String line="";
		String pj = "";
		
			while ((line = br.readLine()) != null) {
				pj += line + "\n";
			}
			
			JSONObject j = new JSONObject(pj);
			
			String email = j.getString("email");
			String name = j.getString("name");
			String phone = j.getString("phone");
			JSONObject a = j.getJSONObject("address");
				String street = a.getString("street");
				String city = a.getString("city");
				String state = a.getString("state");
				String zip = a.getString("zip");
			String fb = j.getString("facebook");
			String tw = j.getString("twitter");
			
			int id = addSubscriber(email, name, phone, street, city, state, zip, fb, tw);
			
			
			JSONArray jarray = new JSONArray();
			
			JSONObject jResponse = new JSONObject(new JSONStringer().object().
					key("id").value(s.getID()).key("errors").
					value(jarray).endObject().toString());
			
			return Response.status(201).entity(jResponse.toString()).build();
			
		} catch (JSONException | IOException e){
			return Response.status(404).entity(e.toString()).build();
		}		
	}
		@PUT
		@Path("/{uid}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)		
		public Response putSubcriber(@PathParam("uid") String uid, InputStream input){
			
			try{
			BufferedReader br= new BufferedReader(new InputStreamReader(input));
			String line="";
			String pj = "";
			
				while ((line = br.readLine()) != null) {
					pj += line + "\n";
				}
				
				JSONObject j = new JSONObject(pj);
				
				String email = j.getString("email");
				String name = j.getString("name");
				String phone = j.getString("phone");
				JSONObject a = j.getJSONObject("address");
				String street = a.getString("street");
				String city = a.getString("city");
				String state = a.getString("state");
				String zip = a.getString("zip");
				String fb = j.getString("facebook");
				String tw = j.getString("twitter");
				
				Iterator<Subscriber> i=subs.iterator();
				while(i.hasNext()){
					s=(Subscriber)i.next();
					if(s.getID()==Integer.parseInt(uid)){
						Address add=new Address(street, city, state, zip);
						s.setEmail(email);
						s.setName(name);
						s.setPhone(phone);
						s.setAddress(add);
						s.setFB(fb);
						s.setTwitter(tw);
						JSONArray jarray = new JSONArray();
						JSONObject jResponse = new JSONObject(new JSONStringer().object().
								key("id").value(s.getID()).key("errors").
								value(jarray).endObject().toString());

						return Response.status(200).entity(jResponse.toString()).build();
					}
				}
			
				return Response.status(404).entity("ID not Found").build();
			}
			catch (JSONException | IOException e){
				return Response.status(404).entity(e.toString()).build();
			}		
			
		}
			@GET
			@Path("/{uid}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getSub(@PathParam("uid")String uid){
				Iterator<Subscriber> i= subs.iterator();
				JSONObject j= new JSONObject();
				while (i.hasNext()){
					s=(Subscriber)i.next();
					if(s.getID()==Integer.parseInt(uid)){
						try{
						j.put("name", s.getName());
						j.put("email", s.getEmail());
						j.put("phone", s.getPhone());
						j.put("address", new JSONObject(s.getAddress()));
						j.put("facebook", s.getFB());
						j.put("twitter", s.getTwitter());
						return Response.status(200).entity(j.toString()).build();
						
						}catch (JSONException e){
							return Response.status(404).entity(e.toString()).build();
						}
					}
				}
				return Response.status(201).entity(j.toString()).build();
				
			}
		
			
			@GET
			@Path("/{sid}/delivery")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getDelivery(@PathParam("sid")String sid){
				Iterator<Subscriber> i= subs.iterator();
				JSONObject j= null;
				while (i.hasNext()){
					s=(Subscriber)i.next();
					if(s.getID()==Integer.parseInt(sid)){
						try{
							j=new JSONObject(new JSONStringer().object().key("dow").value(s.getDOW()).key("tod").value(s.getTOD()).endObject().toString());
							
						}catch(JSONException e){
							return Response.status(404).entity(e.toString()).build();
						}
						}
					}
				return Response.status(200).entity(j.toString()).build();
				
			}
			}
			
		