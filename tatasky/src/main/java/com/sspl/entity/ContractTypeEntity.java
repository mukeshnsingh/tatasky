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
@Table(name="contract_type")
public class ContractTypeEntity implements Serializable{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Id
		    @Column(name="contract_type_id")
		    @GeneratedValue
		    private Integer id;
				
			@Column(name="contract_type_name")
			private String contractTypeName;

			@Column(name="contract_document")
			private String contractDocument;

			@Column(name="uploaded_contract_path")
			private String uploadedContractPath;

			
			@Column(name="signed_contract_path")
			private String signedContractPath;

			public String getSignedContractPath() {
				return signedContractPath;
			}

			public void setSignedContractPath(String signedContractPath) {
				this.signedContractPath = signedContractPath;
			}

			public String getUploadedContractPath() {
				return uploadedContractPath;
			}

			public void setUploadedContractPath(String uploadedContractPath) {
				this.uploadedContractPath = uploadedContractPath;
			}
			
			@Column(name="uploaded_contract_document")
			private String uploadedContractDocument;

			public String getUploadedContractDocument() {
				return uploadedContractDocument;
			}

			public void setUploadedContractDocument(String uploadedContractDocument) {
				this.uploadedContractDocument = uploadedContractDocument;
			}

			@ManyToOne
		    @JoinColumn(name="profile_sig_id")
		    private   ProfileSignatoriesEntity profileSignatoriesEntity;
			
			@ManyToOne
		    @JoinColumn(name="document_id")
		    private   DocumentsEntity documentsEntity;

			
			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getContractTypeName() {
				return contractTypeName;
			}

			public void setContractTypeName(String contractTypeName) {
				this.contractTypeName = contractTypeName;
			}

			public String getContractDocument() {
				return contractDocument;
			}

			public void setContractDocument(String contractDocument) {
				this.contractDocument = contractDocument;
			}

			public ProfileSignatoriesEntity getProfileSignatoriesEntity() {
				return profileSignatoriesEntity;
			}

			public void setProfileSignatoriesEntity(ProfileSignatoriesEntity profileSignatoriesEntity) {
				this.profileSignatoriesEntity = profileSignatoriesEntity;
			}

			public DocumentsEntity getDocumentsEntity() {
				return documentsEntity;
			}

			public void setDocumentsEntity(DocumentsEntity documentsEntity) {
				this.documentsEntity = documentsEntity;
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
		    
			@Column(name="contract_status")
			private String contractStatus;

			
		    public String getContractStatus() {
				return contractStatus;
			}

			public void setContractStatus(String contractStatus) {
				this.contractStatus = contractStatus;
			}

			@Column(name="last_chg_by")
		    private String lastChgBy;
		    
		    @Column(name="last_chg_date")
		    private Date lastChgDate;
		    
		    @Column(name="last_chg_time")
		    private String lastChgTime;

			

}
