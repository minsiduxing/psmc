<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<html>
<head>
<title>用户修改密码界面</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/authentication/loginController.do?method=autUpdatePasswdOperate" class="easyui-panel" title="修改密码" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:20px">
		<div>原密码:</div>
			<input class="easyui-textbox" id="oldPassword" name="oldPassword" type="password" missingMessage="请输入旧密码" style="width:100%;height:40px;padding:12px"  data-options="required:true,validType:'length[1,20]',prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
		<div>新密码:</div>
			<input class="easyui-textbox" id="newPassword" name="newPassword" type="password" missingMessage="请输入新密码" style="width:100%;height:40px;padding:12px"  data-options="required:true,validType:'length[1,20]',prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
		<div>确认密码:</div>
			<input class="easyui-textbox" id="renewPassword" name="renewPassword" type="password" style="width:100%;height:40px;padding:12px"  data-options="prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px;color:#d64242;font-size: small;">
		</div>
		<div>
			<input type="submit" id="submit" class="easyui-linkbutton" style="padding:5px 0px;width:100%;" value="确定修改" onclick="convertMd5();"/>
		</div>
	</form>
</body>
<script type="text/javascript" src="../js/md5.js"></script>
<script>
var msg = '${msg}';
var url = "<%=request.getContextPath()%>"+"/logOut";
	$(function(){
		recalc();
		$(window).resize(function(){
			recalc();
		});
		if(msg=='0'){
			$.messager.confirm('提示', '修改成功，您需要重新登录!', function(r){
				if (r){
					parent.window.location = url;
				}
				parent.window.location = url;
			});
		}
		if(msg=='1'){
			$.messager.alert('提示','修改失败，原密码错误，请确认您的正确原密码!');
		}
		if(msg=='2'){
			$.messager.confirm('提示', '修改失败，输入不合法数据，系统退出!', function(r){
				if (r){
					parent.window.location = url;
				}
				parent.window.location = url;
			});
		}
		$("input",$("#renewPassword").next("span")).blur(function(){  
			checkNewPassword();
		}) 
	});
	
	function recalc(){
		var formH = $(".panel").height();
		var formW = $(".panel").width();
		var documentH = $(document).height();
		var documentW = $(document).width();
		
		$(".panel").css({
			position:'absolute', 
			top:(documentH - formH)/2+"px",
			left:(documentW - formW)/2+"px"
		});
	}
	
	//密码md5加密
	function convertMd5(){
		$('#oldPassword').textbox('setValue',hex_md5($('#oldPassword').textbox('getValue')));
		$('#newPassword').textbox('setValue',hex_md5($('#newPassword').textbox('getValue')));
		$('#renewPassword').textbox('setValue',hex_md5($('#renewPassword').textbox('getValue')));
	}
	//判断两次输入密码是否一致
	function checkNewPassword(){
		var newPassword = $.trim($("#newPassword").val());
		var reNewPassword = $.trim($("#renewPassword").val());
		if(reNewPassword != null && reNewPassword.length> 0){
			if(newPassword != reNewPassword){
				$.messager.alert('提示','两次输入的密码不一致，请重新输入!');
				//清空输入框的值
				$("#renewPassword").val('');
			}
		}else{
			$.messager.alert('提示','输入值为空，请重新输入!');
		}
		
	}
</script>
</html>