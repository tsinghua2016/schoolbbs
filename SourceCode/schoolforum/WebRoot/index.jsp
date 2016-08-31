<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>欢迎来到校园网</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/no-response.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/css/index_extend.css" rel="stylesheet" >
   <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
   <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
   <script src="${pageContext.request.contextPath}/js/jquery.md5.js"></script>
   <script src="${pageContext.request.contextPath}/js/base.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/static/nav.jsp"></jsp:include>
<!-- 导航结束-->


<div class="context">
	<div class="schoolpanel">
        <div class="school">
        <div class="schoolTitle">福建师范大学福清分校<br/><br/>Fuqing branch of fujian normal university</div>
            <div class="schoolMsg">
            坐落于全国著名侨乡、“文献名邦”——福清市。地处省会中心城市福州、综合实验区平潭主干线中枢位置。是省属全额拨款
             的全民制事业单位。
            </div>
           <a class="glyphicon glyphicon-tag btn btn-style" href="http://www.fjnufq.edu.cn/" target="_blank">&nbsp;访问官网</a>
        </div>
      </div>
      <!--notice-->
      
<div class="spinner">
  <div class="rect1"></div>
  <div class="rect2"></div>
  <div class="rect3"></div>
  <div class="rect4"></div>
  <div class="rect5"></div>
</div>

  
        <div class="noticepanel">
          <div class="noticeTitle">校园动态</div>
       	  <div class="notice">
            		<div class="noticeMsg">
                    学校最近又发什么福利了没有?有没有我的份...<br/>
                    社团要举办些什么好玩的活动，时间地点，有抽奖不？奖品丰盛不？<br/>
                    我想报的考试（或者竞赛）什么时候可以报名?学校什么时候安排报名？<br/>
                     <a class="glyphicon glyphicon-eye-open btn btn-style" href="notice" >&nbsp;我来瞄两眼</a>       		      
                   </div>
        	</div>
   			</div>
		
      
      <!--话题板块-->
      <div class="spinner">
  <div class="rect1"></div>
  <div class="rect2"></div>
  <div class="rect3"></div>
  <div class="rect4"></div>
  <div class="rect5"></div>
</div>

              <div class="forumpanel">
       	  <div class="forum">
          <div class="forumTitle">校园论坛</div>
            		<div class="forumMsg">
                   以兴趣主题聚合志同道合者的互动平台，同好网友聚集在这里交流话题、展示自我、结交朋友<br/>
                
                <a class="btn btn-style" href="forum" >最近大家都在聊什么</a>       		       </div>
        	</div>
   			</div>
		</div>
 </div>



      <div class="spinner">
  <div class="rect1"></div>
  <div class="rect2"></div>
  <div class="rect3"></div>
  <div class="rect4"></div>
  <div class="rect5"></div>
</div>
<!--尾部-->

<jsp:include page="/WEB-INF/static/footer.jsp"></jsp:include>
</body>
</html>
