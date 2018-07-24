var editdialog;

//表单dialog初始化方法
function initDialog(){
	editdialog = $("#uploadImageDiv").dialog({
		modal: true,
		closed: true,
	    width: 480,
	    height: 460,
	    resizable:true,
	    cache: false
	});
}

//打开图片上传dialog
function openUploadDialog(){
	if(!editdialog){
		initDialog();
	}
	editdialog.panel({title:"选择图片"});
	editdialog.panel({iconCls:'icon-save'});
	editdialog.panel({href:toImageUpload});
	editdialog.window("open");
}

var jcrop_api;
function previewImage(fileObj){
    $("#x").val("");
    $("#y").val("");
    $("#w").val("");
    $("#h").val("");
    if(jcrop_api!=null){
    	jcrop_api.destroy();    
    }
    var imgPreviewId = "target";
    var allowExtention=".jpg,.bmp,.gif,.png,.jpeg";//允许上传文件的后缀名
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();            
    var browserVersion= window.navigator.userAgent.toUpperCase();
    if(allowExtention.indexOf(extention)>-1){ 
        if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等
            if(window.FileReader){
                var reader = new FileReader(); 
                reader.onload = function(e){
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
                    $("#preview").attr("src",$("#"+imgPreviewId).attr("src"));
                    createJCrop(imgPreviewId);
                };  
                reader.readAsDataURL(fileObj.files[0]);
            }else if(browserVersion.indexOf("SAFARI")>-1){
                alert(getMessage(msgE0042));
            }
        }else if (browserVersion.indexOf("MSIE")>-1){
            $("#uploadform").ajaxForm({
                url:"/BML/file/proimg/iesrc",
                type:"post",
                dataType:"json",
                success:function(data){
                $("#"+imgPreviewId).attr("src","/BML/files/proInfo/temp/"+data.seriName);
                $("#preview").attr("src","/BML/files/proInfo/temp/"+data.seriName);
                createJCrop(imgPreviewId);
                },error:function(){
                    alert(getMessage(msgE0005, uploadPic));
                }
             });
            $("#uploadform").submit();
        }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
            if(firefoxVersion<7){//firefox7以下版本
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());
                $("#preview").attr("src",$("#"+imgPreviewId).attr("src"));
                createJCrop(imgPreviewId);
            }else{//firefox7.0+                    
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));
                $("#preview").attr("src",$("#"+imgPreviewId).attr("src"));
                createJCrop(imgPreviewId);
            }
        }else{
            document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
            $("#preview").attr("src",$("#"+imgPreviewId).attr("src"));
            createJCrop(imgPreviewId);
        }         
    }else{
    	commonObj.alert("图片格式支持jpg,bmp,gif,png,jpeg!","warning");
        fileObj.value="";//清空选中文件
        if(browserVersion.indexOf("MSIE")>-1){                        
            fileObj.select();
            document.selection.clear();
        }                
        fileObj.outerHTML=fileObj.outerHTML;
    }
}
// 创建jcrop,图片剪切区域选择最主要的函数
function createJCrop(divId) {
	
     var boundx,
         boundy,
         $preview = $('#preview-panel'),
         $pcnt = $('#preview-panel .previewDiv'),
         $pimg = $('#preview-panel .previewDiv img'),

         xsize = $pcnt.width(),
         ysize = $pcnt.height();
     
     $('#'+divId).Jcrop({
         onChange: updatePreview,
         onSelect: updatePreview,
         aspectRatio: 1
       },function(){
         var bounds = this.getBounds();
         boundx = bounds[0];
         boundy = bounds[1];
         jcrop_api = this;

//         $preview.appendTo(jcrop_api.ui.holder);
       });
     
     function updatePreview(c)
     {
         if (parseInt(c.w) > 0)
         {
             var rx = xsize / c.w;
             var ry = ysize / c.h;
             $pimg.css({
                   width: Math.round(rx * boundx) + 'px',
                   height: Math.round(ry * boundy) + 'px',
                   marginLeft: '-' + Math.round(rx * c.x) + 'px',
                   marginTop: '-' + Math.round(ry * c.y) + 'px'
             });
         }
         $("#w").attr("value",Math.round(c.w));
         $("#h").attr("value",Math.round(c.h));
         $("#x").attr("value",Math.round(c.x));
         $("#y").attr("value",Math.round(c.y));
         $("#boundx").attr("value",Math.round(boundx));
         $("#boundy").attr("value",Math.round(boundy));
     };
}

function imageUpload(){
	var uploadUrl = uploadPhoto;
	$("#upload-file").ajaxSubmit({
	    url:uploadUrl,
	    type:"post",
	    dataType:"json",
	    success:function(data){
	        var browserVersion= window.navigator.userAgent.toUpperCase();
	        if(jcrop_api!=null){
	        	jcrop_api.destroy();    
	        }
	        $("#imagePath").val(data.rmsg);
//	        if (browserVersion.indexOf("MSIE")>-1){
//	            if(browserVersion.indexOf("MSIE 6")>-1){//ie6                    
//	                $("#target1").attr("src","/BML/files/proInfo/"+data.seriName);
//	            }else{//ie[7-9]
//	                $("#target1").attr("src","/BML/files/proInfo/"+data.seriName);
//	                //document.getElementById("targetNew").setAttribute("src","/BML/files/proInfo/"+data.seriName);
//	            }
//	        }else{
//	            $("#target1").attr("src","/BML/files/proInfo/"+data.seriName);
//	        }
//	        $("#picpath0").val(data.seriName);
	    },error:function(){
	    	commonObj.alert ("上传失败!","warning");
	    }
	});
}

function closeDialog(){
	$('#uploadImageDiv').dialog('close');
}

