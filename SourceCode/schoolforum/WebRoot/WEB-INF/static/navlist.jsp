<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


    <div class="panel-body navlist">
     <div class="panel-heading menu-name">
	服务导航
    </div>
    <div class="panel-heading">
	<a href="http://www.fjnufq.edu.cn/" target="_blank">校园官网</a>
    </div>
   <div class="panel-heading">
    <a href="notice"> 校园动态</a>
    </div>
     <div class="panel-heading">
    <a href="forum">校内论坛</a>
    </div>
    <div class="panel-heading">
    <a href="map.jsp">校园地图</a>
    </div>
        <div class="panel-heading">
    <a href="filelist">文件分享</a>
    </div>
    </div>
 