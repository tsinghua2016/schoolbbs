<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:forEach items="${list}" var="reply">
     <div class="panel panel-primary reply-topicmsg">
       <div class="panel-heading tilte-list ">
                  <div class="panel-title replyuser"><span class="glyphicon glyphicon-user"></span>
                  ${reply["username"]}
                  <div class="time">${ fn:substringBefore(reply["date"],'.')}</div></div>
         </div>
                <div class="panel-body ">${ reply["replymsg"]}</div>
  </div>
</c:forEach>
     <input type="hidden" value="${page}" id="page" name="page" /> 