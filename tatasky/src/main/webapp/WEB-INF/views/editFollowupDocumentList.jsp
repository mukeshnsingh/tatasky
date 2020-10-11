<%@page import="com.sspl.entity.*"%>
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

<style>
.readonlyTxt {
	color: #000000;
	background-color: #E0E0E0;
}
</style>
<%

String approvalAuth="";			
if (request.getAttribute("approvalAuth") != null) {
	approvalAuth= (String) request.getAttribute("approvalAuth");
}
			
			%>
<title>View Contracts</title>
</head>
<body>
	<form:form name="ContractType" commandName="documentApprovarForm">
		<div class="middlecontent">
			<div class="middlebox">
				<font style="font-size: 20px">View Contracts</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>


				<br>
				<div>
					<fieldset class="fieldsetsystem">
						<legend>Pending Contract List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">

								<tr>
									<th>Contract Name</th>
									<th>Uploaded Document</th>
									<th>Document Type</th>
									<th>Profile</th>
									<th>View</th>
								</tr>

								<c:if test="${!empty contractTypeList}">
									<c:forEach items="${contractTypeList}"
										var="documentApprovarForm">
										<tr>
											<td><a href="/tatasky/editFollowupDocumentList/"
												${documentApprovarForm.id}>
													${documentApprovarForm.contractTypeName}</ahref></td>
											<td>${documentApprovarForm.contractDocument}</td>
											<td>${documentApprovarForm.documentsEntity.documentName}</td>
											<td>${documentApprovarForm.profileSignatoriesEntity.profileSigName}</td>
											<td>${documentApprovarForm.contractDocument}</td>
											<%-- <td><a href="/tatasky/downLoadDocument/${documentApprovarForm.id}"> ${documentApprovarForm.contractDocument} </a></td> --%>
										</tr>
									</c:forEach>
								</c:if>



							</table>
						</div>
					</fieldset>
				</div>


				<br>
				<fieldset class="fieldset">
					<legend>Approve Contract</legend>
					<div class="inputdiv">
						<table>

							<tr>
								<td><form:label path="contractTypeName">
										<spring:message code="label.contractTypeName" />
									</form:label></td>
								<td><form:input path="contractTypeName"
										style="width: 116px" cssClass="${readonlyTxt}"
										readonly="${readonly}" /></td>

								<td><form:label path="contractDocument">
										<spring:message code="label.contractDocument" />
									</form:label></td>
								<td><form:input path="contractDocument"
										style="width: 116px" cssClass="${readonlyTxt}"
										readonly="${readonly}" /></td>

								<td><form:label path="followupComment">
										<spring:message code="label.followupComment" />
									</form:label></td>
								<td><form:textarea path="followupComment"
										style="width: 116px" validate="Comment,string,yes" /></td>

							</tr>
							<tr>

								<%--  <td><form:label path="enabled"><spring:message code="label.approvedReject"/></form:label></td>
                                <td><form:checkbox path="enabled" value="1" /></td> --%>
								<td><c:choose>

										<c:when test="${approvalAuth=='1'}">
											<td><input class="press" type="button" id="update"
												onclick="submitForm('ContractType', '/tatasky/approveDocument/${documentApprovarForm.id}');"
												value="<spring:message code="label.approve"/>" /></td>
											<td><input class=
								"press" type="button" id="update"
												onclick="submitForm('ContractType', '/tatasky/rejectDocument/${documentApprovarForm.id}');"
												value="<spring:message code="label.reject"/>" /></td>
								</c:when>
										<c:otherwise>
									          Not Authorised
         									</c:otherwise>
									</c:choose>

							</tr>

						</table>
					</div>
				</fieldset>

			</div>
		</div>

	</form:form>

</body>




</html>
