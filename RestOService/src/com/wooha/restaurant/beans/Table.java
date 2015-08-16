package com.wooha.restaurant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONObject;

@Entity(name="rst_tables")
public class Table {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="occupied_flag")
	private char occupiedFlag;
	
	@Column(name="bill_id")
	private String billId;
	
	@Column(name="delete_flag")
	private char deleteFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getOccupiedFlag() {
		return occupiedFlag;
	}

	public void setOccupiedFlag(char occupiedFlag) {
		this.occupiedFlag = occupiedFlag;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public char getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(char deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Override
	public String toString(){
		JSONObject tableJson = new JSONObject();
		tableJson.put("id", getId());
		tableJson.put("billId", getBillId());
		tableJson.put("description", getDescription());
		tableJson.put("occupiedFlag", Character.toString(getOccupiedFlag()));
		tableJson.put("deleteFlag", Character.toString(getDeleteFlag()));
		
		return tableJson.toString();
	}

}
