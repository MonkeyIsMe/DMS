package com.dms.dao;

import java.util.List;
import java.util.Set;

import com.dms.model.Information_notice;

public interface Information_noticeDAO {
	
	public boolean add(Information_notice information); //发布公告
	
	
	public List<Information_notice> getInformationnotice(); //查询公告
	
	public boolean delete(String id);
	
	public Information_notice query(String id);
}
