<%@ page language="java" import="java.util.*,java.sql.*,edu.findvideo.bean.*,edu.findvideo.dao.*,edu.findvideo.util.*,edu.findvideo.factory.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="p" uri="http://www.andiersoo.com/jsp/tag"%>
<%
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
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>搜索场景标签结果</title>

    <link rel="stylesheet" type="text/css" href="CSS/searchtag.css" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--你自己的样式文件 -->
    <%--<link href="bootstrap/css/your-style.css" rel="stylesheet">--%>
    <%--Zero-2--%>
    <link rel="shortcut icon" href="img/favicon.ico">

    <%--<script type="text/javascript" src="jquery-1.7.2.js"></script>--%>
    <script src="bootstrap/js/jquery-2.1.1.js"></script>
    <%
        List taglist = (List)request.getAttribute("taglist");
    %>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-lg-3" style="margin-top:18px;">
            <div id="img">
                <img src="img/title.jpg" width="300" height="99">
            </div></div>
        <ul class="nav nav-tabs navbar-right">
            <%--<li><a href="http://www.japanesecorpus.com/">主页</a></li>--%>
            <li><a href="findvideo.jsp">搜索首页</a></li>
            <li><a href="exit.do">退出</a></li>
            <li><a href="##">${username}</a></li>
        </ul>
        <div id="tagform" style="margin-top: 43px">
            <form method="post" class="form-inline" action="searchtag.do">
                <%--<input type="hidden" name="category1" id="classfunction">--%>
                <div class="row" align="center">
                    <div class="form-group" style="width: 100px;margin-right: 16px;margin-left: -217px;">
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

                    <div class="form-group" style="height: 42px;margin-left: -14px;">
                        <div style="line-height: 35px">
                            <button type="submit" type="button" class="btn btn-default input-lg"><span class="glyphicon glyphicon-search" style="margin: 4px;"></span></button>
                        </div>
                    </div>

                    <div class="form-group" style="margin-left: 9px">
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                                搜索类型
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="findvideo.jsp">关键词搜索</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">标签搜索</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </form>
        </div>


    </div>
    <%--<div id="title"><img src="img/title.jpg" width="400" height="100"></div>--%>
    <div id="result">
        <%
            if(taglist.isEmpty()){
        %>
        <p>对不起，您搜索的内容不存在。请确认输入是否正确。</p>
        <%
        }
        else
        {
            for(int i=0;i<taglist.size();i++)
            {
                Tag tag = (Tag)taglist.get(i);
                if(i%3==0){%>
        <div class="row">
            <% }
            %>
            <div class="col-md-4">
                <div class="tagvideo">
                    <div class="name">
                        场景<%=tag.getTagid() %>
                        <span class="cate">添加者:<%=tag.getusername() %></span>
                    </div>
                    <div class="message">
                        <%
                            if(tag.getDescription()==null || "".equals(tag.getDescription()))
                                out.println("暂无描述");
                            else
                                out.println(tag.getDescription());
                        %>
                    </div>
                    <div class="video">
                        来源于 <span class="medianame"><%=tag.getMedianame() %></span>
                    </div>
                    <form action="tag.do" method="post">
                        <input type="hidden" name="mediaurl" value=<%=tag.getMediaurl() %>/>
                        <input type="hidden" name="starttime" value=<%=tag.getStarttime() %>/>
                        <input type="hidden" name="endtime" value=<%=tag.getEndtime() %>/>
                        <input type="hidden" name="method" value="play"/>
                        <button type="submit"  class="btn btn-primary btn-default"/>播放</button>
                    </form>
                    <!--
				<form action="changeSucc.jsp" method="post">
					<input type="hidden" name="tagid" value="${tag.tagid}"/>
					<input type="submit" value="修改" class="playbtn" />		
				</form>-->

                    <%--<form action="deleteCl.jsp" method="post">--%>
                        <%--<input type="hidden" name="tagid" value=<%=tag.getTagid() %>>--%>
                        <%--<input type="hidden" name="username" value=<%=tag.getusername() %>>--%>
                        <%--<button type="submit" class="btn btn-primary btn-lg"onclick="return confirm('确认删除？')">删除</button>--%>
                    <%--</form>--%>
                </div>
            </div>
            <%
                if(i%3==2){%>
        </div>
        <%}
        }
        }
        %>
    </div>
</div>
</div>
<div id="footer">
    <p>本站所有视频均来自网络，仅限学术研究，请勿用于商业用途</p>
    <p> Copyright 2014&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
</div>
<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
<script src="bootstrap/js/jquery-2.1.1.js"></script>
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
