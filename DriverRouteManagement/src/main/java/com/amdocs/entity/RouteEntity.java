package com.amdocs.entity;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class RouteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_no")
	private long routeno;
	@Column(name = "sourcename")
	private String source_name;
	
	@Column(name = "destin_name")
	private String destin_name;
	
	@ManyToOne
	@JoinColumn(name="ENO")
	private DriverEntity drivers;
	

	
	
	
}
