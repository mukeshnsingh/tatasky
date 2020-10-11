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
@Table(name="profile_signatories")
public class ProfileSignatoriesEntity implements Serializable{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Id
		    @Column(name="profile_sig_id")
		    @GeneratedValue
		    private Integer id;
			
			
			@Column(name="profile_sig_name")
			private String profileSigName;
			
			public String getProfileSigName() {
				return profileSigName;
			}

			public void setProfileSigName(String profileSigName) {
				this.profileSigName = profileSigName;
			}

			@ManyToOne
		    @JoinColumn(name="profile_id")
		    private   ProfileEntity profileEntity;
			
			@ManyToOne
		    @JoinColumn(name="document_id")
		    private   DocumentsEntity documentsEntity;
			
			public DocumentsEntity getDocumentsEntity() {
				return documentsEntity;
			}

			public void setDocumentsEntity(DocumentsEntity documentsEntity) {
				this.documentsEntity = documentsEntity;
			}

			@ManyToOne
		    @JoinColumn(name="signatory_id_1")
		    private   SignatoryEntity signatoryEntity1;
	
			@ManyToOne
		    @JoinColumn(name="signatory_id_2")
		    private   SignatoryEntity signatoryEntity2;

			@ManyToOne
		    @JoinColumn(name="signatory_id_3")
		    private   SignatoryEntity signatoryEntity3;

			@ManyToOne
		    @JoinColumn(name="signatory_id_4")
		    private   SignatoryEntity signatoryEntity4;

			@ManyToOne
		    @JoinColumn(name="signatory_id_5")
		    private   SignatoryEntity signatoryEntity5;


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

			public ProfileEntity getProfileEntity() {
				return profileEntity;
			}

			public void setProfileEntity(ProfileEntity profileEntity) {
				this.profileEntity = profileEntity;
			}

			public SignatoryEntity getSignatoryEntity1() {
				return signatoryEntity1;
			}

			public void setSignatoryEntity1(SignatoryEntity signatoryEntity1) {
				this.signatoryEntity1 = signatoryEntity1;
			}

			public SignatoryEntity getSignatoryEntity2() {
				return signatoryEntity2;
			}

			public void setSignatoryEntity2(SignatoryEntity signatoryEntity2) {
				this.signatoryEntity2 = signatoryEntity2;
			}

			public SignatoryEntity getSignatoryEntity3() {
				return signatoryEntity3;
			}

			public void setSignatoryEntity3(SignatoryEntity signatoryEntity3) {
				this.signatoryEntity3 = signatoryEntity3;
			}

			public SignatoryEntity getSignatoryEntity4() {
				return signatoryEntity4;
			}

			public void setSignatoryEntity4(SignatoryEntity signatoryEntity4) {
				this.signatoryEntity4 = signatoryEntity4;
			}

			public SignatoryEntity getSignatoryEntity5() {
				return signatoryEntity5;
			}

			public void setSignatoryEntity5(SignatoryEntity signatoryEntity5) {
				this.signatoryEntity5 = signatoryEntity5;
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
