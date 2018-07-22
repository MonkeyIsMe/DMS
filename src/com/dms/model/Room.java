package com.dms.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;



public class Room implements Serializable{
	private String room_id; //寝室号
	private String room_flag; //标志位
	private Long room_num; //床位数
	private String room_attendance; //考勤情况
	private String apart_task; //内务情况
	
	private Set<Student> students = new HashSet<Student>();
	
	
	
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getRoom_flag() {
		return room_flag;
	}
	public void setRoom_flag(String room_flag) {
		this.room_flag = room_flag;
	}
	public Long getRoom_num() {
		return room_num;
	}
	public void setRoom_num(Long room_num) {
		this.room_num = room_num;
	}
	public String getRoom_attendance() {
		return room_attendance;
	}
	public void setRoom_attendance(String room_attendance) {
		this.room_attendance = room_attendance;
	}
	public String getApart_task() {
		return apart_task;
	}
	public void setApart_task(String apart_task) {
		this.apart_task = apart_task;
	}
	

	
	public JSONObject toJSON() {
		
		JSONObject jo = new JSONObject();
		jo.put("room_id", this.room_id);
		jo.put("room_num", this.room_num);
		jo.put("room_attendance", this.room_attendance);
		jo.put("apart_task", this.apart_task);
		return jo;
	}
	
	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_flag=" + room_flag + ", room_num=" + room_num + ", room_attendance="
				+ room_attendance + ", apart_task=" + apart_task + ", students=" + students + "]";
	}
	
	/*
	private String room_id; //寝室号
	private String room_flag; //标志位
	private Long room_num; //床位数
	private String room_attendance; //考勤情况
	private String apart_task; //内务情况
	*/
}
