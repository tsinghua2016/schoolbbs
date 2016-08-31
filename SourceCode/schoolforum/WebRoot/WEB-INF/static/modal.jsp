<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- login modal -->
<div class="modal fade" id="login" role="dialog"  aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content modal-style">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               登录
            </h4>
         </div>
	<div id="loginerrmsg" class="alert  alert-warning" role="alert">	</div>

        
         <div class="modal-dialog">
         <form action="javascript:void(0)" method="post" id="loginform">
       <span class="input-list"> <span class="modal-label">账号</span><input type="email" class="form-control form-msg" name="email" id="lusername" 
         	placeholder="注册时的邮箱地址" maxlength="20"/></span><br/><br/>
<span class="input-list">  <span class="modal-label">密码</span><input type="password" class="form-control form-msg" name="password" id="lpassword" maxlength="16"
         	placeholder="密码"/></span><br/><br/>
           
            <span class="input-list"> <span class="modal-label modal-three " >验证码</span>
            <input type="text" value="" class="form-control form-msg form-code" name="imagecode" id="lcode" autocomplete="off" maxlength="4"
            placeholder="验证码"/>
            <img id="loginimage" src="" alt="网络不好"/>
            <a href="javascript:void(0)" class="image-change" id="a_login">换一个</a>
            </span><br/>
              <div class="modal-other" ><input type="checkbox" style=" margin-right:10px" id="rember"/>下次自动登录</div><br/>
               <input type="submit" class="btn  btn-submit" value="登录" id="login_btn"/>
              </form>
         </div>
         
         <div class="modal-footer">
           
         </div>
         
      </div>
</div>
</div>
<!-- login end -->

<!--register start-->
<div class="modal fade" id="register"  role="dialog"  aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content modal-style modal-register">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
              注册
            </h4>
         </div>
	<div id="registererrmsg" class="alert  alert-warning" role="alert"></div>
	
         <form action="javascript:void(0)" method="post">
         <div class="modal-dialog">
         
       <span class="input-list"> <span class="modal-label modal-three" >用户名</span><input type="text" class="form-control form-msg" name="username" id="rusername" autocomplete="off" maxlength="8"
         	placeholder="用户名"/></span><br/><br/>
                       <span class="input-list">  <span class="modal-label">邮箱</span><input type="email" class="form-control form-msg" name="email" id="email" placeholder="邮箱地址 -- 这将是你的账号" autocomplete="off"maxlength="20" /></span><br/><br/>
<span class="input-list">  <span class="modal-label">密码</span><input type="password" class="form-control form-msg" name="password" id="rpassword"
         	placeholder="密码" autocomplete="off" maxlength="16"/></span><br/><br/>
             
             <span class="input-list">  <span class="modal-label sure">确认密码</span><input type="password" class="form-control form-msg" id="surepasswd"
         	placeholder="确认密码" autocomplete="off" maxlength="16"/></span><br/><br/>

            <span class="input-list"> <span class="modal-label modal-three " >验证码</span>
            <input type="text" value="" class="form-control form-msg form-code" name="imagecode" id="rcode" autocomplete="off"
            placeholder="验证码" maxlength="4"/>
            <img id="registerimage" src="" alt="网络不好"/>
            <a href="javascript:void(0)" class="image-change" id="a_register">换一个</a>
            </span><br/>
               <input type="submit" class="btn  btn-submit" value="注册" id="register_btn"/>
         </div>
         </form>
         <div class="modal-footer">
         </div>
         
      </div>
</div>

</div>
<!--register end--->