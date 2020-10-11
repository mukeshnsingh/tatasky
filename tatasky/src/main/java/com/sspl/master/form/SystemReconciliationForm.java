package com.sspl.master.form;

public class SystemReconciliationForm {

	private String bankShortName;
	private String bankName;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	private String glAccountNumber;
	private String bankMainAccount;
	private String fromDate;
	private String toDate;
	public String getBankShortName() {
		return bankShortName;
	}
	public void setBankShortName(String bankShortName) {
		this.bankShortName = bankShortName;
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
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
		
}
