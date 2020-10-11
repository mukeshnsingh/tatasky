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
@Table(name="signatories_mapping")
public class SignatoriesMappingEntiry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="signatories_mapping_id")
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name="profile_sig_id")
	private   ProfileSignatoriesEntity profileSignatoriesEntity;

	@ManyToOne
	@JoinColumn(name="employee_id")
	private   EmployeeEntity employeeEntity;

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

	public ProfileSignatoriesEntity getProfileSignatoriesEntity() {
		return profileSignatoriesEntity;
	}

	public void setProfileSignatoriesEntity(ProfileSignatoriesEntity profileSignatoriesEntity) {
		this.profileSignatoriesEntity = profileSignatoriesEntity;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
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
