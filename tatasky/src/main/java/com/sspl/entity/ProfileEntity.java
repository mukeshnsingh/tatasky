package com.sspl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="profiles_main")
public class ProfileEntity implements Serializable{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Id
		    @Column(name="profile_id")
		    @GeneratedValue
		    private Integer id;
				
			@Column(name="profile_name")
			private String profileName;

			@Column(name="profile_description")
			private String profileDescription;

			@Column(name="input_folder")
			private String inputFolder;

			@Column(name="output_folder")
			private String outputFolder;

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

			public String getProfileName() {
				return profileName;
			}

			public void setProfileName(String profileName) {
				this.profileName = profileName;
			}

			public String getProfileDescription() {
				return profileDescription;
			}

			public void setProfileDescription(String profileDescription) {
				this.profileDescription = profileDescription;
			}

			public String getInputFolder() {
				return inputFolder;
			}

			public void setInputFolder(String inputFolder) {
				this.inputFolder = inputFolder;
			}

			public String getOutputFolder() {
				return outputFolder;
			}

			public void setOutputFolder(String outputFolder) {
				this.outputFolder = outputFolder;
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

			public String getEnabled() {
				return enabled;
			}

			public void setEnabled(String enabled) {
				this.enabled = enabled;
			}


}
