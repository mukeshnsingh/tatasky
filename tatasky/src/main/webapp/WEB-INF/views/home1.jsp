<%@page import="com.sspl.utility.Utility"%>
<%@page import="com.sspl.entity.UsersLog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tatasky Workflow System</title>
          
    </head>
    <body>
         <div class="middlecontent" > 
      
          <%
          List<UsersLog> usersLogList=new ArrayList<UsersLog>();
  		if(request.getAttribute("usersLogList")!=null){
  			usersLogList=(List)request.getAttribute("usersLogList");
  		} else if (session.getAttribute("usersLogList") != null) {
  			usersLogList=(List)request.getAttribute("usersLogList");
  		}
  		String loginDate="";
  		if(usersLogList.size()>0){
  			UsersLog usersLog=new UsersLog();
  			usersLog=(UsersLog)usersLogList.get(0);
  			loginDate=""+Utility.convertDateToStringWithoutTime(usersLog.getLoginDate())+" :: "+usersLog.getLoginTime();
  		}
          %>      
                <div class="box1_con_blue" > 
                  <br>
                   <b><font color="red"> ${message}</font></b>
                  <br>
                    <b>Last Successful Login :<%=loginDate %></b>
                    
                   <fieldset class="fieldset"><legend><b>List of Failed Login after last successful login</b></legend>
                       
                    <table class="">
                        
                		<%

                		if(usersLogList.size()>0){
                			int cnt=0;
                		String loginDatechild="";
                  		for(UsersLog usersLog:usersLogList){
                  			loginDatechild=""+Utility.convertDateToStringWithoutTime(usersLog.getLoginDate())+" :: "+usersLog.getLoginTime();
                  			++cnt;
                  			if(cnt>3){
                  				break;
                  			}
                		%> 
                		<tr><td><%=loginDatechild %></td></tr>              
         		         <%}}%>           
                        
                        
                        
                    </table>
                    </fieldset>
                         </div>
                     
               
                 
 
              </div>
           
      
             
                    
    </body>
    
</html>
