<%--
    Document   : articleDetail
    Created on : 2012-3-27, 12:30:28
    Author     : Administrator
--%>

<%@page import="edu.findvideo.util.GrammaUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/style.css" />
        <title>视频语料库</title>
    </head>
    <%
                ArrayList<GrammaUtil> grammas = (ArrayList) request.getAttribute("grammas");
    %>
    <style type="text/css">
        .wordLine{
            width: 900px;
            list-style: none;
        }
        .wordItem{
            float: left;
            margin-top: 5px;
            margin-left: 1px;
        }
        table{
            border: solid 1px;
        }
        table td{
            border-top: solid 1px;
        }
    </style>
    <body>
        <div id="main_content">
            <div id="top_banner">
                <div id="top_banner">
                    <div id="top_title">FindVideo</div>
                </div>

            </div>

            <div id="page_content">
                
                <br /><br /><br />
                <div id="left_section2">
                    <div class="title" style="font-family:'微软雅黑'">
						分 词 结 果
                        <div class="line_style">
                        </div>
                    </div>


                    <div class="text_content_result" style="font-family:'微软雅黑'; font-size:14px; color:#000000">
                        <div>
                            <ul class="wordLine">
                                <%
                                    for(int i = 0;i<grammas.size();i++){
                                %>
                                <li class="wordItem">
                                        <%=grammas.get(i).getSurface()%>
                                </li>
                                <%
                                    }
                                %>
                            </ul>
                        </div>
                            <br/>
                            <br/>
                            <br/>
                            <br/>
                            <hr/>
                        <div>
                            <ul class="wordLine">
                                <%
                                    for(int i = 0;i<grammas.size();i++){
                                %>
                                <li class="wordItem">
                                    <table align="center" cellpadding="5" cellspacing="1" >
                                        <tr><td><%=grammas.get(i).getSurface()%></td></tr>
                                        <tr><td><%=grammas.get(i).getProperty()%></td></tr>
                                    </table>
                                </li>
                                <%
                                    }
                                %>
                            </ul>
                        </div>
                    </div>

                </div>
                <div class="clear"></div>
            </div>
         
        </div>
    </body>
</html>
