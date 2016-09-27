<%@ page language="java" import="java.util.*,java.io.IOException,javax.servlet.*,edu.findvideo.factory.DaoFactory,edu.findvideo.dao.TagDao" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
		request.getRequestDispatcher("findvideo2.jsp").forward(request, response);	
	
	 %>
  </head>
  
  <body>
  </body>
</html>
