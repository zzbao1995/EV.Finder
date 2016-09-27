<%@ page language="java" import="java.util.*,java.sql.*,edu.findvideo.bean.*,
edu.findvideo.dao.*,edu.findvideo.util.*,edu.findvideo.util.*" pageEncoding="UTF-8"%>
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
       String name=request.getParameter("name");
       String user=request.getParameter("user");
      String QQ=request.getParameter("QQ");
      String mail=request.getParameter("mail");
       String pw=request.getParameter("pw");
       String pw2=request.getParameter("pw2");
 
       if(pw.equals("") || pw2.equals("") || name.equals("") || QQ.equals("")||mail.equals("") || user.equals("") || !pw.equals(pw2))
       {
       	    response.sendRedirect("false.jsp");
       	   
       }
       else{
            Connection conn = null;
		    PreparedStatement pstmt = null;
            try{
		        int flag = 0;
		        char[] c1 = user.toCharArray();
		        char[] c2 = pw.toCharArray();
		        for (int i = 0; i < c1.length; i++) {
		            int num = c1[i];
		            String numstr = Integer.toBinaryString(num);
		            if (numstr.length() > 8) {
		               flag = 1;
		               break;
		            } 
		        }
		        for (int i = 0; i < c2.length; i++) {
		            int num = c2[i];
		            String numstr = Integer.toBinaryString(num);
		            if (numstr.length() > 8) {
		               flag = 1;
		               break;
		            } 
		        }
		        if(flag==1){
		        	response.sendRedirect("false.jsp");
		        }else{
		       		String sql = "insert into user(username,password,role,number,mail,QQ,realname)values('"+user+"','"+pw+"',0,0,'"+mail+"','"+QQ+"','"+name+"')";
		       		conn = DB.getConnection();
					pstmt = conn.prepareStatement(sql);
		       		int row = pstmt.executeUpdate();
		       		if(row==1)
		       		    response.sendRedirect("true.jsp");
		       		pstmt.close();
       				conn.close();
		        }
       		}catch(Exception e){
       			 response.sendRedirect("false.jsp");
       		}	
       }
  %>
    
    
  </body>
</html>
