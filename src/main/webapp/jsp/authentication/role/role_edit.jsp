<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="../../../common.jsp"%>

<title>角色编辑页面</title>
</head>
<body>

<input type="hidden" id="oper" name="oper" value="<c:out value="${oper}"/>"/>
	<form id="editForm" method="POST">
		
		<table class="table">
		<input type="hidden" id="uuid" name="uuid" value="<c:out value="${role.UUID}"/>"/>
		<input type="hidden" class="myinput" id="creator" value='<c:out value="${role.CREATOR}"/>'/>
		<input type="hidden" class="myinput" id="createTime" value='<c:out value="${role.CREATE_TIME}"/>' />
			<tr>
				<td>角色编码</td>
				<td class="inputTd"><input class="myinput" id="roleNo" name="roleNo" /></td>
			</tr>
			<tr>
				<td>角色名称</td>
				<td class="inputTd"><input class="myinput" id="roleName" name="roleName" /></td>
			</tr>
			<tr>
				<td>角色描述</td>
				<td class="inputTd"><input class="myinput" id="remark" name="remark" value='<c:out value="${role.REMARK}"/>'/></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(function() {
		    $('#roleNo').textbox({
		        value: '<c:out value="${role.ROLE_NO}"/>',
		        type: "text",
		        required: true,
		        delay:500
		    });
		    
		    $('#roleName').textbox({
		        value: '<c:out value="${role.ROLE_NAME}"/>',
		        type: "text",
		        required: true
		    });
		});
	</script>
</body>
</html>