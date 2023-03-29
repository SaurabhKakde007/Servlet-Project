package com.studentapp15.model;

import java.sql.ResultSet;

public interface DAOserver {
	public void connectionDB();
	
	public boolean verifycreditals(String email,String password);
	
	public void NewReg(String name,String city,String email,String mobile);
	
	public ResultSet Allregistration();
	
	public void deleteByEmail(String email);
	
	public void updateReg(String email,String mobile);

}
