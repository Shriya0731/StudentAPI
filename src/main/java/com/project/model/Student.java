package com.project.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity

@Table(name="Student")
public class Student {
	Student(){
		
	}
	@Column
	@Id
	
	private int cno;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name ="email" )
	private String email;
	
	@Column(name="div")
	private String div;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="academicYear")
	private String academicYear;
	
	@Column(name="mobileno")
	private String mobileno;
	
	@OneToMany(targetEntity=Event.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cno",referencedColumnName = "cno")
	private List<Event> events;
	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getpassword() {
		return password;
	}

	public void setpassword(String pass) {
		this.password = pass;
	}
	
	
	public Student(int cno, String name, String email, String div, String branch, String academicYear, String mobileno,List events) {
		
		this.cno = cno;
		this.name = name;
		this.email = email;
		this.div = div;
		this.branch = branch;
		this.academicYear = academicYear;
		this.mobileno = mobileno;
		this.events = events;
	}
	
	



}
