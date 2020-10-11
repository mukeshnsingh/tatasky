package com.sspl.master.form;

import java.io.Serializable;

public class DocumentApprovarForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer  id;

	private String contractTypeName;

	private String contractDocument;

	private String followupComment;

	private String enabled;

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

	public String getFollowupComment() {
		return followupComment;
	}

	public void setFollowupComment(String followupComment) {
		this.followupComment = followupComment;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	} 

	


}
