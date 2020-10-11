package com.sspl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="brs_user")
public class RoleEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="role_id")
	@GeneratedValue
    private Integer role_id;	
	
	public Integer getRole_id() {
		return role_id;
	}


	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public String getReco_sysreco_submit() {
		return reco_sysreco_submit;
	}


	public void setReco_sysreco_submit(String reco_sysreco_submit) {
		this.reco_sysreco_submit = reco_sysreco_submit;
	}


	public String getReco_reco_submit() {
		return reco_reco_submit;
	}


	public void setReco_reco_submit(String reco_reco_submit) {
		this.reco_reco_submit = reco_reco_submit;
	}


	public String getReco_unreco_submit() {
		return reco_unreco_submit;
	}


	public void setReco_unreco_submit(String reco_unreco_submit) {
		this.reco_unreco_submit = reco_unreco_submit;
	}


	public String getReco_approvereco_submit() {
		return reco_approvereco_submit;
	}


	public void setReco_approvereco_submit(String reco_approvereco_submit) {
		this.reco_approvereco_submit = reco_approvereco_submit;
	}


	public String getFileupload_submit() {
		return fileupload_submit;
	}


	public void setFileupload_submit(String fileupload_submit) {
		this.fileupload_submit = fileupload_submit;
	}


	public String getBankmaster_view() {
		return bankmaster_view;
	}


	public void setBankmaster_view(String bankmaster_view) {
		this.bankmaster_view = bankmaster_view;
	}


	public String getBankmaster_submit() {
		return bankmaster_submit;
	}


	public void setBankmaster_submit(String bankmaster_submit) {
		this.bankmaster_submit = bankmaster_submit;
	}


	public String getBankaccount_view() {
		return bankaccount_view;
	}


	public void setBankaccount_view(String bankaccount_view) {
		this.bankaccount_view = bankaccount_view;
	}


	public String getBankaccount_submit() {
		return bankaccount_submit;
	}


	public void setBankaccount_submit(String bankaccount_submit) {
		this.bankaccount_submit = bankaccount_submit;
	}


	public String getReports_brs_view() {
		return reports_brs_view;
	}


	public void setReports_brs_view(String reports_brs_view) {
		this.reports_brs_view = reports_brs_view;
	}


	public String getReports_gltran_view() {
		return reports_gltran_view;
	}


	public void setReports_gltran_view(String reports_gltran_view) {
		this.reports_gltran_view = reports_gltran_view;
	}


	public String getReports_banktran_view() {
		return reports_banktran_view;
	}


	public void setReports_banktran_view(String reports_banktran_view) {
		this.reports_banktran_view = reports_banktran_view;
	}


	public String getAdmin_user_view() {
		return admin_user_view;
	}


	public void setAdmin_user_view(String admin_user_view) {
		this.admin_user_view = admin_user_view;
	}


	public String getAdmin_user_submit() {
		return admin_user_submit;
	}


	public void setAdmin_user_submit(String admin_user_submit) {
		this.admin_user_submit = admin_user_submit;
	}


	public String getAdmin_roleper_view() {
		return admin_roleper_view;
	}


	public void setAdmin_roleper_view(String admin_roleper_view) {
		this.admin_roleper_view = admin_roleper_view;
	}


	public String getAdmin_roleper_submit() {
		return admin_roleper_submit;
	}


	public void setAdmin_roleper_submit(String admin_roleper_submit) {
		this.admin_roleper_submit = admin_roleper_submit;
	}


	public String getAdmin_sysparam_view() {
		return admin_sysparam_view;
	}


	public void setAdmin_sysparam_view(String admin_sysparam_view) {
		this.admin_sysparam_view = admin_sysparam_view;
	}


	public String getAdmin_sysparam_submit() {
		return admin_sysparam_submit;
	}


	public void setAdmin_sysparam_submit(String admin_sysparam_submit) {
		this.admin_sysparam_submit = admin_sysparam_submit;
	}


	public String getAdmin_passpolicy_view() {
		return admin_passpolicy_view;
	}


	public void setAdmin_passpolicy_view(String admin_passpolicy_view) {
		this.admin_passpolicy_view = admin_passpolicy_view;
	}


	public String getAdmin_passpolicy_submit() {
		return admin_passpolicy_submit;
	}


	public void setAdmin_passpolicy_submit(String admin_passpolicy_submit) {
		this.admin_passpolicy_submit = admin_passpolicy_submit;
	}


	@Column(name="role_name")
	private String role_name;
	
	@Column(name="active")
	private String active;
	
	
	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	@Column(name="reco_sysreco_submit")
	private String reco_sysreco_submit;
	
	@Column(name="reco_reco_submit")
	private String reco_reco_submit;
	
	@Column(name="reco_unreco_submit")
	private String reco_unreco_submit;
	
	
	@Column(name="reco_approvereco_submit")
	private String reco_approvereco_submit;
	
	
	@Column(name="fileupload_submit")
	private String fileupload_submit;
	
	

	
	@Column(name="bankmaster_view")
	private String bankmaster_view;
	
		
	@Column(name="bankmaster_submit")
	private String bankmaster_submit;
	
	@Column(name="bankaccount_view")
	private String bankaccount_view;
	
	@Column(name="bankaccount_submit")
	private String bankaccount_submit;
	
	@Column(name="reports_brs_view")
	private String reports_brs_view;
	
	@Column(name="reports_gltran_view")
	private String reports_gltran_view;
	
	@Column(name="reports_banktran_view")
	private String reports_banktran_view;
	
	@Column(name="admin_user_view")
	private String admin_user_view;
	
	@Column(name="admin_user_submit")
	private String admin_user_submit;
	
	@Column(name="admin_roleper_view")
	private String admin_roleper_view;
	
	@Column(name="admin_roleper_submit")
	private String admin_roleper_submit;
	
	@Column(name="admin_sysparam_view")
	private String admin_sysparam_view;
	
	@Column(name="admin_sysparam_submit")
	private String admin_sysparam_submit;
	
	
	
	@Column(name="admin_passpolicy_view")
	private String admin_passpolicy_view;
	
	
	@Column(name="admin_passpolicy_submit")
	private String admin_passpolicy_submit;
	
}
