package com.dms.dao;
import java.util.List;
import java.util.Set;

import com.dms.model.Fix;

public interface FixDAO {
	
	public boolean add(Fix fix);  //申请一个维修的服务
	
	public List<Fix> getFixInformation(); //查询维修服务
	
	public Fix query(String id);
	
	public boolean update (Fix fix);
	
	public boolean delete(String id);
}
