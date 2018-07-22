package com.dms.dao;

import java.util.List;
import java.util.Set;

import com.dms.model.Change_room;
import com.dms.model.Room;
import com.dms.model.Student;

public interface RoomDAO {
	
	public Room query(String id); //查询一个宿舍的情况
	
	public boolean add(Room room); //选宿舍
	
	public boolean queryfull(String id); //查询宿舍是不是满了
	
	public boolean update(Room room); //更新一个房间信息
	
	public Set<Student> getRooms(String id); //获得房间里学生信息
	
	public List<Room> queryEmpty();  //查询空宿舍 
	
	public boolean delete(String id); //退宿舍
	
	public boolean addroom(Room room);
}
