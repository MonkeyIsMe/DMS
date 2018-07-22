package com.dms.model;

import java.io.Serializable;

import org.json.JSONObject;







public class Change_room implements Serializable{

	private Long apart_id; //序列号
	private String apart_room_id; //寝室号
	private String apart_stu_id; //学号
	private String apart_stu_name; //名字
	private String apart_reason; //申请理由
	private boolean flag; //标记是否被处理
	
	
	
	
	
	public Long getApart_id() {
		return apart_id;
	}
	public void setApart_id(Long apart_id) {
		this.apart_id = apart_id;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getApart_stu_id() {
		return apart_stu_id;
	}
	public void setApart_stu_id(String apart_stu_id) {
		this.apart_stu_id = apart_stu_id;
	}
	public String getApart_stu_name() {
		return apart_stu_name;
	}
	public void setApart_stu_name(String apart_stu_name) {
		this.apart_stu_name = apart_stu_name;
	}
	public String getApart_room_id() {
		return apart_room_id;
	}
	public void setApart_room_id(String apart_room_id) {
		this.apart_room_id = apart_room_id;
	}
	public String getApart_reason() {
		return apart_reason;
	}
	public void setApart_reason(String apart_reason) {
		this.apart_reason = apart_reason;
	}
	
	public JSONObject toJSON() {
		
		JSONObject jo = new JSONObject();
		jo.put("apart_room_id", this.apart_room_id);
		jo.put("apart_stu_id", this.apart_stu_id);
		jo.put("apart_stu_name", this.apart_stu_name);
		jo.put("apart_reason", this.apart_reason);
		return jo;
	}
	
	@Override
	public String toString(){
		return this.toJSON().toString();
	}
	
/*
	private String apart_room_id; //寝室号
	private String apart_cnt; //床位号
	private String apart_stu_id; //学号
	private String apart_stu_name; //名字
	private String apart_reason; //申请理由
	private boolean flag; //标记是否被处理
	*/
}
