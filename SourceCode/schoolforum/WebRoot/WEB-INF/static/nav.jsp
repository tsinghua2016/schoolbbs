<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container" >
<ul class="nav navbar-nav navbar-right">
<li >
<form action="search" method="post">
<input type="text" placeholder="查找帖子"  id="searchinput" name="searchmsg" maxlength="15"/>
<Button type="submit" class="glyphicon glyphicon-search btn_search" id="search"/>
</form>
</li>

<c:choose>  
  
   <c:when test="${empty sessionScope.user}">  
   	<li><a href="javascript:" data-toggle="modal"  data-target="#login" id="modal_login">登录</a></li>
	<li><a href="javascript:" data-toggle="modal"  data-target="#register" id="modal_register">注册账号</a></li>
   </c:when>  
   <c:otherwise>  
   <li><a>${sessionScope.user}</a></li>
   <li><a href="msg">消息(${sessionScope.msgnum})</a></li>
   <li><a href="javascript:" id="userexit">退出</a></li>
   </c:otherwise>  
</c:choose>  
</ul>
<div class="navbar-header"> 
<a class="navbar-brand" href="index">校园网</a>
</div>
</div>
</nav>
<c:if test="${empty sessionScope.user}">
<jsp:include page="/WEB-INF/static/modal.jsp"></jsp:include>
</c:if>

