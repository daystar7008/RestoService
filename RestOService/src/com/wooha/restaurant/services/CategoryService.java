package com.wooha.restaurant.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wooha.restaurant.dao.CategoryDAO;
import com.wooha.restaurant.dao.SubCategoryDAO;

@Path("/category")
public class CategoryService {

	private CategoryDAO categoryDao;
	private SubCategoryDAO subCategoryDao;
	
	@Path("/getMainCategories")
	@GET @Produces(MediaType.APPLICATION_JSON)
	public String getMainCategories(){
		categoryDao = new CategoryDAO();
		
		return categoryDao.getAllCategories().toString();
	}
	
	@Path("/getSubCategories/{categoryId}")
	@GET @Produces(MediaType.APPLICATION_JSON)
	public String getSubCategories(@PathParam("categoryId") int categoryId){
		subCategoryDao = new SubCategoryDAO();
		categoryDao = new CategoryDAO();
		return subCategoryDao.getSubCategories(categoryId).toString();
	}
	
}
