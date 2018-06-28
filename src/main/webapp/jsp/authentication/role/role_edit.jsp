<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="../../../common.jsp"%>

<title>角色编辑页面</title>
</head>
<body>

<input type="hidden" id="oper" name="oper" value="<c:out value="${oper}"/>"/>
	<form id="editForm" method="POST" class="addfrom">
		<input type="hidden" id="uuid" name="uuid" value="<c:out value="${role.UUID}"/>"/>
		<input type="hidden" class="myinput" id="creator" value='<c:out value="${role.CREATOR}"/>'/>
		<input type="hidden" class="myinput" id="createTime" value='<c:out value="${role.CREATE_TIME}"/>' />
		
		
		<ul class="addform-subcontent">
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">角色编码：</label>
				<input class="myinput" id="roleNo" name="roleNo" />
			</li> 
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">角色名称：</label>
				<input class="myinput" id="roleName" name="roleName" />
			</li> 
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">备注：</label><br>
				<br><textarea id="remark" name="remark" rows="4" cols="40" style="border-radius:5px; border: 1px solid #ccc;">${role.REMARK}</textarea>
			</li> 
		</ul>
		
		<%-- <ul class="addform-subcontent">
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">备注：</label>
				<textarea id="remark" name="remark" rows="4" cols="30" style="border-radius:5px; border: 1px solid #ccc;">${role.REMARK}</textarea>
			</li> 
		</ul> --%>
		
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