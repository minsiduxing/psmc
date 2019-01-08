

/**
 * 页面初始化
 */

$(function(){
	//富文本编辑器初始化
	wangEditorInit(isEdit);
	//表单初始化
	initEditor1(isEdit);
	initEditor2(isEdit);
	initEditor4(isEdit);
	initEditor5(isEdit)
	formInint(isEdit);
	/*//图片初始化
	newsPicInit(isEdit);*/
});
var editor1;
var editor2;
var editor3;
var editor4;
var editor5;
function sbmit (e){
	event.preventDefault();
	var result = $('#editForm').form("validate");
	$("#deptIntroduction").val(editor1.txt.html());
	$("#deptRegulation").val(editor2.txt.html());
	$("#hiddencontent").val(editor3.txt.html());
	$("#latestNews").val(editor4.txt.html());
	$("#cooperation").val(editor5.txt.html());
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
	commonObj.showResponse(data);
}

//协会简介
function initEditor1(isEdit){
	editor1 = createWangeditor("introductionContent");
	 if (isEdit=="edit") {
   	  editor1.txt.html($("#introduction").html()) ;
     }
     if(isEdit=="query"){
   	  editor1.txt.html($("#introduction").html()) ;
   	  editor1.$textElem.attr('contenteditable', false);
     }
}

//规范管理办法
function initEditor2(isEdit){
	editor2 = createWangeditor("regulationContent");
	 if (isEdit=="edit") {
   	  editor2.txt.html($("#regulation").html()) ;
     }
     if(isEdit=="query"){
   	  editor2.txt.html($("#regulation").html()) ;
   	  editor2.$textElem.attr('contenteditable', false);
     }
}

//最新消息
function initEditor4(isEdit){
	editor4 = createWangeditor("latestNewsContent");
	 if (isEdit=="edit") {
   	  editor4.txt.html($("#latest").html()) ;
     }
     if(isEdit=="query"){
   	  editor4.txt.html($("#latest").html()) ;
   	  editor4.$textElem.attr('contenteditable', false);
     }
}

//合作意向
function initEditor5(isEdit){
	editor5 = createWangeditor("cooperationContent");
	 if (isEdit=="edit") {
   	  editor5.txt.html($("#cooperation1").html()) ;
     }
     if(isEdit=="query"){
   	  editor5.txt.html($("#cooperation1").html()) ;
   	  editor5.$textElem.attr('contenteditable', false);
     }
}

/**
 * 富文本编辑器初始化-----------------------------------
 */
function createWangeditor(divId){
	var E = window.wangEditor;
	var editor = new E("#" + divId);
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
								    'list',  // 列表
								    'justify',  // 对齐方式
								    'emoticon',  // 表情
								    'table',  // 表格
								    'undo',  // 撤销
								    'redo'  // 重复
								   ];
	editor.customConfig.zIndex = 500;
	editor.create(); 
    E.fullscreen.init("#" + divId);
    return editor;
}


function  wangEditorInit(isEdit){
    	  var E = window.wangEditor;
          editor3 = new E('#newsContent');
    	  editor3.customConfig.menus = [
   	                                    'head',  // 标题
									    'bold',  // 粗体
									    'fontSize',  // 字号
									    'fontName',  // 字体
									    'italic',  // 斜体
									    'underline',  // 下划线
									    'strikeThrough',  // 删除线
									    'foreColor',  // 文字颜色
									    'backColor',  // 背景颜色
									    'list',  // 列表
									    'justify',  // 对齐方式
									    'emoticon',  // 表情
									    'image',  // 插入图片
									    'table',  // 表格
									    'undo',  // 撤销
									    'redo'  // 重复
									   ];
    	  editor3.customConfig.uploadImgMaxSize = 1000 * 1000;//限制图片最大不超过1M
    	  editor3.customConfig.zIndex = 500;
          editor3.customConfig.uploadImgServer = imageuploadsrc;  // 上传图片到服务器
          editor3.customConfig.uploadImgHooks = {
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
          editor3.create(); 
          E.fullscreen.init('#newsContent');
          if (isEdit=="edit") {
        	  editor3.txt.html($("#demeanour").html()) ;
          }
          if(isEdit=="query"){
        	  editor3.txt.html($("#demeanour").html()) ;
        	  editor3.$textElem.attr('contenteditable', false);
          }
    }
//富文本编辑器结束-----------------------------
function retList(){
	window.location.href=retrunUrl;
}
//表单数据初始化结束--------------------------------------