<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../common.jsp"%>
<title>用户修改密码界面</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/authentication/loginController.do?method=autUpdatePasswdOperate" class="easyui-panel" title="修改密码" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" id="oldPassword" name="oldPassword" type="password" style="width:100%;height:40px;padding:12px"  data-options="prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" id="newPassword" name="newPassword" type="password" style="width:100%;height:40px;padding:12px"  data-options="prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" id="renewPassword" name="renewPassword" type="password" style="width:100%;height:40px;padding:12px"  data-options="prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px;color:#d64242;font-size: small;">
			<span><c:out value="${msg}"></c:out></span>
		</div>
		<div>
			<input type="submit" id="submit" class="easyui-linkbutton" style="padding:5px 0px;width:100%;" value="确定修改"/>
		</div>
	</form>
</body>
<script>
	$(function(){
		recalc();
		$(window).resize(function(){
			recalc();
		});
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
</script>
</html>