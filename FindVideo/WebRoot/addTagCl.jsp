<%@ page language="java" import="java.util.*,java.sql.*,edu.findvideo.bean.*,
edu.findvideo.dao.*,edu.findvideo.util.*,edu.findvideo.factory.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
  <% 
		HttpSession hs = request.getSession(true);
		String username = (String)hs.getAttribute("username");
		int judge = DaoFactory.getInstance().getUserDao().validateUser2(username);
        String password = DaoFactory.getInstance().getUserDao().validateUser3(username);
        if(judge==0) 
			response.sendRedirect("changeFail.jsp");
		else
			response.sendRedirect("changeSucc.jsp");
		       		
  %>
    
    
  </body>
</html>
