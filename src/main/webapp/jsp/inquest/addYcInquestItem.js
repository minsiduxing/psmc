/**
 * 提交
 * @returns
 */
function save(e){
    event.preventDefault();
    var isCustom = $("input[name='isCustom1']:checked").val();
    $("#isCustom").val(isCustom);
    var result = $('#inquestItemForm').form("validate");
    if(!Boolean(result)){
        $.messager.alert('警告','请填写必填项！','warning');
        return;
    }
    var inquestItemdata = $("#inquestItemForm").serialize();
    $.messager.progress();
    $.ajax({
        type: "POST",
        url: addUrl,
        data: inquestItemdata,
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

function imageUpload(fileObj){
    $.messager.progress();
    $("#inquestItemForm").ajaxSubmit({
        url:uploadUrl,
        type:"post",
        dataType:"json",
        success:function(data){
            //$("#pic").append("<a href='javascript:"+imgShow(data.filePrefix + data.filePath)+"'>" +data.fileRealName +"."+data.fileSuffix +"</a>&nbsp;&nbsp;&nbsp;&nbsp;");
            var strHtml = '<tr id="'+data.attachmentUuid+'"><td>';
            strHtml += '<a href="javascript:void(0);" onclick="imgShow('+"'"+data.filePrefix + data.filePath+"'"+')" >' +data.fileRealName + '.'+data.fileSuffix + '</a></td>';

            strHtml += '<td><input style="width:50px; height: 25px;" class="easyui-linkbutton" onclick="deleteImage('+"'"+data.attachmentUuid + "','" + data.filePrefix + data.filePath +"'"+')" value="删除"/>';
            strHtml += '</td></tr>';
            $("#picTable").append(strHtml);
            $.parser.parse($("#picTable"));
            var attachmentUuids = $("#attachmentUuids").val();
            var displayAtlas = $("#displayAtlas").val();
            if(attachmentUuids){
                $("#attachmentUuids").val(attachmentUuids + "," + data.attachmentUuid);
            }else{
                $("#attachmentUuids").val(data.attachmentUuid);
            }
            if (displayAtlas){
                $("#displayAtlas").val(displayAtlas + ";" + data.filePrefix + data.filePath);
            }else {
                $("#displayAtlas").val(data.filePrefix + data.filePath);
            }
            $.messager.progress("close");
            commonObj.alert ("上传成功!","info");
            var file = $("#image");
            file.after(file.clone().val(""));
            file.remove();
        },error:function(){
            $.messager.progress("close");
            commonObj.alert ("上传失败!","warning");
        }
    });
}

function videoUpload(){
    $.messager.progress();
    $("#inquestItemForm").ajaxSubmit({
        url:uploadVideoUrl,
        type:"post",
        dataType:"json",
        success:function(data){
            if (data.res == 'success'){
                $("#displayVidio").val(data.rmsg);
                var videoName = data.rmsg.substring(data.rmsg.lastIndexOf("/") + 1);
                $("#videoName").html(videoName);
            }
            $.messager.progress("close");
            commonObj.alert ("上传成功!","info");
            var file = $("#video");
            file.after(file.clone().val(""));
            file.remove();
        },error:function(){
            $.messager.progress("close");
            commonObj.alert ("上传失败!","warning");
        }
    });
}

function deleteImage(attachmentUuid, path){
    $.messager.progress();
    $.ajax({
        url:deleteAttachment + "&uuid=" + attachmentUuid,
        type:"post",
        success:function(data){
            $.messager.progress("close");
            $("#" + attachmentUuid).hide();
            var displayAtlas = $("#displayAtlas").val();
            if (displayAtlas){
                displayAtlas = displayAtlas.replace(path + ";", "");
                displayAtlas = displayAtlas.replace(path, "");
                $("#displayAtlas").val(displayAtlas);
            }
            commonObj.showResponse(data);
        },error:function(){
            $.messager.progress("close");
            commonObj.alert ("删除失败!","warning");
        }
    });
}

function imgShow(imgUrl){
    $("#bigimg").attr("src", imgUrl);//设置#bigimg元素的src属性
    /*获取当前点击图片的真实大小，并显示弹出层及大图*/
    $("<img/>").attr("src", imgUrl).load(function(){

        var windowW = $(window).width();//获取当前窗口宽度
        var windowH = $(window).height();//获取当前窗口高度
        var realWidth = this.width;//获取图片真实宽度
        var realHeight = this.height;//获取图片真实高度
        var imgWidth, imgHeight;
        var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放
        if(realHeight>windowH*0.9) {//判断图片高度
            imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
            imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
            if(imgWidth>windowW*0.9) {//如宽度扔大于窗口宽度
                imgWidth = windowW*scale;//再对宽度进行缩放
            }
        } else if(realWidth>windowW*0.9) {//如图片高度合适，判断图片宽度
            imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
            imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
        } else {//如果图片真实高度和宽度都符合要求，高宽不变
            imgWidth = realWidth;
            imgHeight = realHeight;
        }

        $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放
        var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
        var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
        $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
        $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg

    });

    $("#outerdiv").click(function(){//再次点击淡出消失弹出层
        $(this).fadeOut("fast");
    });

}

function zoomImg(realHeight, realWidth, windowH, windowW){
    var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放
    if(realHeight>windowH*scale) {//判断图片高度
        imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
        imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
        if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
            imgWidth = windowW*scale;//再对宽度进行缩放
        }
    } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
        imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
        imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度
    } else {//如果图片真实高度和宽度都符合要求，高宽不变
        imgWidth = realWidth;
        imgHeight = realHeight;
    }
}