<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
   <title>登录</title>
   <link href="../a_js_css/bootstrap.css" rel="stylesheet">
   <link href="../a_js_css/no-response.css" rel="stylesheet">
    <link href="../a_js_css/login.css" rel="stylesheet">
   <script src="../a_js_css/jquery.js"></script>
   <script src="../a_js_css/bootstrap.js"></script>
</head>

<body  background="1.jpg" class="style2">
<div style="width:250px;margin:20% auto;font-size:16px;" >
<form action="login" method="post">
用户名：<input type="text" class="form-control style1 " style="width:100%;height:30px;"name="user"  placeholder="请输入用户名">
密码 ：<input type="password" style="width:100%;height:30px;"  class="form-control style1" name="pass"  placeholder="请输入密码"><br/>
<input type="submit" class="btn btn-default" style="float:right;width:100%" value="登录"/>
</form>
</div>
</body>
</html>			