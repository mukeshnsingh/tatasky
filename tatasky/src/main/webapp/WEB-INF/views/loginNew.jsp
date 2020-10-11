<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <script src="${pageContext.request.contextPath}/js/common.js"></script>
<html>
<head>
    <title>***Bank Reco***</title>
</head>
<body>
 
<h2></h2>
 <style>  .error {      color: #EF1313;      font-style: italic;  }</style>
<!-- //  -->

<script type="text/javascript">
	function validate(action){
	errorMessage=new Array();
	var userName=document.getElementById("userName").value;
	var password=document.getElementById("password").value;
	if(userName==""){
		errorMessage[0]="User Name can not be blank";
	}
	if(password==""){
		errorMessage[1]="password can not be blank";
	}
	if(errorMessage.length>0){
		return false;
	}else{
	//document.user[0].method="POST";
	document.users.action = action;
	document.users.submit();
	
	}
	}
	
</script>

<form:form name="users" commandName="users">
 <table>
<%--  	<form:errors path="userName" cssclass="error"></form:errors>
 	<form:errors path="password" cssclass="error"></form:errors>
 --%>
 <DIV ID="errorUser" class="error" style="display: none">
 	User Name can not be blank.
 </DIV>
 
 <DIV ID="errorPwd" class="error" style="display: none">
 	Password can not be blank.
 </DIV>
     <tr>
        <td><form:label path="userName" >User Name </form:label>
        <font color="red"><form:errors path="userName"/></font>
        </td>
        <td><form:input path="userName" value=""/>
        </td>
    </tr>
    
        <tr>
        <td><form:label path="password" >Password</form:label>
	            	<font color="red"><form:errors path="password"/></font>
	            	</td>
        <td><form:password path="password" value=""/>
        
        </td>
    </tr>
    
        <tr>
        <td colspan="2">

					<input type="button"  id="save" value="Login" onclick="validate('/tatasky/validate');"/>
        </td>
    </tr>
</table> 

</form:form>
</body>
</html>