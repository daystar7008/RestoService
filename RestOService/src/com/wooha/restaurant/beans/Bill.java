package com.wooha.restaurant.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity(name = "rst_bill_master")
public class Bill {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	@Column(name = "biller_name")
	private String billerName;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "date")
	private Date date;

	@Column(name = "table_id")
	private int tableId;

	@OneToMany(mappedBy = "bill", fetch = FetchType.LAZY)
	private List<BillDetail> billDetails;
	
	@Column(name = "closed_flag")
	private char closedFlag;

	@Column(name = "delete_flag")
	private char deleteFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillerName() {
		return billerName;
	}

	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public char getClosedFlag() {
		return closedFlag;
	}

	public void setClosedFlag(char closedFlag) {
		this.closedFlag = closedFlag;
	}

	public char getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(char deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Override
	public String toString(){
		JSONObject billJson = new JSONObject();
		billJson.put("id", getId());
		billJson.put("billerName", getBillerName());
		billJson.put("totalAmount", getTotalAmount());
		billJson.put("date", getDate().toString());
		billJson.put("tableId", getTableId());
		billJson.put("billDetails", new JSONArray(getBillDetails()));
		billJson.put("closedFlag", getClosedFlag());
		billJson.put("deleteFlag", getDeleteFlag());
		
		return billJson.toString();
	}

}
