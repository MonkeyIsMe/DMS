package com.dms.model;

import java.io.Serializable;

import org.json.JSONObject;

public class Payment implements Serializable{
	
	private Long pay_cnt;  //订单号
	private String pay_description; //订单名称
	private String pay_money; //付款金额
	private String pay_room_id; //需要支付的寝室号
	private String pay_body; //订单描述
	
	public Long getPay_cnt() {
		return pay_cnt;
	}
	public void setPay_cnt(Long pay_cnt) {
		this.pay_cnt = pay_cnt;
	}
	public String getPay_description() {
		return pay_description;
	}
	public void setPay_description(String pay_description) {
		this.pay_description = pay_description;
	}
	public String getPay_money() {
		return pay_money;
	}
	public void setPay_money(String pay_money) {
		this.pay_money = pay_money;
	}
	public String getPay_room_id() {
		return pay_room_id;
	}
	public void setPay_room_id(String pay_room_id) {
		this.pay_room_id = pay_room_id;
	}
	public String getPay_body() {
		return pay_body;
	}
	public void setPay_body(String pay_body) {
		this.pay_body = pay_body;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("pay_cnt", this.pay_cnt);
		jo.put("pay_description", this.pay_description);
		jo.put("pay_money", this.pay_money);
		jo.put("pay_room_id", this.pay_room_id);
		jo.put("pay_body", this.pay_body);
		return jo;
	}
	
	@Override
	public String toString(){
		return this.toJSON().toString();
	}
	
}
