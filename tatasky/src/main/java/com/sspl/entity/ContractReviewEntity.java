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
@Table(name="contract_review")
public class ContractReviewEntity implements Serializable{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Id
		    @Column(name="contract_review_id")
		    @GeneratedValue
		    private Integer id;
				
			@Column(name="contract_review_name")
			private String contractReviewName;

			@ManyToOne
		    @JoinColumn(name="profile_sig_id")
		    private   ProfileSignatoriesEntity profileSignatoriesEntity;

			
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

			@Column(name="status")
		    private String enabled; 
		    
		    @Column(name="last_chg_by")
		    private String lastChgBy;
		    
		    @Column(name="last_chg_date")
		    private Date lastChgDate;
		    
		    @Column(name="last_chg_time")
		    private String lastChgTime;


			public String getContractReviewName() {
				return contractReviewName;
			}

			public void setContractReviewName(String contractReviewName) {
				this.contractReviewName = contractReviewName;
			}

			

}
