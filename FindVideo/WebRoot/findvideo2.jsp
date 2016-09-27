<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="edu.findvideo.util.CountVisitor,java.util.*,java.io.IOException,javax.servlet.*,edu.findvideo.factory.DaoFactory,edu.findvideo.dao.TagDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
//request.getRequestDispatcher("search.do").forward(request,response);

    TagDao tagDao = DaoFactory.getInstance().getTagDao();
    List<String> categorylist1 = tagDao.listCategory1();
    List<String> categorylist2 = tagDao.listCategory2();
    List<String> categorylist3 = tagDao.listCategory3();
    List<String> categorylist4 = tagDao.listCategory4();
    List<String> complexset = new ArrayList<String>();
    complexset.add("原型搜索");
    complexset.add("分词搜索");
    request.setAttribute("complexsets", complexset);
    request.setAttribute("categorylist1", categorylist1);
    request.setAttribute("categorylist2", categorylist2);
    request.setAttribute("categorylist3", categorylist3);
    request.setAttribute("categorylist4", categorylist4);

//long count=Integer.parseInt(getServletContext().getAttribute("visitorCount").toString());
//
//count=count+1;
//getServletContext().setAttribute("visitorCount",count);
//CountVisitor countVisitor=new CountVisitor();
//countVisitor.writeCount(count);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">

      <title>JVFinder</title>
      <meta http-equiv="pragma" content="no-cache">
      <meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
      <meta http-equiv="keywords" content="视频,语料库,检索">
      <meta http-equiv="description" content="This is the homepage of JVFinder.">
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

      <link href="CSS/search.css" rel="stylesheet" type="text/css">

      <script src="bootstrap/js/jquery-2.1.1.js"></script>

      <link rel="stylesheet" type="text/css" href="CSS/index.css">
      <link rel="shortcut icon" href="img/favicon.ico">

      <script type="text/javascript" src="js/index.js"></script>
      <script>
          function classbyfunction(item,val){
              //   $("#classfunction").val($(item).val());
              $("#classfunction").val(val);
              alert($(item).val());
              alert($("#classfunction").val());
              $(item).css({"background":"blue"});
              alert($("#classfunction").val());
          }
      </script>
  </head>

  <body>
  <!-- 导航 -->
  <%--<div id="nav">--%>
  <%--<span id="link">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.japanesecorpus.com/">主页</a>--%>
  <%--&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp" id="set">一般搜索</a>--%>
  <%--<span id="login">&nbsp;&nbsp;&nbsp;&nbsp;<a href="exit.do">退出</a>--%>
  <%--&nbsp;&nbsp;&nbsp;&nbsp;<a href="production.jsp">使用说明</a>--%>
  <%--</span>--%>
  <%--<span id="visit">亲爱的<I>${username}</I>,欢迎您的到来！</span>--%>
  <%--</div>--%>
  <!-- end 导航 -->
  <div class="container">

          <div class="row">
              <ul class="nav nav-tabs navbar-right">
                  <li><a href="http://www.japanesecorpus.com/">主页</a></li>
                  <li><a href="search.do">搜索首页</a></li>
                  <li><a href="exit.do">退出</a></li>
                  <li><a href="##">${username}</a></li>
              </ul>
          </div>
      <div class="row" style="margin-top: 35px">
          <div clas="row">
              <div id="logo">
                  <img src="img/title.jpg" width="331" height="99">
              </div>
          </div>
          <div id="tagform" style="margin-top: -56px">
              <form method="post" class="form-inline" action="searchtag.do">
                  <%--<input type="hidden" name="category1" id="classfunction">--%>
                  <div class="row" align="center">
                      <div class="form-group" style="width: 100px;margin-right: 16px">
                          <label class="control-label">功能</label>
                          <select name="category1" class="form-control">
                              <c:forEach items="${categorylist1}" var="name">
                                  <option value="${name}"/>
                                  ${name}
                              </c:forEach>
                          </select>
                      </div>
                      <div class="form-group" style="width: 100px;margin-right: 30px">
                          <label class="control-label">会话</label>
                          <select name="category2" class="form-control">
                              <c:forEach items="${categorylist2}" var="name">
                                  <option value="${name}"/>
                                  ${name}
                              </c:forEach>
                          </select>
                      </div>
                      <div class="form-group" style="width: 100px;margin-right: 30px">
                          <label class="control-label">场景</label>
                          <select name="category3" class="form-control">
                              <c:forEach items="${categorylist3}" var="name">
                                  <option value="${name}"/>
                                  ${name}
                              </c:forEach>
                          </select>
                      </div>
                      <div class="form-group" style="width: 100px;margin-right: 30px">
                          <label class="control-label">对话关系</label>
                          <select name="category4" class="form-control">
                              <c:forEach items="${categorylist4}" var="name">
                                  <option value="${name}"/>
                                  ${name}
                              </c:forEach>
                          </select>
                      </div>

                      <div class="form-group" style="height: 42px;margin-left: -5px;">
                          <div style="line-height: 35px">
                               <button type="submit" type="button" class="btn btn-default input-lg"><span class="glyphicon glyphicon-search" style="margin: 4px;"></span></button>
                          </div>
                      </div>

                      <div class="form-group" style="margin-left: 20px">
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
                  </div>
              </form>
          </div>
      </div>

      </div>
  </div>
  <div id="footer">
      <p>本站所有视频均来自网络，仅限学术研究，请勿用于商业用途</p>
      <p> Copyright 2014&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
  </div>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
