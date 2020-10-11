package com.sspl.utility;

import java.util.Date;


public class DataModifier {

		private String lastChgBy;
	    
	    private Date lastChgDate;
	    
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

		private String lastChgTime;
}
