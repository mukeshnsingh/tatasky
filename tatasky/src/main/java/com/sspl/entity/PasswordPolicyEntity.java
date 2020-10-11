package com.sspl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="brs_passwordpolicy")
public class PasswordPolicyEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="password_policy_id")
	@GeneratedValue
	private Integer password_policy_id;
	
	@Column(name="password_min_age")
	private String password_min_age;
	
	@Column(name="password_max_age")
	private String password_max_age;
	
	@Column(name="password_stored_history")
	private String password_stored_history;
	
	@Column(name="password_check_quality")
	private String password_check_quality;
	
	
	
	@Column(name="password_expired_warning")
	private String password_expired_warning;
	
	@Column(name="password_grace_authentication_limit")
	private String password_grace_authentication_limit;
	
	@Column(name="password_lock_out")
	private String password_lock_out;
	
	@Column(name="password_max_failure")
	private String password_max_failure;
	
	@Column(name="password_failure_count_interval")
	private String password_failure_count_interval;
	
	
	@Column(name="password_must_change")
	private String password_must_change;
	
	
	
	@Column(name="password_lock_out_duration")
	private String password_lock_out_duration;
	
	@Column(name="password_allow_user_change")
	private String password_allow_user_change;
	
	@Column(name="account_expiration_interval")
	private String account_expiration_interval;
	
	@Column(name="account_expiration_external")
	private String account_expiration_external;

	public Integer getPassword_policy_id() {
		return password_policy_id;
	}

	public void setPassword_policy_id(Integer password_policy_id) {
		this.password_policy_id = password_policy_id;
	}

	public String getPassword_min_age() {
		return password_min_age;
	}

	public void setPassword_min_age(String password_min_age) {
		this.password_min_age = password_min_age;
	}

	public String getPassword_max_age() {
		return password_max_age;
	}

	public void setPassword_max_age(String password_max_age) {
		this.password_max_age = password_max_age;
	}

	public String getPassword_stored_history() {
		return password_stored_history;
	}

	public void setPassword_stored_history(String password_stored_history) {
		this.password_stored_history = password_stored_history;
	}

	public String getPassword_check_quality() {
		return password_check_quality;
	}

	public void setPassword_check_quality(String password_check_quality) {
		this.password_check_quality = password_check_quality;
	}

	
	public String getPassword_expired_warning() {
		return password_expired_warning;
	}

	public void setPassword_expired_warning(String password_expired_warning) {
		this.password_expired_warning = password_expired_warning;
	}

	public String getPassword_grace_authentication_limit() {
		return password_grace_authentication_limit;
	}

	public void setPassword_grace_authentication_limit(
			String password_grace_authentication_limit) {
		this.password_grace_authentication_limit = password_grace_authentication_limit;
	}

	public String getPassword_lock_out() {
		return password_lock_out;
	}

	public void setPassword_lock_out(String password_lock_out) {
		this.password_lock_out = password_lock_out;
	}

	public String getPassword_max_failure() {
		return password_max_failure;
	}

	public void setPassword_max_failure(String password_max_failure) {
		this.password_max_failure = password_max_failure;
	}

	public String getPassword_failure_count_interval() {
		return password_failure_count_interval;
	}

	public void setPassword_failure_count_interval(
			String password_failure_count_interval) {
		this.password_failure_count_interval = password_failure_count_interval;
	}

	

	public String getPassword_must_change() {
		return password_must_change;
	}

	public void setPassword_must_change(String password_must_change) {
		this.password_must_change = password_must_change;
	}

	
	public String getPassword_lock_out_duration() {
		return password_lock_out_duration;
	}

	public void setPassword_lock_out_duration(String password_lock_out_duration) {
		this.password_lock_out_duration = password_lock_out_duration;
	}

	public String getPassword_allow_user_change() {
		return password_allow_user_change;
	}

	public void setPassword_allow_user_change(String password_allow_user_change) {
		this.password_allow_user_change = password_allow_user_change;
	}

	public String getAccount_expiration_interval() {
		return account_expiration_interval;
	}

	public void setAccount_expiration_interval(String account_expiration_interval) {
		this.account_expiration_interval = account_expiration_interval;
	}

	public String getAccount_expiration_external() {
		return account_expiration_external;
	}

	public void setAccount_expiration_external(String account_expiration_external) {
		this.account_expiration_external = account_expiration_external;
	}
	
	
}
