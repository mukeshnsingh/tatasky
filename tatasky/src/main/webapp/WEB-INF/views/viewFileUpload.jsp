<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
<html>
    
    <head>
         <title>Consolidation</title>
          
    </head>
    <%--
    response.setContentType("application/vnd.ms-excel");
	response.addHeader("Content-Disposition", "attachment;filename=\"file upload.xls\"");
     --%>
    
    <body>
                      <form:form name="fileUploadEntity" commandName="fileUploadEntity"> 

         <div class="middlecontent" > 
      
                
                  
<div id="msg">
                    <font color="red">${map[message]}</font> 
                    </div>
                        <fieldset class="fieldsetConsl">
                            <legend><b>Uploded File Details</b></legend>
                               <table  class="tableConsl">
                                <tr>
                                    <th >File ID</th>
                                    <th >File Status</th>
                                    <th >GL Date Range<br />(From & To)</th>
                                    <th >BS Date Range<br />(From & To)</th>
                                    <th >Cycle Status</th>
                                    <th >Status</th>
                                    <th >Error Logs</th>
                                    </tr>
                         
                                   <c:if  test="${!empty fileUploadEntityList}">
                                   <c:forEach items="${fileUploadEntityList}" var="fileUpload">
                                    <tr>
										<td>
										${fileUpload.id}
										</td>
										  <c:choose>
												<c:when test="${usersObj.userRole=='ROLE_ADMIN'}">
<td>
										<c:choose>
												<c:when test="${fileUpload.uiSataus=='Y'}">
										Uploaded
												</c:when>
												<c:when test="${fileUpload.uiSataus=='R'}">
										Reject
												</c:when>
												<c:when test="${fileUpload.uiSataus=='C'}">
										Consolidated
												</c:when>
												<c:otherwise>
													None
												</c:otherwise>
											</c:choose>
										</td>
												</c:when>
												<c:otherwise>
<td>
										Uploaded
										</td>
												</c:otherwise>
											</c:choose>
										
										
										
										<td>
										
										&nbsp;&nbsp; <fmt:formatDate pattern="yyyy-MM-dd" value="${fileUpload.uiGlFromdate}" /> &nbsp;&nbsp;
										<br />&nbsp;&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${fileUpload.uiGlTodate}" />&nbsp;&nbsp;
										<c:choose>
												<c:when test="${fileUpload.uiSataus=='Y'}">
											        <br />Consolidation
										<a href="/bankreco/consolidateFiles/${fileUpload.id}">Click</a>
												</c:when>
												<c:otherwise>
													Consolidated
												</c:otherwise>
											</c:choose>
										
										</td>
										<td>
										
										&nbsp;&nbsp; <fmt:formatDate pattern="yyyy-MM-dd" value="${fileUpload.uiBsFromdate}" /> &nbsp;&nbsp;
										<br />&nbsp;&nbsp;<fmt:formatDate pattern="yyyy-MM-dd" value="${fileUpload.uiBsTodate}" />&nbsp;&nbsp;
										<c:choose>
												<c:when test="${fileUpload.uiSataus=='Y'}">
											        <br />Consolidation
										<a href="/bankreco/consolidateFiles/${fileUpload.id}">Click</a>
												</c:when>
												<c:otherwise>
													Consolidated
												</c:otherwise>
											</c:choose>
										
										</td>
										
										<td>
										<c:choose>
												<c:when test="${fileUpload.uiSataus=='Y'}">
										Consolidation
												</c:when>
												<c:when test="${fileUpload.uiSataus=='R'}">
										Reject
												</c:when>
												<c:when test="${fileUpload.uiSataus=='C'}">
										<a href="/bankreco/lockedFileCycle/${fileUpload.id}">Lock Cycle </a>
												</c:when>
												<c:when test="${fileUpload.uiSataus=='L'}">
											        Locked Cycle
												</c:when>
												<c:otherwise>
													Open
												</c:otherwise>
											</c:choose>
								        </td>
								        <td>
											        ${fileUpload.uiSataus}
								        </td>
								        <td>
								        <a href="/bankreco/viewLogs/AR@${fileUpload.id}"><font color="red"> AR Error</font></a> <br/>
										<a href="/bankreco/viewLogs/AP@${fileUpload.id}"><font color="red"> AP Error</font></a> <br/>
										<a href="/bankreco/viewLogs/GL@${fileUpload.id}"><font color="red"> GL Error</font></a> <br/>
								        
								        </td>
                                    </tr>
                                   </c:forEach>
                                   </c:if>
                              </table>                                                      
    	  </fieldset>
                         </div>
</form:form>
    </body>
</html>
