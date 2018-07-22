package com.dms.dao;

import java.util.List;

import com.dms.model.Room;
import com.dms.model.Student;

public interface StudentDAO {
	
	public boolean add(Student student);  //添加一个学生信息
	
	public Student query(String id); //查询一个学生信息
	
	public boolean update(Student student);  //更新一个学生信息
	
	public boolean delete(String id); //删除一个学生信息
	
	public boolean update1(String id,String room_id,Room room);  //更新一个学生信息
	
	public List<Student> getStudent(String id);
	
	public List<Student> UpdatePwd();
}
