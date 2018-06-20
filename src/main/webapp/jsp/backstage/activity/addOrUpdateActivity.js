/**
 * 提交
 * @returns
 */
function save(e){
	event.preventDefault();
	
	var result = $('#activityForm').form("validate");
	if(!Boolean(result)){
		$.messager.alert('警告','请填写必填项！','warning');
		return;
	}
	var activitydata = $("#activityForm").serialize();
	var url = addUrl;
	$.messager.progress(); 
	$.ajax({
		   type: "POST",
		   url: url,
		   data:activitydata,
		   success: function(data){
			   $.messager.progress("close");
				commonObj.showResponse(data);
		   },
		   error:function(XMLHttpRequest, textStatus, errorThrown){
			   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			   $.messager.progress("close");
		   }
	});
	
}

/**
 * 返回列表
 * @returns
 */
function retList(){
	window.location.href=retrunUrl;
}