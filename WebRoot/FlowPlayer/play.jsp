<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,edu.findvideo.bean.*,edu.findvideo.util.*,java.math.BigDecimal" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SimpleSub ss = (SimpleSub) request.getAttribute("SimpleSub");
double durationD = ss.getEndTime() - ss.getStartTime();
double duration = RoundTool.round(durationD,2,BigDecimal.ROUND_DOWN);
int durationB = (int) (duration + 1);
%>

<html>
  <head>
   
    <title>play</title>
    <link href="CSS/play.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">

	</script>
  </head>
  
  <body onload="">
  <script type="text/javascript" src="FlowPlayer/flowplayer-3.0.3.min.js"></script>
	<h2>视频:<%=ss.getMediaTitle() %></h2>
	<a style="display:block;width:640px;height:360px" id="player"></a>
	<!-- this will install flowplayer inside previous A- tag. -->
	<script type="text/javascript">
	
	flowplayer("player", "FlowPlayer/flowplayer-3.0.3.swf", {
	  clip: {
	    url: '<%=ss.getMediaUrl() %>',
	    autoPlay: true,
	    autoBuffering: true,
	    provider: 'h264streaming',
	    bufferLength: <%=durationB %>,
	    seekableOnBegin: false,
	    start: <%=ss.getStartTime() %>,
	    duration: <%=duration %>
	  },

	  plugins: {
	    h264streaming: {
	      url: 'FlowPlayer/flowplayer.h264streaming-3.0.5.swf'
	    },
	    controls: {
	    	scrubber: false,
	    	url: 'FlowPlayer/flowplayer.controls-3.0.3.swf',   	      
     		play: false,
     		fullscreen: true	
	    }                    
	  }
	});
	
	</script>
	<div id="a"></div><br>
	<div id="b"></div>
	<div>字幕:<br><p><%=ss.getContentMark() %></p></div>
	<button onclick="history.go(-1)">返回</button>
  </body>
</html>
