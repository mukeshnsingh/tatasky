package com.sspl.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.sspl.entity.Users;


public class Utility {
	public static void main(String[] args) {
		try {
		
			System.out.println(new Utility().getDirectConnection());
			getCurrentDateAndTime();
			//System.out.println("date "+convertDateToStringWithoutTimeGl(new Date()));
			System.out.println("date "+convertDateToStringWithoutTimeBS(new Utility().dateFormatterConvertStr("Sat Jan 04 00:00:00 IST 2014")));
			//System.out.println("convertStringTypeDateToDateType-->"+new Utility().convertStringTypeDateToDateType("12/1/2013"));
			System.out.println("date "+new Utility().dateFormatterConvertStr("Sat Jan 04 00:00:00 IST 2014"));
			
			String id="AR@1";
System.out.println(""+id.substring(0, id.length()-2));
System.out.println(""+id.substring(3, id.length()));
		/*	List<String> st=new ArrayList<String>();
			st.add("a");
			st.add("b");
			st.add("c");
			st.add("d");
			st.add("e");

			String temp="x";
			int cnt=0;
			for (String string : st) {
				//"'"+bankAcAndSubAc+"','"+bankAccountEntity.getBankSubAccount()+"'";
					temp=temp+"','"+string;
				
				System.out.println(""+temp);
			}
			System.out.println("t"+temp);
*/			
			/*String dateStr = "Tue Apr 30 00:00:00 IST 2013";emp-->
			System.out.println("date "+new Utility().dateFormatterConvertStr(dateStr));
			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			Date date = (Date)formatter.parse(dateStr);
			System.out.println(date);        

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
			System.out.println("formatedDate : " + formatedDate);
			
*/			
			
			
			/*DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
			Date date = null;
			String formatedDate ="";
			try {
				date = (Date)formatter.parse("04/25/2013");
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("formatedDate-->"+formatedDate);
			*/
			/*String t="16.0";
			System.out.println(Math.round(Double.parseDouble(t.toString())));
			String tt[]=t.split(".");
			System.out.println(t+""+tt.length);
			System.out.println(""+tt);
			*///fileNameAppender();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Map<String,Object> getSessionAttribute(String sessionAttr) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(sessionAttr!=null){
			String sessionParentArr[];
			sessionParentArr=sessionAttr.split(";");
			 if(sessionParentArr.length>0){
				 for (int i = 0; i < sessionParentArr.length; i++) {
					String sessionChildArr[];
					sessionChildArr=sessionParentArr[i].split(":");
					try {
						//System.out.println("Key["+sessionChildArr[0]+"] value["+sessionChildArr[1]+"]");
						if(sessionChildArr.length==2){
							map.put(sessionChildArr[0].trim(), sessionChildArr[1]);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 }
		 }
		return map;
	}

	public static Map<String,Object> getCurrentDateAndTime() {

		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate="";
		String currentTime="";
		String timeStamp="";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		StringTokenizer s = new StringTokenizer(datetime," ");
		while(s.hasMoreTokens())
		{
			currentDate = s.nextToken();
			currentTime = s.nextToken();
		}
		timeStamp=currentDate+" "+currentTime;
		System.out.println("time "+timeStamp);
		
		map.put("timeStamp",timeStamp);
		map.put("currentDate", currentDate);
		map.put("currentTime", currentTime);
		return map;
	}

	public static String fileNameAppender() {
		String fileName="";
		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate="";
		String currentTime="";
		map=getCurrentDateAndTime();
		if(map.get("currentDate")!=null){
			currentDate=(String)map.get("currentDate");
		}
		if(map.get("currentTime")!=null){
			currentTime=(String)map.get("currentTime");
		}

		String dateArr[]=currentDate.split("/");
		String timeArr[]=currentTime.split(":");
		fileName=dateArr[0]+dateArr[1]+dateArr[2]+timeArr[0]+timeArr[1]+timeArr[2]+"_";
		System.out.println("fileName-->"+fileName);
		return fileName;
	}

	public static DataModifier getDataModifier(Users  usersObj) {
		Map<String, Object> map = new HashMap<String, Object>();
		String currentTime="";
		map=getCurrentDateAndTime();
		if(map.get("currentTime")!=null){
			currentTime=(String)map.get("currentTime");
		}
		DataModifier object=new DataModifier();
		object.setLastChgBy(usersObj.getUserName());
		object.setLastChgTime(currentTime);
		object.setLastChgDate(new Date());

		return object;
	}
	
	public static Date convertStringTypeDateToDateType(String date)
	{
		Date orderDateTime = null;
		
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		if(date != null)
		{
			try 
			{
				orderDateTime = df.parse(date);
			}
			catch (ParseException e) 
			{
				e.printStackTrace();
			}
		}
		return orderDateTime;
	}
	public static Date dateFormatterDDMMYYYY(String stringDate)
	{
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
		try 
		{
			return(dateFormatterDDMMYYYY.parse( stringDate ));
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Date dateFormatterConvertDate(String stringDate)
	{
	DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	Date date = null;
	String formatedDate ="";
	try {
		date = (Date)formatter.parse(stringDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
		System.out.println("formatedDate-->"+formatedDate);
		date=convertStringTypeDateToDateType(formatedDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return date;
}
	public static String dateFormatterConvertStr(String stringDate)
	{
		System.out.println("stringDate-->"+stringDate);
	//DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	Date date = null;
	String formatedDate ="";
	try {
		date = (Date)formatter.parse(stringDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("formatedDate-->"+formatedDate);
	return formatedDate;
}
	public static StringBuffer dateFormatterConvertUiValidate(String stringDate)
	{
		System.out.println("stringDate-->"+stringDate);
	//DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	Date date = null;
	StringBuffer dateOnly = new StringBuffer();
	try {
		date = (Date)formatter.parse(stringDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dateOfMonth, month, year;
		dateOfMonth=cal.get(Calendar.DATE);
		month=cal.get(Calendar.MONTH) + 1;
		year=cal.get(Calendar.YEAR);
		System.out.println("dateOfMonth-->"+dateOfMonth);
		System.out.println("month-->"+month);
		System.out.println("year-->"+year);
		if(dateOfMonth<10)
		dateOnly.append("0");
		
		dateOnly.append(dateOfMonth);
		dateOnly.append("/");
		if(month<10)
			dateOnly.append("0");
		
			dateOnly.append(month);
			dateOnly.append("/");

			dateOnly.append(year);
			
		//formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("dateOnly-->"+dateOnly);
	return dateOnly;
}
	/*public static Date convertIntoDate(kkk kkkDate)
	{
		System.out.println("stringDate-->"+stringDate);
		Date date=null;
		try {
			if(stringDate!=null && !stringDate.equalsIgnoreCase("")){
				date=Utility.dateFormatterConvert(stringDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	*/
	public static String convertDateToStringWithoutTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		StringBuffer dateOnly = new StringBuffer();
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
		dateOnly.append("-");
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10)
			dateOnly.append("0");
		dateOnly.append( dateOfMonth );
		dateOnly.append("-");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10)
			dateOnly.append("0");
		dateOnly.append(month);
		//System.out.println(" date ["+date+"] dateOnly ["+dateOnly+"]");
		//.append(" ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
		return dateOnly.toString();
	}
	public static String convertDateToStringWithoutTimeBS(String date) {
		
		String dateArr[]=date.split("/");
		StringBuffer dateOnly = new StringBuffer();
		dateOnly.append(dateArr[2]);
		dateOnly.append("-");
		dateOnly.append(dateArr[1]);
		dateOnly.append("-");
		dateOnly.append(dateArr[0]);
		
		
		return dateOnly.toString();
	}
public static String convertDateToStringWithoutTimeDiff(String date) {
		System.out.println("date-->"+date);
		String dateArr[]=date.split("-");
		System.out.println("dateArr-->"+dateArr.length);
		StringBuffer dateOnly = new StringBuffer();
		
		if(dateArr[1].length()==1)
		dateOnly.append("0");
		dateOnly.append(dateArr[1]);
		dateOnly.append("/");
		
		//check add 0
		if(dateArr[2].length()==1)
			dateOnly.append("0");
			
		dateOnly.append(dateArr[2]);
		dateOnly.append("/");
		dateOnly.append(dateArr[0]);
		
		
		return dateOnly.toString();
	}
public static String convertDateToStringWithoutTimeGl(String date) {
		
		String dateArr[]=date.split("/");
		StringBuffer dateOnly = new StringBuffer();
		int day=0;
		dateOnly.append(dateArr[2]);
		dateOnly.append("-");
		int month=0;
		month=Integer.parseInt(""+dateArr[1]);
		if (month < 10)
			dateOnly.append("0");
		dateOnly.append(month);
		dateOnly.append("-");
		day=Integer.parseInt(""+dateArr[0]);
		if (day< 10)
			dateOnly.append("0");
		dateOnly.append(day);
		return dateOnly.toString();
	}

	public static String convertIntoDateStr(String stringDate)
	{
		
		String date = null;
		try {
			if(stringDate!=null && !stringDate.equalsIgnoreCase("")){
				date=Utility.dateFormatterConvertStr(stringDate);
			}
			System.out.println("date-->"+date);
		} catch (Exception e) {
			//e.printStackTrace();
			date=stringDate;
		}
		System.out.println("Input Date ["+stringDate+"] Output Date ["+date+"]");
		//return stringDate;
		return date;
	}
	public static double convertIntoDouble(String strValue)
	{
		double value=0;
		try 
		{
			if(strValue!=null && !strValue.equalsIgnoreCase("")){
				value=Double.parseDouble(strValue);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public static long convertIntoInt(String strValue)
	{
		long value=0;
		try 
		{
			if(strValue!=null && !strValue.equalsIgnoreCase("")){
				/*String temp[]=strValue.split(".");
				System.out.println("temp.length "+temp);
				if(temp.length>0){
					value=Integer.parseInt(temp[0]);
				}else{
					value=Integer.parseInt(strValue);
				}*/
				value=Math.round(Double.parseDouble(strValue.toString()));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public static long convertIntoLong(String strValue)
	{
		long value=0;
		try 
		{
			if(strValue!=null && !strValue.equalsIgnoreCase("")){
				value=Long.parseLong(strValue);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	/**
	 * This method getDirectConnection()
	 * 
	 * @author Mukesh Narayan Singh
	 * @return Connection connection
	 */
	public Connection getDirectConnection() throws Exception {
		Connection connection = null;
		String driverClassName = "com.mysql.jdbc.Driver";

		try {
			String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=bank";
			String dbUserId = "sa";
			String dbPwd = "maxadmin";

			/*Properties properties=new Properties();

			URL resourcePath =  Thread.currentThread().getContextClassLoader().getResource("messages_en.properties");
			try {
				properties.load(new FileInputStream(new File(resourcePath.getFile())));
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
			} catch (IOException e) {
				//e.printStackTrace();
			}

			if (properties.getProperty("jdbc.driverClassName") != null) {
				driverClassName = properties.getProperty("jdbc.driverClassName");
			}
			
			if (properties.getProperty("jdbc.databaseurl") != null) {
				dbUrl = properties.getProperty("jdbc.databaseurl");
			}
			if (properties.getProperty("jdbc.username") != null) {
				dbUserId = properties.getProperty("jdbc.username");
			}
			if (properties.getProperty("jdbc.password") != null) {
				dbPwd = properties.getProperty("jdbc.password");
			}
			System.out.println("Pdw "+dbPwd);
*/			Class.forName(driverClassName);
			connection = DriverManager.getConnection(dbUrl, dbUserId, dbPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static Map<String,Object> getLogMsg(Users usersObj,String appName) {
		Map<String, Object> map = new HashMap<String, Object>();
		String timeStamp="";
		String logingMsgInfo="";
		String logingMsgTech="";
		Map<String, Object> dateMap=new HashMap<String, Object>();
		dateMap=Utility.getCurrentDateAndTime();
		timeStamp=(String)dateMap.get("timeStamp");
		//Time Stamp | Application Name | Log Type | User ID | Account No | Description 
		String logType="INFO";
		logingMsgInfo="Time Stamp ["+timeStamp+"] App Name ["+appName+"] Log Type ["+logType+"] User ID ["+usersObj.getUserName()+"]  Description [N/A ]";
		logType="TECH";
		logingMsgTech="Time Stamp ["+timeStamp+"] App Name ["+appName+"] Log Type ["+logType+"] User ID ["+usersObj.getUserName()+"]  Description [N/A ]";
		
		map.put("logingMsgInfo", logingMsgInfo);
		map.put("logingMsgTech", logingMsgTech);
		return map;
	}
	public static long dateDiff(String dateStart,String dateStop) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		 System.out.println(" dateStart["+dateStart+"]   dateStop ["+dateStop+"]");
		Date d1 = null;
		Date d2 = null;
		long diffDays =0;
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
 
			long diff = d2.getTime() - d1.getTime();
			 diffDays = diff / (24 * 60 * 60 * 1000);
 
			//System.out.print(diffDays + " days, ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffDays;
	}
}
