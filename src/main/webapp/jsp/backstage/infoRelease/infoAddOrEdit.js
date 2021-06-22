

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
		  editor.config.zindex = 1;//高度
		  editor.config.height = 500;//高度
		  editor.config.showMenuTooltips = false;//菜单栏提示
    	  editor.config.uploadImgMaxSize = 1024 * 1024;//限制图片最大不超过1M
          editor.config.uploadImgServer = imageuploadsrc;  // 上传图片到服务器
		  editor.config.showLinkImg = false;//隐藏插入网络图片
		  editor.config.pasteIgnoreImg = true; //黏贴内容把图片过滤
          editor.config.uploadImgHooks = {
        		    customInsert: function (insertImg, result, editor) {
        		        insertImg(result.rmsg);
        		    }
        		}
		    editor.config.uploadVideoMaxSize = 1 * 50 * 1024 * 1024; // 限制50m
			/**
			 * html5 video 支持的视频格式
			 * MP4 = MPEG 4文件使用 H264 视频编解码器和AAC音频编解码器
			 *WebM = WebM 文件使用 VP8 视频编解码器和 Vorbis 音频编解码器
			 *Ogg = Ogg 文件使用 Theora 视频编解码器和 Vorbis音频编解码器
			 */
			editor.config.uploadVideoAccept = ['mp4','mpeg4','webm'];
			editor.config.uploadVideoServer = videouploadsrc;  // 上传视频到服务器

			editor.config.uploadVideoHooks  = {
				before: function(xhr) {
					alert('正在上传视频,请勿进行其他业务操作,请耐心等待,留意编辑栏的进度条和系统提示!');
					editor.disable();
				},
				// 视频上传并返回了结果，视频插入已成功
				success: function(xhr) {
					editor.enable();
				},
				// 视频上传并返回了结果，但视频插入时出错了
				fail: function(xhr, editor, resData) {
					editor.enable();
				},
				customInsert: function(insertVideoFn, result) {
					editor.enable();
					if('success' == result.res){
						console.info(result);
						insertVideoFn(result.rmsg);
					}

				}
			}
          editor.create();

          if (isEdit=="edit") {
			  editor.txt.html($("#infoContent").html()) ;
			  editor.enable();
          }
          if(isEdit=="query"){
        	  editor.txt.html($("#infoContent").html()) ;
			  editor.disable();
          }
    }
//富文本编辑器结束-----------------------------
function retList(){
	window.location.href=retrunUrl;
}
//表单数据初始化结束--------------------------------------