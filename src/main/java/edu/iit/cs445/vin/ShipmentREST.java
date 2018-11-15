package edu.iit.cs445.vin;

import org.json.*;
import java.io.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
@Path("/sub/{uid}/shipments")
public class ShipmentREST {

/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShipments(@PathParam("uid")String uid){
		
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
	}*/
	
	/*	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postShipments(@PathParam("uid")String uid,InputStream input){
		try{
			BufferedReader br= new BufferedReader(new InputStreamReader(input));
			String line="";
			String pj = "";
		
			while ((line = br.readLine()) != null) {
				pj += line + "\n";
			}
			JSONObject j=new JSONObject(pj);
			JSONArray a=(JSONArray)j.get("Shipments");
			for(int i=0;i<a.length();i++){
				JSONObject tp=(JSONObject)a.get(i);
				int id=tp.getInt("id");
				String selMonth=tp.getString("selection_month");
				String stat=tp.getString("status");
				Shipments bleh=new Shipments(stat,selMonth,Integer.parseInt(uid));//adds ship obj to ship List
			}
			
			return Response.status(201).entity(j.toString()).build();
		}catch(JSONException | IOException e){
			return Response.status(404).entity(e.toString()).build();
		}
	}*/
	
	
}
