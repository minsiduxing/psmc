$(function(){
	//富文本编辑器初始化
	wangEditorInit($("#isEdit").val());
});
var editor;
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
   									    'emoticon',  // 表情
   									    'image',  // 插入图片
   									    'table',  // 表格
   									    'undo',  // 撤销
   									    'redo'  // 重复
   									   ]
       	  editor.customConfig.uploadImgMaxSize = 1000 * 1000;//限制图片最大不超过1M
          editor.customConfig.zIndex = 500;
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
        	  editor.txt.html(newsContent) ;
          }
          if(isEdit=="query"){
        	  editor.txt.html(newsContent) ;
        	  editor.$textElem.attr('contenteditable', false);
          }
          
    }
//富文本编辑器结束-----------------------------
/**
 * 提交
 * @returns
 */
function save(e){
	event.preventDefault();
	var isCustom = $("input[name='isCustom1']:checked").val();
	$("#isCustom").val(isCustom);
	$("#hiddencontent").val(editor.txt.html());
	var result = $('#innovationForm').form("validate");
	if(!Boolean(result)){
		$.messager.alert('警告','请填写必填项！','warning');
		return;
	}
	if(editor.txt.text()=="" || editor.txt.text()==null){
		commonObj.alert ("成果内容不能为空!","warning");
		return;
	}
	var innovationdata = $("#innovationForm").serialize();
	var url = addUrl;
	$.messager.progress(); 
	$.ajax({
		   type: "POST",
		   url: url,
		   data:innovationdata,
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