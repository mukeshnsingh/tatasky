package com.sspl.master.form;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {

	private String bankShortName;
	
	private String glAccountNumber;

	private Date glFromDate;
	
	private Date glToDate;

	private Date bankFromDate;
	
	private Date bankToDate;
	
	public Date getBankFromDate() {
		return bankFromDate;
	}

	public void setBankFromDate(Date bankFromDate) {
		this.bankFromDate = bankFromDate;
	}

	public Date getBankToDate() {
		return bankToDate;
	}

	public void setBankToDate(Date bankToDate) {
		this.bankToDate = bankToDate;
	}

	public Date getGlFromDate() {
		return glFromDate;
	}

	public void setGlFromDate(Date glFromDate) {
		this.glFromDate = glFromDate;
	}

	public Date getGlToDate() {
		return glToDate;
	}

	public void setGlToDate(Date glToDate) {
		this.glToDate = glToDate;
	}

	public String getGlAccountNumber() {
		return glAccountNumber;
	}

	public void setGlAccountNumber(String glAccountNumber) {
		this.glAccountNumber = glAccountNumber;
	}

	public String getBankMainAccount() {
		return bankMainAccount;
	}

	public void setBankMainAccount(String bankMainAccount) {
		this.bankMainAccount = bankMainAccount;
	}

	private String bankMainAccount;
	
	public String getBankShortName() {
		return bankShortName;
	}

	public void setBankShortName(String bankShortName) {
		this.bankShortName = bankShortName;
	}

	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
}
