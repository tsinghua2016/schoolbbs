<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<footer class="container">
<span>版权所有:<a href="http://www.fjnufq.edu.cn/" target="_blank">福建师范大学福清分校</a></span>
<span>地址：福建省福清市龙江街道校园新村1号</span>
<span>邮编：350300</span>
<span>联系电话：0591-85222439﻿</span>
<span><a href="javascript:" data-toggle="modal"  data-target="#tickling" id="open_tickling">反馈</a></span>
</footer>
<div class="modal fade" id="tickling" tabindex="-1" role="dialog"  aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content modal-style ticklingtype">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
             反馈
            </h4>
         </div>
         <div id="ticklingerr" class="alert  alert-warning" role="alert">	</div>
         <div class="modal-dialog ">
         <form action="javascript:void(0)" method="post" >    
		<span class="input-list">  <span class="modal-label">问题说明:</span>
         <div contenteditable="true" class="editdetail" id="ticklingmsg"></div>
          <span class="input-list"> <span class="modal-label modal-three " >验证码</span>
            <input type="text" value="" class="form-control form-msg form-code" name="imagecode"  autocomplete="off" maxlength="4"
            placeholder="验证码" id="tickling_code_input"/>
            <img  src="" alt="网络不好" id="tickling_code"/>
            <a href="javascript:void(0)" class="image-change" id="tickling_another">换一个</a>
            </span>
        </span>
               <input type="submit" class="btn  btn-postmsg btn-tickling" value="提交" id="tickling_btn"/>
              </form>
         </div>
         
      </div>
</div>
</div>