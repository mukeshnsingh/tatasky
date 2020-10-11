<%--
 * Copyright 2020 SSPL. All rights reserved.
 * Use is subject to license terms.
 * navigation.jsp  
 * Purpose of the JSP -  This is for navigation.
 * @author  Mukesh Narayan Singh
 * Create Date: 30 Sep 2020
 * Revision Date:      
 * Revision By: 
 * @version 1.0
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="com.sspl.entity.*"%>
<link href="<c:url value="/resources/css/hstyle.css" />" rel="stylesheet">
   <script src="<c:url value="/resources/js/menu.js" />"></script>
<DIV id="menu">
<script type="text/javascript">
			var menu = new Array();
  
  
<%//			code for jsp
                Map map = new HashMap();
                int counter = 0;
                Set<Application> roleApp = null;
			if (request.getAttribute("roleApp") != null) {
				roleApp = (Set) request.getAttribute("roleApp");
			}
		//	System.out.println("roleApp-->"+roleApp);
			String userName = "";
			

			if (request.getAttribute("roleApp") != null) {
				roleApp = (Set<Application>) request.getAttribute("roleApp");
				session.setAttribute("roleApp", roleApp);
			} else if (session.getAttribute("roleApp") != null) {
				roleApp = (Set<Application>) session.getAttribute("roleApp");
			}
			
			if (roleApp != null) {

				for (Application application2 : roleApp) {
					out.println("menu[" + counter + "] = new Array();");
					out.println("menu[" + counter + "][0] ='"
							+ application2.getApp_id() + "'");
					out.println("menu[" + counter + "][1] ='"
							+ application2.getParent_id() + "'");
					out.println("menu[" + counter + "][2] ='"
							+ application2.getName() + "'");
					out.println("menu[" + counter + "][3] ='"
							+ application2.getUrl() + "?appId="
							+ application2.getApp_id() + "'");
					counter++;
				}
			}%>              
           	makeMainMenu();
           	
  </script>
  </div>   
  