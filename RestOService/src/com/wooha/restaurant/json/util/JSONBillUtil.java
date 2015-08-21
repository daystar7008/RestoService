package com.wooha.restaurant.json.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.wooha.restaurant.beans.Bill;
import com.wooha.restaurant.beans.BillDetail;
import com.wooha.restaurant.beans.Item;

public class JSONBillUtil {

	private Bill bill;
	
	public Bill jsonToBill(String json) throws JSONException, ParseException{
		JSONObject billJson = new JSONObject(json);

		if(billJson != null){
			bill = new Bill();
			bill.setId(billJson.getString(Bill.ID));
			bill.setBillerName(billJson.getString(Bill.BILLER_NAME));
			bill.setTableId(billJson.getInt(Bill.TABLE_ID));
			bill.setTotalAmount(billJson.getDouble(Bill.TOTAL_AMOUNT));
			bill.setClosedFlag(billJson.getString(Bill.CLOSED_FLAG).charAt(0));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
			
			bill.setDate(dateFormat.parse(billJson.getString(Bill.DATE)));
			System.out.println(bill.getDate());
			
			JSONArray billDetailsJson = billJson.getJSONArray(Bill.BILL_DETAILS);
			List<BillDetail> billDetails = new ArrayList<BillDetail>();
			
			for(int i = 0; i < billDetailsJson.length(); i++){
				JSONObject billDetailJson = new JSONObject(billDetailsJson.getString(i));
				BillDetail billDetail = new BillDetail();
				billDetail.setId(billDetailJson.getLong(BillDetail.ID));
				billDetail.setQuantity((short)billDetailJson.getInt(BillDetail.QUANTITY));
				billDetail.setAmount(billDetailJson.getDouble(BillDetail.AMOUNT));
				
				JSONObject itemJson = billDetailJson.getJSONObject(BillDetail.ITEM);
				Item item = new Item();
				item.setId(itemJson.getLong(Item.ID));
				item.setDescription(itemJson.getString(Item.DESCRIPTION));
				item.setPrice(itemJson.getDouble(Item.PRICE));
				
				billDetail.setItem(item);
				
				billDetails.add(billDetail);
			}
			
			bill.setBillDetails(billDetails);
		}
		
		return bill;
	}
	
}
