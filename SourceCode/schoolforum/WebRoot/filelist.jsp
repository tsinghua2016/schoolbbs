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
               <div class="panel-heading forum-name">
                  <h3 class="panel-title">文件列表</h3>
               		<input type="button" class="btn btn-postmsg mybtn" style="margin-top:-4px;" value="上传" id="post_btn" 
               		 data-toggle="modal"  data-target="${empty sessionScope.user ? '#login' :'#postmsg'  }" />
               </div>
  <c:if test="${ not empty sessionScope.user}">             

<!--文件 上传 -->

<div class="modal fade" id="postmsg" tabindex="-1" role="dialog"  aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content modal-style question" style="height:251px">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               上传文件
            </h4>
         </div>
         <div class="modal-dialog ">
         <form action="upload.action" method="post" enctype="multipart/form-data" >
       <span class="input-list"> <span class="modal-label">请选择需要上传的文件</span>
       <input type="file"  style="margin-left:42px;margin-top:8px;" name="upload"/></span><br/><br/>
               <input type="submit" class="btn  btn-postmsg btn-post" value="上传" />
              </form>
         </div>
         
      </div>
</div>
</div>



</c:if>  

 
       
               <div class="panel-body forumlist"  >
                
                 <div id="forumdata">
                  <!--data-->
    			
 <c:forEach items="${filelist}" var="topic">
 
 
                    <div class="panel panel-primary">
                       <div class="panel-heading tilte-list">                 
                          <div class="glyphicon glyphicon-user topic-user" style="color:#0D76D9">${topic["user"].username}</div>
                          <a class="panel-title" href="download?filename=${topic['filename']}" >${topic["filename"]}</a>
                          <div class="time">${fn:substringBefore(topic["uploadtime"], ".")}</div>
                       </div>
                    </div>   
</c:forEach>


               <!--data end-->
                    </div>
           </div>
               <!--list end-->

            </div>
            <!--end notice-->
            
    </div>
    
    <jsp:include page="/WEB-INF/static/footer.jsp"></jsp:include>
  </body>
</html>
