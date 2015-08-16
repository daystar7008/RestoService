package com.wooha.restaurant.dao;

import java.util.List;

import org.hibernate.Session;

import com.wooha.hibernate.util.HibernateUtil;
import com.wooha.restaurant.beans.Category;

public class CategoryDAO {

	private Session session;
	
	public CategoryDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public List<Category> getAllCategories(){
		@SuppressWarnings("unchecked")
		List<Category> categories = session.createCriteria(Category.class).list();
		
		return categories;
	}
	
	public Category getCategory(int id){
		Category category = (Category)session.get(Category.class, id);
		return category;
	}
	
	public static void main(String[] args) {
		CategoryDAO categoryAccess = new CategoryDAO();
		for(Category category : categoryAccess.getAllCategories()){
			System.out.println(category.getDescription());
		}
		
		System.out.println(categoryAccess.getCategory(1).getDescription());
	}
	
}
