<%@page import="com.sspl.entity.DocumentsEntity"%>
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
<title>Signatory Management</title>
</head>

<body>
	<form:form name="Signatory" commandName="signatoryEntity">
		<div class="middlecontent">
			<div class="leftbox">
				<div class="homeleftboxbg">
					<div class="box1_con_blue">
						<br /> <input class="press" type="button"
							value="<spring:message code="label.new"/>"
							onclick="submitForm('Signatory', '/tatasky/viewSignatory');" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('Signatory', '/tatasky/editSignatoryActive/${signatoryEntity.id}');"
							value="<spring:message code="label.update"/>" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('Signatory', '/tatasky/addSignatory/${signatoryEntity.id}');"
							value="<spring:message code="label.save"/>" />
					</div>
				</div>
			</div>
			<div class="middlebox">
				<font style="font-size: 20px">Enter Signatory Details</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>
				<br>
				<div>
					<fieldset class="fieldset">
						<legend>Signatory List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">

								<tr>
									<th>Signatory Name</th>
									<th>Signatory Code</th>
								</tr>
								<c:if test="${!empty signatoryList}">
									<c:forEach items="${signatoryList}" var="signatoryEntity">
										<tr>
											<td><a
												href="/tatasky/editSignatory/${signatoryEntity.id}">
													${signatoryEntity.signatoriesName} </a></td>
											<td>${signatoryEntity.signatoriesCode}</td>
										</tr>
									</c:forEach>
								</c:if>
							</table>
						</div>
					</fieldset>
				</div>
				<br>
				<fieldset class="fieldset">
					<legend>Signatory Master</legend>
					<div class="inputdiv">
						<table class="bank">
							<tr>
								<td><form:label path="signatoriesName">
										<spring:message code="label.signatoriesName" />
									</form:label></td>
								<td><form:input path="signatoriesName" style="width: 116px"
										validate="Signatory,string,yes" /></td>

								<td><form:label path="signatoriesCode">
										<spring:message code="label.signatoriesCode" />
									</form:label></td>
								<td><form:input path="signatoriesCode" style="width: 116px"
										validate="Signatories Code,string,yes" /></td>

								<td><form:label path="enabled">
										<spring:message code="label.active" />
									</form:label></td>
								<td><form:checkbox path="enabled" value="1" /></td>

							</tr>
						</table>
					</div>

				</fieldset>

			</div>
		</div>
	</form:form>

</body>
</html>
