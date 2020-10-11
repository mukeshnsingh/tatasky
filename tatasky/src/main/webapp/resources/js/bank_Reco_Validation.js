/*Common Methods*/

function viewBank(form,action){
var str=eval('document.'+form);
	str.action = action;
    str.submit();
}

function commonSubmit(form,subAction,method)
{

var check=eval('document.'+form);
if(method(check)==true)
	{
	check.action=subAction;
	check.submit();
	}
else{
	return false;
}
}


function checkmodify()
{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Select Element from list !!!";
	document.getElementById('change').innerHTML="";
	

	
}

function validateExtention(filename)
{
var checkflag=true;
var checkExtension=filename;
var checkfile=checkExtension.substring(checkExtension.lastIndexOf('.')+ 1).toLowerCase();
if(checkfile!="xls"&&checkfile!="xlsx")
	 {
	   checkflag=false;
	 }

return checkflag;
}

function validateBsExtension(filename)
{
	var checkflag=true;
	 var checkExtension=filename;
	 var checkfile=checkExtension.substring(checkExtension.lastIndexOf('.')+ 1).toLowerCase();
	 if(checkfile!="txt")
		 {
		   checkflag=false;
		 }
	 
	  return checkflag;
	
}

function findFileName(file)
{
var filename=file.substring(file.lastIndexOf('\\')+ 1,file.lastIndexOf('\\')+3);	
return filename;
}

function dateValidate(fromdate,todate)
{
var checkflag=true;
if(fromdate!=""&& todate!="")
	{
	var fromdatesplit=fromdate.split("/");
	var todatesplit=todate.split("/");

	var fromdatevalue=new Date(fromdatesplit[0]+"/"+fromdatesplit[1]+"/"+fromdatesplit[2]);
	var todatevalue=new Date(todatesplit[0]+"/"+todatesplit[1]+"/"+todatesplit[2]);
	
	if(fromdatevalue>todatevalue)
     {
           checkflag=false;

        }	
             }

  return checkflag;
}

function validateRadioButton()
{
for(var i=0;i<document.getElementsByName('accountType').length;i++)
	{
	if(document.getElementsByName('accountType')[i].checked==true)
		{
		return true;
		}
	}
return false;
}

function validateRadioType()
{
	var type="";
	var i="";	
var account=document.getElementById('bankSubAccount').value;
var j=document.getElementsByName('accountType').length;
for( i=0;i<j;i++)
{
if(document.getElementsByName('accountType')[i].checked==true & document.getElementsByName('accountType')[i].value=="SUB")
{
	type="SUB";
}
}
if(type=="SUB" &( account==null ||account==""))
		{
		return false;
		}
	return true;
}

function  validateString(strValue)
{
	
	  var objRegExp = /^[A-Za-z\s-]{1,}$/;
	if(objRegExp.test(strValue))
		{
	
		return true;
		}
	
	  return false; 
}

function validateNumber(strValue)
{

var objRegExp= /^[0-9]{1,}$/;
if(objRegExp.test(strValue))
	{
	
	return true;
		}
return false;
}

function validateEmail(strValue)
{
	
	var objRegExp= /^[a-zA-Z][\w\.]*[a-zA-Z0-9]@[a-zA-Z0-9][\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]$/;
	if(objRegExp.test(strValue))
	{
	
	return true;
		}
return false;
		
}

function validateAlphaNumeric(strValue)
{
var objRegExp=/^[\w\-]{1,}$/;
if(objRegExp.test(strValue))
	{
	return true;
	}
return false;
}

/*END*/



/*Bank_Master Validation*/

function bankMasterValidator(form)
{
var bankname=form.bankName.value;
var bankshortname=form.bankShortName.value;
var contactperson=form.bankContactPerson.value;
var contactnumber=form.bankContaCtnumber.value;
var email=form.bankContactEmail.value;

if(bankname=="")
{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Name cann't be null !!!";
	
	return false;
	
}
if(!validateString(bankname))
    {
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Name should be string !!!";
	
	return false;
	
    }
if(bankshortname=="")
	{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Short Name cann't be null !!!";
	
	return false;
	}
if(!validateString(bankshortname))
{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Short Name should be string !!!";
	
	return false;
}
if(!validateString(contactperson)&&contactperson!=="")
	{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Contact Person should be string !!!";
	
	return false;
	}
if(!validateNumber(contactnumber)&&contactnumber!=="")
{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Contact Number should be number !!!";
	
	return false;
}
if(!validateEmail(email)&& email!=="")
{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Invalid Email-Id !!!";
	
	return false;
	}
document.getElementById('error').style.visibility="hidden";
document.getElementById('spanmessage').innerHTML ="";

return true;
}
/*===========END============*/

/*Bank Account Master validation*/

function bankAccValidation(form)
{
	
	var bankshortname=form.bankShortName.value;
	var branch=form.branchName.value;
	var bankAccountnumber=form.bankMainAccount.value;
	var ifsccode=form.ifscCode.value;
	var accountType=form.accountType.value;
	var bankMainAccountNumber=form.bankSubAccount.value;
	var glAccountNumber=form.glAccountNumber.value;
	var glAccountName=form.glAccountName.value;
	var contactperson=form.bankContactPerson.value;
	var contactnumber=form.bankContactNumber.value;
	var email=form.bankContactEmail.value;
	
	if(bankshortname=="")
	{

	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Short Name cann't be null";
	return false;
	}
     
 if(!validateAlphaNumeric(branch)&&branch!="")
	 {
	
	 document.getElementById('error').style.visibility="visible";
	 document.getElementById('spanmessage').innerHTML ="Branch Name invalid";
	return false;
	 
	 }
 if(bankAccountnumber==""||bankAccountnumber==null)
	{
	 
	 
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Account Number cann't be null";
	return false;
	}
 if(!validateNumber(bankAccountnumber))
    {
	 
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Account Number should be number";
	return false;
    }
  if(!validateAlphaNumeric(ifsccode)&&ifsccode!="")
    {
	
 document.getElementById('error').style.visibility="visible";
 document.getElementById('spanmessage').innerHTML ="IFSC code  is invalid";
	return false;
  }
 
  if(validateRadioButton()==false)
	 {
	  
	 document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="Account Type is mandatory";
		return false;
	 }
  if(validateRadioType()==false)
	  {
	 
	  document.getElementById('error').style.visibility="visible";
	  document.getElementById('spanmessage').innerHTML ="Bank Main Account cann't be null";
		return false;
	  }
 if(glAccountNumber=="")
	{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Gl Account Number cann't be null";
	return false;
	}
 
 if(!validateAlphaNumeric(glAccountNumber))
{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Gl Account Number should be number";
	return false;
}
 
 if(!validateString(glAccountName)&& glAccountName!="")
 {
	 
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Gl Account Name should be string";
	return false;
 }
 
  if(!validateString(contactperson)&&contactperson!=="")
	{
	 
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Contact Person should be string";
	return false;
	}
 if(!validateNumber(contactnumber)&&contactnumber!=="")
{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Contact Number should be number";
	return false;
}
 
if(!validateEmail(email)&& email!=="")
{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Invalid Email-Id";
	return false;
	}

if(validateRadioType()==true &&(bankAccountnumber==bankMainAccountNumber))
{
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank-Account number cann't be equal to Main Account Number ";
	return false;
}
document.getElementById('error').style.visibility="hidden";
document.getElementById('spanmessage').innerHTML ="";

return true;

}
 function glMappingValidation(form)
 {
	
	 var glAttribute=form.glAttribute.value;
	 var BankAttribute=form.bankAttribute.value;
	
	 if(glAttribute=="")
	 {
		
		 document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="Gl-Attribute cann't be null !!!";
	 	return false;
	 	
	 }
	 
	 if(!validateString(glAttribute))
	     {
	 	document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="Gl-Attribute should be string !!!";
	 	return false;
	 	
	     }
	 
	 if(BankAttribute=="")
	 	{
	 	document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="Bank Attribute cann't be null !!!";
	 	return false;
	 	}
	 
	 if(!validateString(BankAttribute))
	 {
	 	document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="Bank Attribute should be string !!!";
	 	return false;
	 }
	 
	
	 document.getElementById('error').style.visibility="hidden";
	 document.getElementById('spanmessage').innerHTML ="";
	 return true;
 }
 
/*=====================end=======================*/
 
 
 /*=======file upload validation==================*/
 
 function fileUploadvalidation(form)
 {

	var bankShortName=form.bankShortName.value;
	var bankMainAccount=form.bankMainAccount.value;
	var glAccountNumber=form.glAccountNumber.value;
	var glFromDate=form.glFromDate.value;
	var glToDate=form.glToDate.value;
	var glfile=document.getElementById("fileGl").value;      
	var arfile=document.getElementById("fileAr").value;
	var apfile=document.getElementById("fileAp").value;
	var bankFromDate=form.bankFromDate.value;
	var bankToDate=form.bankToDate.value;
	var bsfile=document.getElementById("fileBs").value;
	 
	 
	 if(bankShortName=="")
		{
	
		 document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Bank Short Name cann't be blank";
		 return false
		} 
	 if(bankMainAccount=="")
		 {
		 
		 document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Bank Main Account Number cann't be blank";
		 return false;
		 
		 }
	 if(glAccountNumber=="")
		 {
		 
		 document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Gl-Account Number cann't be blank";
		 return false
		 }
	 
	 if(glFromDate=="")
		 {
		 
		 document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="ERP: From Date cann't be blank";
		 return false;
		 }
	 
	 if(glToDate=="")
		 {
		 
		 document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="ERP: To Date cann't be blank";
		 return false;
		 }
	 if(dateValidate(glFromDate,glToDate)==false && glFromDate!=null && glToDate!=null)
	 {
		
		 document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="ERP:From Date should be less then To Date";
	 return false;
	 }
	 if(glfile=="")
	{
		
		 document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Select Gl file";
		 return false;
	 }
	
	 else if(findFileName(glfile)!="GL" || validateExtention(glfile)==false) 
		 {
		  document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Provide Excel File GL";
		 return false;
		 }
	
	if(arfile=="")
		{
		document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Select AR file";
		 return false;
		 
		}else if(findFileName(arfile)!="AR" || validateExtention(arfile)==false)
	 {
			document.getElementById('error').style.visibility="visible";
			 document.getElementById('spanmessage').innerHTML ="Provide Excel File AR";
			 return false;
	 }
  
	if(apfile=="")
	{
	document.getElementById('error').style.visibility="visible";
	 document.getElementById('spanmessage').innerHTML ="Select AP file";
	 return false;
	 
	}else if(findFileName(apfile)!="AP" || validateExtention(apfile)==false)
 {
		document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Provide Excel File AP";
		 return false;
 }
	
if(bankFromDate=="")
	 {
	 document.getElementById('error').style.visibility="visible";
	 document.getElementById('spanmessage').innerHTML ="BS: From Date cann't be blank";
	 return false;
	 }

if(bankToDate=="")
	 {
	
	 document.getElementById('error').style.visibility="visible";
	 document.getElementById('spanmessage').innerHTML ="BS: To Date cann't be blank";
	 return false;
	 }
if(dateValidate(bankFromDate,bankToDate)==false && bankFromDate!=null && bankToDate!=null)
{
	
	 document.getElementById('error').style.visibility="visible";
	 document.getElementById('spanmessage').innerHTML ="BS:From Date should be less then To Date";
	 return false;
}

	if(bsfile=="")
		{
		
		document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="BS:Select Bs file";
		 return false;
		}
	else if(findFileName(bsfile)!="BS" || validateBsExtension(bsfile)==false)
		{
		document.getElementById('error').style.visibility="visible";
		 document.getElementById('spanmessage').innerHTML ="Provide Text File oF BS";
		return false;
		}
	document.getElementById('error').style.visibility="hidden";
	 document.getElementById('spanmessage').innerHTML ="";
	 
	 return true;
 }
/*==============***end****=====================*/

 /*====System reconcile validation======*/
 function SystemRecoValidation(form)
 {
	 var bankShortName=form.bankShortName.value;
	 var glAccount=form.glAccountNumber.value;
	 var bankMainAccount=form.bankMainAccount.value;
	 var fromdate=form.fromdate.value;
	 var todate=form.todate.value;
	 
	 if(bankShortName=="")
	 {
		
		document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="Bank Short Name cann't be null !!!";
	 	
	 	return false;
	 	
	 }
	
	 if(glAccount=="")
	 {
		
		 document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="Gl-Account cann't be null !!!";
	 	return false;
	 	
	 }
	
	 if(bankMainAccount=="")
	 {
		
		 document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="Bank Main Account cann't be null !!!";
	 	return false;
	 	
	 }
	
	 if(fromdate=="")
	 {
		
		 document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="From Date cann't be null !!!";
	 	return false;
	 	
	 }
	
	 if(todate=="")
	 {
		
		 document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="To Date cann't be null !!!";
	 	return false;
	 	
	 }
	
	 if(glAttribute=="")
	 {
		
		 document.getElementById('error').style.visibility="visible";
	 	document.getElementById('spanmessage').innerHTML ="From Date should be less then To Date";
	 	return false;
	 	
	 }
	
 }





/*report validation*/

function brsReportValidate(form)

{
	var glAccount=form.glAccountNumber.value;
	var bankName=form.bankName.value;
	var bankMainAccount=form.bankMainAccount.value;
	var brsFromDate=form.brsfromDate.value;
	var brsToDate=form.brstoDate.value;
	
	if(glAccount=="")
	{
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="Gl-Account cann't be null !!!";
		
		return false;
		
	}
	
	if(bankName=="")
	{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Name cann't be null !!!";
	
		return false;
		
	}
	if(bankMainAccount=="")
	{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="Bank Account cann't be null !!!";
		
		return false;
		
	}
	if(brsFromDate=="")
	{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="From Date cann't be null !!!";

		return false;
		
	}
	if(brsToDate=="")
	{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="To Date Cann't be null !!!";
		
		return false;
		
	}
	
	if(dateValidate(brsFromDate,brsToDate)==false && brsFromDate!=""&&brsToDate!="")
    {
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="From Date Cann't  be greater then To Date";
		return false;
    }
	return true;
}


function validateRadioCheck(form,element)
{
	for(var i=0;i<eval('document.'+form+'.'+element).length;i++)
		{
		if(eval('document.'+form+'.'+element)[i].checked==true)
			{
			return true;
			}
		}
	
return false;

}


function glreportvalidate(form)
{
	
	var reconType='reconcileType';
	var appType='approveType';
	var glAccount=form.glAccountNumber.value;
	var fromdate=form.glFromDate.value;
    var todate=form.glToDate.value;
    
	if(glAccount=="")
		{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="Gl-Account cann't be null !!!";
		return false;
		}
	
	if(validateRadioCheck('glreport',reconType)==false)
		{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="select Reco Type";
		return false;
		}
	
	if(validateRadioCheck('glreport',appType)==false)
		{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="select Approve Type";
		return false;
		}
	
	if(fromdate=="")
		{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="From Date cann't be null ";
		return false;
		}
	
    if(todate=="")
    	{
    	
    	document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="To Date cann't be null";
    	return false;
    	}
    
    if(dateValidate(fromdate,todate)==false)
    	{
    	
    	document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="From Date Cann't  be greater then To Date";
    	return false;
    	}
    	
    return true;
}


function bankReportValidate(form)
{

var recoType='reconcileType';
var appType='approveType';

var bankMainAccount=form.bankAccountNumber.value;
var fromDate=form.bankFromDate.value;
var toDate=form.bankToDate.value;

if(bankMainAccount=="")
	{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="Bank Account cann't be null !!!";
	return false;
	}

if(validateRadioCheck('bankreport',recoType)==false)
	{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="select Reco Type  ";
	return false;
	}
if(validateRadioCheck('bankreport',appType)==false)
	{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="select Approve Type  ";
	return false;
	}
if(fromDate=="")
	{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="From Date cann't be null !!!";
	return false;
	}
if(toDate=="")
	{
	
	document.getElementById('error').style.visibility="visible";
	document.getElementById('spanmessage').innerHTML ="To Date cann't be null !!!";
	return false;
	}
if(dateValidate(fromDate, toDate)==false)
		{
		
		document.getElementById('error').style.visibility="visible";
		document.getElementById('spanmessage').innerHTML ="From Date Cann't  be greater then To Date";
		return false;
		}
return true;
}
/*end*/




