<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>资源编辑页面</title>

</head>
<body>
	<div>
		<form id="operateForm" method="POST" class="addfrom">
			<input type="hidden" id="uuid" name="uuid" value=""/>
			<input type="hidden" id="resourceUuid" name="resourceUuid" value="${resourceUuid}"/>
			<ul class="addform-subcontent">
				<li class="li-input">
					<label for="" class="input-label">业务名称：</label>
					<input class="myinput" id="operateName" name="operateName" />
				</li>
				<li class="li-input">
					<label for="" class="input-label">所属类：</label>
					<input class="myinput" id="funClass" name="funClass" />
				</li> 
				<li class="li-input">
					<label for="" class="input-label">所属方法：</label>
					<input class="myinput" id="funMethod" name="funMethod" />
				</li>
				<li class="li-input">
					<label for="" class="input-label">排序号：</label>
					<input class="myinput" readonly="readonly" id="ordernum" name="ordernum" />
				</li>
				<li class="li-input">
					<label for="" class="input-label">备注：</label>
					<input class="myinput" id="operateDesc" name="operateDesc" />
				</li>
				<li class="li-input">
					<label for="" class="input-label">所属权限：</label>
					<input id="privilegeUuid" name="privilegeUuid" />
				</li>
				<li class="li-input">
					<label for="" class="input-label">操作编号：</label>
					<input class="myinput" id="operateNo" name="operateNo" />
				</li>
				<li class="li-input">
					<label for="" class="input-label">
						<a id="saveBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">保存</a>
					</label>
				</li>
			</ul>
		</form>
	</div>
	<div>
		<table id="operateTable"></table>
	</div>
<script type="text/javascript">
var editOperateDialogUrl = basePath + "/authentication/tabOperate.do";
editOperateDialogUrl = '<c:url value="'+editOperateDialogUrl+'"/>?method=operateList';

var editOperateUrl = basePath + "/authentication/tabOperate.do";
editOperateUrl ='<c:url value="'+editOperateUrl+'"/>?method=editOperateConfig';

var selectRoelCountUrl = basePath + "/authentication/tabOperate.do";
selectRoelCountUrl ='<c:url value="'+selectRoelCountUrl+'"/>?method=selectRoleCountByOperate';

var deleteOperateUrl = basePath + "/authentication/tabOperate.do";
deleteOperateUrl ='<c:url value="'+deleteOperateUrl+'"/>?method=deleteOperate';

var checkOperateNoUrl = basePath + "/authentication/tabOperate.do";
checkOperateNoUrl ='<c:url value="'+checkOperateNoUrl+'"/>?method=checkOperateNo';

$(document).ready(function() {
	$('#operateName').textbox({
		value : "",
		type : "text",
		required : true
	});

	$('#funClass').textbox({
		value : "",
		type : "text",
		required : true
	});

	$('#funMethod').textbox({
		value : "",
		type : "text",
		required : true
	});
	
	$('#ordernum').textbox({
		value : '<c:out value="${ordernum}"/>',
		type : "text",
		required : true
	});

	$('#operateDesc').textbox({
		value : "",
		type : "text",
		required : false
	});
 	
	$('#privilegeUuid').combobox({
		data:${privilegeTypeJson},
		valueField:"privilegeUuid",
		textField:"privilegeName",
		required : true
	});
	
	$('#operateNo').textbox({
		value : "",
		type : "text",
		required : false
	});
		
	var resourceUuid = $("#resourceUuid").val();
	operateGrid(resourceUuid);
});

//操作配置GRID
function operateGrid(resourceUuid){
	$('#operateTable').datagrid({     
		iconCls:"myicon-table",
		url:editOperateDialogUrl + "&resourceUuid=" + resourceUuid,
		fitColumns:true,
		loadMsg:"数据正在加载，请等待...",
		rownumbers:true,
		singleSelect:false,
		columns:[[
			{field:"uuid",title:"操作主键",hidden:true},
			{field:"privilegeUuid",title:"所属权限标识",hidden:true},
		    {field:"resourceName",title:"资源名称",width:160,halign:"center",align:"center",formatter: showInfo},
		    {field:"operateName",title:"业务操作名称",width:200,halign:"center",align:"center",formatter: showInfo},
		    {field:"funClass",title:"所属类",width:260,halign:"center",align:"center",formatter: showInfo},
		    {field:"funMethod",title:"所属方法",width:240,halign:"center",align:"center",formatter: showInfo},
		    {field:"ordernum",title:"排序号",width:100,halign:"center",align:"center",formatter: showInfo},
		    {field:"operateDesc",title:"备注",width:120,halign:"center",align:"center",formatter: showInfo},
		    {field:"privilegeName",title:"所属权限名称",width:120,halign:"center",align:"center",formatter: showInfo},
		    {field:"operateNo",title:"操作编号",width:220,halign:"center",align:"center",formatter: showInfo},
		    {field:"operate",title:"操作",width:200,halign:"center",align:"center",formatter:formatterOperate}
		]],
		onLoadSuccess:function(data) {
			var a = data.rows.length;
			if(data.rows.length==0){
				var body = $(this).data().datagrid.dc.body2;
				body.find('table tbody').append('<tr><td width="'+body.width()+'" style="height: 25px; text-align: center;" colspan="100">没有数据展示</td></tr>');
			} 
		}
	}); 
}

function formatterOperate(value,row,index) {
	return "<a href='javascript:void(0)' onclick='update(\"" + index + "\")'>修改</a>&nbsp;&nbsp;<a href='javascript:void(0)' onclick='del(\""+row.uuid+"\")'>删除</a>";
}

//鼠标悬浮显示数据
function showInfo(value,row,index){
return "<span title='" + value + "'>" + value + "</span>";
}

//保存按钮
$(function(){
    $('#saveBtn').bind('click', function(){
    	save();
    });
});

//保存
function save(){
	$('#operateForm').form({    
	    url:editOperateUrl,    
	    onSubmit: function(){
	    	 return onSubmit();
	    },    
	    success:function(data){
	    	$.messager.progress("close");
			alert_autoClose("提示","保存成功!","info");
			var obj = JSON.parse(data);
			$("#uuid").val("");
			$("#operateName").textbox('setValue',"");
			$("#funClass").textbox('setValue',"");
			$("#funMethod").textbox('setValue',"");
			$("#operateDesc").textbox('setValue',"");
			$('#privilegeUuid').combobox('select',"");
			$("#ordernum").textbox('setValue',obj.ordernum);
			$("#operateNo").textbox('setValue',"");
			operateGrid(obj.resourceUuid);
	    },
	    error:function(){
	    	$.messager.progress("close");
			alert_autoClose("提示","保存失败!","info");
	    }
	}); 
	$('#operateForm').submit();
}

function update(index){
    var rows = $("#operateTable").datagrid("getRows"); 
    var obj = rows[index];
	$("#uuid").val(obj.uuid);
	$("#operateName").textbox('setValue',obj.operateName);
	$("#funClass").textbox('setValue',obj.funClass);
	$("#funMethod").textbox('setValue',obj.funMethod);
	$("#ordernum").textbox('setValue',obj.ordernum);
	$("#operateDesc").textbox('setValue',obj.operateDesc);
	$('#privilegeUuid').combobox('select',obj.privilegeUuid);
	$("#operateNo").textbox('setValue',obj.operateNo);
}

function del(operateUuid){
	$.messager.confirm('提示', '该操作不可逆，确认删除？', function(r){
		if (r){
			var count = getRoleOperateCount(operateUuid);
			 if(count > 0){
				alert_autoClose("提示","该业务操作已分配给角色，不能删除!","info");
				return;
			}else{
				$.messager.progress(); 
				$.ajax({                                
			       type: "POST",                        
			       url: deleteOperateUrl,                       
			       data: {operateUuid:operateUuid},
			       success: function(data){
			    	   $.messager.progress("close");
			    	   var obj = JSON.parse(data);
			    	   if(obj.count == 1){
			    		   $("#ordernum").textbox('setValue',obj.ordernum);
				    	   operateGrid($("#resourceUuid").val());
						   alert_autoClose("提示","删除成功!","info");
			    	   }else{
						   alert_autoClose("提示","删除失败!","info");
			    	   }
			       },
			       error:function(){
				    	$.messager.progress("close");
						alert_autoClose("提示","删除失败!","info");
				   }
			});
		 }
	  }
  })
}

//查询该业务操作下配置的角色个数
function getRoleOperateCount(operateUuid){
	var count = 0;
 	 $.ajax({                                
        type: "POST",                        
        url: selectRoelCountUrl, 
        async: false,
        data: {operateUuid:operateUuid},
        success: function(data){ 
        	var obj = JSON.parse(data);
            count = obj.count;
        }   
	 }); 
 	 return count;
}

//表单校验
function onSubmit(){
	var result = $('#operateForm').form("validate");
	if(Boolean(result)){
		var flag = checkOperateNo();
		if(!flag){
			alert_autoClose("提示","该操作编号已存在!","info");
			return false;
		}
		$.messager.progress(); 
		return true;
	}else{
		return false;
	}
}

//校验操作编号是否重复
function checkOperateNo(){
	var flag = true;
	var uuid = $("#uuid").val();
	var operateNo =  $("#operateNo").textbox('getValue');
	if(operateNo != ""){
	 	 $.ajax({                                
	         type: "POST",                        
	         url: checkOperateNoUrl, 
	         async: false,
	         data: {operateUuid:uuid,operateNo:operateNo},
	         success: function(data){ 
	         	var obj = JSON.parse(data);
	         	count = obj.count;
	            if(count > 0){
	    	 		flag = false;
	    	 	}
	         }   
	 	 }); 
	}
	return flag;
}
</script>
</body>
</html>