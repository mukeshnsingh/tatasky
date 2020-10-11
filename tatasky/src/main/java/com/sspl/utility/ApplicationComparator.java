package com.sspl.utility;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import com.sspl.entity.Application;

@SuppressWarnings("serial")
public class ApplicationComparator implements Serializable , Comparator<Application>{

	public int compare(Application m1, Application m2) {
		String int1 = m1.getApp_id();
		String int2 = m2.getApp_id();
		return int1.compareTo(int2);
	}
	
	public static TreeSet<Application> getApplicationTreeSet(){
		return new TreeSet<Application> (new ApplicationComparator());
	}
}