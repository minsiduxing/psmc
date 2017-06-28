<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@ include file="common.jsp"%>
<title>系统登录界面</title>
</head>
<body>
	
	<form method="post" id="loginForm" class="easyui-panel" title="用户登录" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:10px">
		<div>用户名:</div>
			<input class="easyui-textbox" id="username" name="username"  style="width:100%;height:40px;padding:12px" data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
		<div>密码:</div>
			<input class="easyui-textbox" id="password" name="password"  type="password" style="width:100%;height:40px;padding:12px"  data-options="prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div  id="msg" style="margin-bottom:20px;color:#d64242;font-size: small;display:none;">
		</div>
		<div>
			<input type=button  class="easyui-linkbutton" onclick=" loginSubmit()" style="padding:5px 0px;width:100%;" value="登录"/>
		</div>
	</form>
</body>
<script type="text/javascript" src="js/md5.js"></script>
<script>
	$(function(){
		recalc();
		$(window).resize(function(){
			recalc();
		});
		//由于easyui-textbox 不触发blur事件所以在此重新绑定
		$("input",$("#username").next("span")).blur(function(){  
			validateUserName();
		}) 
		//由于easyui-textbox 不触发blur事件所以在此重新绑定
		$("input",$("#password").next("span")).blur(function(){  
			validateUserPassword();
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
	//校验用户名
	function validateUserName(){
		if($("#username").val()==""|| $("#username").val()==null){
			$("#msg").css("display","block");
			$("#msg").text("用户名不能为空！");
			return false;
		}else{
			return true;
		}
			
	}
	//校验密码
	function validateUserPassword(){
		 if($("#password").val()=="" || $("#password").val()==null){
			$("#msg").css("display","block");
			$("#msg").text("密码不能为空！");
			return false;
		}
		 // 测试，密码长度校验太麻烦，所以注释正式需要放开
		/* else if($("#password").val().length<6){
			$("#msg").css("display","block");
			$("#msg").text("密码不能小于6位！");
			return false;
		} */
		else{
			return true;
		}
	}
	//登录校验
	function validateLoginInfo (){
		if(validateUserName() && validateUserPassword()){
			return true;
		}
		return false;
	}
	//用户登录
	function loginSubmit(){
		//密码md5加密
     if(validateLoginInfo()){
    	 $('#password').textbox('setValue',hex_md5($('#password').textbox('getValue')));
 		var _url = "<c:url value='/login'/>";
 		var _data = $("#loginForm").serialize();
 		if(validateLoginInfo()){
 			$.ajax({
 				async:false,
 				cache:false,
 				type:'POST',
 				dataType:"text",
 				data:_data,
 				url:_url,
 				success:function(data){
 					var dataObj = JSON.parse(data);
 					if(dataObj.msg =="success"){
 						window.location.href="<c:url value='/jsp/loginTransfer.jsp'/>";
 					}else{
 						$("#msg").css("display","block");
 						$("#msg").text(dataObj.msg);
 					}
 					
 				},
 				error:function (XMLHttpRequest, textStatus, errorThrown) {
 					commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
 				}
 			});
 		}
     }	
	}
	
</script>
</html>
