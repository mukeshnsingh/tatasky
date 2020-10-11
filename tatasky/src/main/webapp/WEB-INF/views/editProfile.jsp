<%@page import="com.sspl.entity.*"%>
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
    
<style>
.readonlyTxt{
	color: #000000;
	background-color: #E0E0E0;
}
</style>
	   
 <title>Profile</title>
     </head>     
   	
<%

List<Role> roles=new ArrayList<Role>();
if(request.getAttribute("roles")!=null)
{
	roles=(List<Role>)request.getAttribute("roles");
	System.out.println("roles size="+roles.size());
}

 List<UsersRole> roleList=new ArrayList<UsersRole>();
String roleName="";
int roleid=0;
int user_role_id=0;
if(request.getAttribute("roleList")!=null)
{
	roleList=(List<UsersRole>)request.getAttribute("roleList");
	System.out.println(roleList.size());
	if(roleList!=null){
	UsersRole roleuser=new UsersRole();
	roleuser=roleList.get(0);
	Role role=(Role)roleuser.getRole();
	System.out.println(role.getRole()+"userroleid====="+roleuser.getId());
	roleName=role.getRole();
	roleid=role.getId();
	user_role_id=roleuser.getId();
		
	}
	
}		
 %>
 
    <body>
	  <form:form name="Profile" commandName="profileEntity">
        <div class="middlecontent"> 
               <div class="leftbox">
                    <div class="homeleftboxbg" >
                           <div class="box1_con_blue"> <br/>
                       <input class="press" type="button" value="<spring:message code="label.new"/>" onclick="submitForm('Profile', '/tatasky/viewProfile');"/>
                        <input class="press" type="button"  id="update"onclick="submitForm('Profile', '/tatasky/editProfileActive/${profileEntity.id}');"  value="<spring:message code="label.update"/>"/>
                        <input class="press" type="button"  id="update"onclick="submitForm('Profile', '/tatasky/modifyProfile/${profileEntity.id}');"  value="<spring:message code="label.save"/>"/>
                    </div>
                    </div>
                </div>
              <div class="middlebox"> 
                 
                  <font style="font-size: 20px"> Enter Profile Details</font>
              <div class="messagebar">
              <span id="messagebar" style="color:red"></span>
               </div>
                 
                
                 <br>
                 <div>
                     <fieldset class="fieldset">
                     <legend>Profile List</legend>
                     <div class="field_sel_rec">
                     <table  class="sel_rec">
                       
                    <tr>
                      <th>Profile Name</th>
                     <th>Profile Description</th>
     <!--                 <th>Input Folder</th>
                     <th>Output Folder</th>
      -->               </tr>   
               
               <c:if  test="${!empty profileList}">	
				<c:forEach items="${profileList}" var="profileEntity">
						<tr>
						<td><a href="/tatasky/editProfile/${profileEntity.id}"> ${profileEntity.profileName} </a></td>
						<td>${profileEntity.profileName}</td>
						<td>${profileEntity.profileDescription}</td>
<%-- 						<td>${profileEntity.inputFolder}</td>
						<td>${profileEntity.outputFolder}</td>
 --%>						</tr>
                        </c:forEach>
</c:if>		
                         </table>
                      </div> 
                     </fieldset>               
                    </div>
                     <br>
                     <fieldset class="fieldset">
                         <legend>User Master</legend>
                         <div class="inputdiv">
                         <table > 
                             <tr>
                                 <td><form:label path="profileName"><spring:message code="label.profileName"/></form:label></td> 
                            <td ><form:input path="profileName" style="width: 116px" cssClass="${readonlyTxt}" readonly="${readonly}" /></td>
                                
                                 <td><form:label path="profileDescription"><spring:message code="label.profileDescription"/></form:label></td>
                                 <td><form:input path="profileDescription" style="width: 116px"  cssClass="${readonlyTxt}" readonly="${readonly}" /></td>
         <%--                        
                                 <td><form:label path="inputFolder"><spring:message code="label.inputFolder"/></form:label></td>
                                 <td><form:input path="inputFolder" style="width: 116px"  cssClass="${readonlyTxt}" readonly="${readonly}"/></td>
                             </tr>
                             <tr></tr>
                             <tr>
                                 <td><form:label path="outputFolder"><spring:message code="label.outputFolder"/></form:label></td>
                                 <td><form:input path="outputFolder" style="width: 116px"  cssClass="${readonlyTxt}" readonly="${readonly}" /></td>
          --%>                    
                                 <td><form:label path="enabled"><spring:message code="label.active"/></form:label></td>
                                 <td><form:checkbox path="enabled" value="1" disabled="${readonly}"  cssClass="${readonlyTxt}"/></td>
                                 
                             </tr>
                             <tr></tr>
                         </table>
                         </div>
                     </fieldset>
                 </div>
          </div>
        </form:form>
    </body>
</html>