<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:choose>  
  
   <c:when test="${not empty sessionScope.user}">  
<div id="replyerrmsg" class="alert  alert-warning" role="alert">	</div>
                 <div class="replyedit" id="reply_edit" contenteditable="true"></div>
  	 <span class="input-list"> <span class="modal-label modal-three " >验证码</span>
            <input type="text" value="" class="form-control form-msg form-code" id="replycode" autocomplete="off" maxlength="4"
            placeholder="验证码"/>
            <img id="replyimage" src="" alt="网络不好"/>
            <a href="javascript:void(0)" class="image-change" id="a_reply">换一个</a>
   </span>
                 <input type="submit" class="btn  btn-postmsg btn-reply" value="发布" id="reply_btn"/>
   
   </c:when>
   
    <c:otherwise> 
     <div class="replyedit" id="reply_edit" contenteditable="false">
      <input type="submit" class="btn  btn-postmsg btn-reply reply-not-login" value="请先登录"  data-toggle="modal"  data-target="#login"/>
     </div>
    
    </c:otherwise>
   </c:choose>