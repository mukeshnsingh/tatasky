<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sspl.entity.BankEntity"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sspl.entity.BankAccountEntity"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
<html>
<head>
 <script src="<c:url value="/resources/js/date.js" />"></script>
<style>
.readonlyTxt {
	color: #000000;
	background-color: #E0E0E0;
}
</style>
<%
List bankMasterList=new ArrayList();
	List bankAccList=new ArrayList();
	if(request.getAttribute("bankMasterList")!=null){
		bankMasterList=(List)request.getAttribute("bankMasterList");
	}
	if(request.getAttribute("bankAccList")!=null){
		bankAccList=(List)request.getAttribute("bankAccList");
	}
 %>
 <script type="text/javascript">
 
		var mainAccArr = new Array();
		var mainGlArr = new Array();
		var mainGlMainArr = new Array();
		<%
		
		   int count = 0;
		int countAc = 0;
		   for (Iterator iterator = bankMasterList.iterator(); iterator.hasNext();) {
			BankEntity mainBankEntity = (BankEntity) iterator.next();

		   for (Iterator subIterator = bankAccList.iterator(); subIterator.hasNext();) {
			BankAccountEntity bankAccountEntity = (BankAccountEntity) subIterator.next();
 if(mainBankEntity.getId().equals(bankAccountEntity.getBankEntity().getId()) && bankAccountEntity.getGlAccountNumber()!=null && !bankAccountEntity.getGlAccountNumber().equalsIgnoreCase("") ){
		        %>
		         mainGlArr[<%=count%>] = new Array();
		         mainGlArr[<%=count%>][0] = <%=mainBankEntity.getId()%>;
		         mainGlArr[<%=count%>][1] = "<%=bankAccountEntity.getGlAccountNumber()%>";         
		         mainGlArr[<%=count%>][2] = "<%=bankAccountEntity.getGlAccountNumber()%>";
		        <%
		        count++;
		      }
if(mainBankEntity.getId().equals(bankAccountEntity.getBankEntity().getId()) && bankAccountEntity.getBankMainAccount()!=null && !bankAccountEntity.getBankMainAccount().equalsIgnoreCase("") ){
		        %>
		         mainAccArr[<%=countAc%>] = new Array();
		         mainAccArr[<%=countAc%>][0] = <%=mainBankEntity.getId()%>;
		         mainAccArr[<%=countAc%>][1] = "<%=bankAccountEntity.getBankMainAccount()%>";         
		         mainAccArr[<%=countAc%>][2] = "<%=bankAccountEntity.getBankMainAccount()%>";
		        <%
		        countAc++;
		      }
		    }
		   }
		int countGlAc = 0;
		   for (Iterator iterator = bankAccList.iterator(); iterator.hasNext();) {
			BankAccountEntity glAccountEntity = (BankAccountEntity) iterator.next();

		   for (Iterator subIterator = bankAccList.iterator(); subIterator.hasNext();) {
			BankAccountEntity bankAccountEntity = (BankAccountEntity) subIterator.next();
 if(!bankAccountEntity.getBankMainAccount().equalsIgnoreCase("") && glAccountEntity.getGlAccountNumber().equalsIgnoreCase(bankAccountEntity.getGlAccountNumber())){
		        %>
		         mainGlMainArr[<%=countGlAc%>] = new Array();
		         mainGlMainArr[<%=countGlAc%>][0] = <%=glAccountEntity.getGlAccountNumber()%>;
		         mainGlMainArr[<%=countGlAc%>][1] = "<%=bankAccountEntity.getBankMainAccount()%>";         
		         mainGlMainArr[<%=countGlAc%>][2] = "<%=bankAccountEntity.getBankMainAccount()%>";
		        <%
		        countGlAc++;
		      }
		     }
		    }



		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	  

</script >

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View System Reconciliation Data</title>
<!-- <link href="Green.css" rel="stylesheet" type="text/css" /> -->
</head>
<body>
	<div class="middlecontent">

		<div style="margin-top: 35px;" class="leftbox">
			<form:form name="systemReconciliationForm" commandName="systemReconciliationForm">
				<fieldset style="width: 720px; margin-left: 110px">
					<legend>
						<b>System Reconciliation Data</b>
					</legend>
					<center>
						<table>
							<tr>
								<td style="width: 90px;">&nbsp;&nbsp;Bank Name<font
									color="red">*</font></td>
								<td>
								<form:select
										path="bankShortName" style="width: 120px;" onchange="populateGLAndMainAc(this.value,'systemReconciliationForm');" validate="Bank Short Name,string,yes" >
										<form:option value="">Select</form:option>
										<c:forEach items="${bankMasterList}" var="bankAcc">
											<c:choose>
												<c:when test="${fn:length(bankMasterList)>0}">
													<form:option value="${bankAcc.id}">${bankAcc.bankShortName}</form:option>
												</c:when>
												<c:otherwise>
													<form:option value="Select"></form:option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select>
									</td>
								
								<td>GL-Account<font color="red">*</font></td>
								<td><form:select path="glAccountNumber" style="width: 120px;"
										validate="Gl Account,string,yes" onchange="populateMainAcOnGl(this.value,'systemReconciliationForm');">
										<form:option value="">Select</form:option>
									</form:select></td>


								<td style="width: 20px" />
								<td>Bank Main Account No<font color="red">*</font></td>
								<td>
								<form:select path="bankMainAccount" style="width: 120px;"
										validate="Bank Main Account No,string,yes">
										<form:option value="">Select</form:option>
									</form:select></td>
							</tr>

							<tr>

								<td>From Date<font color="red">*</font></td>
								<td>
										<form:input path="fromDate" readonly="readonly" validate="From Date,string,yes" id="fromDate" value="" style="width: 120px" onclick="javascript:setdate('',document.systemReconciliationForm.fromDate,event)" />
										</td>


								<td>&nbsp;&nbsp;To Date<font color="red">*</font></td>
								<td>
										<form:input path="toDate" readonly="readonly" validate="To Date,string,yes" id="toDate" value="" style="width: 120px" onclick="javascript:setdate('',document.systemReconciliationForm.toDate,event)" />
										</td>
								<td style="width: 20px" />

								<td>
									<input class="press" type="button"  id="save" value="Veiw Reco Data" style="width: 100px; margin-left: -10px" onclick="submitForm('systemReconciliationForm', '/bankreco/viewReconciliation');"/>
									</td>
							</tr>

						</table>
						
				</fieldset>
				<fieldset style="width: 720px; margin-left: 110px">
					<legend>
						<b>System Reconciliation Data</b>
					</legend>
					<center>
				
				 <table>
                                     <thead><tr>
                                    <th style="width: 170px;">JournalId</th>
                                    <th style="width: 170px;">Account</th>
                                    <th style="width: 170px;">Instrument Type</th>
                                    <th style="width: 170px;">Instrument Number</th>
                                    <th style="width: 170px;">Credit</th>
                                    <th style="width: 170px;">Debit</th>
                                </tr></thead>
                                
                                 
<tbody>

                                   <c:if  test="${!empty list}">
                                   <c:forEach items="${list}" var="obj">
                                    <tr>
<td>${obj[7]}</td> 
<td>${obj[6]}</td> 
<td>${obj[3]}</td> 
<td>${obj[4]}</td> 
<td>${obj[2]}</td>
<td>${obj[1]}</td>
                                    </tr>
                                   </c:forEach>
                                   </c:if>
                                   </tbody>
                                </table>
				</center>
				</fieldset>
				
			</form:form>

		</div>
	</div>

<script type="text/javascript">

function populateGLAndMainAc(val,formName){
	 obj = eval('document.'+formName+'.glAccountNumber');
	 obj1 = eval('document.'+formName+'.bankMainAccount');
		obj.length = 1;
		obj1.length = 1;
	 for(i=0;i<mainGlArr.length;i++){
	  if(mainGlArr[i][0]==val){
	   obj.length++;
	   obj.options[obj.length-1].value=mainGlArr[i][1];
	   obj.options[obj.length-1].text=mainGlArr[i][2];   
	  }
	 }
	 for(j=0;j<mainAccArr.length;j++){
	  if(mainAccArr[j][0]==val){
	   obj1.length++;
	   obj1.options[obj1.length-1].value=mainAccArr[j][1];
	   obj1.options[obj1.length-1].text=mainAccArr[j][2];   
	  }
	 }
	}
function populateMainAcOnGl(val,formName){
	 obj = eval('document.'+formName+'.bankMainAccount');
	obj.length = 1;
		//alert("len "+mainGlMainArr.length+" val "+val);
	 for(i=0;i<mainGlMainArr.length;i++){
	  if(mainGlMainArr[i][0]==val){
	   obj.length++;
	   obj.options[obj.length-1].value=mainGlMainArr[i][1];
	   obj.options[obj.length-1].text=mainGlMainArr[i][2];   
	  }
	 }
	}

</script>

</body>
</html>
