<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
         
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Policy</title>
               <link href="css/style.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        
    

       <%--  <jsp:include page="Header.jsp"></jsp:include> --%>
          <div class="middlecontent" > 
                <div class="middlebox" style="margin-left: 100px"><font style="font-size: 20px">Password Policy
                    </font>
                    <div id="PasswordPolicy" style="width: 750px; background-color: #B0C4DE;  height: 20px; padding-top: 2px; color: #000000;text-align: justify" >
                       <span style="color: green"></span>
                                      </div>
                   <br>
                  
                    <div>
                        <form:form  name="password_policy" commandName="passwordPolicyEntity">
                            <fieldset style="width: 735px;"> 
                                <legend><b>Password Policy Rules</b></legend>
                      
                            <table class="Password">
                                <col width="300">
                                <col width="80">

                                <tr>

                                    <td><form:label path="password_min_age"><spring:message  code="label.minimum_age"/></form:label><font color="red">*</font></td>  

                                    <td><form:input path="password_min_age" value=""/></td>

                                </tr>

                                <tr>
                                    <td><form:label path="password_max_age"><spring:message  code="label.maximum_age"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_max_age" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="password_stored_history"><spring:message  code="label.storage_history"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_stored_history" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="password_check_quality"><spring:message  code="label.check_quality"/></form:label><font color="red">*</font></td>

                                    <td>
                                        <form:radiobutton path="password_check_quality"/><spring:message  code="label.true"/>
                                         <form:radiobutton path="password_check_quality"/><spring:message  code="label.false"/>
                                    </td>



                                </tr>

                                <tr>
                                    <td><form:label path="password_expired_warning"><spring:message  code="label.expired_warning"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_expired_warning" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="password_grace_authentication_limit"><spring:message  code="label.grace_authentication"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_grace_authentication_limit" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="password_lock_out"><spring:message  code="label.lockout"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_lock_out" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="password_lock_out_duration"><spring:message  code="label.lockoutduration"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_lock_out_duration" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="password_max_failure"><spring:message  code="label.max_failure"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_max_failure" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="password_failure_count_interval"><spring:message  code="label.failure_count_interval"/></form:label><font color="red">*</font></td>

                                    <td><form:input path="password_failure_count_interval" value=""/></td>


                                <tr>
                                    <td><form:label path="password_must_change"><spring:message  code="label.must_change"/></form:label><font color="red">*</font></td>
                                    <td>
                                        <form:radiobutton path="password_must_change"/><spring:message  code="label.true"/>
                                        <form:radiobutton path="password_must_change"/><spring:message  code="label.false"/>

                                    </td>
                                </tr>

                                <tr>
                                    <td><form:label path="password_allow_user_change"><spring:message  code="label.allow_user_change"/></form:label><font color="red">*</font></td>
                                    <td>
                                         <form:radiobutton path="password_allow_user_change"/><spring:message  code="label.true"/>
                                        <form:radiobutton path="password_allow_user_change"/><spring:message  code="label.false"/>    

                                    </td>
                                </tr>

                                <tr>
                                    <td><form:label path="password_allow_user_change"><spring:message  code="label.account_expiration_interval"/></form:label>(in months)<font color="red">*</font></td>

                                    <td><form:input path="password_allow_user_change" value=""/></td>


                                </tr>

                                <tr>
                                    <td><form:label path="account_expiration_external"><spring:message  code="label.account_expiration_external"/></form:label><font color="red">*</font></td>
                                    <td><form:input path="account_expiration_external" value=""/></td>


                                </tr>
                            </table>









                        </fieldset>

                        <br>
                        <div style="width: 740px; margin-left: 2px; background-color: #C8C8C8">
                            
                            
				
                                <input type="submit" value="<spring:message code="label.save"/>" style="margin-left: 10px"  />
                                
                                
                        </div><br>

                    </form:form>




                </div>

            </div>
        </div>
                      
        <%-- <jsp:include page="footer.jsp"></jsp:include> --%> 


    </body>
</html>

