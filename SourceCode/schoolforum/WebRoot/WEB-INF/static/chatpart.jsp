<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<c:forEach items="${array}" var="reply">
<script type="text/javascript">
$(document).ready(function(){

$("#chat${reply['uid']}U${reply['mid']}").click(function()
	{
		var msg=$("#text${reply['uid']}U${reply['mid']}").val()
		if ($.trim(msg).length==0)
			alert("回复内容不能为空");
		else{
			
			$("#text${reply['uid']}U${reply['mid']}").val("");
			$.ajax({
				type : "post",
				 url : "chatreply",  
			data : 
			  {	
				uid:${reply['uid']},
				data:msg,
				qid:${reply['qid']}
			 },
				 async : false,  
				 success : function(data)
				{
					alert("回复成功");
				}
			});	
		}	
	
	}
	);

});
</script>
</c:forEach> 


  <c:forEach items="${array}" var="reply">
     <div class="panel panel-primary reply-topicmsg">
       <div class="panel-heading tilte-list ">
                  <div class="panel-title replyuser"><span class="glyphicon glyphicon-user"></span>
                  ${reply["username"]}
                  <c:if test="${reply['isread']==0}">
                  <em>&nbsp;&nbsp;&nbsp;&nbsp;[NEW]</em>
				</c:if>
                  <div class="time">${ fn:substringBefore(reply["time"],'.')}</div></div>
         </div>
                <div class="panel-body ">${ reply["msg"]}
                 <div> 
                 <input type="text" value="" maxlength="50" placeholder="请输入回复内容" class="call_title" id="text${reply['uid']}U${reply['mid']}">
                 <input id="chat${reply['uid']}U${reply['mid']}" class="btn btn-call"  value="回复"/>
                 </div>
                </div>
               
  </div>
</c:forEach> 