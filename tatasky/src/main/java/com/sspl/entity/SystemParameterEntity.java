package com.sspl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="brs_systemParameter")
public class SystemParameterEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="systparam_id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="account_L_attempts")
	private String account_L_attempts;
	
	@Column(name="display_rows")
	private String display_rows;
	
	
	@Column(name="max_duration")
	private String max_duration;


	public Integer getid() {
		return id;
	}


	public void setid(Integer id) {
		this.id =id;
	}


	public String getAccount_L_attempts() {
		return account_L_attempts;
	}


	public void setAccount_L_attempts(String account_L_attempts) {
		this.account_L_attempts = account_L_attempts;
	}


	public String getDisplay_rows() {
		return display_rows;
	}


	public void setDisplay_rows(String display_rows) {
		this.display_rows = display_rows;
	}


	public String getMax_duration() {
		return max_duration;
	}


	public void setMax_duration(String max_duration) {
		this.max_duration = max_duration;
	}
	
	
}
