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
        int userId = DaoFactory.getInstance().getUserDao().validateUser3(username);
		String s_id=request.getParameter("tagid");
		String s_userId2=request.getParameter("userId2");
		int userId2 = Integer.parseInt(s_userId2);
		int id = Integer.parseInt(s_id);
        if(judge==0) 
			response.sendRedirect("changeFail.jsp");
		else{
			if(userId2!=userId)
				response.sendRedirect("changeFail.jsp");
			else{
				String sql = "delete from tag where tagid=?";
				Connection conn = DB.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,s_id);
				pstmt.execute();				
				response.sendRedirect("changeSucc.jsp");
			}
		}
       		       		
  %>
    
    
  </body>
</html>
