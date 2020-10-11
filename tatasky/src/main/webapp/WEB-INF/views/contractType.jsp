<%@page import="com.sspl.entity.Role"%>
<%@page import="com.sspl.entity.ContractTypeEntity"%>
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
<title>Contract Management</title>
</head>

<body>
	<form:form name="ContractType" commandName="fileUploadDocForm"
		enctype="multipart/form-data">
		<div class="middlecontent">
						<%--  
			<div class="leftbox">
				<div class="homeleftboxbg">
					<div class="box1_con_blue">
						<br />

						               <input class="press" type="button" value="<spring:message code="label.new"/>" onclick="submitForm('ContractType', '/tatasky/viewContractType');"/>
                        <input class="press" type="button"  id="update"onclick="submitForm('ContractType', '/tatasky/editContractTypeActive/${fileUploadDocForm.id}');"  value="<spring:message code="label.update"/>"/>
                         <input class="press" type="button"  id="update"onclick="submitForm('ContractType', '/tatasky/addContractType/${fileUploadDocForm.id}');"  value="<spring:message code="label.save"/>"/>
						<input class="press" type="button" id="update"
							onclick="submitForm('ContractType', '/tatasky/addContractType');"
							value="<spring:message code="label.save"/>" />

					</div>
				</div>
			</div>
         --%>


			<div class="middlebox">

				<font style="font-size: 20px">Enter Contract Details</font>
				<div class="messagebar">
					<span id="messagebar" style="color: red"></span>
				</div>


				<br>
				<div>
					<%--              <fieldset class="fieldset">
                     <legend>Contract List</legend>
                     <div class="field_sel_rec">
                     <table  class="sel_rec" >
                                           
                     <tr>
                      <th>Contract Name</th>
                     <th>Uploaded Document</th>
                     <th>Document Type</th>
                     <th>Profile</th>
                    </tr> 
               <c:if  test="${!empty contractTypeList}">	
				<c:forEach items="${contractTypeList}" var="contractTypeEntity">
						<tr>
						<td><a href="/tatasky/editContractType/${contractTypeEntity.id}"> ${contractTypeEntity.contractTypeName} </a></td>
						<td>${contractTypeEntity.contractDocument}</td>
						<td>${contractTypeEntity.documentsEntity.documentName}</td>
						<td>${contractTypeEntity.profileSignatoriesEntity.profileSigName}</td>
						</tr>
                        </c:forEach>
</c:if>		
                         </table>
  </div>
                     </fieldset> --%>
				</div>
				<br>
				<fieldset class="fieldset">
					<legend>Contract Master</legend>
					<div class="inputdiv">
						<table class="bank">
							<tr>
								<td><form:label path="contractTypeName">
										<spring:message code="label.contractTypeName" />
									</form:label></td>
								<td><form:input path="contractTypeName"
										style="width: 116px" validate="Contract Type,string,yes" /></td>
								<td><form:label path="">
										<spring:message code="label.document" />
									</form:label></td>
								<td><select name="document" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty documentList}">
											<c:forEach items="${documentList}" var="document">
												<option value="${document.id}">${document.documentName}</option>
											</c:forEach>
										</c:if>
								</select></td>
								<td><form:label path="">
										<spring:message code="label.profile" />
									</form:label></td>
								<td><select name="profile" style="width: 122px;">
										<option value="">---Select---</option>
										<c:if test="${!empty profileSignatoriesEntityList}">
											<c:forEach items="${profileSignatoriesEntityList}"
												var="profile">
												<option value="${profile.id}">${profile.profileSigName}</option>
											</c:forEach>
										</c:if>
								</select></td>

							</tr>
							<tr>
								<td>Upload Document<font color="red">*</font></td>
								<td colspan="2" ><input type="file" value="" name="files[0]" /></td>


								<td><form:label path="enabled">
										<spring:message code="label.active" />
									</form:label></td>
								<td><form:checkbox path="enabled" value="1" /></td>

							</tr>
							<tr>
							<td>
							<input class="press" type="button" id="update"
							onclick="submitForm('ContractType', '/tatasky/addContractType');"
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
