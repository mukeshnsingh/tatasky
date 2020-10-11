<%@page import="com.sspl.entity.Role"%>
<%@page import="com.sspl.entity.EmployeeEntity"%>
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
<title>Employee</title>
</head>

<body>
	<form:form name="Employee" commandName="employeeEntity">
		<div class="middlecontent">
			<div class="leftbox">
				<div class="homeleftboxbg">
					<div class="box1_con_blue">
						<br /> <input class="press" type="button"
							value="<spring:message code="label.new"/>"
							onclick="submitForm('Employee', '/tatasky/viewEmployee');" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('Employee', '/tatasky/editEmployeeActive/${employeeEntity.id}');"
							value="<spring:message code="label.update"/>" /> 
                        <input class="press" type="button"  id="update"onclick="submitForm('Employee', '/tatasky/addEmp1');"  value="<spring:message code="label.save"/>"/>


					</div>
				</div>
			</div>


			<div class="middlebox">

				<font style="font-size: 20px">Enter Employee Details</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>


				<br>
				<div>
					<fieldset class="fieldset">
						<legend>Employee List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">

								<tr>
									<th>Employee Name</th>
									<th>Employee Code</th>
									<th>Mobile</th>
									<th>Email</th>
									<th>Department</th>
								</tr>


								<c:if test="${!empty employeList}">
									<c:forEach items="${employeList}" var="employeeEntity">
										<tr>

											<td><a href="/tatasky/editEmployee/${employeeEntity.id}">
													${employeeEntity.employeeName} </a></td>

											<td>${employeeEntity.employeeCode}</td>
											<td>${employeeEntity.mobileNo}</td>
											<td>${employeeEntity.email}</td>
											<td>${employeeEntity.deptObj.departmentName}</td>
										</tr>

									</c:forEach>
								</c:if>



							</table>

						</div>

					</fieldset>
				</div>
				<br>

				<fieldset class="fieldset">
					<legend>Employee Master</legend>
					<div class="inputdiv">
						<table class="bank">

							<tr>

								<td><form:label path="employeeName">
										<spring:message code="label.fname" />
									</form:label></td>
								<td><form:input path="employeeName" style="width: 116px"
										validate="First Name,string,yes" /></td>

								<td><form:label path="employeeCode">
										<spring:message code="label.empCode" />
									</form:label></td>
								<td><form:input path="employeeCode" style="width: 116px" /></td>

								 <td><form:label path="">
										<spring:message code="label.department" />
									</form:label></td>
								<td><select name="lastChgBy" style="width: 122px;"
									validate="Department,string,yes">
										<option value="">---Select---</option>
										<c:if test="${!empty departmentList}">
											<c:forEach items="${departmentList}" var="lastChgBy">
												<option value="${lastChgBy.id}">${lastChgBy.departmentName}</option>
											</c:forEach>
										</c:if>
								</select></td>


							</tr>

							<tr>

								<td><form:label path="mobileNo">
										<spring:message code="label.mobileno" />
									</form:label></td>
								<td><form:input path="mobileNo" style="width: 116px"
										validate="Mobile,int,yes" /></td>

								<td><form:label path="email">
										<spring:message code="label.emailid" />
									</form:label></td>
								<td><form:input path="email" style="width: 116px"
										validate="Email ,email,yes" /></td>

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
