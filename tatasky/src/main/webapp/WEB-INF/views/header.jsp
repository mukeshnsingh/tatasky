<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.sspl.entity.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <meta http-equiv="refresh" content="${pageContext.session.maxInactiveInterval};url=/tatasky/sessionExpired" />
   <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
   <script src="<c:url value="/resources/js/bank_Reco_Validation.js" />"></script>
   <script src="<c:url value="/resources/js/bankreco.js" />"></script>
   </head>
    <body>
    
        <div id="wrapper"> 
                  <div class="header1">
                   <div><table width="960" height="52px"><tr><td  ><img src="<c:url value='/resources/images/tata-sky-logo.png'/>" alt="Carrefour" height="50" width="80" ></td>  
                    
               
                      <td style="text-align:right;">  <b>Welcome</b><b style="color:navy; text-transform: capitalize;"> ${usersObj.userName}| 
													
													<a href="/tatasky/logoutSuccess" >Logout</a>
													</b></td></tr></table></div>
											                       
                        </div></body></html>
