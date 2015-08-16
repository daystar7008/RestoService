package com.wooha.restaurant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.json.JSONObject;

@Entity(name="rst_items")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "sub_category_id")
	private SubCategory subCategory;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "delete_flag")
	private char deleteFlag;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(char deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Override
	public String toString(){
		JSONObject itemJson = new JSONObject();
		itemJson.put("id", getId());
		itemJson.put("categoryId", getCategory().getId());
		itemJson.put("subCategoryId", getSubCategory().getId());
		itemJson.put("description", getDescription());
		itemJson.put("price", getPrice());
		//itemJson.put("deleteFlag", getDeleteFlag());
		
		return itemJson.toString();
	}
	
}
