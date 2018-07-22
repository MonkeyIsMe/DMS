package com.dms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

public class Student implements Serializable{
	
	//学生表:
	//学号，密码，姓名，院系，专业，班级，寝室号，入学时间，毕业时间,身份标志位,联系电话
	
	 private String stu_id;  //学号
	 private String stu_password; //密码
	 private String stu_name; //姓名
	 private String stu_room_id; //寝室
	 private String stu_yard; //院系
	 private String stu_marjor_in; //专业
	 private String stu_class_id; //班级
	 private String stu_in_time; //入学时间
	 private String stu_out_time; //离校时间
	 private String stu_flag; //身份标志位
	 private String stu_email;
	 private String stu_tele_num; //电话号码
	 
	 
	 private Room room;
	 


	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_password() {
		return stu_password;
	}
	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_room_id() {
		return stu_room_id;
	}
	public void setStu_room_id(String stu_room_id) {
		this.stu_room_id = stu_room_id;
	}
	public String getStu_yard() {
		return stu_yard;
	}
	public void setStu_yard(String stu_yard) {
		this.stu_yard = stu_yard;
	}
	public String getStu_marjor_in() {
		return stu_marjor_in;
	}
	public void setStu_marjor_in(String stu_marjor_in) {
		this.stu_marjor_in = stu_marjor_in;
	}
	public String getStu_class_id() {
		return stu_class_id;
	}
	public void setStu_class_id(String stu_class_id) {
		this.stu_class_id = stu_class_id;
	}
	public String getStu_in_time() {
		return stu_in_time;
	}
	public void setStu_in_time(String stu_in_time) {
		this.stu_in_time = stu_in_time;
	}
	public String getStu_out_time() {
		return stu_out_time;
	}
	public void setStu_out_time(String stu_out_time) {
		this.stu_out_time = stu_out_time;
	}
	public String getStu_flag() {
		return stu_flag;
	}
	public void setStu_flag(String stu_flag) {
		this.stu_flag = stu_flag;
	}
	public String getStu_tele_num() {
		return stu_tele_num;
	}
	public void setStu_tele_num(String stu_tele_num) {
		this.stu_tele_num = stu_tele_num;
	}
	
	
	 
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("stu_id", this.stu_id);
		jo.put("stu_name", this.stu_name);
		jo.put("stu_room_id", this.stu_room_id);
		jo.put("stu_yard", this.stu_yard);
		jo.put("stu_marjor_in", this.stu_marjor_in);
		jo.put("stu_in_time", this.stu_in_time);
		jo.put("stu_tele_num", this.stu_tele_num);
		jo.put("stu_email", this.stu_email);
		jo.put("stu_class_id", this.stu_class_id);
		return jo;
		
	}
	@Override
	public String toString(){
		return this.toJSON().toString();
	}
	/*
	 private String stu_id;  //学号
	 private String stu_password; //密码
	 private String stu_name; //姓名
	 private String stu_room_id; //寝室
	 private String stu_yard; //院系
	 private String stu_marjor_in; //专业
	 private String stu_class_id; //班级
	 private Date stu_in_time; //入学时间
	 private Date stu_out_time; //离校时间
	 private String stu_flag; //身份标志位
	 private String stu_tele_num; //电话号码
	 */
	 
}
