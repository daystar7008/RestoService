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

	public static final String ID = "id";
	public static final String BILLER_NAME = "billerName";
	public static final String TOTAL_AMOUNT = "totalAmount";
	public static final String DATE = "date";
	public static final String TABLE_ID = "tableId";
	public static final String BILL_DETAILS = "billDetails";
	public static final String CLOSED_FLAG = "closedFlag";
	
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
		billJson.put(ID, getId());
		billJson.put(BILLER_NAME, getBillerName());
		billJson.put(TOTAL_AMOUNT, getTotalAmount());
		billJson.put(DATE, getDate().toString());
		billJson.put(TABLE_ID, getTableId());
		billJson.put(CLOSED_FLAG, Character.toString(getClosedFlag()));
		billJson.put("deleteFlag", getDeleteFlag());

		JSONArray billDetailsJson = new JSONArray();
		for(BillDetail billDetail : getBillDetails()){
			JSONObject billDetailJson = new JSONObject();
			JSONObject itemJson = new JSONObject();
			
			billDetailJson.put(BillDetail.ID, billDetail.getId());
			billDetailJson.put(BillDetail.QUANTITY, billDetail.getQuantity());
			billDetailJson.put(BillDetail.AMOUNT, billDetail.getAmount());
			
			Item item = billDetail.getItem();
			itemJson.put(Item.ID, item.getId());
			itemJson.put(Item.DESCRIPTION, item.getDescription());
			itemJson.put(Item.PRICE, item.getPrice());
			
			billDetailJson.put(BillDetail.ITEM, itemJson);
			
			billDetailsJson.put(billDetailJson);
		}
		
		billJson.put("billDetails", billDetailsJson);
		
		return billJson.toString();
	}

}
