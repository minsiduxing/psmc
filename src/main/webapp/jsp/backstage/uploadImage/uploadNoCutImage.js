

function previewImageNoCut(fileObj){
  var imgPreviewId = "targetView";
  var allowExtention=".jpg,.bmp,.gif,.png,.jpeg";//允许上传文件的后缀名
  var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();
  var browserVersion= window.navigator.userAgent.toUpperCase();
  if(allowExtention.indexOf(extention)>-1){
    $("#"+imgPreviewId).css({"max-width":"100%", "max-height":"100%", "width":"auto", "height":"auto"});
    if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等
      if(window.FileReader){
        var reader = new FileReader();
        reader.onload = function(e){
          document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
        };
        reader.readAsDataURL(fileObj.files[0]);
      }
    }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox
      var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
      if(firefoxVersion<7){//firefox7以下版本
        document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());
      }else{//firefox7.0+
        document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));
      }
    }else{
      document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
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

function imageNoCutUpload(){
  var uploadPhotoNoCutUrl = uploadPhotoNoCut;
  $.messager.progress();
  $("#upload-file-no-cut").ajaxSubmit({
    url:uploadPhotoNoCutUrl,
    type:"post",
    dataType:"json",
    success:function(data){
      $("#imagePath").val(data.rmsg);
      $.messager.progress("close");
      commonObj.alert ("上传成功!","info");
    },error:function(){
      $.messager.progress("close");
      commonObj.alert ("上传失败!","warning");
    }
  });
}

function closeNoCutDialog(){
  $('#uploadNoCutImageDiv').dialog('close');
}