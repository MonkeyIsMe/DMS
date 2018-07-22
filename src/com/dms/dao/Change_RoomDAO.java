package com.dms.dao;

import java.util.List;

import com.dms.model.Change_room;

public interface Change_RoomDAO {

	public List<Change_room> change(); //查询一个换宿舍信息
	
	public boolean add(Change_room change); //添加一个交换宿舍
	
	public Change_room query(String id); //查询一个交换宿舍的信息
	
	public boolean Update(Change_room room); //更新一个查询信息
	
	public boolean delete(String id);
	
}
