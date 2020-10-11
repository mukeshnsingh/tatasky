<%@page import="com.sspl.entity.BankAccountEntity"%>
<%@page import="com.sspl.entity.Role"%>
<%@page import="com.sspl.entity.ProfileSignatoriesEntity"%>
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
<title>Configure Profile</title>
</head>

<body>
	<form:form name="ProfileWorkflow" commandName="profileSignatoriesEntity">
		<div class="middlecontent">
			<div class="leftbox">
				<div class="homeleftboxbg">
					<div class="box1_con_blue">
						<br /> <input class="press" type="button"
							value="<spring:message code="label.new"/>"
							onclick="submitForm('ProfileWorkflow', '/tatasky/viewProfileWorkflow');" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('ProfileWorkflow', '/tatasky/editProfileWorkflowActive/${profileSignatoriesEntity.id}');"
							value="<spring:message code="label.update"/>" /> <input
							class="press" type="button" id="update"
							onclick="submitForm('ProfileWorkflow', '/tatasky/addProfileWorkflow/${profileSignatoriesEntity.id}');"
							value="<spring:message code="label.save"/>" />


					</div>
				</div>
			</div>


			<div class="middlebox">

				<font style="font-size: 20px">Configure Profile</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>


				<br>
				<div>
					<fieldset class="fieldset">
						<legend>ProfileWorkflow List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">
								<tr>
									<th>Profile</th>
									<th>Document</th>
									<th>Signatory 1</th>
									<th>Signatory 2</th>
									<th>Signatory 3</th>
									<th>Signatory 4</th>
									<th>Signatory 5</th>
								</tr>



								<c:if test="${!empty profileSignatoriesList}">
									<c:forEach items="${profileSignatoriesList}" var="profileSignatoriesEntity">
										<tr>

											<td><a href="/tatasky/editUser/${profileSignatoriesEntity.id}">
													${profileSignatoriesEntity.profileEntity.profileName} </a></td>
											<td>${profileSignatoriesEntity.documentsEntity.documentName}</td>
											<td>${profileSignatoriesEntity.signatoryEntity1.signatoriesName}</td>
											<td>${profileSignatoriesEntity.signatoryEntity2.signatoriesName}</td>
											<td>${profileSignatoriesEntity.signatoryEntity3.signatoriesName}</td>
											<td>${profileSignatoriesEntity.signatoryEntity4.signatoriesName}</td>
											<td>${profileSignatoriesEntity.signatoryEntity5.signatoriesName}</td>
										</tr>

									</c:forEach>
								</c:if>



							</table>

						</div>

					</fieldset>
				</div>
				<br>

				<fieldset class="fieldset">
					<legend>Configure Profile Master</legend>
					<div class="inputdiv">
						<table class="bank">

							<tr>
								<td><form:label path="">
										<spring:message code="label.profile" />
									</form:label></td>
								<td><select name="profile" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty profileList}">
											<c:forEach items="${profileList}" var="profile">
												<option value="${profile.id}">${profile.profileName}</option>
											</c:forEach>
										</c:if>
								</select></td>
								<td><form:label path="">
										<spring:message code="label.document" />
									</form:label></td>
								<td><select name="document" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty documentsList}">
											<c:forEach items="${documentsList}" var="document">
												<option value="${document.id}">${document.documentName}</option>
											</c:forEach>
										</c:if>
								</select></td>
								<td><form:label path="">
										<spring:message code="label.signatory1" />
									</form:label></td>
							
								<td><select name="signatory1" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty signatoriesList}">
											<c:forEach items="${signatoriesList}" var="signatory1">
												<option value="${signatory1.id}">${signatory1.signatoriesName}</option>
											</c:forEach>
										</c:if>
								</select></td>
							</tr>
							<tr>
							<td><form:label path="">
										<spring:message code="label.signatory2" />
									</form:label></td>
							
								<td><select name="signatory2" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty signatoriesList}">
											<c:forEach items="${signatoriesList}" var="signatory2">
												<option value="${signatory2.id}">${signatory2.signatoriesName}</option>
											</c:forEach>
										</c:if>
								</select></td>
							<td><form:label path="">
										<spring:message code="label.signatory3" />
									</form:label></td>
							
								<td><select name="signatory3" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty signatoriesList}">
											<c:forEach items="${signatoriesList}" var="signatory3">
												<option value="${signatory3.id}">${signatory3.signatoriesName}</option>
											</c:forEach>
										</c:if>
								</select></td>
							<td><form:label path="">
										<spring:message code="label.signatory4" />
									</form:label></td>
							
								<td><select name="signatory4" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty signatoriesList}">
											<c:forEach items="${signatoriesList}" var="signatory4">
												<option value="${signatory4.id}">${signatory4.signatoriesName}</option>
											</c:forEach>
										</c:if>
								</select></td>
							
							</tr>
							<td><form:label path="">
										<spring:message code="label.signatory5" />
									</form:label></td>
							
								<td><select name="signatory5" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty signatoriesList}">
											<c:forEach items="${signatoriesList}" var="signatory5">
												<option value="${signatory5.id}">${signatory5.signatoriesName}</option>
											</c:forEach>
										</c:if>
								</select></td>
							
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
