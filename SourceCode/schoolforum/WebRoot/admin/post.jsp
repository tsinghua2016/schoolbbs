<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>校园网后台</title>


    <link href="../a_js_css/bootstrap.css" rel="stylesheet">
    <link href="../a_js_css/dashboard.css" rel="stylesheet">
     <script src="../a_js_css/jquery.js"></script>
    <script src="../a_js_css/data.js"></script>

</head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" >校园网后台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a>${sessionScope.superuser}</a></li>
            <li><a href="adminexit">退出</a></li>
            <li><a>&nbsp;</a></li>
            <li><a>&nbsp;</a></li>
              <li><a>&nbsp;</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            
            <li ><a href="admin">用户反馈</a></li>
            <li class="active"><a href="post" >发布公告</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         	
	         	<div class=" main postdiv" >
	 		<h2 class="sub-header">发布公告</h2>
	    	<div >标题：<br/><input type="text" maxlength="20" placeholder="请输入标题" class="post_title" id="title"> </div>
	    	<div >内容：<br/><div  class="postdetail" contenteditable="true" id="detail"></div></div>
	    	<input id="btn_add" type="submit" class="btn btn-default post_btn"  value="提交"/>

</div>
         	
          </div>
        </div>
      </div>
    </div>
</body>
</html>
