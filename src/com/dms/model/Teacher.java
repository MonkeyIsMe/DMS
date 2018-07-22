package com.dms.model;

import org.json.JSONObject;

public class Teacher {
	private String tea_account;
	private String tea_password;
	private String tea_name;
	private String tea_yard;
	private String tea_tele_num;
	private String tea_flag;
	private String tea_email;
	
	
	public String getTea_email() {
		return tea_email;
	}
	public void setTea_email(String tea_email) {
		this.tea_email = tea_email;
	}
	public String getTea_account() {
		return tea_account;
	}
	public void setTea_account(String tea_account) {
		this.tea_account = tea_account;
	}
	public String getTea_password() {
		return tea_password;
	}
	public void setTea_password(String tea_password) {
		this.tea_password = tea_password;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public String getTea_yard() {
		return tea_yard;
	}
	public void setTea_yard(String tea_yard) {
		this.tea_yard = tea_yard;
	}
	public String getTea_tele_num() {
		return tea_tele_num;
	}
	public void setTea_tele_num(String tea_tele_num) {
		this.tea_tele_num = tea_tele_num;
	}
	public String getTea_flag() {
		return tea_flag;
	}
	public void setTea_flag(String tea_flag) {
		this.tea_flag = tea_flag;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("tea_account", this.tea_account);
		jo.put("tea_password", this.tea_password);
		jo.put("tea_name", this.tea_name);
		jo.put("tea_yard", this.tea_yard);
		jo.put("tea_tele_num", this.tea_tele_num);
		jo.put("tea_flag", this.tea_flag);
		return jo;
	}
	
	@Override
	public String toString(){
		return this.toJSON().toString();
	}
	/*	
	 * private String tea_account;
	private String tea_password;
	private String tea_name;
	private String tea_yard;
	private String tea_tele_num;
	private String tea_flag;
	*/
}
