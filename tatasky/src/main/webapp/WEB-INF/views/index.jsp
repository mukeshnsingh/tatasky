<%--
 * Copyright 2020 SSPL. All rights reserved.
 * Use is subject to license terms.
 * index.jsp  
 * Purpose of the JSP -  This is for index.
 * @author  Mukesh Narayan Singh
 * Create Date: 30 Sep,2020 
 * Revision Date:      
 * Revision By: 
 * @version 1.0
--%>
<%@page import="java.util.Map"%>
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>

<%
		String contentJsp="";
		if(request.getAttribute("contentJsp")!=null){
			contentJsp=(String)request.getAttribute("contentJsp");
		}
		System.out.println("contentJsp-->"+contentJsp);
		if(contentJsp != null && !contentJsp.equalsIgnoreCase("")){  
		
		contentJsp=contentJsp+".jsp";
%>
		
		<jsp:include page="<%=contentJsp%>" flush="true" />

<%
		}
		else{%>
		
			<jsp:include page="home1.jsp" flush="true" />
			
<% 		}
%>

