<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="edu.findvideo.bean.*"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int i=1;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<link href="CSS/admin.css" rel="stylesheet" type="text/css">
  </head>
  <body>
      <div align="center" style="padding-bottom:50px;padding-top:50px">
&nbsp;&nbsp;&nbsp;&nbsp;您好，欢迎来到标签添加界面&nbsp;&nbsp;<span ><a href="login.jsp">退出</a>&nbsp;&nbsp;&nbsp;<a href="index.jsp">首页</a></span></div>
    <div class="content-box-content" align="center" style="width: 100%; overflow: hidden;">
						<div class="tab-content  default-tab" id="tab2">
							<div align="center" id="show">
								<table class="media">
									<thead>
										<tr>
											<th class="media_id">
												视频编号
											</th>
											<th class="compostime">
												视频标题
											</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<td colspan="3">
												<div class="clear"></div>
											</td>
										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${mediaList}" var="tm">
										<tr>
											<td align="center" width="40px"><%=i++%></td>
											<td align="center" width="500px" style="font-family:STSong;font-weight:bold;">${tm.mediaTitle }</td>
											<td><div class="play"><a href="logins?name=${tm.mediaTitle}&first=${tm.mediaId}">视频列表</a></div></td>
										</tr>
										</c:forEach>
										<c:if test="${empty mediaList}">
											<tr>
												<td colspan="3">
													<center>
														目前数据库尚未录入视频
													</center>
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
					</div>
   
  </body>
</html>
  