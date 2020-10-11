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

<title>View Contracts</title>
</head>
<body>
	<form:form name="ContractType" commandName="contractTypeEntity">
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
									<c:forEach items="${contractTypeList}" var="contractTypeEntity">
										<tr>
											<td>
											<a href="/tatasky/editFollowupDocumentList/${contractTypeEntity.id}">
											${contractTypeEntity.contractTypeName}</ahref></td>
											<td>${contractTypeEntity.contractDocument}</td>
											<td>${contractTypeEntity.documentsEntity.documentName}</td>
											<td>${contractTypeEntity.profileSignatoriesEntity.profileSigName}</td>
											<td>${contractTypeEntity.contractDocument}</td>
											<%-- <td><a href="/tatasky/downLoadDocument/${contractTypeEntity.id}"> ${contractTypeEntity.contractDocument} </a></td> --%>
										</tr>
									</c:forEach>
								</c:if>



							</table>
						</div>
					</fieldset>
				</div>


				<br>

			</div>
		</div>

	</form:form>

</body>




</html>
