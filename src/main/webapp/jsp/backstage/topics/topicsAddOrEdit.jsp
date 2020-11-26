<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
	.tds{
		text-align:right;
		width:10%
	}
	
  </style>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
  </head>
  <%@ include file="../../../common.jsp"%>
  <body id="body">

	<div class=" panel-default" style="margin-top:15px; border: 1px solid #ddd;">
	<form id="editForm" method="POST" enctype="multipart/form-data">
		<input type="hidden" id="topicUuid" name="topicUuid" value="${topic.topic_uuid}"/>
		<input type="hidden" id="blockUuid" name="blockUuid" value="${blockUuid}"/>
		<input type="hidden" id="attachmentUuids" name="attachmentUuids" value=""/>
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:15px;" >
		
			<tr>
				<td class="tds">信息标题：</td>
				<td width="25%">
					<input id="topicName" name="topicName" value="${topic.topic_name}" style="width:30%;"/>
				</td>
			</tr>
			<tr>
				<td class="tds">信息内容：</td>
				<td width="25%">
					<textarea style="width:70%; border-radius:5px; border: 1px solid #ccc;" rows="10" cols="" id="topicContent" name="topicContent">${topic.topic_content}</textarea>
				</td>
			</tr>
		
		
			<tr>
				<td class="tds">选择图片：</td>
				<td width="25%">
					<input id="image" name="image" type="file" style="width:30%;border-radius:5px; border: 1px solid #ccc; margin-right: 10px;"/>
					<input style="width:50px; height: 25px;" id="upload" class="easyui-linkbutton" onclick="imageUpload();" value="上传"/>
				</td>
			</tr>
			<tr>
				<td class="tds">图片附件：</td>
				<td width="25%">
				    <div id="pic">
				    	<%-- <c:forEach var="att" items="${attachmentList}" varStatus="status">
			        		<a href="javascript:imgShow('${att.file_prefix }${att.file_path}')">${att.file_real_name}.${att.file_suffix}</a>
			        	</c:forEach> --%>
			        	<table id="picTable" width="80%">
			        		<c:forEach var="att" items="${attachmentList}" varStatus="status">
			        		<tr id="${att.attachment_uuid }">
			        			<td ><a href="javascript:savepic('${att.file_prefix }${att.file_path}')">${att.file_real_name}.${att.file_suffix} </a></td>
			        			<td ><input style="width:50px; height: 25px;" class="easyui-linkbutton" onclick="deleteImage('${att.attachment_uuid}')" value="删除"/></td>
			        		</tr>
			        		
			        	</c:forEach>
			        	</table>
	                </div>
				</td>
			</tr>
		
		</table>
		</form>
	</div>
	 <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
			<input id="submitbtn" type="button" class="easyui-linkbutton" onclick="save()" value="提交"/>
			<input id="button" type="reset" class="easyui-linkbutton" onclick=" retList() "  value="返回列表"/>
	</div>
	<img id='downImg' src='' style='display: none;' />
	<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:10000;width:100%;height:100%;display:none;">
		    <div id="innerdiv" style="position:absolute;">
		        <img id="bigimg" style="border:5px solid #fff;" src="" />
		    </div>
		</div>
  </body>
</html>
<script type="text/javascript">
var basePath = $("#basePath").val();

//上传图片
var uploadUrl = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileUploadByPC';
var addTopicsUrl = '<c:url value="/website/backstage/tabTopicsController.do"/>?method=addTopics';	
var toTopicsListPage = '<c:url value="/website/backstage/tabTopicsController.do"/>?method=toTopicsListPage&blockUuid='+$("#blockUuid").val();
//删除图片附件
var deleteAttachment = '<c:url value="/website/backstage/tabAttachmentController.do"/>?method=deleteAttachment';	

	$('#topicName').textbox({
		type:"text",
        required : true
	});
	
	$("#topicContent").validatebox({
		required: true,    
	    validType: "text"
	});

	function imageUpload(fileObj){
		$.messager.progress(); 
		$("#editForm").ajaxSubmit({
		    url:uploadUrl,
		    type:"post",
		    dataType:"json",
		    success:function(data){
		    	//$("#pic").append("<a href='javascript:"+imgShow(data.filePrefix + data.filePath)+"'>" +data.fileRealName +"."+data.fileSuffix +"</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		    	var strHtml = '<tr id="'+data.attachmentUuid+'"><td>';
		    	strHtml += '<a href="javascript:'+imgShow(data.filePrefix + data.filePath) +'">' +data.fileRealName + '.'+data.fileSuffix + '</a></td>';
		    	strHtml += '<td><input style="width:50px; height: 25px;" class="easyui-linkbutton" onclick="deleteImage('+"'"+data.attachmentUuid+"'"+')" value="删除"/>';
		    	strHtml += '</td></tr>';
		    	$("#picTable").append(strHtml);
		    	$.parser.parse($("#picTable"));
		    	var attachmentUuids = $("#attachmentUuids").val()
		    	if(attachmentUuids){
		    		$("#attachmentUuids").val(attachmentUuids + "," + data.attachmentUuid);
		    	}else{
		    		$("#attachmentUuids").val(data.attachmentUuid);
		    	}
		        $.messager.progress("close");
		        commonObj.alert ("上传成功!","info");
		    },error:function(){
		    	$.messager.progress("close");
		    	commonObj.alert ("上传失败!","warning");
		    }
		});
	}
	
	function deleteImage(attachmentUuid){
		$.messager.progress(); 
		$.ajax({
		    url:deleteAttachment + "&uuid=" + attachmentUuid,
		    type:"post",
		    success:function(data){
		        $.messager.progress("close");
		        $("#" + attachmentUuid).hide();
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
	
	function save(){
		event.preventDefault();
		var result = $('#editForm').form("validate");
		if(!Boolean(result)){
			$.messager.alert('警告','请填写必填项！','warning');
			return;
		}
		var topicdata = $("#editForm").serialize();
		var url = addTopicsUrl;
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: url,
			   data:topicdata,
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
		window.location.href=toTopicsListPage;
	}
	
	function downLoadIamge(url){
		//如果隐藏IFRAME不存在，则添加
        if (!document.getElementById("IframeReportImg"))
        $('').appendTo("body");
        
        if ($("#IframeReportImg").src != url) {
            //加载图片
            $("#IframeReportImg").src = url;
        }
        if ($("#IframeReportImg").src != "about:blank")
        	$("#IframeReportImg").document.execCommand("SaveAs");
	}
	
	/* function download(url) {
		debugger;
		var a = window.open(url)
		a.document.execCommand('Saveas',true,"test.png")
		a.window.close()
		return false
    } */
	
    function savepic(url) { 
    	　　if (document.all.a1 == null) { 
    	　　　　var objIframe = document.createElement("IFRAME"); 
    	　　　　document.body.insertBefore(objIframe, document.getElementById("outerdiv")); 
    	　　　　objIframe.outerHTML = "<iframe name=a1 style='width:400px;hieght:300px' src=" + url + "></iframe>"; 
    	　　　　var re = setTimeout("savepic()", 1) 
    	　　} else { 
    	　　　　clearTimeout(re) 
    	　　　　var pic = window.open(url, "a1") 
    	　　　　pic.document.execCommand("SaveAs") 
    	　　　　document.all.a1.removeNode(true) 
    	　　} 
    	} 
	

</script>
