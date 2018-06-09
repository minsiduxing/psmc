<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>用户组编辑页面</title>


</head>
<body>
<form id="editForm" method="POST" class="addfrom">
		<input type="hidden" id="oper" name="oper" value="${oper}" />
		<input type="hidden" id="uuid" name="uuid" value="${tabGroup.uuid}" />
		<input type="hidden" id="parentGroupCode" name="parentGroupCode" value="${tabGroup.parentGroupCode}" />
		<input type="hidden" id="creatorName" name="creatorName" value="${tabGroup.creatorName}" />
		<input type="hidden" id="createTime" name="createTime" value="<fmt:formatDate value="${tabGroup.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />" />
		<input type="hidden" id="ordernum" name="ordernum" value="${tabGroup.ordernum}" />
		
		<ul class="addform-subcontent">
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">用户组名称：</label>
				<input id="groupName" name="groupName"/>
			</li> 
			<li class="li-input"><label for="" class="input-label">用户组类型：</label>
				<input id="groupType" name="groupType"/>
			</li>
			<li class="li-input"><label for="" class="input-label">用户组编码：</label>
				<input id="groupCode" name="groupCode" />
			</li>
			
		</ul>
		<ul class="addform-subcontent">
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">备注：</label>
				<textarea id="remark" name="remark"  style="width:520px;height:60px;">${tabGroup.remark}</textarea>
			</li> 
		</ul>
	</form>
<script type="text/javascript">
	$(document).ready(function() {

		$('#groupName').textbox({
			value : "${tabGroup.groupName}",
			type : "text",
			required : true
		});

		$('#groupCode').textbox({
			value : "${tabGroup.groupCode}",
			type : "text",
			required : true
		});

		
		commonObj.initDictCombobox("groupType","USER_GROUP_TYPE","<c:out value="${tabGroup.groupType}"/>",true,false);
		
		
	});

</script>
</body>
</html>