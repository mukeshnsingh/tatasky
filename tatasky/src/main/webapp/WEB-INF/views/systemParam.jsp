<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="menu.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Parameters</title>
    .test
    {
    visibility: hidden;
    }
    </style> 
        
    </head>
    <body>
      
            <div class="middlecontent" > 
                <div class="middlebox" style="margin-left: 100px" >
                <br>
                <font style="font-size: 20px" > System Parameters
                    </font>
                    <div id="systemparameter" style="width: 640px; margin-top: 0px; background-color: #B0C4DE;  height: 20px; padding-top: 2px; color: #000000; " >
                        <span style="color: red"></span>
                </div>
            
                <div>
                    <form:form  name="syst_Param" action="add_ModifySysParam" method="POST" commandName="systemParameter">

                        <br>
                        <fieldset style="width: 640px;">
                            <legend> <b>System Parameters</b></legend>
                            
                            <table class="Password">
                                <col width="300">
                                <col width="80">
       


                                <tr>
                                    <td><form:label path="account_L_attempts"><spring:message code="label.accountlocked"/></form:label><font color="red">*</font></td>
                                    <td><form:input path="account_L_attempts"  value=""/>
                                    <%-- <form:hidden path="id"/> --%></td>




                                <tr>
                                    <td><form:label path="display_rows"><spring:message code="label.number_of_rows"/></form:label><font color="red">*</font></td>
                                    <td><form:input path="display_rows" value=""/></td> 
                                </tr>

                                <tr><td><form:label path="max_duration"><spring:message code="label.maxmimum_duration"/></form:label><font color="red">*</font></td>
                                    <td><form:input path="max_duration" value="" /></td>
<form:input path="id" cssClass="test"/>
                                </tr>

                            </table>




                           </fieldset>


                            <br>
                            <div style="width: 640px; margin-left: 3px; background-color: #C8C8C8">
                                
                                <input type="submit" style="margin-left: 14px; width: 80px" value="<spring:message code="label.save" />"/>

                               

                            </div> 

                         </form:form>
                </div>
                <br>

            </div>

        </div>
       <%--  <jsp:include page="footer.jsp"></jsp:include> --%>
    </body>
</html>

