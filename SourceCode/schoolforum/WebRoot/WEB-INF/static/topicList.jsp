<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:forEach items="${list}" var="topic">
 
 
                    <div class="panel panel-primary">
                       <div class="panel-heading tilte-list">
                          <span class="reply" title="回复">${topic["reply"]}</span>
                          <a class="panel-title" href="detail?id=${topic['id']}">${topic["title"]}</a>
                          <div class="time">${fn:substringBefore(topic["date"], ".")}</div>
                       </div>
                    </div>   
</c:forEach>
     <input type="hidden" value="${page}" id="page" name="page" /> 