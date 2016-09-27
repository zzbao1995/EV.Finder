<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="edu.findvideo.util.CountVisitor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath", basePath);
//request.getRequestDispatcher("search.do").forward(request,response);

//long count=Integer.parseInt(getServletContext().getAttribute("visitorCount").toString());
//
//count=count+1;
//getServletContext().setAttribute("visitorCount",count);
//CountVisitor countVisitor=new CountVisitor();
//countVisitor.writeCount(count);

%>

<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">

    <title>EVFinder</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="视频,语料库,检索">
    <meta http-equiv="description" content="This is the homepage of EVFinder.">
    <%--Zero-2--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--你自己的样式文件 -->
    <%--<link href="bootstrap/css/your-style.css" rel="stylesheet">--%>
    <%--Zero-2--%>
    <link rel="stylesheet" type="text/css" href="CSS/index.css">
    <link rel="shortcut icon" href="img/favicon.ico">
    <script type="text/javascript" src="jquery-1.7.2.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>
  
  <body>
  <div class="container">
  <!-- 导航 ，居右-->
      <div class="row">

              <ul class="nav nav-tabs navbar-right">
                  <%--<li><a href="http://www.japanesecorpus.com/">主页</a></li>--%>
                  <li><a href="findvideo.jsp">搜索首页</a></li>
                  <li><a href="exit.do">退出</a></li>
                  <li><a href="##">${username}</a></li>
              </ul>

      </div>
  	<!-- end 导航 -->
  <div class="row" style="margin-top: 93px">
      <div class="col-lg-6 col-lg-offset-3">
          <div class="row">
              <div class="col-md-12" id="logo">
                  <img src="img/title.jpg" width="331" height="99">
              </div>
          </div>
          <div class="row">
              <form method="post" action="search.do">
                  <div class="col-lg-10">
                      <div class="input-group input-group-lg">
                          <input type="text" class="form-control" name="keywords">
                          <span class="input-group-btn"><button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button></span>
                      </div>
                  </div>
                  <div class="col-lg-1" style="margin-top: 6px">
                      <div class="dropdown">
                              <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                                  搜索类型
                                  <span class="caret"></span>
                              </button>
                              <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                  <li role="presentation"><a role="menuitem" tabindex="-1" href="findvideo.jsp">关键词搜索</a></li>
                                  <li role="presentation"><a role="menuitem" tabindex="-1" href="findvideo2.jsp">标签搜索</a></li>
                              </ul>
                      </div>
                  </div>

                  <select name="complex" hidden>
                      <c:forEach items="${complexsets}" var="name">
                          <option value="${name}"/>
                          ${name}
                      </c:forEach>
                  </select>
                  <select name="media_class" hidden>
                      <option value="所有类" selected>所有类</option>
                      <option value="战争">战争类</option>
                      <option value="生活">生活类</option>
                      <option value="爱情">爱情类</option>
                      <option value="喜剧">喜剧类</option>
                      <option value="亲情">亲情类</option>
                      <option value="伦理">伦理类</option>
                      <option value="职场">职场类</option>
                      <option value="喜剧">喜剧类</option>
                      <option value="悬疑">悬疑类</option>
                      <option value="穿越">穿越类</option>
                      <option value="历史">历史类</option>
                  </select>


                  <input type="radio" name="order" value="顺序" hidden="hidden"/>

                  <input type="radio" name="order" value="乱序" checked="checked" hidden="hidden">
              </form>
          </div>
      </div>
  </div>
  	
  	<%--<div id="logo">--%>
    	<%--<img src="img/title.jpg" width="331" height="99">--%>
    	<%--<br/>--%>
   		<%--<br/>--%>
    	<%--<div id="keywordform">--%>
			<%--<form method="post" action="search.do">--%>
      			<%--<input type="text" name="keywords" id="keywords" size="12"/>--%>
      			<%--<input type="submit" value="Search" style="background:#1354ec;color:#ffffff" />--%>
    		<%--</form>--%>
    	<%--</div>--%>
    <%--</div>--%>
    </div>
	<div id="footer">
		<p>本站所有视频均来自网络，仅限学术研究，请勿用于商业用途</p>
		<p>© Copyright 2014&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
	</div>

  <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
  <script src="bootstrap/js/jquery-2.1.1.js"></script>
  <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
  <script src="bootstrap/js/bootstrap.min.js"></script>
 </body>
</html>
	  