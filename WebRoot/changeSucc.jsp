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
  
  <body bgcolor="green">
  <!-- 导航 -->
  	<div id="nav" >
	<span id="link">&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.japanesecorpus.com/">主页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
  	</div>
  	<!-- end 导航 -->
  	<div id="logo">
    <img src="img/title.jpg" width="331" height="99">
    <br/>
    <br/>
    <br/>
    <center>
    	<h1>感谢您的努力，您的操作成功!</h1><br>
    	<span><a href="findvideohelp.jsp" id="set">高级搜索</a></span>&nbsp;&nbsp;&nbsp;&nbsp;
		<span><a href="index.jsp" id="set">一般搜索</a></span>
    </center>
    
    
    
	<div id="footer">
	<p>© Copyright 2013&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
	</div>
  </body>
</html>