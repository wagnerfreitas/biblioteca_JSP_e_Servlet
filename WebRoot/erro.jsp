<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Erro</title>
  </head>
  
  <body>
  	<a href="javascript: history.go(-1)">Voltar</a><br/>	
  	Aconteceu um erro...
  </body>
</html>