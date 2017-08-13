<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>资源编辑页面</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">
		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label">资源ID：</label>
				<input class="myinput" id="id" name="id" />
			</li>
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">资源名称：</label>
				<input class="myinput" id="resourceName" name="resourceName" />
			</li> 
			<li class="li-input"><label for="" class="input-label">资源URL：</label>
				<input class="myinput" id="resourceUrl" name="resourceUrl" />
			</li>
			<li class="li-input"><label for="" class="input-label">资源类型：</label>
				<input id="resourceType" name="resourceType" />
			</li>
			<li class="li-input"><label for="" class="input-label">上级资源ID：</label>
				<input class="myinput" id="parentResourceUuid" name="parentResourceUuid" />
			</li>
			<li class="li-input"><label for="" class="input-label">创建人账号：</label>
				<input class="myinput" id="creatorName" name="creatorName" />
			</li>
			<li class="li-input"><label for="" class="input-label">创建时间：</label>
				<input class="myinput" id="createTime" name="createTime" />
			</li>
			<li class="li-input"><label for="" class="input-label">备注：</label>
				<input class="myinput" id="remark" name="remark" />
			</li>
			<li class="li-input"><label for="" class="input-label">排序号：</label>
				<input class="myinput" id="ordernum" name="ordernum" />
			</li>
		</ul>
	</form>
<script type="text/javascript">
	$(document).ready(function() {
		$('#id').textbox({
			value : "${tabResource.id}",
			type : "text",
			readonly : true,
			required : true
		});

		$('#resourceName').textbox({
			value : "${tabResource.resourceName}",
			type : "text",
			required : true
		});

		$('#resourceUrl').textbox({
			value : "${tabResource.resourceUrl}",
			type : "text",
			required : true
		});
		
		$('#parentResourceUuid').textbox({
			value : "${tabResource.parentResourceUuid}",
			type : "text",
			readonly : true,
			required : true
		});

		$('#creatorName').textbox({
			value : "${tabResource.creatorName}",
			type : "text",
			readonly : true,
			required : true
		});

		$('#createTime').textbox({
			value : "${tabResource.createTime}",
			type : "text",
			readonly : true,
			required : true
		});

		$('#remark').textbox({
			value : "${tabResource.remark}",
			type : "text",
			required : false
		});
		
		$('#ordernum').textbox({
			value : "${tabResource.ordernum}",
			type : "text",
			readonly : true,
			required : true
		});
		
		$('#resourceType').combobox({
			data:"${tabResource.resourceTypeJson}",
			valueField:"id",
			textField:"text",
			required : true
		});
		
		$('#resourceType').combobox('select','${tabResource.resourceType}');
	});

</script>
</body>
</html>