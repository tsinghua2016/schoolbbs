<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传成功</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/404/404.css" />
</head>

<body >

<body >
    <div class="image" style="text-align:center;height:140px">上传成功
    </div>
    <div >
    <a href="javascript:history.go(-1);" class="back">返回上一页</a>
    <a href="index" class="index">返回主页</a>
    </div>
</body>
</body>
</html>
