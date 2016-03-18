package com.wooha.restaurant.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wooha.restaurant.dao.TableDAO;

@Path("/table")
public class TableService {
	
	private TableDAO tableDao;
	
	@GET
	@Path("/getUnoccupiedTables")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUnOccupiedTables(){
		tableDao = new TableDAO();
		
		return tableDao.getUnOccupiedTables().toString();
	}
	
	@GET
	@Path("getOccupiedTables")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOccupiedTables(){
		tableDao = new TableDAO();
		
		return tableDao.getOccupiedTables().toString();
	}

}
