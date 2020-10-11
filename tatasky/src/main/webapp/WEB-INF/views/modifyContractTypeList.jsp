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

<title>Contract Management</title>
</head>
<body>
	<form:form name="ContractType" commandName="contractTypeEntity">
		<div class="middlecontent">

			<div class="middlebox">

				<font style="font-size: 20px">Enter Contract Details</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>


				<br>
				<div>
					<fieldset class="fieldset">
						<legend>Contract List</legend>
						<div class="field_sel_rec">
							<table class="sel_rec">

								<tr>
									<th>Contract Name</th>
									<th>Uploaded Document</th>
									<th>Document Type</th>
									<th>Profile</th>
								</tr>

								<c:if test="${!empty contractTypeList}">
									<c:forEach items="${contractTypeList}" var="contractTypeEntity">
										<tr>
											<td><a
												href="/tatasky/editContractType/${contractTypeEntity.id}">
													${contractTypeEntity.contractTypeName} </a></td>
											<td>${contractTypeEntity.contractDocument}</td>
											<td>${contractTypeEntity.documentsEntity.documentName}</td>
											<td>${contractTypeEntity.profileSignatoriesEntity.profileSigName}</td>
										</tr>
									</c:forEach>
								</c:if>



							</table>
						</div>
					</fieldset>
				</div>
				<br>
				<fieldset class="fieldset">
					<legend>Contract Master</legend>
					<div class="inputdiv">
						<table>
							
							<tr>
                                 <td><form:label path="contractTypeName"><spring:message code="label.contractTypeName"/></form:label></td> 
                                 <td ><form:input path="contractTypeName" style="width: 116px" cssClass="${readonlyTxt}" readonly="${readonly}" /></td>
                                
                                <%--  <td><form:label path="contractDocument"><spring:message code="label.contractDocument"/></form:label></td>
                                 <td><form:input path="contractDocument" style="width: 116px"  cssClass="${readonlyTxt}" readonly="${readonly}" /></td>
                                 --%>
                                <td><form:label path=""><spring:message code="label.document"/></form:label></td>
                                 <td>    <select name="document" style="width:122px;" cssClass="${readonlyTxt}" ${disabled} >
                                         <option value="">---Select---</option>
                                        <c:if test="${!empty documentList}">
                                        <c:forEach items="${documentList}" var="document">
                                        <option value="${document.id}">${document.documentName}</option>
                                        </c:forEach>
                                        </c:if>
                                     </select>
                                     
                                     <script type="text/javascript">
		        						document.ContractType.document.value=${contractTypeEntity.documentsEntity.id}
		        					</script>
                                 </td>
                                
                                <td><form:label path=""><spring:message code="label.profile"/></form:label></td>
                                 <td>    <select name="profile" style="width:122px;" cssClass="${readonlyTxt}" ${disabled}>
                                         <option value="">---Select---</option>
                                        <c:if test="${!empty profileSignatoriesEntityList}">
                                        <c:forEach items="${profileSignatoriesEntityList}" var="profile">
                                        <option value="${profile.id}">${profile.profileSigName}</option>
                                        </c:forEach>
                                        </c:if>
                                     </select>
                                     <script type="text/javascript">
		        						document.ContractType.profile.value=${contractTypeEntity.profileSignatoriesEntity.id}
		        					</script>
                                 </td>
                             	</tr>
                                 <tr>
                                
                             	 <td><form:label path="enabled"><spring:message code="label.active"/></form:label></td>
                                <td><form:checkbox path="enabled" value="1"
										disabled="${readonly}" cssClass="${readonlyTxt}" /></td>

                                 <td>
                                 <input class="press" type="button" id="update"
									onclick="submitForm('ContractType', '/tatasky/editContractTypeActive/${contractTypeEntity.id}');"
									value="<spring:message code="label.update"/>" />
								</td><td>	
								<input class="press" type="button" id="update"
									onclick="submitForm('ContractType', '/tatasky/modifyContractType/${contractTypeEntity.id}');"
									value="<spring:message code="label.save"/>" />
                                 </td>
                             </tr>

						</table>
					</div>
				</fieldset>

			</div>
		</div>

	</form:form>

</body>




</html>
