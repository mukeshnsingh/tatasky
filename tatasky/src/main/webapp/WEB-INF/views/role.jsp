<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles</title>
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script>
            $(function() {
                $("#accordion").accordion();
            });
        </script>

    </head>
    <body>
       
            <div class="middlecontent" > 
<form:form name="role" commandName="roleEntity" >
                <div style="margin-top: 35px;" class="leftbox">
                    <div class="homeleftboxbg" style="width:100px; height: 350px; background-color: #DBDFE8">
                        <div class="box_woodpanel"></div>

                        <div class="box1_con_blue"> <br/>
 
                   <input class="press" type="reset"  value="<spring:message code="label.new"/>"/>
                   <br/><br/>
                   <input class="press" type="button"  value="<spring:message code="label.update"/>" /><br/><br/>
                   <input class="press" type="submit"  value="<spring:message code="label.save"/>" />
                     
                            <div class="box_woodpanel"></div>

                        </div>
                    </div>
                </div>
    
           <div class="middlebox" style="margin-left: -120px; font-size: 9pt;">
           <font style="font-size: 20px"> Roles and Responsibility
                    </font>
                    
    <div id ="messageDiv" style="width: 700px; background-color: #B0C4DE;  height: 20px; padding-top: 2px; font-size: 9pt;" >
        <div id="saveMessage">
        <span id="messagebar" style="color:red"></span>
   
        </div>
               
    </div>
           
         

</div>
                    
                    <br>
                    <div >
                        <fieldset style="width: 690px">
                            <legend><b>Role List</b></legend>
                            <div class="field_sel_rec">
                                
                                <table style="width: 670px;text-align: center" class="sel_rec">
                                    <thead>
                                     <th>Select Record</th>
                                    <th>Role</th>
                                 
                                    <th>Creation Date</th>
                                    </thead>
                                    
                                   
                                    <tr>
                                        <td></td>
                                        <td></td>
                                     
                                        <td></td>
                                        
                                    </tr>
                                   
                                
                                
                                         
                                </table>
                            
                            </div>
                        </fieldset>
                        <br>
                        <form:label path="role_name"><spring:message code="label.role"/></form:label><font color="red">*</font>
                        <form:input path="role_name" value="" />
                         <spring:message code="label.active"/> 
                            <form:checkbox path="active" value=""/>
                            <br>
                            <br>
                            <fieldset style="width: 690px;" >
                            <legend><b>Permissions</b></legend>
                  
                  
                    <div id="accordion" >
                                
                                <h3>Reconciliation</h3>
                                <div>
                              <table >
                                        <tr>
                                            <td style="width: 200px;"><form:label path="reco_sysreco_submit"><spring:message code="label.syst_reconcile"/></form:label></td>
                                            <td><form:checkbox path="reco_sysreco_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr> 
                                        
                                        <tr>
                                            <td style="width: 200px;"><form:label path="reco_reco_submit"><spring:message code="label.reconcile"/></form:label></td>
                                            <td><form:checkbox path="reco_reco_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr>
                                        
                                        <tr>
                                            <td style="width: 200px"><form:label path="reco_unreco_submit"><spring:message code="label.un_reconcile"/></form:label></td>
                                            <td><form:checkbox path="reco_unreco_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr>
                                        
                                        <tr>
                                            <td style="width: 200px"><form:label path="reco_approvereco_submit"><spring:message code="label.approve"/></form:label></td>
                                            <td> <form:checkbox path="reco_approvereco_submit" value=""/><spring:message code="label.approve"/></td>
                                        </tr>
                                    </table>
                                    

                                </div>
                                
                                
                                <h3>File Upload</h3>
                                <div>
                              <table><tr>
                                      <td style="width: 200px"><form:label path="fileupload_submit"><spring:message code="label.inputfile"/></form:label></td>
                                   <td><form:checkbox path="fileupload_submit" value=""/><spring:message code="label.submit"/></td>
                                    </tr> </table>
                                    
                                </div>

                                
                                
                                <h3>Bank</h3>
                                <div>
                                    
                                    <table>
                                        <tr>
                                            <td style="width: 200px"><form:label path="bankmaster_view"><spring:message code="label.bank"/></form:label></td>
                                            <td width="100px"><form:checkbox path="bankmaster_view" value=""/><spring:message code="label.view"/></td>
                                            <td width="100px"><form:checkbox path="bankmaster_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr> 
                                    </table>

                                </div>
                                
                                <h3>Bank Account</h3>
                                <div>


                                    <table>
                                        <tr>
                                            <td style="width: 200px"><form:label path="bankaccount_view"><spring:message code="label.bankaccount"/></form:label></td>
                                            <td width="100px"><form:checkbox path="bankaccount_view" value=""/><spring:message code="label.view"/></td>
                                            <td width="100px"><form:checkbox path="bankaccount_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr> 
                                    </table>

                                </div>
                                
                                <h3>Reports</h3>
                                <div>


                                    <table>
                                        <tr>
                                            <td style="width: 200px"><form:label path="reports_brs_view"><spring:message code="label.report"/></form:label></td>
                                            <td width="100px"><form:checkbox path="reports_brs_view" value=""/><spring:message code="label.view"/></td>
                                            
                                        </tr> 
                                        
                                        <tr>
                                            <td style="width: 200px"><form:label path="reports_gltran_view"><spring:message code="label.gl_transactions"/></form:label></td>
                                            <td width="100px"><form:checkbox path="reports_gltran_view" value=""/><spring:message code="label.view"/></td>
                                            
                                        </tr> 
                                        
                                        <tr>
                                            <td style="width: 200px"><form:label path="reports_banktran_view"><spring:message code="label.bank_transaction"/></form:label></td>
                                            <td width="100px"><form:checkbox path="reports_banktran_view" value=""/><spring:message code="label.view"/></td>
                                            
                                        </tr> 
                                    </table>

                                </div>
                                
                                <h3>Admin</h3>
                                <div>


                                   <table>
                                        <tr>
                                            <td style="width: 200px"><form:label path="admin_user_view"><spring:message code="label.user"/></form:label></td>
                                            <td width="100px"><form:checkbox path="admin_user_view" value=""/><spring:message code="label.view"/></td>
                                            <td width="100px"><form:checkbox path="admin_user_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr> 
                                        
                                        <tr>
                                            <td style="width: 200px"><form:label path="admin_roleper_view"><spring:message code="label.roles&permission"/></form:label></td>
                                            <td width="100px"><form:checkbox path="admin_roleper_view" value=""/><spring:message code="label.view"/></td>
                                            <td width="100px"><form:checkbox path="admin_roleper_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr> 
                                        
                                        <tr>
                                            <td style="width: 200px"><form:label path="admin_sysparam_view"><spring:message code="label.system_parameter"/></form:label></td>
                                            <td width="100px"><form:checkbox path="admin_sysparam_view" value=""/><spring:message code="label.view"/></td>
                                            <td width="100px"><form:checkbox path="admin_sysparam_submit" value=""/><spring:message code="label.submit"/></td>
                                        </tr> 
                                        
                                        <tr>
                                            <td style="width: 200px"><form:label path="admin_passpolicy_view"><spring:message code="label.password_policy"/></form:label></td>
                                            <td width="100px"><form:checkbox path="admin_passpolicy_view" value=""/><spring:message code="label.view"/></td>
                                            <td width="100px"><form:checkbox path="admin_passpolicy_view" value=""/><spring:message code="label.submit"/></td>
                                        </tr> 
                                    </table>

                                </div>
                            </div>


                        </fieldset>
                        <br>


                    </div>
    </form:form>
                </div>
            
                            
                        
        <%-- <jsp:include page="footer.jsp"></jsp:include> --%>    
    </body>
</html>
