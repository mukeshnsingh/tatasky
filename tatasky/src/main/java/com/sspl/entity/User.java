package com.sspl.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="users")  
public class User  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

      
    @Id  
    @GeneratedValue  
    private Integer id;  
      
    private String login;  
      
    private String password;  
      
    private Role role;  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getLogin() {  
        return login;  
    }  
  
    public void setLogin(String login) {  
        this.login = login;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public Role getRole() {  
        return role;  
    }  
  
    public void setRole(Role role) {  
        this.role = role;  
    }     
  
}  