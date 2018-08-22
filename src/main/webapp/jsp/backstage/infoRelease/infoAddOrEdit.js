

/**
 * 页面初始化
 */

$(function(){
	//富文本编辑器初始化
	wangEditorInit(isEdit);
	//表单初始化
	formInint(isEdit);
});
var editor;
function sbmit (e){
	event.preventDefault();
	var result = $('#editForm').form("validate");
	var isCustom = $("input[name='isCustom1']:checked").val();
	$("#isCustom").val(isCustom);
	$("#hiddencontent").val(editor.txt.html());
	if(editor.txt.text()=="" || editor.txt.text()==null){
		commonObj.alert ("信息不能为空!","warning");
		return;
	}
	var formdata = $("#editForm").serialize();
	var _addUrl = addUrl;
	if(Boolean(result)){
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: _addUrl,
			   data:formdata,
			   success: function(data){
				   successCallback(data);
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				   $.messager.progress("close");
			   }
			});
		return true;
	}else{
		return false;
	}
}
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#accountTableId").datagrid('reload');
	commonObj.showResponse(data);
}

/**
 * 富文本编辑器初始化-----------------------------------
 */
function  wangEditorInit(isEdit){
    	  var E = window.wangEditor;
          editor = new E('#newsContent');
    	  editor.customConfig.menus = [
    	                                'head',  // 标题
									    'bold',  // 粗体
									    'fontSize',  // 字号
									    'fontName',  // 字体
									    'italic',  // 斜体
									    'underline',  // 下划线
									    'strikeThrough',  // 删除线
									    'foreColor',  // 文字颜色
									    'backColor',  // 背景颜色
									    'link',  // 插入链接
									    'list',  // 列表
									    'justify',  // 对齐方式
									    'quote',  // 引用
									    'emoticon',  // 表情
									    'image',  // 插入图片
									    'table',  // 表格
									    'undo',  // 撤销
									    'redo'  // 重复
									   ]
    	  editor.customConfig.uploadImgMaxSize = 3 * 1000 * 1000;//限制图片最大不超过3M
    	  editor.customConfig.zIndex = 998;
          editor.customConfig.uploadImgServer = imageuploadsrc;  // 上传图片到服务器
          editor.customConfig.uploadImgHooks = {
        		    // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        		    // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
        		    customInsert: function (insertImg, result, editor) {
        		        // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
        		        // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

        		        // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
        		    	console.info(result.rmsg);
        		        var url = result.rmsg;
        		        insertImg(url);

        		        // result 必须是一个 JSON 格式字符串！！！否则报错
        		    }
        		}
          editor.create(); 
          E.fullscreen.init('#newsContent');
          if (isEdit=="edit") {
        	  editor.txt.html(newscontent) ;
          }
          if(isEdit=="query"){
        	  editor.txt.html(newscontent) ;
        	  editor.$textElem.attr('contenteditable', false);
          }
          
    }
//富文本编辑器结束-----------------------------
function retList(){
	window.location.href=retrunUrl;
}
//表单数据初始化结束--------------------------------------