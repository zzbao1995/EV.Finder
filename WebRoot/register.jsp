<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EVFinder</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="视频,语料库,检索">
	<meta http-equiv="description" content="This is the homepage of EV.Finder.">
	<link rel="stylesheet" type="text/css" href="CSS/index.css">
	<link rel="shortcut icon" href="img/favicon.ico">
	<script type="text/javascript" src="jquery-1.7.2.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
  </head>
  
  <body bgcolor="#aeeeee">
  <!-- 导航 -->
  	<div id="nav" >
	<%--<span id="link">&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.japanesecorpus.com/">主页</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
	<%--</span>--%>
  	<span id="login"><a href="login.jsp"><h3>&nbsp;&nbsp;&nbsp;&nbsp;登录</h3></a></span>
  	</div>
  	<!-- end 导航 -->
  	<div id="logo">
        <h1 style="font-size: 66px;font-family: cursive;color: blue">&nbsp;&nbsp;EV.Finder</h1>
    <%--<img src="img/title.jpg" width="360" height="99">--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <%--<br/>--%>
    <center>
       <h3>&nbsp;&nbsp;用户注册</h3>
        </center>
    <form action="regesterCl.jsp" method="post">
        <form name="myform" method="post" onsubmit="check()">
        姓&nbsp;&nbsp;名：<input type="text" name="name" placeholder="输入您的真实姓名"></br></br>
       &nbsp用户名：<input type="text" name="user" placeholder="输入您的登录用户名"></br></br>
       &nbsp;&nbsp;Q Q  ：<input type="text" name="QQ"></br></br>
       &nbsp;E-mail：<input type="text" name="mail"></br></br>
       密&nbsp;&nbsp;码：<input type="password" name="pw" placeholder="至少6位字母、数字或下划线"></br></br>
       确认密码：<input type="password" name="pw2"></br></br>
    <input type="submit" value="注册" >
       &nbsp;&nbsp;
    <input type="reset" value="重置">
    
	<div id="footer">
	<p>© Copyright 2016&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
	</div>
            </form>
  </body>
</html>