<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <div class="more" id="morelist">
     <input type="button" class="btn" value="这里空空的" id="loadingbtn" disabled/>
</div>