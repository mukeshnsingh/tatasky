<%@page import="com.sspl.entity.Role"%>
<%@page import="com.sspl.entity.ContractTypeEntity"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contract Review</title>
    </head>
  
      <body>
           <form:form name="ContractReview" commandName="contractReviewEntity">
            <div class="middlecontent" > 
                 <div  class="leftbox">
                    <div class="homeleftboxbg" >
                     <div class="box1_con_blue"> <br/>
                 
                        <input class="press" type="button" value="<spring:message code="label.new"/>" onclick="submitForm('ContractReview', '/tatasky/viewContractReview');"/>
                        <input class="press" type="button"  id="update"onclick="submitForm('ContractReview', '/tatasky/editContractReviewActive/${contractReviewEntity.id}');"  value="<spring:message code="label.update"/>"/>
                        <input class="press" type="button"  id="update"onclick="submitForm('ContractReview', '/tatasky/addContractReview/${contractReviewEntity.id}');"  value="<spring:message code="label.save"/>"/>
                       
 
                        </div>
                    </div>
                </div>
            
            
             <div class="middlebox" >
                 
                  <font style="font-size: 20px">Enter Contract Review Details</font>
                 <div class="messagebar">
                     <span id="messagebar" style="color:red"></span>
                       </div>
                 
                
                 <br>
                <div>
                     <fieldset class="fieldset">
                     <legend>Contract Review List</legend>
                     <div class="field_sel_rec">
                     <table  class="sel_rec" >
                                           
                     <tr>
                      <th>Contract Review</th>
                     <th>Profile Signatory</th>
                    </tr> 
               <c:if  test="${!empty contractReviewList}">	
				<c:forEach items="${contractReviewList}" var="contractReviewEntity">
						<tr>
						<td><a href="/tatasky/editContractReview/${contractReviewEntity.id}"> ${contractReviewEntity.contractReviewName} </a></td>
						<td>${contractReviewEntity.profileSignatoriesEntity.profileSigName}</td>
						</tr>
                        </c:forEach>
				</c:if>		
                         </table>
  </div>
                     </fieldset>
                     </div>
                     <br>
                     <fieldset class="fieldset" >
                         <legend>Contract Review Master</legend>
                         <div class="inputdiv">
                         <table class="bank"> 
                             <tr>
                                 <td><form:label path="contractReviewName"><spring:message code="label.contractReviewName"/></form:label></td> 
                                 <td ><form:input path="contractReviewName" style="width: 116px" validate="Contract Review,string,yes"   /></td>
 
                                 <td><form:label path=""><spring:message code="label.profile"/></form:label></td>
                                 <td>    <select name="profile" style="width:122px;">
                                         <option value="">---Select---</option>
                                        <c:if test="${!empty profileSignatoriesEntityList}">
                                        <c:forEach items="${profileSignatoriesEntityList}" var="profile">
                                        <option value="${profile.id}">${profile.profileSigName}</option>
                                        </c:forEach>
                                        </c:if>
                                     </select>
                                 </td>
                             	 
                             	 <td><form:label path="enabled"><spring:message code="label.active"/></form:label></td>
                                 <td><form:checkbox path="enabled" value="1"/></td>
                                 
                             </tr>
                         </table>               
	           </div>
                      
                     </fieldset>
                     
                 </div>
        </div></form:form>
 
    </body>
</html>
