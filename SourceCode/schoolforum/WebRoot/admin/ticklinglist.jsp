<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:forEach items="${list}" var="tickling">
			   <li class="list-group-item">
			       <span class="time">${tickling["date"]}</span>
			       <div class="ticking_detail">
			          ${tickling["msg"]}
			            </div>
			   </li>
</c:forEach>