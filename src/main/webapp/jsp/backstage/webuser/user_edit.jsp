<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>用户编辑页面</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">
<input type="hidden" id="uuid" name="uuid" value="<c:out value="${user.uuid}"/>"></input>
<input type="hidden" id="password" name="password" value="<c:out value="${user.password}"/>"></input>
		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label">用户账号：</label>
				<input class="myinput" id="userId" name="userId"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">用户姓名：</label>
				<input class="myinput" id="userName" name="userName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">身份证号：</label>
				<input class="myinput" id="idCard" name="idCard"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">手机号码：</label>
				<input class="myinput" id="phone" name="phone"></input>
			</li>
		</ul>
	</form>
<script type="text/javascript">
	var basePath = $("#basePath").val();
	var oper = "${oper}";
	$(document).ready(
		function() {
			$('#userId').textbox({
				value : "${user.user_id}",
				type : "text",
				required : true
			});
			
			$('#userName').textbox({
				value : "${user.user_name}",
				type : "text",
				required : true
			});
			
			$('#idCard').textbox({
				value : "${user.id_card}",
				type : "text",
				required : true
			});
			
			$('#phone').textbox({
				value : "${user.phone}",
				type : "text",
				required : true
			});
			
			var oper = "${oper}";
			if ("save" == oper){
				$("#password").val(hex_md5("123456"));
			}
		});
</script>
</body>
</html>