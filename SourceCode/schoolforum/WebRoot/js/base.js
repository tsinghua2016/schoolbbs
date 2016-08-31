window.onload = function() {
if (!window.applicationCache) {
                alert("你的浏览器不支持HTML5,请使用其他浏览器以提高使用体验，比如火狐浏览器,谷歌浏览器等");
  } 
 }
 
   $(document).ready(function(){
	   $('.carousel').carousel({
 						interval: 2000
			});
			
		function checkcodechange(theid)
		{
			$("#"+theid).attr("src","createImageAction?id="+Math.random()*10000);
		}	
		checkcodechange("loginimage");
	    $("#loginerrmsg").hide();
		$("#registererrmsg").hide();
		
	    $("#modal_register").click(function() {
		    $("#registerimage").attr("src","createImageAction?id="+Math.random()*1000);
			$("#registererrmsg").hide().empty();
			});
	    $("#a_register").click(function() {checkcodechange("registerimage");});
		 $("#registerimage").click(function() {checkcodechange("registerimage");});
			
			
			
	    $("#a_login").click(function() { checkcodechange("loginimage");});

	    $("#modal_login").click(function() {
		   checkcodechange("loginimage");
			$("#loginerrmsg").hide().empty();
			});
	    $("#loginimage").click(function() { checkcodechange("loginimage");});
		
		
		
	$("#login_btn").click(function()
	{
		
		var err=$("#loginerrmsg");
		err.hide();
		err.empty();
		var flag=false;
		var msg="";
		if($("#lusername").val().length==0)
		{
			msg="请输入账号--你的邮箱地址";	  
		}
		else if($("#lpassword").val().length==0)
		{
			msg="请输入密码";
		}
		else if($("#lcode").val().length==0)
		{
			msg="请输入验证码";
		}
		else
		{
			flag=true;
		}
		if(!flag)
		{
			err.append(msg);
			err.show();
		}
		else
		{
			flag=false;
			var rember=false;
			if(document.getElementById("rember").checked) rember=true;
			
		$.ajax({
			type : "post",
			 url : "check/logincheck",  
		data : 
		  {	
			email:$("#lusername").val(),
			password:$.md5($("#lpassword").val()),
			imagecode:$("#lcode").val(),
			rember:rember
		 },
			 async : false,  
			 success : function(data)
			{
				data=eval('('+data+')');
				data=data.status;
				if(data=="ok") 
				{
					flag=true;
					window.location.href=window.location.href;
				}
				else 
				{
					$("#loginerrmsg").append(data);
					$("#loginerrmsg").show();
					checkcodechange("loginimage");
				}
				
			}
		});
		}
		
		return flag;
		}
	);

	$("#register_btn").click(function()
	{
		var err=$("#registererrmsg");
		err.hide();
		err.empty();
		var flag=false;
		var msg="";
		
		if($("#rusername").val().length==0)
		{
			msg="请输入用户名";

		}
		else if($("#email").val().length==0)
		{
			msg="请输入邮箱地址";
		}
		else if($("#rpassword").val().length==0)
		{
			msg="请输入密码";
	
		}
		else if($("#rpassword").val().length<6)
		{
			msg="密码至少要6位";
		}
		else if($("#rpassword").val()!=$("#surepasswd").val())
		{
			msg="两次输入的密码不一致";
	
		}
		else if($("#rcode").val().length==0)
		{
			msg="请输入验证码";
		}
		else 
		{
			flag=true;
		}
		if(!flag)
		{
			err.append(msg);
			err.show();
		}
		else
		{
			flag=false;
			$.ajax({
				type : "post",
				 url : "check/registercheck",  
			data : 
			  {	
			    username:$("#rusername").val(),
				email:$("#email").val(),
				password:$.md5($("#rpassword").val()),
				imagecode:$("#rcode").val()
			 },
				 async : false,  
				 success : function(data)
				{
					data=eval('('+data+')');
					data=data.status;
					if(data=="ok") 
					{
						flag=true;
						window.location.href=window.location.href;
					}
					else 
					{
						$("#registererrmsg").append(data);
						$("#registererrmsg").show();
						checkcodechange("registerimage");
					}
					
				}
			});
		}
		return flag;
	}
	);


	$("#userexit").click(
		function()
		{
			$.ajax({
				type : "post",
				 url : "userexit",  
			data : 
			  {	

			 },
				 async : false,  
				 success : function(data)
				{
						window.location.href=window.location.href;
				}
			});
		}
	);


	$("#searchinput").focus(
		function()
		{
			$("#searchinput").css("background-color","#FFF");
		}
	);
		$("#searchinput").blur(
		function()
		{
			$("#searchinput").css("background-color","#565656");
		}
	);
		$("#open_tickling").click(function(){checkcodechange("tickling_code");});
		$("#tickling_code").click(function(){checkcodechange("tickling_code");});
		$("#tickling_another").click(function(){checkcodechange("tickling_code");});
	//用户反馈
		$("#tickling_btn").click(function()
		{
			var msg="";
			var err=$("#ticklingerr");
			err.empty();
			
			if($.trim($("#ticklingmsg").text()).length<10)
			{
				msg="请输入问题描述,不低于十个字";
				$("#ticklingerr").append(msg);
			}
			else if($("#tickling_code_input").val()==0)
				{
					$("#ticklingerr").append("请输入验证码");
				}
			else	
			{
				msg=$.trim($("#ticklingmsg").text());
				$.ajax({
					type : "post",
					 url : "do/addtickling",  
				data : 
				  {	
					msg:msg,
					imagecode:$("#tickling_code_input").val()
				},
					 async : false,  
					 success : function(data)
					{
						data=eval('('+data+')');
						data=data.status;
						if(data=="ok") 
						{
							alert("谢谢您的支持!");
							window.location.href=window.location.href;
						}
						else 
						{
							err.append(data);
							checkcodechange("tickling_code");
						}
						
					}
				});	
			}
			
		});
	$("#search").click(function()
			{
				return $.trim($("#searchinput").val())!=0;
			});
});