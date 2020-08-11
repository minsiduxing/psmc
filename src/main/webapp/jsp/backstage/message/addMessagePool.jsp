<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>录入信息</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">

		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label" style="width: 120px;">模板CODE：</label>
				<select id="tempCode" name="tempCode" >
					
				</select>
				<!-- <input id="evaluateNoticeType" name="evaluateNoticeType" ></input>  -->
			</li>
			<li class="li-input" ><label for="" class="input-label" style="width: 120px;">手机号：</label>
				<input id="phone1" name="phone" style="margin-right: 0px;" value="${tabMessagePool.phone }"></input>
				<input id="msgUuid" name="msgUuid" type="hidden" value="${tabMessagePool.msgUuid }"></input>
			</li>
		</ul>
	</form>
	<div align="center">
		<input type="button" onclick="submitMessagePool();" class="easyui-linkbutton" value="提   交" style="width:60px;height:30px;" >
	</div>
<script type="text/javascript">
	
	
	$("#phone1").textbox({
		required : true
	});
	/*
     * 验证手机号码
     */
    function validatorTel(content){
        // 正则验证格式
        eval("var reg = /^1[34578]\\d{9}$/;");
        return RegExp(reg).test(content);
    }
	
	$(document).ready(function() {
		var code='${tabMessagePool.tempCode }';
		var url = '<c:url value="/website/backstage/TabMessagePoolController.do"/>?method=queryTempCode';
		$.ajax({ 
			url: url,
			dataType: 'json', 
			success: function(data){   
				var str="";
				for (var i = 0; i < data.length; i++) {
					if(code==data[i].tempCode){
						str+='<option selected="selected" value="'+data[i].tempCode+'">'+data[i].tempCode+'</option>'
					}else{
						str+='<option value="'+data[i].tempCode+'">'+data[i].tempCode+'</option>'
					}
				}
				$("#tempCode").html(str);
			}
		});
	}); 
	
	
	
	//提交
	function submitMessagePool(){
		var value = $("#phone1").val();
		debugger;
		if(!validatorTel(value)){
			$.messager.alert('错误','输入手机号不合法','error');
			return;
		}
		var evauateInfo = $("#editForm").serialize();
		var url = '<c:url value="/website/backstage/TabMessagePoolController.do"/>?method=submit';
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: url,
			   data:evauateInfo,
			   success: function(data){
				   $.messager.progress("close");
				   addDialog.window("close");
				   successCallback(data);
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				   $.messager.progress("close");
			   }
		});
	}
 
</script>
</body>
</html>