<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<%@ include file="common.jsp"%>
<link rel="stylesheet" href="css/default/login.css" type="text/css" />
<title>登录</title>
</head>

<body>
<form method="post" id="loginForm" onkeydown='on_return()'>
  	<div id="loginDiv" class="loginDiv">
  		<div id="formDiv" class="formDiv">
  			<img src="images/login.jpg"/>	
  			<div class="formInputDiv">
				<p>
					<input class="input" id="username" name="username">
				</p>
				<div class="formPwInputDiv">
					<p>
						<input class="input" id="password" name="password"  type="password">
					</p>
					<div class="formButtonDiv">
						<input id="submitbtn" type="button" value="登录" onclick="loginSubmit();"/>
					</div>
				</div>
			</div>
		</div>  	
  	</div>
</form>
</body>
<script type="text/javascript" src="js/md5.js"></script>
<script>
	//校验用户名
	function validateUserName(){
		if($("#username").val()==""|| $("#username").val()==null){
			commonObj.alert("用户名不能为空!","warning");
			return false;
		}else{
			return true;
		}
			
	}
	//校验密码
	function validateUserPassword(){
		 if($("#password").val()=="" || $("#password").val()==null){
			commonObj.alert("密码不能为空!","warning");
			return false;
		}
		 // 测试，密码长度校验太麻烦，所以注释正式需要放开
		/* else if($("#password").val().length<6){
			commonObj.alert("密码不能小于6位!","warning");
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
    	 $('#password').val(hex_md5($('#password').val()));
 		var _url = "<c:url value='/login'/>";
 		var _data = $("#loginForm").serialize();
 		if(validateLoginInfo()){
 			$.messager.progress(); 
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
 						$.messager.progress('close');
 	 					commonObj.alert(dataObj.msg,"warning");
 					}
 					
 				},
 				error:function (XMLHttpRequest, textStatus, errorThrown) {
 					commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
 				}
 			});
 		}
     }	
	}
	//点击enter 登录
	function on_return(){
		 if(window.event.keyCode == 13){
		  if (document.all('submitbtn')!=null){
		   document.all('submitbtn').click();
		   }
		 }
	}
</script>
</html>
