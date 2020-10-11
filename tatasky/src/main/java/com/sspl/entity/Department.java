package com.sspl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="department")  
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id  
    @Column(name="department_id")
    @GeneratedValue  
    private Integer id;  

    @Column(name="department_name")
    private String departmentName;
    
    @Column(name="department_code")
    private String departmentCode;

    @Column(name="status")
    private String status; 
    
    @Column(name="last_chg_by")
    private String lastChgBy;
    
    @Column(name="last_chg_date")
    private Date lastChgDate;
    
    @Column(name="last_chg_time")
    private String lastChgTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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
