<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<html>
<head>
<title>用户修改密码界面</title>
</head>
<body>








	<form method="post" class="easyui-panel" title="修改密码" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:20px">
		<div>原密码:</div>
			<input class="easyui-textbox" id="oldPassword" name="oldPassword" type="password" missingMessage="请输入旧密码" style="width:100%;height:40px;padding:12px"  data-options="required:true,validType:'length[1,20]',prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
		<div>新密码:</div>
			<input class="easyui-textbox" id="newPassword" name="newPassword" type="password" missingMessage="请输入新密码" style="width:100%;height:40px;padding:12px"  data-options="required:true,validType:'length[1,20]',prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
		<div>确认密码:</div>
			<input class="easyui-textbox" id="renewPassword" name="renewPassword" type="password" style="width:100%;height:40px;padding:12px"  data-options="prompt:'',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px;color:#d64242;font-size: small;">
		</div>
		<div>
			<input type="button" id="submit" class="easyui-linkbutton" style="padding:5px 0px;width:100%;" value="确定修改" onclick="submitFn();" />
		</div>
	</form>
</body>
<script type="text/javascript" src="../js/md5.js"></script>
<script>
var msg = '${msg}';
var url = "<%=request.getContextPath()%>"+"/logOut";
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
	
	//密码md5加密
	function convertMd5(){
		$('#oldPassword').textbox('setValue',hex_md5($('#oldPassword').textbox('getValue')));
		$('#newPassword').textbox('setValue',hex_md5($('#newPassword').textbox('getValue')));
		$('#renewPassword').textbox('setValue',hex_md5($('#renewPassword').textbox('getValue')));
	}
	//判断两次输入密码是否一致
	function checkNewPassword(){
		var _flag = false;
        var oldPassword = $.trim($("#oldPassword").textbox('getValue'));
        var newPassword = $.trim($("#newPassword").textbox('getValue'));
        var reNewPassword = $.trim($("#renewPassword").textbox('getValue'));

		if(reNewPassword){
			if(newPassword != reNewPassword){
				//清空输入框的值
				$('#renewPassword').textbox('setValue','');
				$('#newPassword').textbox('setValue','');
				$.messager.alert('提示','两次输入的密码不一致，请重新输入!');
			}else{
				_flag=true;
			}
		}else{
			$.messager.alert('提示','输入值为空，请重新输入!');
		}
		return _flag;
	}

	function submitFn(){
		if(!checkNewPassword()){
			return false;
		}
		convertMd5();
		var _msg = '';
		var _info = '';
		var _url = "<%=request.getContextPath()%>/authentication/loginController.do?method=autUpdatePasswdOperate";
		 $("input",$("#renewPassword").next("span")).blur(function(){  
			
		}); 
		
		var _data = $("form").serialize();
		$.messager.progress();
		$.ajax({
				async:false,
				cache:false,
				type:'POST',
				dataType:"text",
				data:_data,
				url:_url,
				success:function(msg){
					$.messager.progress('close');
					_msg = msg;
					if(msg=='0'){
						_info= '修改成功，您需要重新登录!';
					}
					if(msg=='1'){
						_info= '修改失败，原密码错误，请确认您的正确原密码!';
						$('#renewPassword').textbox('setValue','');
						$('#newPassword').textbox('setValue','');
						$('#oldPassword').textbox('setValue','');
					}
					if(msg=='2'){
						_info= '修改失败，输入不合法数据，系统退出!';
					}
					
					
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) {
					commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				}
			});
		 	$.messager.alert('提示',_info,'info',function(){
			if(_msg!='1'){
				parent.window.location = url;
			}
		});
		 	$(".panel-tool-close").css("display","none");
	}
</script>
</html>