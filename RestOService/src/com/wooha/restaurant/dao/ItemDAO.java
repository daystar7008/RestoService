package com.wooha.restaurant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wooha.hibernate.util.HibernateUtil;
import com.wooha.restaurant.beans.Item;
import com.wooha.restaurant.beans.SubCategory;

public class ItemDAO {

	private Session session;
	
	public ItemDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public List<Item> getItems(){
		@SuppressWarnings("unchecked")
		List<Item> items = session.createCriteria(Item.class).list();
		
		return items;
	}
	
	public List<Item> getItems(SubCategory subCategory){
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>) session.createQuery("SELECT item "
															+ "FROM com.wooha.restaurant.beans.Item item JOIN item.subCategory subCategory"
														  + " WHERE item.subCategory ='" + subCategory.getId() + "'").list();
		
		return items;
	}
	
	public Item getItem(long id){
		Item item = (Item)session.get(Item.class, id);
		
		return item;
	}
	
	public long saveItem(Item item){
		long id = 0;
		if(item != null){
			Transaction transaction = session.beginTransaction();
			id = (Long) session.save(item);
			transaction.commit();
		}
		
		return id;
	}
	
	public static void main(String[] args) {
		ItemDAO dao = new ItemDAO();
		//List<Item> items = dao.getItems(new SubCategoryDAO().getSubCategory(15));
		List<Item> items = dao.getItems(new SubCategoryDAO().getSubCategory(15));
		
		for(Item item : items){
			System.out.println(item.getDescription() + ":" + item.getPrice() + ":" + item.getSubCategory().getDescription() + ":" + item.getCategory().getDescription());
		}
		
		//System.out.println(new SubCategoryDAO().getSubCategory(15).getDescription());
	}
	
}
