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
	<meta http-equiv="description" content="This is the homepage of EVFinder.">
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
  	<span id="login"><a href="login.jsp">&nbsp;&nbsp;&nbsp;&nbsp;登录</a></span>
  	</div>
  	<!-- end 导航 -->
  	<div id="logo">
    <h1 style="font-size: 66px;font-family: cursive;color: blue">EV.Finder</h1>
    <%--<img src="img/title.jpg" width="331" height="99">--%>
    <%--<br/>--%>
    <br/>
    <br/>
    <center>
    	<h1>恭喜您，注册成功!请尽情地学习英语！</h1><br>
    	<h3>您可以点击最上一行的“登录”按钮登录</h3>
    </center>
    
    
    
	<div id="footer">
	<p>© Copyright 2016&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
	</div>
  </body>
</html>