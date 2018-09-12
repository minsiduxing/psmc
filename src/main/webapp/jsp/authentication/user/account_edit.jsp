<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>用户编辑页面</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">
<input type="hidden" id="uuid" name="uuid" value="<c:out value="${account.UUID}"/>"></input>
<input type="hidden" id="personId" name="personId" value="<c:out value="${person.UUID}"/>"></input>
<input type="hidden" id="accUuid" name="accUuid" value="<c:out value="${person.ACC_UUID}"/>"></input>
<input type="hidden" id="accountType" name="accountType" value="<c:out value="${account.account_type}"/>"></input>
<input type="hidden" id="idCard" name="idCard" value="<c:out value="${person.id_card}"/>"></input>
<input type="hidden" id="authType" name="authType" value="<c:out value="${account.auth_type}"/>"></input>
<input type="hidden" id="area" name="area" value="<c:out value="${person.area}"/>"></input>
<input type="hidden" id="province" name="province" value="<c:out value="${person.province}"/>"></input>
<input type="hidden" id="city" name="city" value="<c:out value="${person.city}"/>"></input>
<input type="hidden" id="prefecture" name="prefecture" value="<c:out value="${person.prefecture}"/>"></input>
<input type="hidden" id="birthday" name="birthday" value="<c:out value="${person.birthday}"/>"></input>
<input type="hidden" id="addrCode" name="addrCode" value="<c:out value="${person.addr_code}"/>"></input>
		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label">账号名称：</label>
				<input class="myinput" id="accountName" name="accountName"></input>
			</li>
			 <li class="li-input" id="accountPassPanel" ><label for="" class="input-label">账号密码：</label>
				<input class="myinput" id="accountPass" name="accountPass"></input>
			</li> 
			<li class="li-input"><label for="" class="input-label">是否锁定：</label>
				<input id="isLocked" name="isLocked"></input></li>
			<li class="li-input"><label for="" class="input-label">姓名：</label>
				<input class="myinput" id="personName" name="personName"></input></li>
			<li class="li-input"><label for="" class="input-label">性别：</label>
				<input id="sex" name="sex"></input></li>
			<li class="li-input"><label for="" class="input-label">年龄：</label>
				<input class="myinput" id="age" name="age"></input></li>
			<li class="li-input"><label for="" class="input-label">手机号：</label>
				<input class="myinput" id="telephone" name="telephone"></input></li>
			<li class="li-input"><label for="" class="input-label">Email：</label>
				<input class="myinput" id="email" name="email"></input></li>
			<li class="li-input"><label for="" class="input-label">所属地：</label>
				<input class="myinput" id="cityName" name="cityName"></input> <input
				type="hidden" id="cityId" name="cityId" value="${person.CITYID}"></input>
			</li>
			<li>
				<label for="" class="input-label">所属用户组：</label>
				<input type="hidden" id="groupid" name="groupid" value="${account.GROUPID}"></input>
				<input id="groupname" name="groupname"></input>
			</li>
			
		</ul>
		
		<ul>
			<li class="li-input"><label for="" class="input-label">所属角色：</label>
				<input id="roleUuid" name="roleUuid"></input></li>
		</ul>
	</form>
<script type="text/javascript">
	var basePath = $("#basePath").val();
	function cityCallBack(ids, names) {
		$("#cityId").val(ids);
		$('#cityName').textbox('setValue', names);
	}

	function groupTreeChange(newval,oldval){
		$("#groupid").val(newval);
	}

	var oper = "${oper}";
	$(document)
			.ready(
					function() {
						if ("edit" != oper) {
						$('#accountPass').textbox({
							value : "${account.ACCOUNT_PASS}",
							type : "password",
							required : true,

							validType : [ 'rules_accountPass' ]
						});
						}
						else{
							//如果是编辑隐藏密码修改
							$('#accountPassPanel').css("display","none");
							$('#accountPass').attr("type","hidden");
							$('#accountPass').val("${account.ACCOUNT_PASS}");
						}
						if ("edit" == oper) {
							$('#accountName').textbox({
								value : "${account.ACCOUNT_NAME}",
								type : "text",
								required : true,
								delay : 500
								//validType : [ 'rules_accountName' ]
							});

							$('#accountName').textbox('readonly', true);

						} else {
							$('#accountName').textbox({
								value : "${account.ACCOUNT_NAME}",
								type : "text",
								required : true,
								delay : 10000,
								validType : [ 'rules_accountName' ]
							});
						}

						$('#personName').textbox({
							value : "${person.PERSON_NAME}",
							type : "text",
							required : true
						});

						$('#age').textbox({
							value : "${person.AGE}",
							type : "text",
							required : false,
							validType : [ 'rules_positiveNo' ]
						});

						$('#telephone').textbox({
							value : "${person.TELEPHONE}",
							type : "text",
							required : true,
							validType : [ 'rules_mobilePhoneNo' ]
						});

						$('#email').textbox({
							value : "${person.EMAIL}",
							type : "text",
							required : false,
							validType : [ 'email' ]
						});

						$('#cityName').textbox(
								{
									value : "${person.CITY_NAME}",
									type : "text",
									required : true,
									editable : false,
									inputEvents : $.extend({},
								$.fn.textbox.defaults.inputEvents,
								{
									click : function(event) {
										commonObj.loadRegoinTree(
												"radio", null,
												cityCallBack);
									},
								})
					});
						
		var loadComboRoleList =basePath+"/authentication/roleController.do";
		loadComboRoleList = '<c:url value="'+loadComboRoleList+'"/>?method=loadComboRoleList';
		$('#roleUuid').combogrid(
		{
			value : "${account.ROLE_UUID}",
			width : 310,
			required : true,
			panelMaxHeight : 150,
			editable : false,
			idField : 'UUID',
			textField : 'ROLE_NAME',
			url: loadComboRoleList ,
			columns:[[   
 				  {field:'UUID',title:'主键',hidden:true},    
		          {field:'ROLE_NO',title:'角色编码',width:155},    
		          {field:'ROLE_NAME',title:'角色名称',width:155}
		      ]]  
		});

		var loadGroupTreeUrl =basePath+"/authentication/tabGroupController.do";
		loadGroupTreeUrl = '<c:url value="'+loadGroupTreeUrl+'"/>?method=getTreeJson';
		$('#groupname').combotree({    
		    url: loadGroupTreeUrl,    
		    required: true,
		    lines:true,
		    editable:false,
		    value:'${account.GROUP_NAME}',
		    onChange:groupTreeChange
		});  

		
	
	commonObj.initDictCombobox("isLocked","IF","<c:out value="${account.IS_LOCKED}"/>",true,false);
	commonObj.initDictCombobox("sex","SEX","<c:out value="${person.SEX}"/>",true,false);

});

</script>
</body>
</html>