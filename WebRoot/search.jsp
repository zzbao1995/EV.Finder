<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="p" uri="http://www.andiersoo.com/jsp/tag"%> 
<%@ page import="edu.findvideo.util.*,edu.findvideo.bean.*,java.util.*"%>
<%
String path = request.getContextPath();//获得绝对根目录路径..
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";//组建url前缀路径..
int countS = 0;//记录每部视频的匹配条数
int countM = 0;//记录每页视频的个数
MarkContent mc = new MarkContent();
PageModel pm = (PageModel)request.getAttribute("pm");
ArrayList<ArrayList<Subtitle>> al = null;
String keyword = (String) request.getSession().getAttribute("keyword");
if (keyword==null||keyword.equals("")) {
	keyword = "";
}
if (pm!=null) {
	al = pm.getList();
	//RandomList rList=new RandomList();
	//rList.randomList(al);
		
}
int pageSize = pm.getPageSize();
%>
<%--Zero-1--%>
<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<!Doctype html>
<html>
  <head>
  	<title>EVFinder</title>
      <%--Zero-2--%>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap -->
      <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <!--你自己的样式文件 -->
      <%--<link href="bootstrap/css/your-style.css" rel="stylesheet">--%>
      <%--Zero-2--%>
     <link rel="shortcut icon" href="img/favicon.ico">
  	<link href="CSS/search.css" rel="stylesheet" type="text/css">
	<%--<script type="text/javascript" src="jquery-1.7.2.js"></script>--%>
      <script src="bootstrap/js/jquery-2.1.1.js"></script>
	<script type="text/javascript">
        $(document).ready(function(){
            $("#setPSButton").click(function(){
                $("#setPSText").toggle();
            });
            $("#subToggle").click(function(){
                $("#setLen").toggle();
            })
        });

    </script>
		
	<script type="text/javascript">
		function submitForm(countS,countM) {

			with(document.getElementById("mediaFormM"+countM+"S"+countS)) {
			//	alert("mediaForm"+countS);
                //alert(document.getElementsByName("change").value);
                var change = document.getElementsByName("change");
                var chg = document.getElementsByName("chg");
                for(var i=0;i<2;i++){
                    if(chg[i].checked){
                        change[i].checked = true;
                        break;
                    }
                }
                //alert(document.getElementsByName("change").value);
                document.getElementById("changeSTM"+countM+"S"+countS).value=document.getElementById("changeST").value;
                document.getElementById("changeETM"+countM+"S"+countS).value=document.getElementById("changeET").value;
                document.getElementById("contentForwardM"+countM+"S"+countS).value=document.getElementById("contentForward").value;
                document.getElementById("contentBackwardM"+countM+"S"+countS).value=document.getElementById("contentBackward").value;
				method="post";
				action="play.do";
				submit();
			}
		}
		
			function displayHideUI(countM, countS)
			{
			     var ui = document.getElementById("changeDivM"+countM+"S"+countS);
			     ui.style.display="none";
			}
			function displayShowUI(countM, countS)
			{
			     var ui = document.getElementById("changeDivM"+countM+"S"+countS);
			     ui.style.display="block";//display为空的话会好使，为block会使后边的空间换行
			}
			function forSS() {
				var mt = document.getElementsByName("mt");
				var setPSText = document.getElementById("setPSText");
				setPSText.style.display="none";
				for (var countM=1;countM<=mt.length;countM++) {
					simpleShow(countM);
				}
			}
			function simpleShow(countM) {		
				var liShows = document.getElementsByName("simple" + countM);
				var sbutton1 = document.getElementById("sda" + countM);
				var sbutton2 = document.getElementById("sdb" + countM);
				var markS = 0;
				for (var i=0;i<liShows.length;i++) {
					var ss = liShows[i];
					var scount = ss.className;
					if (scount >= 5) {
						ss.style.display="none";
					}
					markS = scount;
				}
				if (markS < 5) {
					sbutton1.style.display="none";
				}else {
					sbutton1.style.display="";
				}
				sbutton2.style.display="none";
			}
			function sDisplay(countM) {
				var liShows = document.getElementsByName("simple" + countM);	
				var sbutton1 = document.getElementById("sda" + countM);
				var sbutton2 = document.getElementById("sdb" + countM);
				sbutton1.style.display="none";
				sbutton2.style.display="";
				for (var i=0;i<liShows.length;i++) {
					var ss = liShows[i];
					var scount = ss.className;;
					ss.style.display="block";				
				}
			}
			function setPS(value) {
				var ps = document.getElementById("CpageSize");
				ps.value = value;
			}


    </script>
  </head>

  <body onload="forSS()">
  <c:if test="${pm==null}">
      <jsp:forward page="index.jsp"></jsp:forward>
  </c:if>

  <div class="container">
      <form id="search" method="post" action="search.do" >
      <div class="row" >
          <ul class="nav nav-tabs navbar-right">
              <%--<li><a href="http://www.japanesecorpus.com/">主页</a></li>--%>
              <li><a href="findvideo.jsp">搜索首页</a></li>
              <li><a href="exit.do">退出</a></li>
              <li><a href="##">${username}</a></li>
          </ul>

        <%--<div id="header">--%>
          <div class="col-lg-3">
              <div id="img">
                  <img src="img/title.jpg" width="300" height="99">
              </div>
          </div>

          <div class="col-lg-4">
              <div class="row">
                  <div class="col-lg-12">
                      <div class="input-group input-group-lg" style="padding-top:34px">
                          <input class="form-control" type="text" name="keywords" id="keywords"  value="<%=keyword %>">
                          <span class="input-group-btn"><button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button></span>
                      </div>

                  </div>
                         <%--media_class放到外面--%>
                  <input type="hidden" name="CpageSize" id="CpageSize" value="<%=pageSize %>" >
              </div>
          </div>
          <div class="col-lg-1">
              <div class="dropdown" style="padding-top: 39px">
                  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
                      搜索类型
                      <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">关键词搜索</a></li>
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="findvideo2.jsp">标签搜索</a></li>
                  </ul>
              </div>
          </div>
      </div>

      <div class="row" id="setZ">
          <div class="form-group" style="margin-left: 28px">
              <div class="sel">
                  <select name="complex" class="form-control" style="width:auto" onchange="document.getElementById('search').submit()" >
                      <option style="display: none" value="<%=request.getSession().getAttribute("complex")%>" selected><%=request.getSession().getAttribute("complex").toString()%></option>
                      <c:forEach items="${complexsets}" var="name">
                          <option value="${name}">${name}</option>
                          ${name}
                      </c:forEach>
                  </select>
              </div>
              <div class="sel">
                  <select name="order" class="form-control" style="width:auto" onChange="document.getElementById('search').submit()">
                      <option style="display: none" value="<%=request.getSession().getAttribute("order")%>" selected><%=request.getSession().getAttribute("order").toString()%></option>
                      <option value="乱序">乱序</option>
                      <option value="顺序">顺序</option>
                  </select>
              </div>
              <div class="sel">
                  <select name="media_class" class="form-control" style="width:auto" onChange="document.getElementById('search').submit()">
                      <option style="display: none" value="<%=request.getSession().getAttribute("media_class")%>" selected><%=request.getSession().getAttribute("media_class").toString()%></option>
                      <option value="所有类">所有类</option>
                      <option value="战争类">战争类</option>
                      <option value="生活类">生活类</option>
                      <option value="爱情类">爱情类</option>
                      <option value="喜剧类">喜剧类</option>
                      <option value="亲情类">亲情类</option>
                      <option value="伦理类">伦理类</option>
                      <option value="职场类">职场类</option>
                      <option value="喜剧类">喜剧类</option>
                      <option value="悬疑类">悬疑类</option>
                      <option value="穿越类">穿越类</option>
                      <option value="历史类">历史类</option>
                      <option value="科幻类">科幻类</option>
                      <option value="动漫类">动漫类</option>
                  </select>
              </div>
              <div id="setLen" class="sel" style="margin-left: 0">
                  <div class="sel">
                      <input name="chg" type="radio" value="content" checked="checked">
                      <label class="control-label">字幕</label>

                  <div class="sel">
                      <select id="contentForward" class="form-control" style="width:auto">
                          <option value="0">向前0句</option>
                          <option value="1">向前1句</option>
                          <option value="2" selected="selected">向前2句</option>
                          <option value="3">向前3句</option>
                          <option value="4">向前4句</option>
                          <option value="5">向前5句</option>
                          <option value="6">向前6句</option>
                          <option value="7">向前7句</option>
                          <option value="8">向前8句</option>
                          <option value="9">向前9句</option>
                          <option value="10">向前10句</option>
                      </select>
                  </div>

                  <div class="sel">
                      <select id="contentBackward" class="form-control">
                          <option value="0">向后0句</option>
                          <option value="1">向后1句</option>
                          <option value="2" selected="selected">向后2句</option>
                          <option value="3">向后3句</option>
                          <option value="4">向后4句</option>
                          <option value="5">向后5句</option>
                          <option value="6">向后6句</option>
                          <option value="7">向后7句</option>
                          <option value="8">向后8句</option>
                          <option value="9">向后9句</option>
                          <option value="10">向后10句</option>
                      </select>
                  </div>
                  <div class="sel">
                      <input name="chg" type="radio" value="time">
                      <label class="control-label">时间</label>
                  </div>

                  <div class="sel">
                      <select id="changeST" class="form-control">
                          <option value="10" selected="selected">提前10s</option>
                          <option value="20">提前20s</option>
                          <option value="30">提前30s</option>
                          <option value="40">提前40s</option>
                          <option value="60">提前60s</option>
                      </select>
                  </div>

                  <div class="sel">
                      <select id="changeET" class="form-control">
                          <option value="10" selected="selected">延后10s</option>
                          <option value="20">延后20s</option>
                          <option value="30">延后30s</option>
                          <option value="40">延后40s</option>
                          <option value="60">延后60s</option>
                      </select>
                  </div>
              </div>
              </div>
          </div>
      </div>
      </form>

  <%boolean isNull = (al.size()==0); %>
  <c:choose>
      <c:when test="<%=isNull %>">
          <div id="content">
              <p style="margin-top: 20px;margin-left: 30px;">对不起，您搜索的内容不存在。请确认输入是否正确。</p>
          </div>
      </c:when>
      <c:otherwise>
          <div id="content" style="margin-left: -7px;">
              <p class="resultCount">共找到<%=pm.getResultCount()%>集相关视频</p>

              <%--<div id="setLen" style="position:absolute;right:244px;top:165px;width:100px;display:none;z-index: 5">--%>
                  <%--<form class="form form-horizontal">--%>
                      <%--<div class="form-group">--%>
                        <%--<input name="chg" type="radio" value="content" checked="checked">--%>
                        <%--<label class="control-label">字幕:</label>--%>
                        <%--<br>--%>
                        <%--向前--%>
                        <%--<select id="contentForward" class="form-control">--%>
                            <%--<option value="0">0句</option>--%>
                            <%--<option value="1">1句</option>--%>
                            <%--<option value="2" selected="selected">2句</option>--%>
                            <%--<option value="3">3句</option>--%>
                            <%--<option value="4">4句</option>--%>
                            <%--<option value="5">5句</option>--%>
                            <%--<option value="6">6句</option>--%>
                            <%--<option value="7">7句</option>--%>
                            <%--<option value="8">8句</option>--%>
                            <%--<option value="9">9句</option>--%>
                            <%--<option value="10">10句</option>--%>
                        <%--</select>--%>
                        <%--向后--%>
                        <%--<select id="contentBackward" class="form-control">--%>
                            <%--<option value="0">0句</option>--%>
                            <%--<option value="1">1句</option>--%>
                            <%--<option value="2" selected="selected">2句</option>--%>
                            <%--<option value="3">3句</option>--%>
                            <%--<option value="4">4句</option>--%>
                            <%--<option value="5">5句</option>--%>
                            <%--<option value="6">6句</option>--%>
                            <%--<option value="7">7句</option>--%>
                            <%--<option value="8">8句</option>--%>
                            <%--<option value="9">9句</option>--%>
                            <%--<option value="10">10句</option>--%>
                        <%--</select>--%>
                          <%--<input name="chg" type="radio" value="time">--%>
                          <%--<label class="control-label">时间：</label>--%>
                          <%--<br>--%>
                          <%--提前--%>
                          <%--<select id="changeST" class="form-control">--%>
                              <%--<option value="10" selected="selected">10s</option>--%>
                              <%--<option value="20">20s</option>--%>
                              <%--<option value="30">30s</option>--%>
                              <%--<option value="40">40s</option>--%>
                              <%--<option value="60">60s</option>--%>
                          <%--</select>--%>
                          <%--延后--%>
                          <%--<select id="changeET" class="form-control">--%>
                              <%--<option value="10" selected="selected">10s</option>--%>
                              <%--<option value="20">20s</option>--%>
                              <%--<option value="30">30s</option>--%>
                              <%--<option value="40">40s</option>--%>
                              <%--<option value="60">60s</option>--%>
                          <%--</select>--%>
                      <%--</div>--%>
                  <%--</form>--%>
              <%--</div>--%>

              <%
                  for (int i=0;i<al.size();i++) {
                      ArrayList<Subtitle> subList = (ArrayList<Subtitle>)al.get(i);
                      int temp = 1;//合并同一视频标题
              %>
              <div class="row">
                  <div class="col-md-10">
                  <ul class="MEDIA_TITLE">
                      <%
                          for (int j=0;j<subList.size();j++) {
                              Subtitle sub = (Subtitle)subList.get(j);
                              countS++;
                              if (temp==1) {
                                  countM++;
                                  countS = 0;//一部视频结束时清零
                      %>

                      <div id="mt" name="mt">
                          <li>
                              <strong><%=sub.getMedia().getMediaTitle() %></strong><small>包含<%=subList.size() %>个结果</small>
                              <span class="hid" id="sda<%=countM %>" title="点击完整显示" onclick="sDisplay(<%=countM %>)">完整显示</span>
                              <span class="hid" id="sdb<%=countM %>" title="点击收起" style="display:none;" onclick="simpleShow(<%=countM %>)">收起</span>
                          </li>
                      </div>

                      <ul class="SUBTITLE" style="font-size: 17px">
                          <%
                                  temp = 0;
                              }//end if
                              String st = mc.doubleToTime(sub.getStartTime());
                              String et = mc.doubleToTime(sub.getEndTime());
                          %>
                          <div name="simple<%=countM %>" id="simple<%=countM %>" class="<%=countS %>">
                              <li>
                                  <span name="content" class="content"><a href="#" onclick="submitForm(<%=countS %>,<%=countM %>)"><%=sub.getContentMark() %></a></span>
                                  <span name="time" class="hide"> <%=st %>~<%=et %></span>

                                  <%--<span class="hide" onclick="displayShowUI(<%=countM%>,<%=countS %>)">高级设置</span>--%>

                                  <div>
                                      <form name="mediaForm" id="mediaFormM<%=countM%>S<%=countS %>" method="post" action="play.do">
                                          <input name="mediaTitle" type="hidden" value="<%=sub.getMedia().getMediaTitle() %>">
                                          <input name="content" type="hidden" value="<%=sub.getContent() %>">
                                          <input name="startTime" type="hidden" value="<%=sub.getStartTime() %>">
                                          <input name="endTime" type="hidden" value="<%=sub.getEndTime() %>">
                                          <input name="mediaUrl" type="hidden" value="<%=sub.getMedia().getUrl() %>">
                                          <input name="duration" type="hidden" value="<%=sub.getMedia().getDuration() %>">
                                          <input name="subtitleId" type="hidden" value="<%=sub.getSubtitleId() %>">
                                          <input name="mediaId" type="hidden" value="<%=sub.getMedia().getMediaId() %>">

                                          <div id="changeDivM<%=countM%>S<%=countS %>" style="display:none;" class="ex">

                                            <span class="By">
                                            <input name="change" type="radio" value="content" checked="checked">根据字幕：
                                            向前
                                            <select name="contentForward" id="contentForwardM<%=countM%>S<%=countS %>" class="form-control">
                                                <option value="0">0句</option>
                                                <option value="1">1句</option>
                                                <option value="2" selected="selected">2句</option>
                                                <option value="3">3句</option>
                                                <option value="4">4句</option>
                                                <option value="5">5句</option>
                                                <option value="6">6句</option>
                                                <option value="7">7句</option>
                                                <option value="8">8句</option>
                                                <option value="9">9句</option>
                                                <option value="10">10句</option>
                                            </select>
                                            向后
                                            <select name="contentBackward" id="contentBackwardM<%=countM%>S<%=countS %>" class="form-control">
                                                <option value="0">0句</option>
                                                <option value="1">1句</option>
                                                <option value="2" selected="selected">2句</option>
                                                <option value="3">3句</option>
                                                <option value="4">4句</option>
                                                <option value="5">5句</option>
                                                <option value="6">6句</option>
                                                <option value="7">7句</option>
                                                <option value="8">8句</option>
                                                <option value="9">9句</option>
                                                <option value="10">10句</option>
                                            </select>
                                            </span>

                                            <span class="By">
                                            <input name="change" type="radio" value="time">根据时间：
                                            提前
                                            <select name="changeST" id="changeSTM<%=countM%>S<%=countS%>" class="form-control">
                                                <option value="10" selected="selected">10s</option>
                                                <option value="20">20s</option>
                                                <option value="30">30s</option>
                                                <option value="40">40s</option>
                                                <option value="60">60s</option>
                                            </select>
                                            延后
                                            <select name="changeET" id="changeETM<%=countM%>S<%=countS %>" class="form-control">
                                                <option value="10" selected="selected">10s</option>
                                                <option value="20">20s</option>
                                                <option value="30">30s</option>
                                                <option value="40">40s</option>
                                                <option value="60">60s</option>
                                            </select>
                                            </span>


                                            <%--<span class="hide" onclick="displayHideUI(<%=countM%>,<%=countS %>)">隐藏</span>--%>
                                          </div>
                                      </form>
                                  </div>
                              </li>
                          </div>
                          <%
                              }//第2层for循环结束
                          %>

                      </ul>

                  </ul>
                  </div>
              </div>
              <%
                  }//第1层for循环结束
              %>
          </div>

          <div class="row" style="margin-left: -11px;">
              <%--<div class="col-md-9 col-md-offset-2">--%>
                  <div class="setPageSize" style="margin-left: 45px">
                        <button type="button" class="btn btn-default" id="setPSButton">设置</button>
		                <span id="setPSText">每页显示视频数：
		                <!-- <input type="text" id="setPageSize" value="<%=pageSize %>" onkeyup="setPS(this.value)" /> -->
                            <select id="setPageSize" onchange="setPS(this.value)">
                                <option value="1">1</option>
                                <option value="5">5</option>
                                <option value="<%=pageSize %>" selected="selected"><%=pageSize %></option>
                                <option value="10">10</option>
                                <option value="20">20</option>
                            </select>
		                </span>
                        <br>
                        <p:pagingTag id="pagingTag" gotoURI="search.do" />
                  </div>

              <%--</div>--%>
          </div>
      </c:otherwise>
  </c:choose>
  <div id="footer">
      <p>本站所有视频均来自网络，仅限学术研究，请勿用于商业用途</p>
      <p>© Copyright 2014&nbsp;|&nbsp; 大连理工大学软件学院英语教研室</p>
  </div>
</div>

  <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
  <script src="bootstrap/js/jquery-2.1.1.js"></script>
  <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
  <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
