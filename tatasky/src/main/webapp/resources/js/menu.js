
/*-----------------------------Menu------------------------------------*/
	openNode = 0;
	mouseOn = 0;
function makeMainMenu(){
   	cnt = 0;
	temp = '<ul id="sddm">';
	for(i=0;i<menu.length;i++){
		if(menu[i][1]==0){
			cnt++;	
			temp+='<li  id="'+menu[i][0]+'" class="menu'+cnt+'"><a href="'+menu[i][3]+'" onmouseover="showMenu(this.parentNode)" onmouseout="setOpenNode(this.parentNode)">'+menu[i][2]+'</a></li>';
		}
	}
	temp+='</ul>';
	document.getElementById('menu').innerHTML = temp;
}

isMenu = false;
function showMenu(obj){
    if(obj.id == mouseOn){
        return;
    }
     mouseOn = obj.id;
	isMenu = true;
	findOpenSibling(obj.id);
	addEvent( obj, 'mouseover', findRes );
	tmptxt = '<ul>';
	for(j=0;j<menu.length;j++){
		if(menu[j][1]==obj.id ){
		    
			tmptxt += '<li id="'+menu[j][0]+'"><a '; 
			if(hasChild(menu[j][0])){
				tmptxt +=  ' class="child" ';
			}
			tmptxt += ' href="'+menu[j][3]+'" onmouseover="showMenu(this.parentNode)" onmouseout="setOpenNode(this.parentNode)">'+menu[j][2]+'</a></li>';
		}
	}
	tmptxt+='</ul>';
	if(tmptxt!='<ul></ul>'){
		obj.innerHTML+=tmptxt;
		findRes(obj);
		openNode = obj.id;
	}
}
function hasChild(id){
	for(a=0;a<menu.length;a++){
		if(menu[a][1]==id)
			return true;
	}
	return false;
}
function findRes(ob){
	if(ob && ob.id){
		allowedWidth = ((checkWidth() - 780)/2)+780	;
		pNode=findElement(ob.id);
		if(ob.childNodes[1]){
			currentPos = findPosX(ob)+172;
			if(currentPos>allowedWidth  && menu[pNode][1]==0){
				if(171-findPosY(ob)>0){
					ob.childNodes[1].style.marginLeft =  '-'+(171-findPosY(ob))+'px';
				}
			}
			else if((currentPos+172)>allowedWidth && menu[pNode][1]!=0){
				ob.childNodes[1].style.marginLeft =  '-329px';
			}
		}
		
	}
}
function findOpenSibling(id){

	prnt = parentMenu(id);
	for(m=0;m<menu.length;m++){
		if(menu[m][1] == prnt){
			if(document.getElementById(menu[m][0]) && document.getElementById(menu[m][0]).innerHTML.toUpperCase().indexOf('<UL')!= -1)
				removeMenu(menu[m][0]);
		}
	}
}
function setOpenNode(obj){
	if(obj){
		isMenu = false;
		tmout = setTimeout("checkIfOpen()",600);
	}
}

function checkIfOpen(){
	if(!isMenu){
	    makeMainMenu();
		openNode = 0;
		mouseOn = 0;		
	}
}
function parentMenu(id){
	for(l=0;l<menu.length;l++){
		if(menu[l][0] == id)
			return menu[l][1];
	}
}

function removeMenu(id){
	for(k=0;k<menu.length;k++){
		if(menu[k][0]==id){ 
			if(document.getElementById(id)){
				tmTxt = '<a ';
				if(menu[k][1]!=0 && hasChild(id))
					tmTxt += 'class="child"';
				 tmTxt += 'onmouseover="showMenu(this.parentNode)" onmouseout="setOpenNode(this.parentNode)" href="'+menu[k][3]+'">'+menu[k][2]+'</a>';
	 			document.getElementById(id).innerHTML = tmTxt;
			}
		}
	}
}
function isNodeOpen(id){
	if(document.getElementById(parentMenu(id)))
		removeMenu(parentMenu(id));
}


function addEvent( obj, type, fn ) {
   if ( obj.attachEvent ) {
     obj['e'+type+fn] = fn;
     obj[type+fn] = function(){obj['e'+type+fn]( window.event );};
     obj.attachEvent( 'on'+type, obj[type+fn] );
   } else
     obj.addEventListener( type, fn, false );
 }
  

function removeEvent( obj, type, fn ) {
   if ( obj.detachEvent ) {
     obj.detachEvent( 'on'+type, obj[type+fn] );
     obj[type+fn] = null;
   } else
     obj.removeEventListener( type, fn, false );
}
function checkWidth() {
  var myWidth = 0;
  if( typeof( window.innerWidth ) == 'number' ) {
    myHeight = window.innerWidth;
  } 
  else {
  	  if( document.documentElement &&
	    ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
      myHeight = document.documentElement.clientWidth;
    } 
	else {
      if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
        myHeight = document.body.clientHeight;
      }
    }
  }
  return myHeight;
}

function findPosX(obj)
{
	var curleft = 0;
	if (obj.offsetParent)
	{
		while (obj.offsetParent)
		{
			curleft += obj.offsetLeft;
			obj = obj.offsetParent;
		}
	}
	else if (obj.x)
		curleft += obj.x;
	return curleft;
}
function findPosY(obj)
{
	var curleft = 0;
	if (obj.offsetParent)
	{
		curleft += obj.offsetWidth;
	}
	else if (obj.width)
		curleft += obj.width;
	return curleft;
}
function findElement(val){
	for(h=0;h<menu.length;h++){
		if(menu[h][0]==val)
			return h;
	}
}
