package com.sspl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="signatories")
	public class SignatoryEntity implements Serializable{

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				
				@Id
			    @Column(name="signatories_id")
			    @GeneratedValue
			    private Integer id;
				
				@Column(name="signatories_name")
				private String signatoriesName;

				@Column(name="signatories_code")
				private String signatoriesCode;

				@Column(name="start_date")
			    private Date startDate;
			    
				@Column(name="end_date")
			    private Date endDate;
			    
			    @Column(name="status")
			    private String enabled; 
			    
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

				public String getSignatoriesName() {
					return signatoriesName;
				}

				public void setSignatoriesName(String signatoriesName) {
					this.signatoriesName = signatoriesName;
				}

				public String getSignatoriesCode() {
					return signatoriesCode;
				}

				public void setSignatoriesCode(String signatoriesCode) {
					this.signatoriesCode = signatoriesCode;
				}

				public Date getStartDate() {
					return startDate;
				}

				public void setStartDate(Date startDate) {
					this.startDate = startDate;
				}

				public Date getEndDate() {
					return endDate;
				}

				public void setEndDate(Date endDate) {
					this.endDate = endDate;
				}

				public String getEnabled() {
					return enabled;
				}

				public void setEnabled(String enabled) {
					this.enabled = enabled;
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
	
