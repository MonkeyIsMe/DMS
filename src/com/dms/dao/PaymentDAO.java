package com.dms.dao;

import com.dms.model.Payment;

public interface PaymentDAO {

	
	public boolean add(Payment payment);
	
	public Payment query(String id);
	
	public boolean update(Payment payment);
	
	public boolean delete(String id);
}
