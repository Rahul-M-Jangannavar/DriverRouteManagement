package com.amdocs.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.*;




@Entity
@Table(name = "EMPLOYEE")
public class DriverEntity {
	@Id
	@Column(name = "ENO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eno;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "LICENCENO")
	private Integer lno;
	@Column(name = "CONTACT_NUMBER")
	private String contactno;
	
	@OneToMany(mappedBy="drivers",cascade=CascadeType.ALL)
	private Set<RouteEntity> routeNo=new HashSet<RouteEntity>();
	
	
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public Integer getLno() {
		return lno;
	}
	public void setLno(Integer lno) {
		this.lno = lno;
	}
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public DriverEntity(Integer eno, String firstName, String lastName, Integer lno,String contactno) {
		super();
		this.eno = eno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lno = lno;
		this.contactno=contactno;
	}

	public DriverEntity() {
		// TODO Auto-generated constructor stub
	}
}
