package com.wooha.restaurant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONObject;

@Entity(name="rst_categories")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="delete_flag")
	private char deleteFlag;
	
	public Category() {

	}
	
	public Category(int id){
		this.id = id;
	}

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

	public char getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(char deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString(){
		JSONObject categoryJson = new JSONObject();
		categoryJson.put("id", getId());
		categoryJson.put("description", getDescription());
		//categoryJson.put("deleteFlag", getDeleteFlag());
		
		return categoryJson.toString();
	}
	
}
