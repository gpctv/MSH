<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <table align="center">
  <tr>
  <td align="center">
  <a href="<%=basePath%>pos">POS</a>  
  </td>
  <tr>
  <td align="center">
  <a href="<%=basePath%>poskey">POSKEY</a>  
  </td>
  <tr>
   <td align="center">
  <a href="<%=basePath%>trans">交易紀錄</a>  
  </td>
  <tr>
   <td align="center">
  <a href="<%=basePath%>salesItemCount">商品統計</a>  
  </td>
  </table>
    
  </body>
</html>
