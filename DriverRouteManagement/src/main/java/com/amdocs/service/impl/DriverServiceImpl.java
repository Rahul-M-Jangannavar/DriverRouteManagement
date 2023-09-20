package com.amdocs.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.entity.DriverEntity;
import com.amdocs.repo.DriverRepository;
import com.amdocs.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository empRepo;

	@Override
	public boolean saveEmployee(DriverEntity emp) {
		// TODO Auto-generated method stub

		// interact db s/w to store data into the database

		DriverEntity empSave = empRepo.save(emp);
		boolean flag = false;

		if (empSave != null)
			flag = true;

		return flag;
	}

	@Override
	public List<DriverEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		//select *from employee;
		List<DriverEntity> empRecords = empRepo.findAll();
		return empRecords;
	}

	@Override
	public DriverEntity getEmployeeId(int id) {
		// TODO Auto-generated method stub
		//select *From employee where eno=?;
		Optional<DriverEntity> empId = empRepo.findById(id);
		DriverEntity emp = empId.get();
		return emp;
	}
	

	@Override
	public boolean updateBook(DriverEntity st) {
		// TODO Auto-generated method stub
		
		//Record is exist or not have to check once record is exist then update the data
		
			
		
		return saveEmployee(st);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		//Record is exist or not have to check first then delete
		DriverEntity emp = getEmployeeId(id);
		boolean flag=false;
		if(emp!=null)
		{
			empRepo.delete(emp);
		flag=true;	
		}
		
			
		
		return flag;
		
		
	}

}

