package com.amdocs.service;

import java.util.List;

import com.amdocs.entity.DriverEntity;

public interface DriverService {

	public boolean saveEmployee(DriverEntity emp);
	
	public List<DriverEntity> getAllEmployees();
	
	public DriverEntity getEmployeeId(int id);

	public boolean updateBook(DriverEntity st);

	public boolean deleteEmployee(int id);
	



	
	
	
}



