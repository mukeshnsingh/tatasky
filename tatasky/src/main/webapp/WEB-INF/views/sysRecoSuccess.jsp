<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:include page="menu.jsp"></jsp:include>
 <script src="<c:url value="/resources/js/date.js" />"></script>

<html>
    <head>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>***Bank Reco***</title>
       </head>
    <body>
              <form:form name="bank" commandName="bank"> 
                <div class="middlecontent" > 

                    <div style="margin-top: 35px;" class="leftbox">
                        
                    </div>
                    <div class="middlebox" style="margin-left: -120px">
						<h4>System Reconciliation Start</h4>
						<h5>Queue Data is ${queueSize}</h5>
                </div>
            </div>

        </form:form>

    </body>
</html>
