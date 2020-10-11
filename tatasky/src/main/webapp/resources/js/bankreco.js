var userArray = new Array();
var userArray2 = new Array();
var errorMessage = new Array();
errorMsg = "";
function validateLogin(action){
	document.user[0].action = action;
	document.user[0].submit();
}
function manualReco(form,action){
	var str=eval('document.'+form);
	str.action = action;
	str.submit();
}
function viewBank(form,action){
	var str=eval('document.'+form);
	str.action = action;
	str.submit();
}
function submitForm(formName,action,extraFunction,extraFunction2,extraFunction3){
errorMsg="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName);
		if(eval("window."+extraFunction))
	    	ob1 =  eval(extraFunction+"()")
	       
			if(eval("window."+extraFunction2))
	        	ob2 = eval(extraFunction2+"()")
	        	 
			if(eval("window."+extraFunction3))
	        	ob3 = eval(extraFunction3+"()")        	
	    	
	    	if(validateFields(formName)== true & ob1 & ob2 &ob3){
				if(formName=="admissionByHin"){
					obj.Submit11.disabled=true
				}
				
				obj.action = action;
				obj.submit();
	    	}else{
	    	   	
				if(errorMsg != ""){
					alert(errorMsg);
		       		return false;	
		       	}
		      
	    	}
	    	 return false;
	}
    
function validateFields(formName){
		
		focusFlag = false;
		errors = "";
		errorMsg += loopThroughElements(formName);
		if(errorMsg == "")
			return true;
		else{
			return errorMsg;
		    }
	}
function submitFormForButton(formName,action,extraFunction,extraFunction2,extraFunction3){

	
errorMsg="";
  ob1 = true;
  ob2 = true;
  ob3 = true;
  obj = eval('document.'+formName)
  if(eval("window."+extraFunction))
      ob1 =  eval(extraFunction+"()")
         
   if(eval("window."+extraFunction2))
          ob2 = eval(extraFunction2+"()")
         
   if(eval("window."+extraFunction3))
          ob3 = eval(extraFunction3+"()")         
      
   if(ob1 & ob2 &ob3){
          obj.action = action;
    obj.submit();
      
   }else{
          
    if(errorMsg != ""){
     alert(errorMsg);
           return false; 
          }
          return true;
      }
 }
 
function checkFoodData(formName){
		
		var breakFastStatus=document.getElementById('breakFastStatus').value
		var lunchStatus=document.getElementById('lunchStatus').value
		var dinnerStatus=document.getElementById('dinnerStatus').value
		
		
		 obj = eval('document.'+formName)
		 
		
		if(breakFastStatus == "" && lunchStatus == "" && dinnerStatus == "")
		{
		 alert("Please Enter The Food Details")
		}
		
		if(breakFastStatus != "" && lunchStatus == "" && dinnerStatus == "" )
		{
		 //alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&status="+breakFastStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(lunchStatus != "" && breakFastStatus=="" && dinnerStatus == "")
		{
			//alert(formName)
 		  url = "/hms/hms/ipd?method=insertFoodTesting&status="+lunchStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(dinnerStatus != "" && lunchStatus == "" && breakFastStatus=="")
		{
		//alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&status="+dinnerStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus != "" && lunchStatus != "" && dinnerStatus == ""  )
		{
		//alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&breakFastStatus="+breakFastStatus+"&lunchStatus="+lunchStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus != "" && lunchStatus == "" && dinnerStatus != ""  )
		{
		//alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&breakFastStatus="+breakFastStatus+"&dinnerStatus="+dinnerStatus;   
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus =="" && lunchStatus != "" && dinnerStatus != ""  )
		{
		//alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&lunchStatus="+lunchStatus+"&dinnerStatus="+dinnerStatus;   
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus !="" && lunchStatus != "" && dinnerStatus != ""  )
		{
		//alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&lunchStatus="+lunchStatus+"&dinnerStatus="+dinnerStatus+"&breakFastStatus="+breakFastStatus;   
		  	obj.action = url;
   			obj.submit();
		}
		
	}
	
function validateRadio(){
			
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('parent')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the patient")
		return false;
		
	}
	function validateRadioForGroup(){
			
			 for(var i = 0; i < document.getElementsByName('groupHospitalId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('groupHospitalId')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the Group")
		return false;
		
	}
	 
   
function loopThroughElements(frmName){
		
		inputs = eval('document.'+frmName+'.elements');
		
		errors = "";
		
		for(i=0;i<inputs.length;i++){
			if(inputs[i].type == 'text' 
				|| inputs[i].type == 'select-one'
				|| inputs[i].type == 'select-multiple'
				|| inputs[i].type == 'textarea' 
				|| inputs[i].type == 'password'){
					
				if(!inputs[i].getAttribute('validate'))
						continue;
				name = inputs[i].getAttribute('validate').substring(0,
					   inputs[i].getAttribute('validate').indexOf(','));
				type = inputs[i].getAttribute('validate').substring(inputs[i].getAttribute('validate').indexOf(',')+1,
					   inputs[i].getAttribute('validate').lastIndexOf(','));
	    		mandatory = inputs[i].getAttribute('validate').substring((inputs[i].
	    				getAttribute('validate').lastIndexOf(',')+1)); 
		    	textValue = trimAll(inputs[i].value);	
		    	textValueForSpaces=(inputs[i].value);
				
				if(mandatory == "yes" & trimAll(textValue) == "" & trimAll(textValueForSpaces) == ""){
					errors += name + " cannot be blank.\n";
				}else if(mandatory == "yes" & textValue == '0' & textValueForSpaces == '0'){
					errors += "Select "+name + ".\n";
				}else if(inputs[i].name != "years" && inputs[i].name != "months" && mandatory == "yes" & textValue == '0' & textValueForSpaces == '0'){
					errors += "Select "+name + ".\n";
				}
				
				if(textValue!= "" & type == 'alphanumeric'){
					if(! validateAlphaNumeric(textValue))
						errors +="Field "+ name +" is not valid.\n";
				}else if(textValue!= "" & type == 'alphaspace'){
					if(!validateAlphaSpace(textValue))
						errors += "Field " + name + " is not valid.\n";						
				}else if(textValue!= "" & textValue!= 'undefined' & type == 'goodString'){
				 	if(!validateGoodString(textValue))
						errors +="Field "+ name +" is not valid.\n";
				}else if(textValue!= "" & type == 'num'){
					if(!validateNumeric(textValue))
						errors += name + " should be a number.\n";
				}else if(textValue!= "" & type == 'phone'){
					if(!validatePhone(textValue))
						errors += name + " should be a valid phone number.\n";
				}else if(textValue!= "" & type == 'email'){
					if(!validateEmail(textValue))
						errors +=name + " should be a valid Email-Id.\n";						
				}
				else if(textValue!= "" & type == 'address'){
					if(!validateAddress(textValue))
						errors += "Field " + name + " should contain only valid characters.\n";					
				}
				else if(textValue!= "" & type == 'int'){
				if(!validateInteger(trimAll(textValue)))
					errors += name + " should be a number(without spaces).\n";						
				}	
				else if(textValue!= "" & type == 'name'){
					if(!chkSpaces(textValue))
						errors += name + " cannot contain spaces.\n";						
					else if(!validateName(textValue))
						errors += name + " is not a valid name.\n";						
				}
				else if(textValue!= "" & type == 'remarks'){
				if(!validateRemarks(textValue))
					errors += name + " is not valid.\n";						
				}
				else if(textValue!= "" & type == 'dateOfAdmission'){
				if(!validateDateOfAdmission(textValue))
					errors += name + " is not valid.\n";
				}
				else if(textValue!= "" & type == 'deliveryDate'){
				if(!validateDeliveryDate(textValue))
					errors += name + " is not valid.\n";
				}
				else if(textValue!= "" & type == 'fullName'){
				if(!validateFullName(textValue))
					errors += name + " is not a valid name.\n";						
				}else if(textValue!= "" & type == 'float'){
				if(!validateFloat(textValue))
					errors +=  name + " should contain integer or decimal value.\n";	
				}else if(textValue!= "" & type == 'date'){
			    	if(!validateDate(textValue))
			    	 errors += name + " is not a valid date (dd/mm/yyyy).\n";
                }else if(textValue!= "" & type == 'numWithSlash'){
			    	if(!validateNumericWithSlash(textValue))
			    	 errors += name + " is not a valid .\n";
                }else if(textValueForSpaces!= "" & type == 'numWithoutSpaces'){
			    	if(!validateInteger(textValueForSpaces))
			    	 errors += name + " should be a number(without spaces).\n";
                }else if(textValueForSpaces!= "" & type == 'floatWithoutSpaces'){
			    	if(!validateFloat(textValueForSpaces))
			    	 errors += name + " should be a number(without spaces).\n";
                } else if(textValue!= "" & type == 'dateOfBirth')
                {
                	if(!validateFutureDate(textValue))
						errors +="Date of Birth cannot be future date\n";
					else if(!validateDateOfBirth(textValue))
						errors += "Please Enter Valid Date Of Birth\n";
                }
                else if(textValue!= "" & type == 'dateOfInteview')
                {
                	if(!validateFutureDate(textValue))
						errors += name + " cannot be future date\n";
				}
				else if(textValue!= "" & type == 'mobilephone')
				{
					if(!validateMobilePhone(textValue))
						{
						
						errors += "Please enter the valid " + name +  " .\n";	
											
						}
				}				
                
			}
		}
		return errors;
}
	function validateFutureDate(strValue){
	date1 = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(date1 > currentDate)
 	{
		return false;
 	}
	 return true;
}

function  validateName( strValue ) {
  var objRegExp = /[^a-z\d]/i;
  if(!(parseInt(strValue)>0))
  		return !objRegExp.test(strValue);
  return false;
}

function chkSpaces(strValue){
	for(j=0; j<strValue.length; j++){
		if(strValue[j]==" ")
			return false;
	}
	return true;
}

function validateInteger( strValue ) {
  var objRegExp  = /(^\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateRemarks( strValue ){
	var objRegExp  = /[^a-z*(\.\-\&\d\s\:\@\#\$\^\*\(\)\{\}\[\]\;\"\,\<\>\?\/\_\\\+\=)]/i;
	if(strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "&"){
			return false;
	}
	else{
		return !objRegExp.test(strValue);
	}
}

function validateDateOfAdmission(strValue) {
   	dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(dateOfJoining > currentDate)
 	{
		return false;
 	}
	 return true;
}
function validateDeliveryDate(strValue) {
   	dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(dateOfJoining < currentDate)
 	{
		return false;
 	}
	 return true;
}
function validateFullName( strValue ) {
	
	var objRegExp  = /[^a-z*(\.\, )]/i;
	if(parseInt(strValue)>0){
		return false;
	}
	else if(strValue.substring(0,1) == ".")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}
function  validateNumeric( strValue ) {
  var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateMobilePhone( strValue ) {
	if(strValue.length < 10 || strValue.length > 12)
	    return false;
   	else
  		return validateInteger(strValue);
}

function validateAlphaNumeric( strValue ) {
	
	//var objRegExp  = /[^a-z*(\d)]/i;
	//Change by tarun
	var objRegExp=/(\s{2,})|([\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\â??\â??\?\n\r])/i
	
	//Change by tarun to allow ".","-",","
	var objRegExp=/(\s{2,})|([\\\/\(\)\_\:\@\$\*\"\&\`\#\â??\â??\?\n\r])/i
	
	return !objRegExp.test(strValue);
	
}

function validateAlphaSpace( strValue ) {
	
	var objRegExp  = /[^a-z*(\d\,\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\â??\â??\?\n\r )]/i;
	if(!(parseInt(strValue)>0)){
		if(strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "'" ){
			return false;
		}
		else{
			return !objRegExp.test(strValue);
		}
	}
  	return false;
}

function validatePhone( strValue ) {
		var objRegExp  = /^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$/
  		return objRegExp.test(strValue);
}

function validateInteger( strValue ) {
  var objRegExp  = /(^\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateAddress( strValue ) {
	
	var objRegExp = /[^a-z*(\d\,\\\/\.\(\)\_\:\"\&\-\'\`\#\â??\â??\n\r )]/i;
	if(strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "'" ){
		return false;
	}
	else{
		return !objRegExp.test(strValue);
	}
	return false;
}

function validateEmail(strValue) {
	//var objRegExp  =/^([a-zA-Z_\.\-][\w]*[a-zA-Z0-9\_])+\@(([a-zA-Z0-9\-])+\.)+(([a-zA-Z]{2,4})*([a-zA-Z]{2,4}))+$/;
	var objRegExp  = /^[a-zA-Z][\w\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]$/;
	return objRegExp.test(strValue);
//if(objRegExp.test(strValue))
   //return checkEmail(strValue);

}

function validateFloat( strValue ) {
 	//var objRegExp  =/^((\+|-)\d)?\d*(\.\d{2})?$/;
 	var objRegExp  =/^([+\-])?\d*([\.])?\d*([eE]([+\-])?)?\d*$/;
 	return objRegExp.test(strValue);
}


function checkEmail(strValue)
	{
		var checkEmail=true;
 		var mytool_array=strValue.split("@");
		var afterRateArray= mytool_array[1].split(".");	

 		if(afterRateArray.length>3) {
 			checkEmail=false;
 		}
 		else if(afterRateArray.length == 3){ 
 		   if(afterRateArray[1].length>2 || afterRateArray[2].length>2){
 		    checkEmail=false;
 		   }
 		}   
 		else if(afterRateArray.length == 2){
 		   if(afterRateArray[1].length>3 || afterRateArray[1].length == 2){
 		   checkEmail=false;
 		   }
 		}
 	
 		if(!checkEmail)
 		{
 			return false;
 		}
 		
 		return true;
 	}


function submitFormCancel(formName,action){ 
			obj = eval('document.'+formName)
			obj.action = action;
		
			obj.submit();
			return true;
}


function trimAll( strValue ) {
 var objRegExp = /^(\s*)$/;

    //check for all spaces
    if(objRegExp.test(strValue)){
       strValue = strValue.replace(objRegExp, '');
       if( strValue.length == 0)
          return strValue;
    }

   //check for leading & trailing spaces
   objRegExp = /^(\s*)([\W\w]*)(\b\s*$)/;
   if(objRegExp.test(strValue)) {
       //remove leading and trailing whitespace characters
       strValue = strValue.replace(objRegExp, '$2');
    }
  return strValue;
}

currentRowClicked=""
function clearRecords(obj){
		if(document.getElementById('multiplebutton'))
			document.getElementById('multiplebutton').style.display = "none";	
	if(currentRowClicked != ""){
		editRecord(document.getElementById(currentRowClicked),formName)

	}
	
	obj.blur();
}


showOnSamePage = true;
addAction = true;
rowsPerPage = 5;
totalPages =""
currentColor = "odd";

function intializeHover(id, nodeName, className){
	navRoot = document.getElementById(id);
	if(!navRoot)
		return;
	for (i=0; i<navRoot.childNodes.length; i++) {
		node = navRoot.childNodes[i];
		if (node.nodeName==nodeName) {
			node.onmouseover=function() {
				this.className+= className;
			}
			node.onmouseout=function() {
				this.className=this.className.replace(className, "");
			}
		}
	}
}

/*--------------Hover on TR's for IE Ends-----------------------------*/
/*----------------------------Set Scrolling Area of every page according to screen resolution--------------*/

function checkSize() {
  var myHeight = 0;
  if( typeof( window.innerWidth ) == 'number' ) {
    //Non-IE
    myHeight = window.innerHeight-138;
  } 
  else {
  	  if( document.documentElement &&
	    ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
      //IE 6+ in 'standards compliant mode'
      myHeight = document.documentElement.clientHeight-168;
    } 
	else {
      if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
        //IE 4 compatible
        myHeight = document.body.clientHeight-142;
      }
    }
  }
  return myHeight;
}

/*----------------------------Set Scrolling Area Ends--------------------*/


/*-------------------Some General Functions---------------------------*/
function findDiv(obj){
	while(obj.nodeName != 'DIV'){
			obj = obj.nextSibling;
	}
	return obj;
}
window.onresize = function (){
	if(document.getElementById('content')){
		document.getElementById('content').style.height = checkSize()+"px";
	}
}


function editForm(formName,action){
		errorMsg = "";
		if(currentRowClicked == ""){
			alert("Select a record to update");
			return false;
		}
		obj = eval('document.'+formName) 
		if(validateFields(formName)== true){
			undoDisabled();		
			obj.action = action;
			obj.submit();
		}
		else{
	    	alert(errorMsg);
	       	return false;			
		}
}

deleteMessage ="Are you sure to InActivate this record?"
function deleteForm(formName,action){
		obj = eval('document.'+formName) 
		if(currentRowClicked == ""){
			alert("Select a record to InActivate");
			return false;
		}

		undoDisabled();
		if(confirm(deleteMessage)){
			obj.action = action;
			obj.submit();
		}
}


subtest_arr = new Array();
currentRowClicked=""
nonEditable="";


function editRecord(obj,formName){
	
	tmptext = ""	
	if(currentRowClicked != "" ){
		//if(subtest_arr.length>0){
			//document.chargeCode.multipleresults.checked = false;
			//document.getElementById('multiplebutton').style.display = 'none';
		//}
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = false;			
					}
					else
						nonEditableObj.readOnly = false;
				}
			}
		}
		if(document.getElementById(currentRowClicked))
			document.getElementById(currentRowClicked).style.backgroundColor = "";
		document.getElementById('edited').innerHTML = " "
		if(document.getElementById('addbutton'))
			document.getElementById('addbutton').style.display = 'inline'
		if(document.getElementById('editbutton'))	
			document.getElementById('editbutton').style.display = 'none';	
		if(document.getElementById('deletebutton'))	
			document.getElementById('deletebutton').style.display = 'none';		
			
		for(i=0;i<formFields.length;i++){
			temp = eval("document."+ formName + "." +  formFields[i][1]);
			if(temp){
				if(temp.type == "select-one")
					temp.selectedIndex = 0;
				else if(temp.type == "checkbox"){
						temp.checked = false;
				}
				else
					temp.value = "";
			}
		}
	}
	
	if(currentRowClicked != obj.id){
		changeButton(obj.id,formName);
		deleteobj = eval("document."+ formName )
		deleteTd = data_arr[findArrayElement(data_arr,obj.id)][statusTd]
		if(deleteTd.toLowerCase()=="inactive")
		{
			if(document.getElementById('editbutton'))
				document.getElementById('editbutton').style.display = 'none'
		}
		else if(document.getElementById('editbutton'))
			document.getElementById('editbutton').style.display = 'inline'
		if(document.getElementById('deletebutton')){
			if((formName == 'menuItemFormula' || formName == 'extraItemFormula') && deleteTd.toLowerCase() == "inactive"){
				document.getElementById('deletebutton').style.display = 'none'
		}else if(formName == 'loanHeader'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'loanDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'reimbHeader'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}
    	else if(formName == 'reimbDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'bonusDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'advance'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'advanceDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'arrear'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'arrearSalary'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}
    	else{
				document.getElementById('deletebutton').style.display = 'inline'
				}
		}		
		if(document.getElementById('addbutton'))	
			document.getElementById('addbutton').style.display = 'none';
		//if(subtest_arr.length>0){
		//	chkMultipleTest(obj.id);
		//}
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = true;			
					}
					else
						nonEditableObj.readOnly = true;
				}
			}
		}
		obj.style.backgroundColor = '#9CCEF8'
		currentRowClicked=obj.id;
		for(i=0;i<formFields.length;i++){
			temp = eval("document."+ formName + "."  +  formFields[i][1]);
			if(formFields[i][1] == "addEditBy")
				tmptext += "<label>last Edited By</label><span>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"
			if(formFields[i][1] == "addEditOn")
				tmptext += "<label>On</label><span>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"				
			if(temp){
				if(temp.type == "select-one"){
					if(formName == "subTest")
						temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].innerHTML);
					else
						temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].childNodes[0].innerHTML);
				}
				else if(temp.type == "radio"){
					if(obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == 'y')
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
				}
				else if(temp.type == "checkbox"){
					if(obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || 	obj.cells[formFields[i][0]-1].childNodes[0].innerHTML=='y'){
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
					}
				}
				else if(temp.type == "select-multiple")
				{
					if (temp.id == "item_master_brand")
					{
							var brand_ids =  obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
							bar = new Array();
			  				bar  = brand_ids.split(",");
			  				var all_brand = document.getElementById('all_item_master_brand')
			  				temp.options.length=0;
			  				for(var l=0; l<all_brand.length;l++)
							{
								for(var m=0; m<bar.length;m++)
								{
									if (all_brand[l].value == bar[m])
									{ 
									temp.length++;
									temp.options[temp.length-1].value=all_brand.options[l].value;
									temp.options[temp.length-1].text=all_brand.options[l].text;
									break;
									}
								}
							}
					}else
					{
						if(formName == "dietMenuItem"){
							temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].childNodes[0].innerHTML);
						}else{
				    		var brand_ids =  obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
							bar = new Array();
			  				bar  = brand_ids.split(",");
		
							for(var k=0; k<temp.length;k++)
			  				{
			  					temp[k].selected = false;
			  				}
			  				
		  					for(var l=0; l<temp.length;l++)
							{
								for(var m=0; m<bar.length;m++)
								{
									if (temp[l].value == bar[m])
									{ 
									temp[l].selected = true;
									break;
									}
								}
							}
						}
					}
				}
				else{
					if(i==0)
						temp.value = obj.id;
					else{
						if(formName == "subTest"){
							temp.value = obj.cells[formFields[i][0]-1].innerHTML;
						}
						else
							temp.value = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
						if(temp.value.indexOf('&amp;') != -1){
							temp.value = replaceSubstring(temp.value, '&amp;', '&')
						}
					}
				}
			}
		}
	}
	else if(currentRowClicked == obj.id){
		//if(subtest_arr.length>0){
			//document.chargeCode.multipleresults.checked= false;
			//document.getElementById('multiplebutton').style.display = 'none';
		//}
		currentRowClicked = "";
	}
	if(tmptext != ""){
		document.getElementById('edited').innerHTML = tmptext;	
	}
	//-------------------------------------
	if(formName == "advance" || formName == "arrear" ||formName == "arrearSalary" ||formName == "loanDetail"){
	
  	document.getElementById('empId').disabled=true;
 }
	
}

function undoDisabled(){
	for(m=0;m<nonEditable.length;m++){
		nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
			if(nonEditableObj){
				if(nonEditableObj.type == "select-one"){
					nonEditableObj.disabled = false;
				}
			}
	}
}
function findArrayElement(arr, findWhat){
	for(cnt=0;cnt<arr.length;cnt++){
		if(arr[cnt][0]==findWhat){
			return cnt;
		}
	}
}
statusTd = "";
function changeButton(id,formName){
	if(statusTd!=""){
		deleteTd = data_arr[findArrayElement(data_arr,id)][statusTd]
		fobj = eval("document."+formName);
		if(deleteTd.toLowerCase()=="active" && formName !="loanHeader" && formName != "loanDetail" && formName != "reimbHeader" && formName != "reimbDetail" && formName != "bonusDetail" && formName != "advance" && formName != "advanceDetail" && formName != "arrear" && formName != "arrearSalary"   ){
			fobj.Delete.value="InActivate"
		}
		else{
			if(formName != "menuItemFormula" && formName != 'extraItemFormula' && formName !="loanHeader" &&  formName != "loanDetail" && formName != "reimbHeader" && formName != "reimbDetail" && formName != "bonusDetail" && formName != "advance" && formName != "advanceDetail" && formName != "arrear" && formName != "arrearSalary"   ){
				fobj.Delete.value="Activate"
				}else{
					document.getElementById('deletebutton').style.display = 'none'
				}
		}
		
	}
}

function findElementIndex(obj, txt){
	for(j=0;j<obj.length;j++){
		if(obj[j].text == txt ||obj[j].value == txt){
			return j;
		}
	}
}


showOnSamePage = true;
addAction = true;
rowsPerPage = 5;
totalPages =""
currentColor = "odd";
function makeTable(starter, end){
    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("totalRecs").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "50%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<font class="error"><b>No Records Found</b></font>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"    
    }
    document.getElementById('resultnavigation').style.display="inline";
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg            
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" ><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'<br /><a href="javascript:sortTable('+cols+',\'up\')"><img src="/hms/jsp/images/arrowUp.gif" /></a><a href="javascript:sortTable('+cols+',\'dn\')"><img src="/hms/jsp/images/arrowDown.gif" /></a></th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th  width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"	
				}

                tempTable += currentColor;   	            
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'    
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                 tempTable +='>';
                   
                    if (formName=='patientEnquiry' || formName=='patientSearch'||formName=='preAnaesthesiaPatientSearch'||formName=='otProcedureNotesEntry'|| formName=='postAnaesthesiaPatientSearch'||formName=='specimenDispatchEntryPatientSearch' || formName=='patientSearchForDisposal')
                    {
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][2]+'\'),\''+formName+'\')">';
                    }
                    else if(formName=='searchExpiryDetails' || formName=='patientVisit' || formName=='updateRegistrationByName' || formName=='patientAdmission' || formName=='patientTransfer' || formName=='patientDischarge' && formName != 'finalDischarge'  || formName == "patientAdvance" || formName == "finalSettlement" || formName == "pendingSampleCollection" || formName == "pendingSampleValidation" || formName== "requestResource")
                    {
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                    else if(formName == "pendingResult")
                    {
                   		tempTable += '<a href="javascript:RequestForCharge(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                    else if(formName == "pendingResultValidation")
                    {
                    	tempTable += '<a href="javascript:RequestForResultValidation(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                    else if(formName == "reportCollection" || formName == 'otPacClearedList')
                    {
                    	tempTable += '<a href="javascript:RequestForReportCollection(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                    else if(showOnSamePage && formName != "finalDischarge")
                    {
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
               		else if(addAction && formName != 'finalDischarge')
               		{
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';
                   	}
                    else if(formName != 'finalDischarge')
                    {
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';
                    }
                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'                    
                }
               tempTable += '</tr>' 
        }
        tempTable += '</tbody></table>'
                            
        document.getElementById('searchtable').innerHTML = tempTable;
    }
    
    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"    
    
    }    
     if(formName == 'finalDischarge'){
    	if(document.getElementById('dischargeButton'))	
			document.getElementById('dischargeButton').style.display = 'inline';
			document.getElementById('dsPrint').style.display = 'inline';	
			
		}
		if(document.getElementById('addInfoId')){
			document.getElementById('addInfoId').style.display = 'inline';	
		}
}

	function Request(obj,formName)
	{
	  obj1 = eval('document.'+formName)
	if( formName != 'patientEnquiry'){
		hin = obj.id;
	  
	    //alert(obj1)
	}
	
    var url;
    if(formName == 'patientVisit'){
   		url = "/hms/hms/registration?method=showVisitDetails&hinId="+hin;
   		obj1 .action = url;
		obj1 .submit();
    }
    }




function dateCompare(){

var nowDate=new Date();

obj1 = eval('document.'+formName+'.validFromDate')
obj2 = eval('document.'+formName+'.validToDate')
		
if(obj1.value != "" && obj2.value != "")
	{

	validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
				
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						errorMsg = "From Date should be smaller than To Date\n";
				}
			}
			
		else
			{
			errorMsg ="From Date should not be greater than Current date\n";
			}
	
	}
	return true;
}


function navigate(obj){
	document.paging.firstpage.style.border = "none"
	document.paging.nextpage.style.border = "none"
	document.paging.lastpage.style.border = "none"
	document.paging.prevpage.style.border = "none"		
	//currentPage = document.paging.pageno.value;
	initTabButtons()
	if(obj.value == 'f' && data_arr.length>rowsPerPage){
		makeTable(0,rowsPerPage);
		//document.getElementById('pageno').value=1
		
		document.getElementById("current").innerHTML=1
	
		document.getElementById("currStart").innerHTML=1
		document.getElementById("currEnd").innerHTML=5
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"	

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"			
	}
	else if(obj.value == 'p'){
		if(start-rowsPerPage>=0){
			document.paging.lastpage.disabled= false;
			document.paging.nextpage.disabled= false;
			document.paging.lastpage.className="next"
			document.paging.nextpage.className="singleNext"	
			if(start==rowsPerPage){
				document.paging.firstpage.disabled= true;
				document.paging.prevpage.disabled= true;
				document.paging.firstpage.className="previousDisable"
				document.paging.prevpage.className="singlePrevDisable"	
			}
			else{
				document.paging.firstpage.disabled= false;
				document.paging.prevpage.disabled= false;
				document.paging.firstpage.className="previous"
				document.paging.prevpage.className="singlePrev"	
			}
			makeTable(start-rowsPerPage,start);
			//document.getElementById('pageno').value--;
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML-2)*5+1
				document.getElementById("currEnd").innerHTML=(document.getElementById("current").innerHTML-1)*5
				document.getElementById("current").innerHTML--;
			
		}

	}
	else if(obj.value == 'n'){
		if(start+rowsPerPage*2<data_arr.length){
			makeTable(start+rowsPerPage,start+(rowsPerPage*2));
			
			//document.getElementById('pageno').value++;
			var tt=document.getElementById("current").innerHTML;
			
			document.getElementById("currStart").innerHTML=(tt)*5+1
				document.getElementById("currEnd").innerHTML=((tt*1)+1)*5
			document.getElementById("current").innerHTML++;
			
			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"					
			
		}
		else if(start+rowsPerPage<data_arr.length){
			makeTable(start+rowsPerPage,data_arr.length);
			//document.getElementById('pageno').value++;		
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML)*5+1
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML++;	
			document.paging.lastpage.disabled= true;
			document.paging.nextpage.disabled= true;
			document.paging.lastpage.className="nextDisable"
			document.paging.nextpage.className="singleNextDisable"	
			
			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"								
		}
	}
	else if(obj.value == 'l'){
		if(data_arr.length % rowsPerPage == 0) {
			makeTable(data_arr.length - rowsPerPage, data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		} else {
			makeTable((data_arr.length - (data_arr.length % rowsPerPage)), data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		}
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"	
		
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"	
	}
	if(!obj.disabled){
		obj.style.border = "none"
	}
}

function goToPage(pageno){

	if(pageno == ""){
		alert("Please Enter Page No.")
		return false;
	}
	if( (pageno>totalPages) || (pageno<=0) || (pageno%1!=0) )
	{
		alert("Please Enter Correct Page No.")
		document.paging.pageno.value=""
		return false;
	}
	if(pageno == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"	
	}
	else if(pageno == totalPages){
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"		
	
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"		
	}
	else{
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"		
	}
	if(pageno*rowsPerPage<data_arr.length)
		makeTable(pageno*rowsPerPage-rowsPerPage,pageno*rowsPerPage)
	else
		makeTable(pageno*rowsPerPage-rowsPerPage,data_arr.length)
		
		document.getElementById("currStart").innerHTML=(pageno-1)*5+1
		document.getElementById("currEnd").innerHTML=(pageno)*5
		
		document.getElementById("current").innerHTML=pageno
	
	
	document.paging.pageno.value=""	
	
}

function multipleResults(obj){
	if(obj.checked == true){
		
		document.chargeCode.multiple.style.display = "inline";
		}
	else{
		
		document.chargeCode.multiple.style.display = "none";
		}
}

function submitForm1(chargeDetails,div,action){
	obj = eval('document.'+chargeDetails) 
	if(validateFields(document.getElementById(div))){
		obj.action = action;
		obj.submit();
	}
}
var date1,date2;
function compareDates(){
	dateobj1 = new Date(date1)
	dateobj2 = new Date(date2)	
	if(dateobj1>dateobj2){
		errorMsg+= 'Field From Date cannot be greater than field To Date';
		return false; 
	}
	return true;
}
function compareCurrentDate(date1, date2, fieldName){
	dateobj1 = new Date(date1)
	dateobj2 = new Date(date2)	
	alert(dateobj1)
	alert(dateobj2)
	if(dateobj1>dateobj2){
		errorMsg+= 'Field '+fieldName+' should not be greater than todays date';
		return false; 
	}
	return true;
}

function replaceSubstring(inputString, fromString, toString) {
   var temp = inputString;
   if (fromString == "") {
      return inputString;
   }
   if (toString.indexOf(fromString) == -1) { // If the string being replaced is not a part of the replacement string (normal situation)
      while (temp.indexOf(fromString) != -1) {
         var toTheLeft = temp.substring(0, temp.indexOf(fromString));
         var toTheRight = temp.substring(temp.indexOf(fromString)+fromString.length, temp.length);
         temp = toTheLeft + toString + toTheRight;
      }
   } else { // String being replaced is part of replacement string (like "+" being replaced with "++") - prevent an infinite loop
      var midStrings = new Array("~", "`", "_", "^", "#");
      var midStringLen = 1;
      var midString = "";
      // Find a string that doesn't exist in the inputString to be used
      // as an "inbetween" string
      while (midString == "") {
         for (var i=0; i < midStrings.length; i++) {
            var tempMidString = "";
            for (var j=0; j < midStringLen; j++) { tempMidString += midStrings[i]; }
            if (fromString.indexOf(tempMidString) == -1) {
               midString = tempMidString;
               i = midStrings.length + 1;
            }
         }
      } // Keep on going until we build an "inbetween" string that doesn't exist
      // Now go through and do two replaces - f, replace the "fromString" with the "inbetween" string
      while (temp.indexOf(fromString) != -1) {
         var toTheLeft = temp.substring(0, temp.indexOf(fromString));
         var toTheRight = temp.substring(temp.indexOf(fromString)+fromString.length, temp.length);
         temp = toTheLeft + midString + toTheRight;
      }
      // n, replace the "inbetween" string with the "toString"
      while (temp.indexOf(midString) != -1) {
         var toTheLeft = temp.substring(0, temp.indexOf(midString));
         var toTheRight = temp.substring(temp.indexOf(midString)+midString.length, temp.length);
         temp = toTheLeft + toString + toTheRight;
      }
   } // Ends the check to see if the string being replaced is part of the replacement string or not
   return temp; // Send the updated string back to the user
} // Ends the "replaceSubstring" function


/*-------------------------------Sorting start-----------------------*/
var sortNo;
function sortTable(no,dir){
	document.paging.firstpage.disabled= true;
	document.paging.prevpage.disabled= true;
	document.paging.firstpage.className="previousDisable"
	document.paging.prevpage.className="singlePrevDisable"	
	document.paging.lastpage.disabled= false;
	document.paging.nextpage.disabled= false;
	document.paging.lastpage.className="next"
	document.paging.nextpage.className="singleNext"		
    sortNo = no;
    data_arr.sort(mysortfn)
        if(dir == 'dn'){
            data_arr.reverse();
        }
      
    if(data_arr.length<rowsPerPage)    
  	  makeTable(0,data_arr.length)
  	else
	    makeTable(0,rowsPerPage)
    //document.getElementById('pageno').value=1
    document.getElementById("currStart").innerHTML=1
				document.getElementById("currEnd").innerHTML=5
    document.getElementById("current").innerHTML=1
}
function mysortfn(a,b) {
var a1 = a[sortNo+1].toString().toUpperCase();
var b1 = b[sortNo+1].toString().toUpperCase();

  if (a1<b1) return -1;
  if (a1>b1) return 1;
  return 0;
}

/*-------------------------------Sorting ends-----------------------*/

function initFocus(){
	if(!document.getElementById('contentspace'))
		return;
	inps = document.getElementById('contentspace').getElementsByTagName('input')
	for(v=0;v<inps.length;v++){
		if(inps[v].type == 'button' || inps[v].type == 'submit'){
			inps[v].onfocus = showFocus;
			inps[v].onblur = hideFocus;			
		}
	}
}
function showFocus(){
	//this.setAttribute('border',1)
}
function hideFocus(){
	//this.style.borderWidth ="0px";
}

function initTabButtons(){
    buttonObj = document.getElementsByTagName('input')
    if(buttonObj){
        for(i=0;i<buttonObj.length;i++){
            if(buttonObj[i].className=="button"){
                buttonObj[i].onfocus = setBorder;
                buttonObj[i].onblur = resetBorder;
           }
       }    
    }
}
function setBorder(){
	//this.style.border = "#146faa"
	//this.style.width = "33px"
	//this.style.height= "20px";
}

function resetBorder(){
	this.style.border = "none"
}



function getDaysInMonth(dobMonth, dobDay, curDay){
    dayinMonth = [31,28,31,30,31,30,31,31,30,31,30,31];
    usrMonth = dobMonth - 1;
    usrDay = dobDay;
    day = curDay;
    daysinMonth = dayinMonth[usrMonth];
    outDay = daysinMonth - usrDay;
    outDay = outDay + day
    return outDay;

}

function clearRecords(obj){
		if(document.getElementById('multiplebutton'))
			document.getElementById('multiplebutton').style.display = "none";	
	if(currentRowClicked != ""){
		editRecord(document.getElementById(currentRowClicked),formName)

	}
	
	obj.blur();
}


function fetchUserValue(obj,formName){
           
  object = eval('document.'+formName)
  if(obj.value != ""){
  	
   		for(var i = 0;i<userArray.length;i++ ){
   		
      if(userArray[i][0] == obj.value){
          
         
           object.loginName.value = userArray[i][0];
           object.userName.value = userArray[i][1];
           object.EmployeeCode.value = userArray[i][2];
           object.password.value = userArray[i][3];
           object.changed_by.value = userArray[i][5];
           object.changed_date.value = userArray[i][6];
           object.changed_time.value = userArray[i][7];
           object.userId.value = userArray[i][8];
           if(userArray[i][4] == "1"){
               userArray[i][4]
               object.status[0].checked = true;
               }
           else
               object.status[1].checked = true;
           break;
       } 
   }
  } 
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 } 
  
  
}


function checkSearch(){

	if(document.getElementById('searchField').value == ''){
		alert("Please enter value in textfield");

		return false;
	}else
		return true;
}

function checkBlankSoc1(){
var id = document.getElementById('radio').value;

	if(id == 0 ){
		errorMsg += "Please select Option.\n";
		return false;
	}
	
	return true;
	
	
}
function checkBlankSoc1(){

	var id = document.getElementById('radio').value;

	if(id == 0 ){
		errorMsg += "Please select Option.\n";
		return false;
	}
	
	return true;
	
	
}
function fetchUserValue2(obj,formName){
          
  object = eval('document.'+formName)
  if(obj.value != ""){
  	 
   		for(var i = 0;i<userArray2.length;i++ ){
   		 
      if(userArray2[i][0] == obj.value){
          
         
           object.loginName.value = userArray2[i][0];
           object.userName.value = userArray2[i][1];
           object.EmployeeCode.value = userArray2[i][2];
           object.password.value = userArray2[i][3];
           object.changed_by.value = userArray2[i][5];
           object.changed_date.value = userArray2[i][6];
           object.changed_time.value = userArray2[i][7];
           object.userId.value = userArray2[i][8];
           
           break;
       } 
   }
  } 
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 } 
  
  }
  
function checkMaxLength(obj){
      if(window.event){
          keyObj = window.event.keyCode
          if(keyObj == 9 || keyObj == 8 ||keyObj == 46 || keyObj == 16 || keyObj == 37 || keyObj == 36 || keyObj == 35 || window.event.ctrlKey )
              return true;
      }
      if(obj.getAttribute("maxlength")){
       if(obj.value.length>obj.getAttribute("maxlength")-1){    
  	        return false;
      	}

      }
}
pasteFlag = false
function checkOnPaste(obj){
 pasteFlag = true;
 /*   txt =window.clipboardData.getData("Text", obj.value)
    if(obj.getAttribute("maxlength")){
     if((txt.length+obj.value.length)>obj.getAttribute("maxlength")-1){
	        obj.value = obj.value.substring(0,obj.getAttribute("maxlength"));
    	    return false;
    	}
    }*/
}
function checkMaxLengthMoz(obj){
    if(obj.getAttribute("maxlength")){
     if(obj.value.length>obj.getAttribute("maxlength")-1){
         obj.value = obj.value.substring(0,obj.getAttribute("maxlength"))
	        return false;
    	}
    }
}
function finalCheck(obj){
 if(obj.getAttribute("maxlength")){
       	if(pasteFlag){
    		obj.value = obj.value.substring(0,obj.getAttribute("maxlength"));
    		pasteFlag = false;
    	}
    }
}  
   
function alertBeforeSubmit(){
	if(confirm("Are you Sure, you want to submit the details ?"))
		return true;
	return false;
}


function resetCheck(){
	document.getElementById('addbutton').style.display = 'inline';
	document.getElementById('reset').style.display = 'inline';
	document.getElementById('editbutton').style.display = 'none';
	document.getElementById('deletebutton').style.display = 'none';
	if(document.getElementById('codeId')!= null){
	document.getElementById('codeId').readOnly = false;
	}
}




//Function to toggle Div, with Plus/Minus image :: By Subin Feb 11 08

function togPlus(objDiv,objImg)
{
	
	if(document.getElementById(objDiv))
	{
		var myElement = document.getElementById(objDiv);    
		if (myElement.style.display == "none")
		{
     	 	myElement.style.display = "block";
    	 	objImg.src = "/hms/jsp/images/minus1.gif";
		}
		else{
	      	myElement.style.display = "none";
	      	objImg.src = "/hms/jsp/images/plus1.gif";
		}
	}
}

//End of Function to toggle Div, with Plus/Minus image 




function validateDate( strValue ) {
  var objRegExp = /^\d{1,2}(\-|\/|\.)\d{1,2}\1\d{4}$/
 
  if(!objRegExp.test(strValue))
    return false; 
  else{
    var strSeparator = strValue.substring(2,3) 

    var arrayDate = strValue.split(strSeparator); 
    var arrayLookup = { '01' : 31,'03' : 31, '04' : 30,'05' : 31,'06' : 30,'07' : 31,
                        '08' : 31,'09' : 30,'10' : 31,'11' : 30,'12' : 31}
 var intDay = parseInt(arrayDate[0],10);
  

    if(arrayLookup[arrayDate[1]] != null) {
      if(intDay <= arrayLookup[arrayDate[1]] && intDay != 0)
        return true; 
    }
 var intMonth = parseInt(arrayDate[1], 10);

    if (intMonth == 2) { 
       var intYear = parseInt(arrayDate[2]);
       if( ((intYear % 4 == 0 && intDay <= 29) || (intYear % 4 != 0 && intDay <=28)) && intDay !=0)
          return true;
       }
  }
  return false; 
}

//------------------ Start For Dynamic Grid---------------------------------------

//This function is used for adding a row dynamically to a table
//At a time generateRow() will one to table
	   function generateRow(idName) {
    	
		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		tblCtrl[1].value=d.length-1;
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
			
		}
		
function generateRowWithoutSrNo(idName) {
    	
		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		var noOfRows=d.length
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input"); 
		for(var i=0;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
			document.getElementById('amcTDetailsListSize').value=noOfRows
			
		}
		
//This function is used for deleting multiple rows at time
		function removeRow(argIndex,idName){
	
	         var table=document.getElementById(idName);
	         var tblRows  = table.getElementsByTagName("tr");
	         var check=0;
	         
	         for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              check=check+1;
	                   }
	               }
	        }
	         if(tblRows.length-1==check){
	         	alert("Can not delete all rows")
	         	return false;
	         }
			
	        for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              document.getElementById(idName).deleteRow(i);
	                   }
	               }
	        }
     }
     
 //------------------ End For Dynamic Grid---------------------------------------
   


function validateNumericWithSlash(strValue){
	var objRegExp = /^(\d{1,}[\/]\d*[\/]\d*[\/]\d*)$/
	return objRegExp.test(strValue);
	
}

function checkDateNotGreaterThanCurrentDate()
{
	var inputDate=document.getElementById("inputDate").value;
	var currentDate=new Date();
	var formatInputDate=new Date(inputDate.substring(6),(inputDate.substring(3,5) - 1) ,inputDate.substring(0,2));
	if(formatInputDate>currentDate)
	{
		alert("Wrong Date entered !");
		return false;
	}
	else 
		return true;
}


function multiplResults(obj){
if(obj.checked == true){
var url;
url="/hms/hms/investigation?method=showNormalValue";
alert(url);
obj.action=url;
obj.submit();
}else{
}
}


				
		
function goToPageOnThisValue(pageno){

	if(pageno!="")
	{
	if( (pageno>totalPages) || (pageno<=0) || (pageno%1!=0) )
	{
		alert("Please Enter Correct Page No.")
		document.paging.pageno.value=""
		return false;
	}
	if(pageno == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"	
	}
	else if(pageno == totalPages){
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"		
	
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"		
	}
	else{
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"		
	
		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"		
	}
	}
	if(pageno*rowsPerPage<data_arr.length)
		makeTable(pageno*rowsPerPage-rowsPerPage,pageno*rowsPerPage)
	else
		makeTable(pageno*rowsPerPage-rowsPerPage,data_arr.length)
		
		document.getElementById("currStart").innerHTML=(pageno-1)*5+1
		document.getElementById("currEnd").innerHTML=(pageno)*5
		
		document.getElementById("current").innerHTML=pageno
	
	
	document.paging.pageno.value=""	
	
}



/**********************************/
<!-- function for pagination -->

   
	function Pager(tableName, itemsPerPage) {

     this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;
    
    this.showRecords = function(from, to) {        
        var rows = document.getElementById(tableName).rows;
        // i starts from 1 to skip table header row
        for (var i = 0; i < rows.length; i++) {
            if (i < from || i > to)  
                rows[i].style.display = 'none';
            else
                rows[i].style.display = '';
        }
    }
    
    this.showPage = function(pageNumber) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}

        var oldPageAnchor = document.getElementById('pg'+this.currentPage);
        oldPageAnchor.className = 'pg-normal';
        
        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg'+this.currentPage);
        newPageAnchor.className = 'pg-selected';
        
        var from = (pageNumber - 1) * itemsPerPage;
        
        var to = from + itemsPerPage - 1;
        
        this.showRecords(from, to);
    }   
    
    this.prev = function() {
        if (this.currentPage > 1)
            this.showPage(this.currentPage - 1);
    }
    
    this.next = function() {
        if (this.currentPage < this.pages) {
            this.showPage(this.currentPage + 1);
        }
    }                        
    
    this.init = function() {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length); 
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
    }

    this.showPageNav = function(pagerName, positionId) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}
    	var element = document.getElementById(positionId);
    	var pagerHtml=""
    	pagerHtml = '<span onclick="' + pagerName + '.prev();" class="previous">Prev</span> | ';

        for (var page = 1; page <= this.pages; page++) 
            pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> | ';
        pagerHtml += '<span onclick="'+pagerName+'.next();" class="next">Next</span>';            
        
        element.innerHTML = pagerHtml;
    }
}

	function hideObjects(obj)
	{
	var ob = document.getElementsByTagName(obj);
	for( i =0 ; i< ob.length ;i++){
	ob[i].style.visibility = "hidden";
	}
	}
	function submitFormAccount(formName,action,extraFunction,extraFunction2,extraFunction3){
		errorMsg="";
				ob1 = true;
				ob2 = true;
				ob3 = true;
				obj = eval('document.'+formName);
				if(eval("window."+extraFunction))
			    	ob1 =  eval(extraFunction+"()")
			       
					if(eval("window."+extraFunction2))
			        	ob2 = eval(extraFunction2+"()")
			        	 
					if(eval("window."+extraFunction3))
			        	ob3 = eval(extraFunction3+"()")        	
			    	
			    	if(validateFields(formName)== true & ob1 & ob2 &ob3){
						if(formName=="admissionByHin"){
							obj.Submit11.disabled=true;
						}
						
						obj.action = action;
						obj.submit();
			    	}else{
			    	   	
						if(errorMsg != "")
						{
						  if(validateRadio()==false)
								{
								
								errorMsg+="Please select the Account Type.\n";
								}
						  if(validateRadioType()==false)
							  {
							  errorMsg+="Please select the Bank Main Account.";				  
							  
							  }
						  
							alert(errorMsg);
				       		return false;	
				       	}
				      
			    	}
			    	 return false;
			}
		    


	function validateRadioType()
	{
		var type="";
		var i="";	
	var account=document.getElementById('bankMainAccount').value;
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
	    
	    
