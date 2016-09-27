<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.findvideo.bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SimpleSub ss = (SimpleSub) request.getAttribute("SimpleSub");
double start = ss.getStartTime();
double end = ss.getEndTime();
String url = ss.getMediaUrl();

%>
<!doctype html>
<html>
  <head>

    <title>play</title>
    <link rel="shortcut icon" href="img/favicon.ico">
    <link rel="stylesheet" type="text/css" href="CSS/tag.css">
    <link rel="stylesheet" type="text/css" href="CSS/jquery-ui-1.8.4.css" media="all" />
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.4.min.js"></script>
	<script type="text/javascript" src="JWPlayer/jwplayer.js"></script>
    <script type="text/javascript" src="js/ztag.js"></script>
  </head>
  
<body>
<div id="num" style="display:none"></div>
<div class="container">
    <div class="row">
        <div class="col-md-8" style="margin-top: -6px;">
            <h3 class="text-left" style="margin-left: 79px;font-family: 'MS Mincho'"><%=ss.getMediaTitle() %></h3>
        </div>

        <ul class="nav nav-tabs navbar-right">
            <%--<li><a href="http://www.japanesecorpus.com:8090/">主页</a></li>--%>
            <li><a href="findvideo.jsp">搜索首页</a></li>
            <li><a href="exit.do">退出</a></li>
            <li><a href="##">${username}</a></li>
        </ul>

    </div>
    <div class="row">
        <div class="col-md-12">

            <div id="container">
                <label>Loading the player...</label>
            </div>

            <script type="text/javascript">
                $(document).ready(function(){
                $("#addtag").dialog({
                    title:"新建标签",
                    height:"auto",
                    bgiframe: true,
                    autoOpen: false,
                    modal: true,
                    draggable:true,
                    resizeable:true,
                    show:"slide",
                    hide:"slide"
                });
                $("#add").click(function(){
                    $("#addtag").dialog("open");
                });
                $("#desp").css("color","#cccccc");
                $("#desp").focus(function(){
                    $("#desp").css("color","#666666");
                    $("#desp").html("");
                });
                $("#num").val(1);
                jwplayer("container").setup({
                    flashplayer: "JWPlayer/player.swf",
                    autostart: true,
                    height: 550,
                    width: "100%",
                    file: "<%=url %>",
                //	plugins: "captions",
                //	image: "",
                    provider: "http",
                    "http.startparam":"starttime",
                    events: {
                        onPause: function(event) {
                                var i = $("#num").val();
                                if(i==1){
                                    $("#start").val(this.getPosition());
                                    $("#start2").val(this.getPosition());
                                    i++;
                                    $("#num").val(i);
                                }
                                else if(i==2){
                                    $("#end").val(this.getPosition());
                                    $("#end2").val(this.getPosition());
                                    i=1;
                                    $("#num").val(i);
                                }
                        }
                    }
                });
                $("#reset").click(function reset(){
                    $("#num").val(1);
                    $("#start").val("");
                    $("#start2").val("");
                    $("#end").val("");
                    $("#end2").val("");
                });
                });
                </script>

	    </div>
    </div>
	<div id="control" class="row">
        <div class="col-md-10">
            <form class="form-group" style="margin-left: 218px;">
                <button type="button" class="btn btn-default">开始时间</button>
                <input class="input-sm" type="text" name="start" size="10" id="start"/>
                <button type="button" class="btn btn-default">结束时间</button>
                <input class="input-sm" type="text" name="end" size="10" id="end"/>
                <button type="button" class="btn btn-default"><a href="#" id="add">添加</a></button>
                <button type="button" class="btn btn-default"><a href="#" id="reset">重置</a></button>
                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                <button type="button" class="btn btn-default"><a href="<%=url%>">下载(右键另存为)</a></button>
            </form>
        </div>
	</div>

    <div id="footer">
        <p>本站所有视频均来自网络，仅限学术研究，请勿用于商业用途</p>
        <p>© Copyright 2014&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
    </div>

	<div id="addtag">
    	<form>
    	<input type="hidden" name="starttime" id="start2"/>
		<input type="hidden" name="endtime" id="end2"/>
		<input type="hidden" name="mediaid" id="mediaid" value="<%=ss.getMediaid()%>"/>
		<input type="hidden" name="mediaurl" id="mediaurl" value="<%=ss.getMediaUrl()%>"/>
		<input type="hidden" name="medianame" id="medianame" value="<%=ss.getMediaTitle()%>"/>
		<input type="hidden" name="method" id="method" value="add"/>
		<div><span style="padding-right:20px">按功能分类</span>
		<select name="category1" id="category1">
   			<c:forEach items="${categorylist1}" var="name1">
   				<option value="${name1}"/>
   				${name1}
   			</c:forEach>
   		</select></div><br/>
   		<div><span style="padding-right:20px">按会话分类</span>
		<select name="category2" id="category2">
   			<c:forEach items="${categorylist2}" var="name2">
   				<option value="${name2}"/>
   				${name2}
   			</c:forEach>
   		</select></div><br/>
		<div><span style="padding-right:20px">按场景分类</span>
	  	<select name="category3" id="category3">
   			<c:forEach items="${categorylist3}" var="name">
   				<option value="${name}"/>
   				${name}
   			</c:forEach>
   		</select></div><br/>
   		<div><span style="padding-right:20px">按对话关系分类</span>
		<select name="category4" id="category4">
   			<c:forEach items="${categorylist4}" var="name">
   				<option value="${name}"/>
   				${name}
   			</c:forEach>
   		</select></div><br/>
		<div><textarea rows="5" cols="30" name="description" id="desp"></textarea>
		</div><br/>
		<input type="button" value="确定" class="loginbutton" id="btn">
    	</form>
	</div>
    <div id="info" class="text-center">
        <br/>
        <label class="text-center">添加成功!</label>
    </div>
</div>
</body>
</html>