<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,edu.findvideo.bean.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String url = ""+request.getAttribute("url");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>播放场景</title>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link rel="shortcut icon" href="img/favicon.ico">
    <link href="CSS/play.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="JWPlayer/jwplayer.js"></script>
    <script src="bootstrap/js/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div class="container">
    <div class="row">

        <ul class="nav nav-tabs navbar-right">
            <%--<li><a href="http://www.japanesecorpus.com/">主页</a></li>--%>
            <li><a href="findvideo.jsp">搜索首页</a></li>
            <li><a href="exit.do">退出</a></li>
            <li><a href="##">${username}</a></li>
        </ul>


        <div class="col-lg-3" style="padding:7px">
            <div id="img">
                <img src="img/title.jpg" width="205" height="60" style="margin-left: 85px">
            </div></div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div id="container" style="height: 560px;width: 960px;background-color: #000000">
				<label style="color: #FFFFFF;line-height: 560px">Loading the player...</label>
			</div>
            <script type="text/javascript">
                $(document).ready(function(){
                    jwplayer("container").setup({
                        flashplayer: "JWPlayer/player.swf",
                        autostart: true,
                        height: 540,
                        width: 960,
                        file: "<%=url %>",
                       // plugins: {sharing: { link: false }},
                        image: "",
                        provider: "http",
                        "http.startparam":"starttime"
                    });
                });
            </script>
        </div>
    </div>
    <%--<div align="center"><a href="<%=url %>">链接地址</a><span>鼠标右键迅雷下载</span><a href="index.jsp">返回首页</a></div>--%>
    <div class="row">
        <div class="col-md-12">
            <div class="btn-group">

                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                <button type="button" class="btn btn-default"><a href="<%=url%>">下载（右键另存为）</a></button>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    <p>本站所有视频均来自网络，仅限学术研究，请勿用于商业用途</p>
    <p>© Copyright 2015&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
</div>
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
<%--<script src="<%=basePath%>resources/bootstrap/js/bootstrap.min.js"></script>--%>

</body>
</html>
