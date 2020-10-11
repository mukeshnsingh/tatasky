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
<title>Documents Management</title>
</head>

<body>
	<form:form name="Documents" commandName="documentsEntity">
		<div class="middlecontent">
			<div class="leftbox">
				<div class="homeleftboxbg">
					<div class="box1_con_blue">
						<br /> <input class="press" type="button"
							value="<spring:message code="label.new"/>"
							onclick="submitForm('Documents', '/tatasky/viewDocuments');" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('Documents', '/tatasky/editDocumentsActive/${documentsEntity.id}');"
							value="<spring:message code="label.update"/>" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('Documents', '/tatasky/addDocuments/${documentsEntity.id}');"
							value="<spring:message code="label.save"/>" />
					</div>
				</div>
			</div>
			<div class="middlebox">
				<font style="font-size: 20px">Enter Documents Details</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>
				<br>
				<div>
					<fieldset class="fieldset">
						<legend>Documents List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">

								<tr>
									<th>Document Name</th>
									<th>Document Code</th>
								</tr>
								<c:if test="${!empty documentsList}">
									<c:forEach items="${documentsList}" var="documentsEntity">
										<tr>
											<td><a
												href="/tatasky/editDocuments/${documentsEntity.id}">
													${documentsEntity.documentName} </a></td>
											<td>${documentsEntity.documentCode}</td>
										</tr>
									</c:forEach>
								</c:if>
							</table>
						</div>
					</fieldset>
				</div>
				<br>
				<fieldset class="fieldset">
					<legend>Documents Master</legend>
					<div class="inputdiv">
						<table class="bank">
							<tr>
								<td><form:label path="documentName">
										<spring:message code="label.documentName" />
									</form:label></td>
								<td><form:input path="documentName" style="width: 116px"
										validate="Documents,string,yes" /></td>

								<td><form:label path="documentCode">
										<spring:message code="label.documentCode" />
									</form:label></td>
								<td><form:input path="documentCode" style="width: 116px"
										validate="Documents Code,string,yes" /></td>

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
