<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="edu.findvideo.bean.*"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
 	<%
 	
 	
 	 %>
  </head>
  <body>
      <div align="center" style="padding-bottom:50px;padding-top:50px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎来到后台管理界面<span class="info"></span><span ><a href="exit.do">&nbsp;&nbsp;返回搜索界面</a></span></div>
    <div class="content-box-content"  style="width: 100%; overflow: hidden;">
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
											<th class="compostime">
												视频时间
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
											<td align="center" width="40px">${tm.mediaId}</td>
											<td align="center" width="400px">${tm.mediaTitle }</td>
											<td style="word-break:break-all;">${tm.duration }</td>
											<td><div class="play"><a href="logins2?first=${tm.duration}&name=${tm.mediaTitle}">查看详情</a></div></td>
										</tr>
										</c:forEach>
										
									</tbody>
								</table>
							</div>
						</div>
					</div>
   
  </body>
</html>
  