<%@page import="com.sspl.entity.Department"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department Management</title>
</head>

<body>
	<form:form name="Department" commandName="department">
		<div class="middlecontent">
			<div class="leftbox">
				<div class="homeleftboxbg">
					<div class="box1_con_blue">
						<br /> <input class="press" type="button"
							value="<spring:message code="label.new"/>"
							onclick="submitForm('Department', '/tatasky/viewDepartment');" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('Department', '/tatasky/editDepartmentActive/${department.id}');"
							value="<spring:message code="label.update"/>" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('Department', '/tatasky/addDepartment/${department.id}');"
							value="<spring:message code="label.save"/>" />
					</div>
				</div>
			</div>
			<div class="middlebox">
				<font style="font-size: 20px">Enter Department Details</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>
				<br>
				<div>
					<fieldset class="fieldset">
						<legend>Department List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">

								<tr>
									<th>Department Name</th>
									<th>Department Code</th>
								</tr>
								<c:if test="${!empty departmentList}">
									<c:forEach items="${departmentList}" var="department">
										<tr>
											<td><a
												href="/tatasky/editDepartment/${department.id}">
													${department.departmentName} </a></td>
											<td>${department.departmentCode}</td>
										</tr>
									</c:forEach>
								</c:if>
							</table>
						</div>
					</fieldset>
				</div>
				<br>
				<fieldset class="fieldset">
					<legend>Department Master</legend>
					<div class="inputdiv">
						<table class="bank">
							<tr>
								<td><form:label path="departmentName">
										<spring:message code="label.departmentName" />
									</form:label></td>
								<td><form:input path="departmentName" style="width: 116px"
										validate="Department,string,yes" /></td>

								<td><form:label path="departmentCode">
										<spring:message code="label.departmentCode" />
									</form:label></td>
								<td><form:input path="departmentCode" style="width: 116px"
										validate="Department Code,string,yes" /></td>

								<td><form:label path="status">
										<spring:message code="label.active" />
									</form:label></td>
								<td><form:checkbox path="status" value="1" /></td>

							</tr>
						</table>
					</div>

				</fieldset>

			</div>
		</div>
	</form:form>

</body>
</html>
