<%@ page language="java" import="java.util.*,java.sql.*,edu.findvideo.bean.*,
edu.findvideo.dao.*,edu.findvideo.util.*,edu.findvideo.factory.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>interfaceInput</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
      <center><br/><br/><br/><br/>
      <form method="get" action="interface.jsp">
      <input type="text" name="keywords" id="keywords" size="12"/>&nbsp;&nbsp;
       <input type="submit" value="Let`s try"/><span class="label"></span>
      </form>
      </center>
  </body>
</html>
