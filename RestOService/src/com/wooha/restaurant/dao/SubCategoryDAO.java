package com.wooha.restaurant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wooha.hibernate.util.HibernateUtil;
import com.wooha.restaurant.beans.Category;
import com.wooha.restaurant.beans.SubCategory;

public class SubCategoryDAO {
	
	private Session session;
	
	public SubCategoryDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public SubCategory getSubCategory(long id) {
		SubCategory subCategory = (SubCategory)session.get(SubCategory.class, id);
		
		return subCategory;
	}
	
	public List<SubCategory> getSubCategories() {
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategories = session.createCriteria(SubCategory.class).list();
		
		return subCategories;
	}
	
	public List<SubCategory> getSubCategories(Category category){
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategories = session.createQuery("SELECT subCategory FROM com.wooha.restaurant.beans.SubCategory subCategory "
															  + "JOIN subCategory.category = '" + category.getId()+ "'").list();
		
		return subCategories;
	}
	
	public long saveSubCategory(SubCategory subCategory){
		long id = 0;
		if(subCategory != null){
			Transaction transaction = session.beginTransaction();
			id = (Long)session.save(subCategory);
			transaction.commit();
		}
		return id;
	}
	
	public static void main(String[] args) {
		//SubCategoryDAO dao = new SubCategoryDAO();
		/*System.out.println(dao.getSubCategory(15).getDescription());
		
		for(SubCategory subCategory : dao.getSubCategories()){
			System.out.println(subCategory.getDescription());
		}*/
		
		/*SubCategory category = new SubCategory();
		category.setCategory(new CategoryDAO().getCategory(1));
		category.setDescription("Cool Drinks");*/
		
		//System.out.println(dao.saveSubCategory(category));
		
	}
	

}
