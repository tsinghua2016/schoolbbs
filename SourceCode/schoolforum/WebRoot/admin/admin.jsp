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
            
            <li class="active"><a href="ticking" >用户反馈</a></li>
            <li><a href="post" >发布公告</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         	
         	<div class=" main" >
			 <h2 class="sub-header">用户反馈</h2>
			<ul class="list-group" >
			<div id="data"></div>
			</ul>
			</div>
         	
          </div>
        </div>
      </div>
    </div>
</body>
</html>