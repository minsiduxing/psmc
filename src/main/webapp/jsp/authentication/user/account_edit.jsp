<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>用户编辑页面</title>

</head>
<body>
<form id="editForm" method="POST">
<input type="hidden" id="uuid" name="uuid" value="<c:out value="${account.UUID}"/>"></input>
<input type="hidden" id="personId" name="personId" value="<c:out value="${person.UUID}"/>"></input>
<input type="hidden" id="accUuid" name="accUuid" value="<c:out value="${person.ACC_UUID}"/>"></input>
<table class="table">
<tr>
	<td>账号名称</td>
	<td class="inputTd">
		<input class="myinput" id="accountName" name="accountName"></input>
	
	</td>
	
	<td>账号密码</td>
	<td class="inputTd">
		<input class="myinput" id="accountPass" name="accountPass"></input>
		
	</td>
</tr>	
<tr>
	<td>是否锁定</td>
	<td class="inputTd">
		<input id="isLocked" name="isLocked"></input>  
	</td>

	<td>姓名</td>
	<td class="inputTd">
		<input class="myinput" id="personName" name="personName"></input>
	</td>
</tr>	
<tr>
	<td>性别</td>
	<td class="inputTd">
		<input id="sex" name="sex"></input>
	</td>

	<td>年龄</td>
	<td class="inputTd">
		<input class="myinput" id="age" name="age"></input>
	</td>
</tr>		
<tr>
	<td>手机号</td>
	<td class="inputTd">
		<input class="myinput" id="telephone" name="telephone""></input>
	</td>

	<td>Email</td>
	<td class="inputTd">
		<input class="myinput" id="email" name="email"></input>
	</td>
</tr>
<tr>
	<td>所属属地</td>
	<td class="inputTd">
		<input class="myinput" id="cityName" name="cityName"></input>
		<input type="hidden" id="cityId" name="cityId" value="${person.CITYID}"></input>
	</td>
	<td>所属角色</td>
	<td class="inputTd">
		<input id="roleUuid" name="roleUuid"></input>
	</td>
</tr>
</table>

</form>
<script type="text/javascript">
function cityCallBack(ids,names){
	$("#cityId").val(ids);
	$('#cityName').textbox('setValue', names);
}

var oper="${oper}";
$(document).ready(function(){ 
	
	$('#accountPass').textbox({    
		value:"${account.ACCOUNT_PASS}",
		type:"password",
		required:true,
		
		validType:['rules_accountPass']
	});

	if("edit" == oper){
		$('#accountName').textbox({    
			value:"${account.ACCOUNT_NAME}",
			type:"text",
			required:true,
			delay:500,
			validType:['rules_accountName']
		});
		
		$('#accountName').textbox('readonly',true);
		//$('#accountPass').textbox('readonly',true);

	}else{
		$('#accountName').textbox({    
			value:"${account.ACCOUNT_NAME}",
			type:"text",
			required:true,
			delay:10000,
			validType:['rules_accountName']
		});
	}

	$('#personName').textbox({    
		value:"${person.PERSON_NAME}",
		type:"text",
		required:true
	});

	$('#age').textbox({    
		value:"${person.AGE}",
		type:"text",
		required:false,
		validType:['rules_positiveNo']
	});

	$('#telephone').textbox({    
		value:"${person.TELEPHONE}",
		type:"text",
		required:true,
		validType:['rules_mobilePhoneNo']
	});
	
	$('#email').textbox({    
		value:"${person.EMAIL}",
		type:"text",
		required:false,
		validType:['email']
	});
	
	$('#cityName').textbox({    
		value:"${person.CITY_NAME}",
		type:"text",
		required:true,
		editable:false,
		inputEvents: $.extend({},$.fn.textbox.defaults.inputEvents,{
			click: function(event){
				console.info(event);
				commonObj.loadRegoinTree("radio",null,cityCallBack);
			},
		})
	});

	$('#roleUuid').combogrid({    
		value:"${account.ROLE_UUID}",
		width:250,
		required:true,
		panelMaxHeight:100,
		editable:false,
		idField:'UUID',    
		textField:'ROLE_NAME', 
		url:'<%=request.getContextPath() %>/authentication/roleController.do?method=loadComboRoleList',    
		columns:[[    
 				  {field:'UUID',title:'主键',hidden:true},    
		          {field:'ROLE_NO',title:'角色编码',width:100},    
		          {field:'ROLE_NAME',title:'角色名称',width:130}
		      ]]  
	});
	
	console.info(eval($('#cityName').textbox("options")));
	
	commonObj.initDictCombobox("isLocked","IF","<c:out value="${account.IS_LOCKED}"/>",true);
	commonObj.initDictCombobox("sex","SEX","<c:out value="${person.SEX}"/>",true);

});

</script>
</body>
</html>