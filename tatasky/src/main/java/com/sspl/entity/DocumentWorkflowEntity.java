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
	@Table(name="document_workflow")  
	public class DocumentWorkflowEntity implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Id  
	    @Column(name="workflow_id")
	    @GeneratedValue  
	    private Integer id;  

		@Column(name="followup_date")
	    private Date followupDate;
	    
		
		@ManyToOne
	    @JoinColumn(name="contract_type_id")
	    private   ContractTypeEntity contractTypeEntity;
		
		/*@ManyToOne
	    @JoinColumn(name="employee_id")
	    private   EmployeeEntity employeeEntity;
		*/
		@ManyToOne
	    @JoinColumn(name="signatories_id")
	    private   SignatoryEntity signatoryEntity;
		
		@Column(name="followup")
		private String followup; 

	    @Column(name="mail_sent")
	    private String mailSent; 
	    
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

		public Date getFollowupDate() {
			return followupDate;
		}

		public void setFollowupDate(Date followupDate) {
			this.followupDate = followupDate;
		}

		public ContractTypeEntity getContractTypeEntity() {
			return contractTypeEntity;
		}

		public void setContractTypeEntity(ContractTypeEntity contractTypeEntity) {
			this.contractTypeEntity = contractTypeEntity;
		}

		/*public EmployeeEntity getEmployeeEntity() {
			return employeeEntity;
		}

		public void setEmployeeEntity(EmployeeEntity employeeEntity) {
			this.employeeEntity = employeeEntity;
		}*/

		public SignatoryEntity getSignatoryEntity() {
			return signatoryEntity;
		}

		public void setSignatoryEntity(SignatoryEntity signatoryEntity) {
			this.signatoryEntity = signatoryEntity;
		}

		public String getFollowup() {
			return followup;
		}

		public void setFollowup(String followup) {
			this.followup = followup;
		}

		public String getMailSent() {
			return mailSent;
		}

		public void setMailSent(String mailSent) {
			this.mailSent = mailSent;
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
