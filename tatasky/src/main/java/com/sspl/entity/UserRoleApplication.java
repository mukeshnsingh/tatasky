package com.sspl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="role_application")
public class UserRoleApplication  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="role_app_id")
    @GeneratedValue
	private int id;
	
	@ManyToOne
    @JoinColumn(name="role_id")
    private Role userRole;
	

    @ManyToOne
    @JoinColumn(name="app_id")
    private Application application;
    
    @Column(name="enabled")
    private int enabled;
    
}
