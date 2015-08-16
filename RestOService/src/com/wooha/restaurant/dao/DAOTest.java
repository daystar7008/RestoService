package com.wooha.restaurant.dao;

import java.util.List;

import org.hibernate.Session;

import com.wooha.hibernate.util.HibernateUtil;
import com.wooha.restaurant.beans.Bill;
import com.wooha.restaurant.beans.BillDetail;
import com.wooha.restaurant.beans.Category;
import com.wooha.restaurant.beans.Item;
import com.wooha.restaurant.beans.SubCategory;
import com.wooha.restaurant.beans.Table;

public class DAOTest {

	private Session session;

	public DAOTest() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void getTables(){
		@SuppressWarnings("unchecked")
		List<Table> tables = (List<Table>)session.createCriteria(Table.class).list();
		
		for(Table table : tables)
			System.out.println(table.getDescription());
		
		session.close();
	}
	
	public void getCategories(){
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>)session.createCriteria(Category.class).list();
		System.out.println(categories);
		
		/*for(Category category : categories)
			System.out.println(category.getDescription());*/
		
		session.close();
	}
	
	public void getSubCategories(){
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategories = (List<SubCategory>)session.createCriteria(SubCategory.class).list();
		
		for(SubCategory subCategory : subCategories)
			System.out.println(subCategory.getDescription() + ":" + subCategory.getCategory().getDescription());
	}
	
	public void getItems(){
		@SuppressWarnings("unchecked")
		List<Item> items = (List<Item>)session.createCriteria(Item.class).list();
		
		for(Item item : items)
			System.out.println(item.getDescription() + " : "
					+ item.getCategory().getDescription() + " : "
					+ item.getSubCategory().getDescription());
	}
	
	public void getBill(){
		@SuppressWarnings("unchecked")
		List<Bill> bills = (List<Bill>)session.createCriteria(Bill.class).list();
		System.out.println(bills);
		/*for(Bill bill : bills){
			System.out.println(bill.getTotalAmount());
			System.out.println("---------------------");
			for(BillDetail billDetails : bill.getBillDetails()){
				Item item = billDetails.getItem();
				System.out.println(item.getDescription() + " - " + item.getPrice());
			}
		}*/
	}
	
	public void getBillDetails(){
		@SuppressWarnings("unchecked")
		List<BillDetail> billDetails = session.createCriteria(BillDetail.class).list();
		System.out.println(billDetails);
	}
	
	public static void main(String[] args) {
		new DAOTest().getBill();
	}
	
}
