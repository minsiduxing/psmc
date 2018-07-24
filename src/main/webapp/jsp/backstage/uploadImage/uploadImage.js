var editdialog;

//表单dialog初始化方法
function initDialog(){
	editdialog = $("#uploadImageDiv").dialog({
		modal: true,
		closed: true,
	    width: 460,
	    height: 450,
	    resizable:true,
	    cache: false
	    /*buttons:[{
			text:'保存',
			iconCls:'icon-save'
			handler:function(){
					$('#editForm').form({    
					    url:saveAccountUrl,    
					    onSubmit: function(){
					    	return onSubmit();
					    },    
					    success:function(data){
					    	successCallback(data);
					    }
					}); 
					convertMd5();
					$('#editForm').submit(); 
					//$("#editdialogDiv").dialog('close');
			}
		}]*/
		
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

//截取图片后保存
$("#uploadform").ajaxForm({
    //url:"/BML/file/proimg/uploadImg?point="+cutPoint,
    type:"post",
    dataType:"json",
    success:function(data){
        var browserVersion= window.navigator.userAgent.toUpperCase();
        if(jcrop_api!=null){
        	jcrop_api.destroy();    
        }
        if (browserVersion.indexOf("MSIE")>-1){
            if(browserVersion.indexOf("MSIE 6")>-1){//ie6                    
                $("#target1").attr("src","/BML/files/proInfo/"+data.seriName);
            }else{//ie[7-9]
                $("#target1").attr("src","/BML/files/proInfo/"+data.seriName);
                //document.getElementById("targetNew").setAttribute("src","/BML/files/proInfo/"+data.seriName);
            }
        }else{
            $("#target1").attr("src","/BML/files/proInfo/"+data.seriName);
        }
        $("#picpath0").val(data.seriName);
    },error:function(){
         alert(getMessage(msgE0043));
    }
});


closeDiv('imgEditArea');

//onchange事件
function fileUpload(){

    if(!$('#upload_btn').val()){
    	return;
    }
    var str1 = $('#upload_btn').val();
    $('#target').attr('src',$('#upload_btn').val()); 
    
//    Ext.getCmp('idFakeFileInput').setValue($('#upload_btn').val());
//    var account = Ext.getCmp('idExpertCode').getValue();
//    $('#idTagDivPhoto img').remove();                    //移除jcrop的渲染
//    $('#idTagDivPhoto div').remove();
//    $('#aa img').remove();
//    $('#idTagDivPhoto').prepend('<img id = "target" src="none.png" width="240px" height="300px" class="jcrop-preview">');
//    $('#aa').prepend('<img id = "preview" src="none.png" width="112px" height="132px" class="jcrop-preview" alt="预览" >');
//    var type = $('#upload_btn').val().split('.')[$('#upload_btn').val().split('.').length-1];
//    if(type.toLowerCase()!='jpg' && type.toLowerCase()!='png'){
//        Ext.MessageBox.alert("提示","请选择 jpg 或者 png 格式的图片");
//        $('#upload_btn').val('');
//        Ext.getCmp('idFakeFileInput').setValue('');
//        return;
//    }
//    if($('#upload_btn').val()){
//        var form = $('#upload-file');
//        var options  = {    
//                url:getPath()+'/ExpertLibController.json?photoUpload=true',    
//                type:'post',    
//                data : {
//                    userAccount:account,
//                    state:'original',
//                    oldName:$('#idPhotoEditWin').data('photoName')
//                },
//                success:function(data){
//                    debugger;
//                     var obj = Ext.util.JSON.decode(data);
//                     if(obj['success']=='false'){
//                         Ext.MessageBox.alert("提示",obj['msg']);
//                         $('#upload_btn').val('');
//                         Ext.getCmp('idFakeFileInput').setValue('');
//                         return;
//                     }
//                     //D:\JavaEE\workspaces\eclipseTest\.metadata\.plugins\org.eclipse.wst.server.core\tmp4\wtpwebapps\zjInfoOS\zjfxjk\expertsLib\photos
//                     $('#target').attr('src','photos/'+obj['msg']+'');
//                     $('#preview').attr('src','photos/'+obj['msg']+'');
//                     $('#idPhotoEditWin').data('photoName',obj['msg']);            //注意，在头像编辑窗口中保存该属性
//                     methods.jcropTackle();
//                }
//            };
//        form.ajaxSubmit(options);
//    }
}

