package com.dms.model;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;



public class Fix implements Serializable{

	private String fix_cnt;   //寝室号
	private String fix_stu_id; //学号
	private String fix_stu_name; //姓名
	private String fix_reason; //问题描述
	private Date fix_time; //提出时间
	private Long fix_id;    //维修号
	private boolean fix_flag; //维修标志位
	

	
	
	
	public boolean isFix_flag() {
		return fix_flag;
	}
	public void setFix_flag(boolean fix_flag) {
		this.fix_flag = fix_flag;
	}
	
	public Date getFix_time() {
		return fix_time;
	}
	public void setFix_time(Date fix_time) {
		this.fix_time = fix_time;
	}
	public Long getFix_id() {
		return fix_id;
	}
	public void setFix_id(Long fix_id) {
		this.fix_id = fix_id;
	}
	public String getFix_cnt() {
		return fix_cnt;
	}
	public void setFix_cnt(String fix_cnt) {
		this.fix_cnt = fix_cnt;
	}
	public String getFix_stu_id() {
		return fix_stu_id;
	}
	public void setFix_stu_id(String fix_stu_id) {
		this.fix_stu_id = fix_stu_id;
	}
	public String getFix_stu_name() {
		return fix_stu_name;
	}
	public void setFix_stu_name(String fix_stu_name) {
		this.fix_stu_name = fix_stu_name;
	}
	public String getFix_reason() {
		return fix_reason;
	}
	public void setFix_reason(String fix_reason) {
		this.fix_reason = fix_reason;
	}
	
	
	public JSONObject toJSON() {
		
		JSONObject jo = new JSONObject();
		jo.put("fix_cnt", this.fix_cnt);
		jo.put("fix_id", this.fix_id);
		jo.put("fix_stu_id", this.fix_stu_id);
		jo.put("fix_stu_name", this.fix_stu_name);
		jo.put("fix_reason", this.fix_reason);
		jo.put("fix_time", this.fix_time);
		jo.put("fix_flag", this.fix_flag);
		return jo;
	}
	
	@Override
	public String toString(){
		return this.toJSON().toString();
	}
	
	/*
	private String fix_cnt;   //寝室号
	private String fix_stu_id; //学号
	private String fix_stu_name; //姓名
	private String fix_room_id; //床位号
	private String fix_reason; //问题描述
	private Date fix_time; //提出时间
	private int fix_id;    //维修号
	private boolean fix_flag; //维修标志位
	 */
	
}
