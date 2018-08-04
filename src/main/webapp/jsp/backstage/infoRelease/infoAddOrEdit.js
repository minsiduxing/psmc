

/**
 * 页面初始化
 */

$(function(){
	//富文本编辑器初始化
	wangEditorInit(isEdit);
	//表单初始化
	formInint(isEdit);
	/*//图片初始化
	newsPicInit(isEdit);*/
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
	/*if($("#hiddenfile").val()==''){
		commonObj.alert ("新闻配图不能为空!","warning");
		return false;
	}*/
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
 * 图片上传编辑---------------------------------------------
 *//*
function newsPicInit(isEdit){
	//用户离开页面删除临时文件
	window.onbeforeunload=function(){
    	//deleteFile();
    	return "";
    }
    if (isEdit=="isEdit") {
    	$("#isedit").val("isEdit");
    	showPicpreview(editnewssrc,"false");
    }
	    var newsPicWidth=0,newsPicHeight=0,imgWidth=0,imgHeight=0;
		var x,y,w,h;
		var pirSrc ;
		
	    $('#thumbnailImageUrl').Huploadify({
	        auto:true,
	        fileTypeExts:'*.jpg;*.png;*.JPG',
	        multi:false,
	        formData:{key:123456,key2:'vvvv'},
	        fileSizeLimit:1024,
	        fileObjName:'newsPic',
	        showUploadedPercent:true,
	        showUploadedSize:true,
	        uploader:uploadUrl,
	        buttonText:'选择图片',
	        onUploadStart:function(){
	            console.log('开始上传');
	            $('.uploadify-queue').html('');
	            },
	        onInit:function(){
	            console.log('初始化');
	            $(".uploadify-queue ").hide();
	            },
	        onUploadComplete:function(file,data){
	        	var ao = $.parseJSON(data);
	        	if(ao.result=='1') {
	        		deleteFile();
	        		pirSrc = ao.picSrc;
	        		newpic =$.parseJSON(ao.newsPic);
	        		showPicpreview(ao.picSrc,"true");
	        		newsPicWidth = newpic.newsPicWidth;
					newsPicHeight = newpic.newsPicHeight;
					imgWidth = ao.newsPic.imgWidth;
					imgHeight = ao.newsPic.imgHeight;
					$("#picpreimg").before("<div id='pc' style='width:"+newsPicWidth+"px;height:"+newsPicHeight+"px;overflow:hidden;margin-bottom:5px;'><img id='preview' src='"+getImag+pirSrc+"'/></div>");
					$("#picpreimg ").Jcrop({
						aspectRatio:newsPicWidth/newsPicHeight,
						onChange: showPreview,
						onSelect: showPreview,
						allowResize:false ,
						setSelect: [0,0,newsPicWidth,newsPicHeight]
					});
					$("#confirmSelect").click(confirmSelect);
	        	}else{
	        		alert(ao.msg);
	        	}
	            },
	        onCancel:function(file){
	            console.log(file);
	        }
	    });
	    //预览图片显示
	    function showPicpreview(picSrc,showbtn){
	    	var previewImg='<img alt="预览图片" id="picpreimg" src='+getImag+picSrc+'>';
	    	if(showbtn=="true"){
	    		var imgBtn ='<input type="button" value="上传" id="confirmSelect" class="img-btn" id="confirmSelect"/>';
	        	$("#picpreview").append(imgBtn+previewImg);
	    	}else{
	    		$("#picpreview").append(previewImg);
	    	}
	    }
	    //重新上传时删除已经存在的图片
	  function deleteFile(){
	    	var imgSrc = $("#picpreimg").attr("src");
	            if(imgSrc!=undefined && imgSrc!=''&& isEdit!="isEdit"){
	            	_url = _url+imgSrc.substring(imgSrc.indexOf("h=")+2,imgSrc.length);
	            	alert(_url);
	            	$.ajax({
	     				async:false,
	     				cache:false,
	     				type:'GET',
	     				url:_url,
	     				success:function(data){
	     					var dataObj = JSON.parse(data);
	     					console.info(dataObj.msg);
	     				},
	     				error:function (XMLHttpRequest, textStatus, errorThrown) {
	     					alert(textStatus);
	     					commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
	     				}
	     			});
	            	$("#preview").remove();
					$("#picpreimg").remove();
					$(".jcrop-holder").remove();
					$("#pc").remove();
					$("#confirmSelect").remove();
	            	$("#preview").remove();
	            }
	   };
	   //修改图片预览
	   function showPreview(coords)
		{
			if (parseInt(coords.w) > 0)
			{
				var rx = newsPicWidth / coords.w;
				var ry = newsPicHeight / coords.h;
				x = coords.x;
				y = coords.y;
				h = coords.h;
				w = coords.w;
				jQuery('#preview').css({
					width: Math.round(rx * imgWidth) + 'px',
					height: Math.round(ry * imgHeight) + 'px',
					marginLeft: '-' + Math.round(rx * coords.x) + 'px',
					marginTop: '-' + Math.round(ry * coords.y) + 'px'
				});
			}
		}
	   //上传修改后的图片
	   function confirmSelect() {
			//var tn = newName.replace("\.","#");
			//alert(tn);			
			$.post(path,{w:w,h:h,x:x,y:y,pirSrc:pirSrc},function(data) {
					var ao = $.parseJSON(data);
					console.info(ao);
					if(ao.result=='1'){
						$("#preview").remove();
						$("#picpreimg").remove();
						$(".jcrop-holder").remove();
						$("#pc").remove();
						$("#confirmSelect").remove();
						showPicpreview(ao.newsrc,"false");
						$("#hiddenfile").val(ao.newsrc);
					}else{
						alert(ao.msg);
					}
					
			},"text")
		}
}
//图片上传编辑结束------------------------------------------
*//**
 * 富文本编辑器初始化-----------------------------------
 */
function  wangEditorInit(isEdit){
    	  var E = window.wangEditor
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
        	  editor.txt.html(newscontent) ;
          }
          if(isEdit=="query"){
        	  editor.txt.html(newscontent) ;
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
              editorText.style.width = '80%';
              toolbarContaner.style.width = '80%';
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
function retList(){
	window.location.href=retrunUrl;
}
//表单数据初始化结束--------------------------------------