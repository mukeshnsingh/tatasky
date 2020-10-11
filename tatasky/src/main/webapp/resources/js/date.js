
datelink=""
	var mn=['January','February','March','April','May','June','July','August','September','October','November','December'];

	function buildCal(m, y){
	 var dim=[31,0,31,30,31,30,31,31,30,31,30,31];
	 var oD = new Date(y, m-1, 1); //DD replaced line to fix date bug when current day is 31st
	 oD.od=oD.getDay()+1; //DD replaced line to fix date bug when current day is 31st

	 var scanfortoday=(y==start.getFullYear() && m==start.getMonth()+1)? start.getDate() : 0 //DD added
	 dim[1]=(((oD.getFullYear()%100!=0)&&(oD.getFullYear()%4==0))||(oD.getFullYear()%400==0))?29:28;

	 var t='<div class="calender"><table class="caltable" cols="7"><tr>';
	 t+='<td colspan="7" align="center">'+mn[m-1]+' - '+y+'</td></tr><tr align="center">';
	 for(s=0;s<7;s++)
	  t+='<td class="calheader" width="30">'+"SMTWTFS".substr(s,1)+'</td>';
	 t+='</tr><tr>';
	 for(i=1;i<=42;i++){
	  var x=((i-oD.od>=0)&&(i-oD.od<dim[m-1]))? i-oD.od+1 : '&nbsp;';
	  if(i==36 && x=='&nbsp;')
	   break;
	  if(x!='&nbsp;'){

	   dd=((x.toString()).length==1)? '0'+x : x
	   mm=((oD.getMonth()+1).toString().length==1)? '0'+(oD.getMonth()+1) : (oD.getMonth()+1)
	   datelink=dd+'/'+mm+'/'+oD.getFullYear()
	   		/*	if(document.registration && document.getElementById('relationId').value !=8){
	   			    if(document.registration.dependentCardIssueDate == dateobj1){
	   			    
	   			   		tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.checkValidityOfCard();window.close();'
			   		}else{
			   		    tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();'
			   		}
			   	}else*/
			   	
			   	 if(document.admissionByHin){
			   	if(document.admissionByHin.dependentCardIssueDate == dateobj1){
	   			   		tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.checkValidityOfCard();window.close();'
			   		}else{
			   		    tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();'
			   		}
			   	} else if(document.mlcForm){
			   	   	if(document.mlcForm.mlcDate == dateobj1){
	   			   		tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.checkMlcDate();window.close();'
			   		}else if(document.mlcForm.incidenceDate == dateobj1 ){
	   			   		tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.checkIncidenceDate();window.close();'
			   		}else{
			   		    tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();'
			   		}
			   	}else if(document.deptList){
	   			   	if(document.deptList.toDate == dateobj1){
	   			   		tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.validateDate();window.close();'
			   		}else{
			   		    tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();'
			   		}
			   }else if(document.patientAppointments){
	   			   	if(document.patientAppointments.appointmentDate == dateobj1){
	   			   		tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.submitForm(\'patientAppointments\',\'appointment?method=showAppointmentPatientDepartmentWise\',\'isApptGrCurrentDate1\',\'checkForHoliday\');window.close();'
			   		}else{
			   		    tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();'
			   		}
			   	}else if(document.ame){
	   			   	if(document.ame.inputDate == dateobj1){
	   			   		tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.addAnnualExamDuration();window.close();'
			   		}else{
			   		    tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();'
			   		}
			   	  }else if(document.applyLeave){
	    			if(document.applyLeave.toDate == dateobj1 || document.applyLeave.fromDate == dateobj1){
	     				if(dateobj1.name!='fromDate')
	      					tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.calculateDays();window.opener.fillJoiningDate(\''+datelink+'\');window.close();'
	     				else
	      					tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.calculateDays();window.close();'
	    				}
	    			if(document.applyLeave.checkbox.checked && document.applyLeave.fromDate == dateobj1 )
	     					tmp='window.opener.dateobj1.value=\''+datelink+'\';window.opener.setJoiningDate(\''+datelink+'\');window.close();'
	    			if(document.applyLeave.joiningDate == dateobj1)
	     					tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();' 
	   			 }  
			   	else
	    			tmp='window.opener.dateobj1.value=\''+datelink+'\';window.close();'
	  }  
	  else{
	   tmp=''
	  }
	  if (x==scanfortoday) //DD added
	  {
	   t+='<td class="today" align="center" onclick="'+tmp+'"><a href="javascript:'+tmp+'">'+x+'</a></td>';
	  }
	  else if(x == "&nbsp;")
	   t+='<td class="date" align="center" >&nbsp;</td>';
	  else
	   t+='<td class="date" align="center" onclick="'+tmp+'" ><a href="javascript:'+tmp+'">'+x+'</a></td>';
	  if(((i)%7==0)&&(i<36))t+='</tr><tr align="center">';
	 }
	 return t+='</tr></table><center><a href="javascript:window.opener.dateobj1.value=\'\';window.close();"><span class="bodytextB_blue">Clear Date</span></a></center></div>';

	}
	var selectedmonth;
	var selectedyear;
	var start;
	var dateobj1;
	var serverdateobj;
	function setdate(dateString,obj,e){
	  	var posx;var posy;
		posx = 0; posy = 0;
		if (!e){var e = window.event;}
		if (e.pageX || e.pageY){
		posx = e.pageX;
		posy = e.pageY;
		}
		else if (e.clientX || e.clientY){
		posx = e.clientX;
		posy = e.clientY;
		}
	 	 dateobj1=obj
	 	
		 serverdateobj= new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
		 var mn=['January','February','March','April','May','June','July','August','September','October','November','December'];
		 if(dateobj1 && dateobj1.value!="")
		  start  = new Date(dateobj1.value.substring(6),(dateobj1.value.substring(3,5) - 1) ,dateobj1.value.substring(0,2));
		 else
		  start  = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
		 selectedmonth=start.getMonth()
		 selectedyear=start.getFullYear();
		 t=buildCal((start.getMonth()+1),start.getFullYear())
		 openWindowForCalender(t,posy,posx);
		}
	  

	function openWindowForCalender(text,posy,posx){
		 
	 var styleStr ="chrome,modal,personalbar=no, top="+ posy + ", left= " + posx + ", hotkeys=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbar=no,resizable=no,copyhistory=yes,width=200,height=235";
	 msgWindow = window.open("","msg", styleStr);
	 var calhed='<head><title>Select a Date</title></head>' 
	 var calender='<body onunload="setTimeout(\'resetDates()\',100)"><div class="calender"><table width="100%" border="0" cellpadding="0" cellspacing="0" ><tr><td><table width="100%" cellpadding="0" cellspacing="0" style="background:#c0c0c0"><tr><td><input name="back" type="button" class="buttoncell" id="btnchar2" value="&lt;&lt;" onclick="window.opener.prevmonth()" /></td><td align="center"><select name="year" id="size8" onchange="window.opener.changeyear(this.value)">'
	 //var calender1='<body onunload="setTimeout(\'resetDates()\',100)"><table width="100%" border="0" cellpadding="0" cellspacing="0" ><tr><td><table width="100%"><tr><td><input name="back" type="button" class="buttoncell" id="btnchar2" value="&lt;&lt;" onclick="window.opener.prevmonth()" /></td><td align="center"><select name="year" class="Dropdown" id="size8" onchange="window.opener.changeyear(this.value)">'
	 for(aa=(serverdateobj.getFullYear()-80);aa<=(serverdateobj.getFullYear()+20);aa++){
	  calender+=(aa==selectedyear)? '<option selected="selected" value="'+aa+'">'+aa+'</option>' : '<option value="'+aa+'">'+aa+'</option>' 
	 }
	 calender+='</select></td><td align="right" ><input name="forward" type="button" class="buttoncell" id="btnchar2" value="&gt;&gt;" onclick="window.opener.nextmonth();" /></td></tr></table></td></tr><tr><td id="calendertext">'+text+'</td></tr></table></div></body>'

	 msgWindow.document.writeln(calhed + calender);
	 msgWindow.document.close();
	 
	}
	function resetDates(){
	 if(window.opener)
	 {
	  window.opener.resetdates();
	 }
	}
	function nextmonth(){

	 selectedmonth++;

	 if(selectedmonth>11){
	  selectedmonth=0
	  selectedyear++;
	  if(selectedyear>msgWindow.document.getElementById('size8').options[msgWindow.document.getElementById('size8').length-1].value){
	   msgWindow.document.getElementById('size8').length++;
	   msgWindow.document.getElementById('size8').options[msgWindow.document.getElementById('size8').length-1].value=selectedyear;
	   msgWindow.document.getElementById('size8').options[msgWindow.document.getElementById('size8').length-1].text=selectedyear;   
	  }
	  msgWindow.document.getElementById('size8').value=selectedyear
	 }
	 t=buildCal(selectedmonth+1,selectedyear)
	 msgWindow.document.getElementById('calendertext').innerHTML=t
	}
	function prevmonth(){
	 if(selectedmonth==0 && selectedyear<=1926) 
	  return;
	 selectedmonth--;  
	 if(selectedmonth<0){
	  selectedmonth=11
	  selectedyear--;
	  msgWindow.document.getElementById('size8').value=selectedyear
	 }
	 t=buildCal(selectedmonth+1,selectedyear)
	 msgWindow.document.getElementById('calendertext').innerHTML=t
	}
	function changeyear(yearchng){
	 selectedyear=yearchng;
	 t=buildCal(selectedmonth+1,selectedyear)
	 msgWindow.document.getElementById('calendertext').innerHTML=t
	}

	function resetdates(){
	 tempdate  = new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
	 selectedmonth=tempdate.getMonth()+1;
	 selectedyear=tempdate.getFullYear();
	}

	