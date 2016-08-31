<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="cache-control" content="no-cache">
 <meta http-equiv="expires" content="0">    
    <title>校园动态</title>
   <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/no-response.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/css/forum.css" rel="stylesheet" >
   <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
   <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
   <script src="${pageContext.request.contextPath}/js/jquery.md5.js"></script>
   <script src="${pageContext.request.contextPath}/js/base.js"></script>
   <script src="${pageContext.request.contextPath}/js/data.js"></script>

  </head>
  
  <body>
<jsp:include page="/WEB-INF/static/nav.jsp"></jsp:include>
    <div class="context">
   <jsp:include page="/WEB-INF/static/navlist.jsp" ></jsp:include>
    
    <!--notice start-->
  <div class="panel panel-primary forummain">
               <div class="panel-heading forum-name topic-name">
                <div class="glyphicon glyphicon-user topic-user" >${username}</div>
                  <h3 class="panel-title topic-title">${topic.title}</h3>
                  <div class="time topic-time">${fn:substringBefore(topic.date, ".")}</div>
                 
               </div>

 
       
               <div class="panel-body forumlist"  >
                
                 <div id="forumdata">
                  <!--data-->
                  <div class="panel-body show-detail">${topic.detail}</div>
    			 <jsp:include page="/WEB-INF/static/replylist.jsp"></jsp:include> 
               <!--data end-->
                    </div>
         
 <c:choose>  
  
   <c:when test="${page==0}">  
   	<div class="more" id="morelist">
         <input type="button" class="btn" value="这里空空的" id="loadingbtn" disabled/>
    </div>
   </c:when>  
   <c:otherwise>  
          <div class="more" id="morelist">
            <input type="button" class="btn" value="加载更多" id="addreply" />
             <input type="hidden" class="btn" value="加载中..." id="loadingbtn" disabled/>
         </div>
   </c:otherwise>  
</c:choose>  
 
     <jsp:include page="/WEB-INF/static/replypart.jsp"></jsp:include>  
                 
                 
           </div>
               <!--list end-->

            </div>
            <!--end notice-->
            
    </div>
    
    <jsp:include page="/WEB-INF/static/footer.jsp"></jsp:include>
  </body>
</html>
