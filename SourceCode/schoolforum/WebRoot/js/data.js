   $(document).ready(function(){
		function checkcodechange(theid)
		{
			$("#"+theid).attr("src","createImageAction?id="+Math.random()*10000);
		}	
	   $("#a_ask").click(function(){checkcodechange("askimage")});
	   $("#askimage").click(function(){checkcodechange("askimage")});
	   $("#post_btn").click(function(){checkcodechange("askimage")});
	   
	 $("#addnotice").click(function()
	 {
		var page= $("#page").attr("value")
		 $("#page").remove();
		 $("#addnotice").attr("type","hidden");
			$("#loadingbtn").attr("type","button");
			var html="加载中";
			$.ajax({
				type : "post",
				 url : "getnoticelist",  
			data : 
			  {	
				page:page
			 },
				 async : true,  
				 success : function(data)
				{
					if(data=="0") 
					{
						$("#loadingbtn").attr("value","没有更多了");
						$("#loadingbtn").attr("type","button");
					}
					else 
					{
						$("#noticedata").append(data);
						$("#loadingbtn").attr("type","hidden");
						$("#addnotice").attr("type","button");
					}
					
				}
			});	
	});
	 



$("#addforum").click(function()
	 {
		var page= $("#page").attr("value")
		 $("#page").remove();
		 $("#addforum").attr("type","hidden");
			$("#loadingbtn").attr("type","button");
			var html="加载中";
			
			$.ajax({
				type : "post",
				 url : "gettopiclist",  
			data : 
			  {	
				page:page
			 },
				 async : true,  
				 success : function(data)
				{
					if(data=="0") 
					{
						$("#loadingbtn").attr("value","没有更多了");
						$("#loadingbtn").attr("type","button");
					}
					else 
					{
						$("#forumdata").append(data);
						$("#loadingbtn").attr("type","hidden");
						$("#addforum").attr("type","button");
					}
					
				}
			});	
	});




	 $("#askerr").hide();
	 $("#ask_btn").click( function(){
		
		 var err=$("#askerr");
		 var msg="";
		 var flag=false;
		 var title;
		 var detail;
		 err.empty();
		
		 if($.trim($("#topictitle").val()).length==0){msg="问题名称不能为空";}
		 else if($.trim($("#thedetail").text()).length<10)
		 {
			msg="请填写问题描述,不低于十个字";
		 }
		 else if($("#askcode").val()==0){msg="请输入验证码"}
		 else{flag=true;
		 title=$.trim($("#topictitle").val());
		 detail=$.trim($("#thedetail").html()).replace(/<br>/g,"\n");
		 }
		
		if(!flag) {err.append(msg);err.show();}
		
		else $.ajax({
				type : "post",
				 url : "do/addtopic",  
			data : 
			  {	
				title:title,
				detail:detail,
				imagecode:$("#askcode").val()
			 },
				 async : false,  
				 success : function(data)
				{
					data=eval('('+data+')');
					data=data.status;
					if(data=="ok") 
					{
						window.location="forum";
					}
					else 
					{
						err.append(data);
						err.show();
						checkcodechange("askimage");
					}
					
				}
			});	
		 
	 });


	 $("#addsearch").click(function()
	 	 {
	 		var page= $("#page").attr("value")
	 		 $("#page").remove();
	 		 $("#addsearch").attr("type","hidden");
	 			$("#loadingbtn").attr("type","button");
	 			var html="加载中";
	 			var Request = new Object();  
	 			Request = GetRequest();
	 			$.ajax({
	 				type : "post",
	 				 url : "getsearch",  
	 			data : 
	 			  {	
	 				page:page,
	 				searchmsg:$("#thesearchmsg").html()
	 			 },
	 				 async : true,  
	 				 success : function(data)
	 				{
	 					if(data=="0") 
	 					{
	 						$("#loadingbtn").attr("value","没有更多了");
	 						$("#loadingbtn").attr("type","button");
	 					}
	 					else 
	 					{
	 						$("#forumdata").append(data);
	 						$("#loadingbtn").attr("type","hidden");
	 						$("#addsearch").attr("type","button");
	 					}
	 					
	 				}
	 			});	
	 	});
	 
	 $("#replyerrmsg").hide();
	 checkcodechange("replyimage");
	 $("#replyimage").click(function(){checkcodechange("replyimage")});
	 $("#a_reply").click(function(){checkcodechange("replyimage");});
	 $("#reply_btn").click(function()
	 {
		 var replymsg;
		 var msg;
		 var err=$("#replyerrmsg");
		 var flag=false;
		 $("#replyerrmsg").empty();
		 if($.trim($("#reply_edit").text()).length<6){msg="回复内容不能为空，且不小于6个字";}
		 else if($("#replycode").val().length==0) {msg="验证码不能为空";}
		 else flag=true;
		 if(flag)
		 {
			 replymsg=$.trim($("#reply_edit").html()).replace(/<br>/g,"\n");
		 			var Request = new Object();  
		 			Request = GetRequest();
		 			$.ajax({
					 	type : "post",
					 	 url : "do/addreply",  
					 	 data : 
					 	 {	
					 		imagecode:$("#replycode").val(),
					 		msg:replymsg,
					 		id:Request['id']
					 	 },
					 	 async : false,  
					 	 success : function(data)
					 	 {
					 		 data=eval('('+data+')');
					 		 data=data.status;
					 		if(data=="ok") 
					 		{
					 			window.location=window.location.href;
					 		}
					 		else 
					 		{
					 			err.append(data);	
					 			err.show();
					 			checkcodechange("replyimage");
					 		}
					 					
					 	 }
					 });
		 		}
			else {
				err.append(msg);	
				err.show();
			}
		 	 
	});
			 
	 
	 
	 
	 
	 $("#addreply").click(function()
		{
	 		var page= $("#page").attr("value")
	 		 $("#page").remove();
	 		 $("#addreply").attr("type","hidden");
	 			$("#loadingbtn").attr("type","button");
	 			var html="加载中";
	 			var Request = new Object();  
	 			Request = GetRequest();
	 			$.ajax({
	 				type : "post",
	 				 url : "getmorereply",  
	 			data : 
	 			  {	
	 				page:page,
	 				id:Request['id']
	 			 },
	 				 async : true,  
	 				 success : function(data)
	 				{
	 					if(data=="0") 
	 					{
	 						$("#loadingbtn").attr("value","没有更多了");
	 						$("#loadingbtn").attr("type","button");
	 					}
	 					else 
	 					{
	 						$("#forumdata").append(data);
	 						$("#loadingbtn").attr("type","hidden");
	 						$("#addreply").attr("type","button");
	 					}
	 					
	 				}
	 			});	
			 
		});
	 
   });
   

   function GetRequest() {  
	    var url = location.search; 
	    var theRequest = new Object();  
	    if(url.indexOf("?") != -1)
	    {   
	      var str = url.substr(1);  
	        strs = str.split("&");  
	      for(var i = 0; i < strs.length; i ++)  
	        {   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);  
	        }  
	    }  
	    return theRequest;  
	} 
 