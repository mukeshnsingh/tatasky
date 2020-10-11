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
						<legend>Contract List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">

								<tr>
									<th>Contract Name</th>
									<th>Uploaded Document</th>
									<th>Document Type</th>
									<th>Profile</th>
									<th>Document Status</th>
									<th>View</th>
									<th>Signed Document</th>
								</tr>

								<c:if test="${!empty contractTypeList}">
									<c:forEach items="${contractTypeList}" var="contractTypeEntity">
										<tr>
											<td>${contractTypeEntity.contractTypeName}</td>
											<td>${contractTypeEntity.contractDocument}</td>
											<td>${contractTypeEntity.documentsEntity.documentName}</td>
											<td>${contractTypeEntity.profileSignatoriesEntity.profileSigName}</td>
											<td>
											<c:choose>

												<c:when test="${contractTypeEntity.contractStatus=='N'}">
            									Pending
         										</c:when>
												<c:otherwise>
									            Approved
         									</c:otherwise>
											</c:choose>
											</td>

											<td><a
												href="/tatasky/downLoadDocument/${contractTypeEntity.id}">
													${contractTypeEntity.contractDocument} </a></td>
										<td>
																				<c:choose>

												<c:when test="${contractTypeEntity.signedContractPath!='#'}">
            									<a href="/tatasky/downLoadSignDocument/${contractTypeEntity.id}">
													${contractTypeEntity.contractDocument} </a>
										
         										</c:when>
												<c:otherwise>
									            ${contractTypeEntity.contractDocument}
         									</c:otherwise>
											</c:choose>
											
													
													</td>
										
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
