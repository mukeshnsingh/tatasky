package com.sspl.master.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadDocForm {

    private Integer id;
	
	private String contractTypeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String contractDocument;

    private String profile;
	
    private   String document;

    private String enabled;
    
	private List<MultipartFile> files;

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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

}
