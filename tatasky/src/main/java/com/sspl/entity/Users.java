package com.sspl.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table (name = "users")
public class Users  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
    @Id
    @Column (name = "USER_ID")
    private String id;

    @Column (name = "PASSWORD", nullable = false)
    private String password;

    
    @Column (name = "USERNAME", nullable = false)
	private String userName;
    
    @Column (name = "role_id", nullable = false)
	private String userRole;
    
    public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Column (name = "enabled", nullable = false)
    private String status;


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@ManyToOne
	@JoinColumn(name="employeeId")
	private   EmployeeEntity employeeEntity;

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}



}
