

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Tatasky Workflow Login</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="wrapper"> 
        
	<div class="middlecontent">
			  <form name='form' action='j_spring_security_check' method='POST'>
	 <center>
	
	 <fieldset  style="width: 300px; margin-top: 50px"><legend >User Login</legend>
	
  <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
   
  <c:if test="${not empty message}">
      <font color="red">
        <c:out value="${message}"/>.
      </font>
    </c:if>
	<c:if test="${not empty messageLogout}">
      <font color="red">
        <c:out value="${messageLogout}"/>.
      </font>
    </c:if>
	 <table>
	    <tr>
	      <td>User Name:</td>
	      <td><input type='text' name='j_username' value=''></td>
	    </tr>
	    <tr>
	      <td>Password:</td>
	      <td><input type='password' name='j_password'/></td>
	    </tr>
	    <tr>
	      <td colspan='2'>
	        <input name="submit" type="submit" value="Login"/></td>
	    </tr>
	  </table>
	  </fieldset>
	   </center>
  </form>
	</div>
	</div>
</body>
</html>
