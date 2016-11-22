<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>用户登录</title>
   	<link rel="stylesheet" type="text/css" href="CSS/login.css">
	<link rel="stylesheet" type="text/css" href="CSS/jquery-ui-1.8.4.css" media="all" />
   	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.4.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript">
	  function register(){
	     window.location.href="register.jsp";
	  }
	
	</script>
  </head>
  <center>
      <br/><br/><br/><br/><br/><br/><h1 style="font-size: 48px ">欢迎来到英语视频搜索平台</h1>
      <h1 style="font-size: 66px; font-family: cursive ">EV.Finder</h1>
  <body bgcolor="#63B8FF">
  <div id="logindialog">
    <div id="logindiv">
	<div>
	<!--<td>临时帐号：teacher &nbsp;&nbsp; 密码：123</td>
	alert("请发送“视频语料库”+姓名+工作单位+欲申请的用户名+预申请密码 至zzbao1995@163.com. 我们将尽快进行审核！")
	-->

	</div>
	
   		<form id="loginform" action="login.do" method="post">
   		<table>
    	<tr><td>用户大名</td><td><input type="text" name="account" id="account"></td></tr>
    	<tr><td>密  码</td><td><input type="password" name="password" size="20" id="password"></td></tr>
    	<tr><td colspan="2" align="center">&nbsp;&nbsp;<input type="submit" id="login" value="登录" class="loginbutton">
    	    &nbsp;&nbsp;<input type="button" value="注册" class="loginbutton" onclick="register()">
    	</td></tr>
    	</table>
    	</form>
    </div>
    <div id="message">${info}</div>
    </div>
  </body>
 </html>