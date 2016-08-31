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
	<link href="${pageContext.request.contextPath}/css/chat.css" rel="stylesheet" >
   <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
   <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
   <script src="${pageContext.request.contextPath}/js/jquery.md5.js"></script>
   <script src="${pageContext.request.contextPath}/js/base.js"></script>

  </head>
  
  <body>
<jsp:include page="/WEB-INF/static/nav.jsp"></jsp:include>
    <div class="context">
   <jsp:include page="/WEB-INF/static/navlist.jsp" ></jsp:include>
    
    <!--notice start-->
  <div class="panel panel-primary forummain">
               <div class="panel-heading forum-name topic-name chattile">消息记录
               </div>
               <div class="panel-body forumlist"  >
                
                 <div id="forumdata">
                  <!--data-->
    			 <jsp:include page="/WEB-INF/static/chatpart.jsp"></jsp:include> 
               <!--data end-->
                    </div>

   <c:if test="${page==0}">  
   	<div class="more" id="morelist">
         <input type="button" class="btn" value="这里空空的" id="loadingbtn" disabled/>
    </div>
   </c:if>  


 
                 
                 
           </div>
               <!--list end-->

            </div>
            <!--end notice-->
            
    </div>
    
    <jsp:include page="/WEB-INF/static/footer.jsp"></jsp:include>
  </body>
</html>
