package com.dms.model;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

public class Information_notice implements Serializable{
	
	//公告表:
	//名称，详细描述，标志位
	private Long infor_id; //公告数
	private Date infor_time; //公告时间
	private String infor_name; //公告名称
	private String infor_description; //公告描述
	private String infor_flag; //公告标志位
	
	
	public Date getInfor_time() {
		return infor_time;
	}
	public void setInfor_time(Date infor_time) {
		this.infor_time = infor_time;
	}
	public String getInfor_name() {
		return infor_name;
	}
	public void setInfor_name(String infor_name) {
		this.infor_name = infor_name;
	}
	public String getInfor_description() {
		return infor_description;
	}
	public void setInfor_description(String infor_description) {
		this.infor_description = infor_description;
	}
	public String getInfor_flag() {
		return infor_flag;
	}
	public void setInfor_flag(String infor_flag) {
		this.infor_flag = infor_flag;
	}
	
	public Long getInfor_id() {
		return infor_id;
	}
	public void setInfor_id(Long infor_id) {
		this.infor_id = infor_id;
	}
	
	
	public JSONObject toJSON() {
		
		JSONObject jo = new JSONObject();
		jo.put("infor_id", this.infor_id);
		jo.put("infor_time", this.infor_time);
		jo.put("infor_name", this.infor_name);
		jo.put("infor_description", this.infor_description);
		jo.put("infor_flag", this.infor_flag);
		return jo;
	}
	
	@Override
	public String toString(){
		return this.toJSON().toString();
	}
	
	/*	private Long infor_id; //公告数
	private Date infor_time; //公告时间
	private String infor_name; //公告名称
	private String infor_description; //公告描述
	private String infor_flag; //公告标志位
	*/

}
