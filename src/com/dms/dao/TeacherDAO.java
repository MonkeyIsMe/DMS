package com.dms.dao;

import com.dms.model.Teacher;

public interface TeacherDAO {
	
	public boolean add(Teacher teacher);
	
	public boolean update (Teacher teacher);
	
	public Teacher query(String id);
	
	public boolean delete (String id);
}
