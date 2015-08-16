package com.wooha.restaurant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wooha.hibernate.util.HibernateUtil;
import com.wooha.restaurant.beans.Bill;

public class BillDAO {

	private Session session;
	
	public BillDAO() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public List<Bill> getItems(){
		@SuppressWarnings("unchecked")
		List<Bill> bills = (List<Bill>)session.createCriteria(Bill.class).list();
		
		return bills;
	}
	
	public Bill getBill(String billId){
		Bill bill = (Bill)session.get(Bill.class, billId);
		
		return bill;
	}
	
	public long saveBill(Bill bill){
		long id = 0;
		if(bill != null){
			Transaction transaction = session.beginTransaction();
			id = (Long)session.save(bill);
			transaction.commit();
		}
		
		return id;
	}
	
	public void updateBill(Bill bill){
		if(bill != null && bill.getId() != null){
			Transaction transaction = session.beginTransaction();
			session.update(bill);
			transaction.commit();
		}
	}
	
	public static void main(String[] args) {
		//BillDAO dao = new BillDAO();
		/*for(Bill bill : dao.getItems()){
			System.out.println(bill.getId() + ":" + bill.getTotalAmount());
			System.out.println("-----------------------------------------");
			for(BillDetail details : bill.getBillDetails()){
				System.out.println(details.getItem().getDescription() + ":" + details.getAmount());
			}
		}*/
		//System.out.println(dao.getBill("1").getTotalAmount());
		
	}
	
}
