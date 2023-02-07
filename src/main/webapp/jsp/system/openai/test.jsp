<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../../common.jsp"%>
	<title>openai测试</title>
</head>

<body id="body">
	  <input id="askContent" name="askContent" class="easyui-textbox" style="width:90%;height:25px">
      <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:send()">发送</a>

<div id="qaViewDiv" name="qaViewDiv	" style="width: 90%;height:100%;margin-top: 10px;border-style:solid;table-border-color-dark: #929292;word-break: break-all">

</div>
<script>
	var basePath = $("#basePath").val();
	var aiChatUrl = basePath+'/system/psmcAiServiceController.do?method=chat';
	aiChatUrl = '<c:url value="'+aiChatUrl+'"/>';
	var i=0;
	function send(){
		$.messager.progress();
		var sendValue = $('#askContent').textbox("getValue");
		if(sendValue == null || sendValue == ""){
			commonObj.alert("请输出你的提问","warning");
			return;
		}

		$.ajax({
			type: "POST",
			url: aiChatUrl,
			data: "&text="+sendValue,
			async: false,
			success: function(data) {
				$.messager.progress("close");
				try{
					debugger;
					var dt = JSON.parse(data);
					if(dt.res == "fail"){
						commonObj.alert(JSON.parse(dt.rmsg).result.msg,"warning");
					}else{
						$("#qaViewDiv").prepend("Human："+i+","+sendValue+"</br>");
						$('#askContent').textbox("setValue","");
						i++;
						$("#qaViewDiv").prepend("AI："+JSON.parse(dt.rmsg).data+"</br>");
					}
				}catch(err){
					console.error(err.toString());
					commonObj.alert("系统错误,请联系管理员!","error");
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				$.messager.progress("close");
				commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			}
		});
	}

</script>
</body>

</html>