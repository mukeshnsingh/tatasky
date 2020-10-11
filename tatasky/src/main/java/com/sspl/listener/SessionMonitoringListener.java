package com.sspl.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionMonitoringListener  implements HttpSessionListener {
	 
	  private static int totalActiveSessions;
	 
	  public static int getTotalActiveSession(){
		return totalActiveSessions;
	  }
	 
	  public void sessionCreated(HttpSessionEvent arg0) {
		totalActiveSessions++;
		System.out.println("sessionCreated - add one session into counter ["+totalActiveSessions+"]");
	  }
	 
	  public void sessionDestroyed(HttpSessionEvent arg0) {
		totalActiveSessions--;
		System.out.println("sessionDestroyed - deduct one session from counter ["+totalActiveSessions+"]");
	  }	

}
