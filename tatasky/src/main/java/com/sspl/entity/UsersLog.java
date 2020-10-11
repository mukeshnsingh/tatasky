package com.sspl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="users_log")  
public class UsersLog implements Serializable {

      
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id  
    @Column(name="users_log_id")
    @GeneratedValue  
    private Integer id;  

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getLastBy() {
		return lastBy;
	}

	public void setLastBy(String lastBy) {
		this.lastBy = lastBy;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name="user_id")
    private Integer usersId;

    @Column(name="status")
    private String status; 

    @Column(name="user_ip")
    private String userIp;
    
    @Column(name="last_by")
    private String lastBy;
    
    @Column(name="login_date")
    private Date loginDate;
    
    @Column(name="login_time")
    private String loginTime;
}
