package com.amdocs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.entity.RouteEntity;
import com.amdocs.exception.DriverNotFoundException;
import com.amdocs.service.DriverService;
import com.amdocs.service.RouteService;

@RestController
@RequestMapping("/routes")
public class RouteController {

	private RouteService routeserv;
	private DriverService driveserv;

	@Autowired
	public RouteController(RouteService routeserv,DriverService driveserv) {
		//super();
		this.routeserv = routeserv;
		this.driveserv=driveserv;
	}
	//Basic URI for API Testing
	
	//http://localhost:8085/books
	
	//insert into book_entity(book_name, pub_date)values(?,?);
	//http://localhost:8085/books/insert
	@PostMapping("/insert/{ENO}")
	public RouteEntity saveBook(@RequestBody RouteEntity route,@PathVariable Integer ENO)throws DriverNotFoundException
	{
		return routeserv.saveBook(route,ENO);
	}
	
	//select *from book_entity
	//http://localhost:8085/books/allbooks

	@GetMapping("/allbooks")
	public List<RouteEntity> getAllbooks()throws DriverNotFoundException
	{
		return routeserv.getAllbooks();
		
	}
	
	//select *from book_entity where isbnno=?
	//http://localhost:8085/books/1
	@GetMapping("/{routeno}")
	public RouteEntity getBookById(@PathVariable Long routeno)throws DriverNotFoundException
	{
		return routeserv.getBookById(routeno);
	}
	
	//http://localhost:8085/books/update/1
	@PutMapping("/update/{routeno}")
	public RouteEntity updateBook(@PathVariable Long routeno,@RequestBody RouteEntity route)throws DriverNotFoundException
	{
		return routeserv.updateBook(routeno, route);
	}
	
	
	@DeleteMapping("/delete/{routeno}")
	public void deleteBook(@PathVariable Long routeno)throws DriverNotFoundException
	{
		routeserv.deleteBook(routeno);
	}
	
}
