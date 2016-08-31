<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <div class="modal fade" id="postmsg" tabindex="-1" role="dialog"  aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content modal-style question">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               提问
            </h4>
         </div>
         <div id="askerr" class="alert  alert-warning" role="alert">	</div>
         <div class="modal-dialog ">
         <form action="javascript:void(0)" method="post" >
       <span class="input-list"> <span class="modal-label">问题名称:</span><br/><input type="text" class="form-control form-msg"  id="topictitle"
         	placeholder="你想问什么" maxlength="28"/></span><br/><br/>
		<span class="input-list">  <span class="modal-label">问题说明:</span>
         <div contenteditable="true" class="editdetail" id="thedetail"></div>
        </span>
          <span class="input-list"> <span class="modal-label modal-three " >验证码</span>
            <input type="text" value="" class="form-control form-msg form-code"  id="askcode" autocomplete="off" maxlength="4"
            placeholder="验证码"/>
            <img id="askimage" src="" alt="网络不好"/>
            <a href="javascript:void(0)" class="image-change" id="a_ask">换一个</a>
            </span><br/>
               <input type="submit" class="btn  btn-postmsg btn-post" value="发布" id="ask_btn"/>
              </form>
         </div>
         
      </div>
</div>
</div>