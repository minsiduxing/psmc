<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>资源编辑页面</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">
		<input class="myinput" id="id" name="id" type="hidden" value="${tabResource.id}" />
		<input class="myinput" id="parentResourceUuid" name="parentResourceUuid" type="hidden" value="${tabResource.parentResourceUuid}" />
		<input class="myinput" id="creatorName" name="creatorName" type="hidden" value="${tabResource.creatorName}" />
		<input class="myinput" id="createTime" name="createTime" type="hidden" value="${tabResource.createTime}" />
		<input class="myinput" id="ordernum" name="ordernum" type="hidden" value="${tabResource.ordernum}" />
		
		
		<ul class="addform-subcontent">
			<li class="li-input" id="accountPassPanel" ><label for="" class="input-label">资源名称：</label>
				<input class="myinput" class="" data-options="required:true" id="resourceName" name="resourceName" />
			</li> 
			
			<li class="li-input"><label for="" class="input-label">资源类型：</label>
				<input id="resourceType" name="resourceType"/>
			</li>
			
			<li class="li-input"><label for="" class="input-label">是否展示：</label>
				<input id="isView" name="isView"></input>
			</li>
		</ul>
		<ul>	
			<li class="li-input"><label for="" class="input-label">资源URL：</label>
				<input class="myinput" id="resourceUrl" name="resourceUrl" style="width:530px;" />
			</li>
		</ul>
		<ul>	
			<li class="li-input"><label for="" class="input-label">备注：</label>
				<input class="myinput" id="remark" name="remark" style="width:530px;"/>
			</li>	
		</ul>
	</form>
<script type="text/javascript">
	$(document).ready(function() {
	/* 	$('#id').textbox({
			value : "${tabResource.id}",
			type : "text",
			readonly : true,
			required : true
		}); */

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
		
		/* $('#parentResourceUuid').textbox({
			value : "${tabResource.parentResourceUuid}",
			type : "text",
			readonly : true,
			required : true
		}); */

	/* 	$('#creatorName').textbox({
			value : "${tabResource.creatorName}",
			type : "text",
			readonly : true,
			required : true
		}); */

	/* 	$('#createTime').textbox({
			value : "${tabResource.createTime}",
			type : "text",
			readonly : true,
			required : true
		}); */

		$('#remark').textbox({
			value : "${tabResource.remark}",
			type : "text",
			required : false
		});
		
	/* 	$('#ordernum').textbox({
			value : "${tabResource.ordernum}",
			type : "text",
			readonly : true,
			required : true
		}); */
		
		$('#resourceType').combobox({
			data:${tabResource.resourceTypeJson},
			valueField:"id",
			textField:"text",
			required : true
		}); 
		
		commonObj.initDictCombobox("resourceType","TAB_RESOURCE_TYPE","<c:out value="${tabResource.resourceType}"/>",true,false);
		commonObj.initDictCombobox("isView","IF","<c:out value="${tabResource.isView}"/>",true,false);
	});

</script>
</body>
</html>