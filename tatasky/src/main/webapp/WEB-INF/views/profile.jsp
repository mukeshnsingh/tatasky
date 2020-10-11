<%@page import="com.sspl.entity.Role"%>
<%@page import="com.sspl.entity.ProfileEntity"%>
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
        <title>Profile</title>
    </head>
  
      <body>
           <form:form name="Profile" commandName="profileEntity">
            <div class="middlecontent" > 
                 <div  class="leftbox">
                    <div class="homeleftboxbg" >
                     <div class="box1_con_blue"> <br/>
                 
                        <input class="press" type="button" value="<spring:message code="label.new"/>" onclick="submitForm('Profile', '/tatasky/viewProfile');"/>
                        <input class="press" type="button"  id="update"onclick="submitForm('Profile', '/tatasky/editProfileActive/${profileEntity.id}');"  value="<spring:message code="label.update"/>"/>
                        <input class="press" type="button"  id="update"onclick="submitForm('Profile', '/tatasky/addProfile/${profileEntity.id}');"  value="<spring:message code="label.save"/>"/>
                       
 
                        </div>
                    </div>
                </div>
            
            
             <div class="middlebox" >
                 
                  <font style="font-size: 20px">Enter Profile Details</font>
                 <div class="messagebar">
                     <span id="messagebar" style="color:red"></span>
                       </div>
                 
                
                 <br>
                <div>
                     <fieldset class="fieldset">
                     <legend>Profile List</legend>
                     <div class="field_sel_rec">
                     <table  class="sel_rec" >
                                           
                     <tr>
                      <th>Profile Name</th>
                     <th>Profile Description</th>
<!--                      <th>Input Folder</th>
                     <th>Output Folder</th>
 -->                    </tr> 
               <c:if  test="${!empty profileList}">	
				<c:forEach items="${profileList}" var="profileEntity">
						<tr>
						<td><a href="/tatasky/editProfile/${profileEntity.id}"> ${profileEntity.profileName} </a></td>
						<td>${profileEntity.profileDescription}</td>
	<%-- 					<td>${profileEntity.inputFolder}</td>
						<td>${profileEntity.outputFolder}</td>
	 --%>					</tr>
                        </c:forEach>
</c:if>		
                         </table>
  </div>
                     </fieldset>
                     </div>
                     <br>
                     <fieldset class="fieldset" >
                         <legend>Profile Master</legend>
                         <div class="inputdiv">
                         <table class="bank"> 
                             <tr>
                                 <td><form:label path="profileName"><spring:message code="label.profileName"/></form:label></td> 
                                 <td ><form:input path="profileName" style="width: 116px" validate="Profile Name,string,yes"   /></td>
                                
                                 <td><form:label path="profileDescription"><spring:message code="label.profileDescription"/></form:label></td>
                                 <td><form:input path="profileDescription" style="width: 116px"  validate="Profile Description,string,yes" /></td>
                                
         <%--                         <td><form:label path="inputFolder"><spring:message code="label.inputFolder"/></form:label></td>
                                 <td><form:input path="inputFolder" style="width: 116px"  validate="Input Folder,string,no"  /></td>
                               </tr>
	                             <tr>
                                 <td><form:label path="outputFolder"><spring:message code="label.outputFolder"/></form:label></td>
                                 <td><form:input path="outputFolder" style="width: 116px"  validate="Display Name,string,no"  /></td>
          --%>                    	 
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
