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
          editor = new E('#editor-toolbar','#newsContent');
          editor.customConfig.uploadImgServer = imageuploadsrc;  // 上传图片到服务器
          editor.customConfig.uploadImgHooks = {
        		    // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        		    // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
        		    customInsert: function (insertImg, result, editor) {
        		        // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
        		        // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

        		        // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
        		    	console.info(result.rmsg);
        		        var url = getImag+result.rmsg;
        		        insertImg(url);

        		        // result 必须是一个 JSON 格式字符串！！！否则报错
        		    }
        		}
          editor.create();  
          if (isEdit=="edit") {
        	  editor.txt.html(newsContent) ;
          }
          if(isEdit=="query"){
        	  editor.txt.html(newsContent) ;
        	  editor.$textElem.attr('contenteditable', false);
          }
          // 获取使用到的元素
          var toolbarContaner = document.getElementById('toolbar-container');
          var editorText = document.getElementById('newsContent');
          var cover = document.getElementById('cover');
          var container = document.getElementById('container');
          $("#newsContent").css("z-index","998");
          // 全屏事件
          /*function doFullScreen() {
              cover.style.display = 'block';
              $("#cover").addClass("cover");
              editorText.style.height = '90%';
              editorText.style.width = '100%';
              toolbarContaner.style.width = '100%';
              cover.appendChild(toolbarContaner);
              cover.appendChild(editorText);
              $('#btn1').text("退出全屏");
          }

          // 退出全屏事件
          function unDoFullScreen() {
        	  debugger;
        	  event.preventDefault();
              container.appendChild(toolbarContaner);
              container.appendChild(editorText);
              editorText.style.height = '100%';
              editorText.style.width = '88.5%';
              toolbarContaner.style.width = '88.5%';
              $("#cover").removeClass("cover");
              $('#btn1').text("全屏");
          }

          // 是否是全屏的标志
          var isFullScreen = false

          // 点击事件
          var btn1 = document.getElementById('btn1');
          btn1.addEventListener('click', function () {
              if (isFullScreen) {
                  isFullScreen = false;
                  unDoFullScreen();
              } else {
                  isFullScreen = true;
                  doFullScreen();
              }
          }, false);*/
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