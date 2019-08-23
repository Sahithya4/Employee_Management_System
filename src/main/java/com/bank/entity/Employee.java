package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int employeeid;
	private String employeename;
	private String email;
	private String departmentname;
	private String reportingmanager;
	private float salary;
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int empid) {
		this.employeeid = empid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getReportingmanager() {
		return reportingmanager;
	}
	public void setReportingmanager(String reportingmanager) {
		this.reportingmanager = reportingmanager;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", email=" + email + ", departmentname="
				+ departmentname + ", reportingmanager=" + reportingmanager + ", salary=" + salary + "]";
	}
	
	

}
