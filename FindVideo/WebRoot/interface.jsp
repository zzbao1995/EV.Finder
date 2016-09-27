<%@ page language="java" import="java.util.*,java.sql.*,edu.findvideo.bean.*,
edu.findvideo.dao.*,edu.findvideo.util.*,edu.findvideo.factory.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>interface</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <%
  	String keyword = request.getParameter("keywords");
    int pageNum=1; 
	int pageSize=100; 
	String baseword=keyword;
	String complex="原型搜索";
	PageModel pm = DaoFactory.getInstance().getSubtitleDao().getContentByKeyword(pageNum, pageSize, keyword, baseword, complex,"random","所有类");
    int i,j;
    ArrayList<ArrayList<Subtitle>> list = pm.getList();
    for(i=0;i<list.size();i++)
    {
    	ArrayList<Subtitle> l = list.get(i);
    	for(j=0;j<l.size();j++)
    	{
    		Media m = l.get(j).getMedia();
    		
    		//System.out.println("视频标题："+m.getMediaTitle());
    		//System.out.println("开始时间："+l.get(j).getStartTime());
    		//System.out.println("结束时间："+l.get(j).getEndTime());
    		//System.out.println("链接地址："+m.getUrl());
    	
    	}
    }
   %>
  <body><center>
  <table width="80%" border="0">
  <%
   for(i=0;i<list.size();i++)
    {
    	ArrayList<Subtitle> l = list.get(i);
    	for(j=0;j<l.size();j++)
    	{
    		Media m = l.get(j).getMedia();
   %>
  <tr>
    <td width="30%">视频标题：<%=m.getMediaTitle() %></td>
    <td width="70%">URL:<%= m.getUrl()%></td>
  </tr>
  <tr>
    <td>开始时间：<%=l.get(j).getStartTime()%></td>
    <td>结束时间：<%=l.get(j).getEndTime()%></td>
  </tr>
  <%
  }
  }
 
   %>
    <%=keyword%>
</table>
    </center>
  </body>
</html>
