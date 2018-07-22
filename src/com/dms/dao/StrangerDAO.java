package com.dms.dao;

import java.util.List;

import com.dms.model.Stranger;

public interface StrangerDAO {
	
	public Stranger query(String id);  //查询一个陌生人信息
	 
	public boolean add(Stranger stranger);  //添加一个陌生人信息
	
	public List<Stranger> querySt();
}
