package com.wooha.restaurant.dao;

import java.util.List;

import org.hibernate.Session;

import com.wooha.hibernate.util.HibernateUtil;
import com.wooha.restaurant.beans.Table;

public class TableDAO {
	
	private Session session;
	
	public TableDAO(){
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public List<Table> getTables(){
		@SuppressWarnings("unchecked")
		List<Table> tables = session.createCriteria(Table.class).list();
		
		return tables;
	}
	
	public Table getTable(int id){
		Table table = (Table) session.get(Table.class, id);
		
		return table;
	}
	
	public List<Table> getOccupiedTables(){
		@SuppressWarnings("unchecked")
		List<Table> tables = session.createQuery("SELECT table FROM com.wooha.restaurant.beans.Table table "
												+ "WHERE table.occupiedFlag='Y'").list();
		
		return tables;
	}
	
	public List<Table> getUnOccupiedTables(){
		@SuppressWarnings("unchecked")
		List<Table> tables = session.createQuery("SELECT table FROM com.wooha.restaurant.beans.Table table "
												+ "WHERE table.occupiedFlag='N'").list();
		
		return tables;
	}
	
	public boolean isTableOccupied(int tableId){
		Table table = (Table) session.get(Table.class, tableId);
		if(table != null && table.getOccupiedFlag() == 'Y'){
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TableDAO dao = new TableDAO();
		for(Table table : dao.getUnOccupiedTables())
			System.out.println(table.getDescription());
		//System.out.println(dao.getTable(1).getDescription());
	}

}
