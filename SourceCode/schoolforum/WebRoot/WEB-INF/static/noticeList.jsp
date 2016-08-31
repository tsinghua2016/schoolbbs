<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:forEach items="${list}" var="notice">
                 <div class="panel panel-primary">
                       <div class="panel-heading tilte-list">
                          <a class="panel-title" data-toggle="collapse" data-target="#demo${notice['id']}" href="javascript:">【通知】${notice["title"]}</a>
                          <span class="time">${fn:substringBefore(notice["date"], ".")}</span>
                       </div>
                       <div class=" panel-body collapse  panel-collapse  out notileMsg" id="demo${notice['id']}">
                          <br/>
                         ${notice["content"]}
                           <br/>
                           <br/>
                       </div>
                    </div>
               
</c:forEach>
     <input type="hidden" value="${page}" id="page" name="page" /> 