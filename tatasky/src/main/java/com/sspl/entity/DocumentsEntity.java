package com.sspl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="document") 
public class DocumentsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id  
    @Column(name="document_id")
    @GeneratedValue  
    private Integer id;  

    @Column(name="document_name")
    private String documentName;
    
    @Column(name="document_code")
    private String documentCode;

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

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentCode() {
		return documentCode;
	}

	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
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
