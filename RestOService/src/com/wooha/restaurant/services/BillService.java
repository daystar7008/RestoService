package com.wooha.restaurant.services;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import com.wooha.restaurant.dao.BillDAO;
import com.wooha.restaurant.json.util.JSONBillUtil;

@Path("/bill")
public class BillService {
	
	private BillDAO billDao;
	private JSONBillUtil jsonBillUtil;
	
	@Path("/saveBill")
	@POST @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
	public String saveBill(@FormParam("bill") String billJson){
		String status = "";
		jsonBillUtil = new JSONBillUtil();
		billDao = new BillDAO();
		try {
			long val = billDao.saveBill(jsonBillUtil.jsonToBill(billJson));
			status = Long.toString(val);
		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	@Path("/getBill/{billId}")
	@GET @Produces(MediaType.APPLICATION_JSON)
	public String getBill(@PathParam("billId") String billId){
		billDao = new BillDAO();
		return billDao.getBill(billId).toString();
	}
	
}
