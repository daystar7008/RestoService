package com.wooha.restaurant.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wooha.restaurant.dao.ItemDAO;

@Path("/item")
public class ItemService {

	private ItemDAO itemDao;
	
	@GET
	@Path("/getItems/{subCategoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItems(@PathParam("subCategoryId") long subCategoryId){
		itemDao = new ItemDAO();
		
		return itemDao.getItems(subCategoryId).toString();
	}
	
}
