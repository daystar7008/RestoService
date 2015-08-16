package com.wooha.restaurant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.json.JSONObject;

@Entity(name = "rst_bill_details")
public class BillDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "bill_id")
	private Bill bill;

	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name = "quantity")
	private short quantity;

	@Column(name = "amount")
	private double amount;

	@Column(name = "delete_flag")
	private char deleteFlag;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public char getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(char deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Override
	public String toString(){
		JSONObject billDetailJson = new JSONObject();
		billDetailJson.put("id", getId());
		billDetailJson.put("billId", getBill().getId());
		billDetailJson.put("item", new JSONObject(getItem()));
		billDetailJson.put("quantity", getQuantity());
		billDetailJson.put("amount", getAmount());
		billDetailJson.put("deleteFlag", getDeleteFlag());
		
		return billDetailJson.toString();
	}

}
