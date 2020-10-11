<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@page import="com.sspl.entity.*"%>
<!DOCTYPE html>
<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
<html>
<head>
<style>

.readonlyTxt {
	color: #000000;
	background-color: #E0E0E0;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Role Permissions</title>
</head>
<%
	List<Application> appList = new ArrayList<Application>();
	if (request.getAttribute("appList") != null) {
		appList = (List<Application>) request.getAttribute("appList");
	}
		List<Role> editRoleList=new ArrayList<Role>();
		List<UserRoleApplicationEntity> userRoleList=new ArrayList<UserRoleApplicationEntity>();
	
	List<Role> roleList=new ArrayList<Role>();
	if (request.getAttribute("roleList") != null) {
		roleList = (List<Role>) request.getAttribute("roleList");
	}
	if (request.getAttribute("editRoleList") != null) {
		editRoleList = (List<Role>) request.getAttribute("editRoleList");
	}
	if (request.getAttribute("userRoleList") != null) {
		userRoleList = (List<UserRoleApplicationEntity>) request.getAttribute("userRoleList");
	}
%>
<body>
	<form:form name="role" commandName="role">
		<div class="middlecontent">

			<c:choose>
				<c:when test="${usersObj.userRole=='ROLE_ADMIN'}">
					<div class="leftbox">

						<div class="checkboxbg"></div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="leftbox">

						<div class="homeleftboxbg">

							<div class="box1_con_blue">
								<br> 
								<input class="press" type="button"	value="<spring:message code="label.new"/>"	onclick="viewBank('role','/bankreco/rolePermissionNew')" />
								
								<input class="press" type="button" onclick="${changelist}"	id="update" value="<spring:message code="label.update"/>" /> 
									
									<input class="press" type="button" id="save" value="<spring:message code="label.save"/>"
									  onclick="viewBank('role', '/bankreco/${Save}')" />
							</div>

						</div>
					</div>
				</c:otherwise>
			</c:choose>

			<div class="middlebox">
				<font style="font-size: 20px;">Role</font>
				<div class="messagebar">
					<img id="error" src="<c:url value='/resources/images/error.png'/>"
						style="visibility: hidden;" /> &nbsp;<span id="spanmessage"
						style="color: red;"></span>
					<c:choose>
						<c:when test="${check=='0'}">
							<span id="change" style="color: red;"><img
								src="<c:url value='/resources/images/error.png'/>" />&nbsp;${message}</span>
						</c:when>
						<c:when test="${check=='1'}">

							<span id="change" style="color: Green; font-size: 12px;"><img
								src="<c:url value='/resources/images/correct.png'/>" />&nbsp;${message}</span>
						</c:when>
					</c:choose>
				</div>

				<br>

				<div>

	<br>
				<div>
					<fieldset class="fieldset">
						<legend>
							<b>Role</b>
						</legend>
						<div class="inputdiv">
							<table class="bank">
 <c:if test="${!empty roleList}">
									<c:forEach items="${roleList}" var="role"
										varStatus="cntGl" begin="0">
										<tr>
											<td>
											<a href="/bankreco/editRolePermission/${role.id}">${role.role}</a> </td>
											<c:choose>
												<c:when test="${role.enabled==1}">
													<td>Active</td>
												</c:when>
												<c:otherwise>
													<td>De-Active</td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</c:if>
					
 
							</table>
						</div>
					</fieldset>
				</div>
    
                            <br>
                            <fieldset style="width: 690px;" >
                            <legend><b>Permissions</b></legend>
   <div id="accordion" >
<%
System.out.println("appList.size()--->"+appList.size());
System.out.println("userRoleList.size()--->"+userRoleList.size());
System.out.println("editRoleList.size()--->"+editRoleList.size());
String roleName="";
int roleId=0;
String roleEnabled="";
if(editRoleList.size()>0){
	Role role=new Role();
	role=editRoleList.get(0);
	roleName=role.getRole();
	roleEnabled=role.getEnabled();
	roleId=role.getId();
}
System.out.println("roleName ["+roleName+"] roleEnabled ["+roleEnabled+"]");
 %>
                  		<div>
                  		          
                  		                        Role<font color="red">*</font>
                  		 <form:hidden path="id"/>                       
                        <input type="text" name="roleName" value=""  ${readonly} class="${readonlyTxt}"/>
                        Active   <input type="checkbox" name="permission" value="1"  ${disabled} class="${readonlyTxt}"/>
                  					 <script type="text/javascript">
          		   document.role.roleName.value='<%=roleName%>';
          		   document.role.id.value='<%=roleId%>';
          		   <%
          		   if(roleEnabled.equalsIgnoreCase("1")){
          		   %>
          		   document.role.permission.checked = true;
          		   <%
          		   }
          		   %>
          		   
                </script>
                        
                  						<table class="bank">
<%

	if(appList.size()>0){
	for(Application app:appList){
	String permission="";
	if(userRoleList.size()>0){
	for(UserRoleApplicationEntity userRoleApplicationEntity:userRoleList){
		if(app.getApp_id().equalsIgnoreCase(userRoleApplicationEntity.getAppId())){
		permission=userRoleApplicationEntity.getPermission();
		break;
		}
	
	}
	}
	System.out.println("permission ["+permission+"]");
 %>

 <tr>
											<td><%=app.getName()%></td>
											<%
											if(app.getParent_id().equalsIgnoreCase("0")){
											
											 %>
											 <td colspan="3">&nbsp;</td>
											<%
										}else{
											if(permission.equalsIgnoreCase("0")){
											 %>
											 <td><input type="radio" name="permission<%=app.getName()%>" value="0" checked="checked"/> N/A</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="1"/> View</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="2"/> Submit</td>
										
											 <%
											}else if(permission.equalsIgnoreCase("1")){
											 %>
											 <td><input type="radio" name="permission<%=app.getName()%>" value="0"/> N/A</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="1" checked="checked"/> View</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="2"/> Submit</td>
										
											 <%
											}else if(permission.equalsIgnoreCase("2")){
											 %>
											 <td><input type="radio" name="permission<%=app.getName()%>" value="0"/> N/A</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="1"/> View</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="2" checked="checked"/> Submit</td>
										
											 <%
											}else{
											
											 %>
											 <td><input type="radio" name="permission<%=app.getName()%>" value="0"/> N/A</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="1"/> View</td>
											<td><input type="radio" name="permission<%=app.getName()%>" value="2"/> Submit</td>
										
											 <%
											 }
										}
											 %>
										</tr>
 <%
 }
	}
 %>
							</table>
                  </div>
                  </div>
                        </fieldset>
			</div>
	</form:form>


</body>
</html>
