package com.dms.model;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

public class Stranger implements Serializable{

	//来访人员表：
	//姓名，身份证号，来访寝室，访问名字，访问学号，联系电话，来访日期，来访时间，同性人数，来访原由
	private Long s_id;
	private String st_name;
	private String st_id;
	private String st_to_room;
	private String st_to_name;
	private String st_telephone;
	private String st_date;
	private String st_people_num;
	private String st_reason;
	
	
	public Long getS_id() {
		return s_id;
	}
	public void setS_id(Long s_id) {
		this.s_id = s_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_id() {
		return st_id;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public String getSt_to_room() {
		return st_to_room;
	}
	public void setSt_to_room(String st_to_room) {
		this.st_to_room = st_to_room;
	}
	public String getSt_to_name() {
		return st_to_name;
	}
	public void setSt_to_name(String st_to_name) {
		this.st_to_name = st_to_name;
	}
	public String getSt_telephone() {
		return st_telephone;
	}
	public void setSt_telephone(String st_telephone) {
		this.st_telephone = st_telephone;
	}
	public String getSt_date() {
		return st_date;
	}
	public void setSt_date(String st_date) {
		this.st_date = st_date;
	}
	public String getSt_people_num() {
		return st_people_num;
	}
	public void setSt_people_num(String st_people_num) {
		this.st_people_num = st_people_num;
	}
	public String getSt_reason() {
		return st_reason;
	}
	public void setSt_reason(String st_reason) {
		this.st_reason = st_reason;
	}
	
	
	public JSONObject toJSON() {
		
		JSONObject jo = new JSONObject();
		jo.put("st_name",this.st_name);
		jo.put("st_id",this.st_id);
		jo.put("st_to_room",this.st_to_room);
		jo.put("st_to_name",this.st_to_name);
		jo.put("st_telephone",this.st_telephone);
		jo.put("st_date",this.st_date);
		jo.put("st_people_num",this.st_people_num);
		jo.put("st_reason",this.st_reason);
		return jo;
	}
	
	@Override
	public String toString(){
		return this.toJSON().toString();
	}
		
	/*
	private String st_name;
	private String st_id;
	private String st_to_room;
	private String st_to_name;
	private String st_telephone;
	private Date st_date;
	private String st_people_num;
	private String st_reason;
	*/
}
