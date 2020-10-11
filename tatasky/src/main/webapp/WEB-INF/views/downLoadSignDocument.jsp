<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sspl.entity.ContractTypeEntity"%>
<%

ContractTypeEntity contractTypeEntity=new ContractTypeEntity();
if(request.getAttribute("contractTypeEntity")!=null){
	contractTypeEntity=(ContractTypeEntity)request.getAttribute("contractTypeEntity");
}
  String filename =contractTypeEntity.getUploadedContractDocument();   
  String filepath = contractTypeEntity.getSignedContractPath();   
  response.setContentType("APPLICATION/OCTET-STREAM");   
  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath+ File.separator + filename);  
  int i;   
  while ((i=fileInputStream.read()) != -1) {  
    out.write(i);   
  }   
  fileInputStream.close();   
%>   