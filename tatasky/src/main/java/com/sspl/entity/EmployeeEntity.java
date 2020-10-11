package com.sspl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity  
@Table(name="employee")  
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id  
    @Column(name="employee_id")
    @GeneratedValue  
    private Integer id;  

    @Column(name="employee_name")
    private String employeeName;
    
    @Column(name="employee_code")
    private String employeeCode;

    @Column(name="email")
    private String email;

    @Column(name="mobile_no")
    private String mobileNo;
    
    @Column(name="status")
    private String status; 
    
    @Column(name="last_chg_by")
    private String lastChgBy;
    
    @Column(name="last_chg_date")
    private Date lastChgDate;
    
    @Column(name="last_chg_time")
    private String lastChgTime;

    @ManyToOne
    @JoinColumn(name="department_id")
    private   Department deptObj;
	
    
    public Department getDeptObj() {
		return deptObj;
	}

	public void setDeptObj(Department deptObj) {
		this.deptObj = deptObj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastChgBy() {
		return lastChgBy;
	}

	public void setLastChgBy(String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	public Date getLastChgDate() {
		return lastChgDate;
	}

	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	public String getLastChgTime() {
		return lastChgTime;
	}

	public void setLastChgTime(String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}


}
