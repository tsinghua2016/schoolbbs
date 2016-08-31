   $(document).ready(function(){

	 $("#btn_add").click(function()
	 {

		 if ($.trim($("#detail").text()).length==0)
		 alert("内容不能为空");
		 else if ($.trim($("#title").val()).length==0)
			 alert("标题不能为空 "); 
		else {
			
			var detailmsg=$("#detail").html().replace(/<br>/g,"\n")
			$.ajax({
				type : "post",
				 url : "addnotice",  
			data : 
			  {	
				title:$.trim($("#title").val()),
				detail: detailmsg
			 },
				 async : false,  
				 success : function(data)
				{
					 alert("发布成功!");
					
				}
			});	
		}
			return false;
	});
	 
	$.ajax({
			type : "post",
			 url : "gettickling",  
		data : 
		  {	
			
		 },
			 async : false,  
			 success : function(data)
			{
					 $("#data").append(data);
			
			}
		});	


	 
   });
   