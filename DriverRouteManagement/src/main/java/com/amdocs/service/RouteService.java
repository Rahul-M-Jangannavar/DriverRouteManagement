package com.amdocs.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.entity.DriverEntity;
import com.amdocs.entity.RouteEntity;
import com.amdocs.exception.DriverNotFoundException;
import com.amdocs.repo.DriverRepository;
import com.amdocs.repo.RouteRepository;

@Service
public class RouteService {
	

	private RouteRepository routerepo;
	private DriverRepository driverrepo;
	
	@Autowired
	public RouteService(RouteRepository routerepo,DriverRepository driverrepo) {
		//super();
		this.routerepo = routerepo;
		this.driverrepo=driverrepo;
	}


	//crud operations
	//savebook data
	//insert query is generated at runtime by server using hibernate and jpa
	public RouteEntity saveBook(RouteEntity route,int ENO) throws DriverNotFoundException
	{
		DriverEntity driver1=driverrepo.findById(ENO).orElse(null);
		if(driver1!=null) {
			route.setDrivers(driver1);
			return routerepo.save(route);
			
		}
		else {
			return null;
		}
	}
	

	public List<RouteEntity> getAllbooks()throws DriverNotFoundException
	{
		return routerepo.findAll();
	}
	
	public 	RouteEntity getBookById(Long routeno)
	{
		return routerepo.findById(routeno).orElse(null);
	}

	public RouteEntity updateBook(Long routeno, RouteEntity route)throws DriverNotFoundException
	{
		RouteEntity existingroute=routerepo.findById(routeno).orElse(null);
		
		if(existingroute!=null)
		{
			existingroute.setSource_name(route.getSource_name());
			existingroute.setDestin_name(route.getDestin_name());
			
		return routerepo.save(existingroute);
		}
		return null;
	}
	
	public void deleteBook(Long routeno)throws DriverNotFoundException
	{
		 routerepo.deleteById(routeno);
	}
	
}
