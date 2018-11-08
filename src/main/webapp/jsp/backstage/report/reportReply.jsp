<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <style type="text/css">
        .ibox {
            clear: both;
            margin-bottom: 25px;
            margin-top: 0;
            padding: 0
        }
        .tds{
            text-align:right;
            width:15%
        }

    </style>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
<%@ include file="../../../common.jsp"%>
<body id="body">
<form id="editForm" method="POST"  >
    <input type="hidden" id="reportUuid" name="reportUuid" value='${report.reportUuid}' readonly="readonly"/>
    <div class=" panel-default" style="margin-top:15px; border: 1px solid #ddd;">
        <div class="panel-heading">
            <label style="background-color:#006699; color: #ffffff">申报信息</label>
        </div>
        <table class="table table-hover" style="font-size:12px; width:70%; border-collapse:separate; border-spacing:10px;">
            <tr>
                <td class="tds">申报标题：</td>
                <td width="30%"> <input  id="reportTitle" name="newsTitle" style="width:70%;"/></td>
                <td class="tds">申报电话：</td>
                <td width="30%"> <input  id="reportTel" name="reportTel" style="width:70%;"/></td>
            </tr>
            <tr>
                <td class="tds">申报人姓名：</td>
                <td width="30%">  <input  id="reportUserName" name="newsTitle" style="width:70%;"/></td>
                <td class="tds">申报时间：</td>
                <td width="30%"><input  id="reportTime" name="newsTitle"  style="width:70%;"/></td>
            </tr>
            <tr>
                <td class="tds">申报内容：</td>
                <td width="30%" colspan="4"><input  id="reportContent" name="newsTitle" style="width:86%; height: 150px; border-radius:5px; border: 1px solid #ccc;"   editable="false" value="${report.reportContent}"/></td>
            </tr>
            <c:if test="${report.reportType == 'repair'}">
            	<tr>
            		<td class="tds">材料附件：</td>
            		<td>
				    	<c:forEach var="att" items="${attachmentList}" varStatus="status">
			        		<a href="javascript:imgShow('${att.file_prefix }${att.file_path}')">${att.file_real_name}.${att.file_suffix}</a>
			        	</c:forEach>
	                 </td>
            	</tr>
            </c:if>
        </table>
    </div>
    <c:if test="${report.reportType !='report'}">
        <div class=" panel-default" style=" border: 1px solid #ddd; margin-top: 5px;">
            <div class="panel-heading">
                <label style="background-color:#006699; color: #ffffff">回复信息</label>
            </div>
            <table class="table table-hover" style="font-size:12px; width:70%; border-collapse:separate; border-spacing:10px;">
                <tr>
                    <td class="tds">回复人：</td>
                    <td width="30%"><input  id="replyUserName" name="replyUserName"  value="${report.replyUserName}" style="width:70%;"/></td>
                    <td class="tds">回复时间：</td>
                    <td width="30%"> <input  id="replyTime" name="replyTime"  value="${report.replyTime}" style="width:70%;"/></td>
                </tr>
                <tr>
                    <td class="tds">回复内容：</td>
                    <td width="30%" colspan="4"> <input  id="replyContent" name="replyContent" class="easyui-textbox" value="${report.replyContent}" style="height: 150px; width:86%; border-radius:5px; border: 1px solid #ccc;"/></td>
                </tr>
            </table>
        </div>
    </c:if>
	<div style= "width:75%; margin-top: 20px" class="operButon" align="center">
		 <c:if test="${report.reportType !='report'}">
         	<input id="submitbtn" type="button" class="easyui-linkbutton" onclick=" exceReply()" value="回复"/>
         </c:if>
         <input id="button" type="reset" class="easyui-linkbutton" onclick="retList()"  value="返回列表"/>
    </div>
</form>
<!--全屏模式-->
<div id="cover" ></div>
<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:10000;width:100%;height:100%;display:none;">
    <div id="innerdiv" style="position:absolute;">
        <img id="bigimg" style="border:5px solid #fff;" src="" />
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    var basePath = $("#basePath").val();
    //申报controller
    var reportDo = basePath+"/website/backstage/reportController.do";
    //回复申报信息
    var repley = '<c:url value="'+reportDo+'"/>?method=replyReport';
    //返回列表
    var goReportList = '<c:url value="'+reportDo+'"/>?method=index&type=${report.reportType}';
    $(document).ready(function(){
        $("#submitbtn").hide();
        $('#reportContent').textbox({
            editable:false,
            multiline:true,
            type : "text"
        });
        $('#reportTitle').textbox({
            value : "${report.reportTitle}",
            editable:false,
            type : "text"
        });
        $('#reportTel').textbox({
            value : "${report.reportTel}",
            editable:false,
            type : "text"
        });
        $('#reportUserName').textbox({
            value : "${report.reportUserName}",
            editable:false,
            type : "text"
        });
        $('#reportTime').textbox({
            value : '<fmt:formatDate value="${report.reportTime}" pattern="yyyy-MM-dd HH:mm:ss" />',
            editable:false,
            type : "text"
        });
        relelyDisply();
    });
    //返回申报列表
    function retList() {
        window.location.href = goReportList;
    }
    //确认是否可以回复
    function relelyDisply() {
        var status = "${report.reportStaus}";
        //如果没有回复则显示回复内容，和回复按钮
        if("2"==status){
            $("#submitbtn").show();
            $('#replyContent').textbox({
                editable:true,
                required : true,
                multiline:true,
                type : "text"
            });
            $('#replyUserName').textbox({
                value : "${report.replyUserName}",
                editable:true,
                required : true,
                type : "text"
            });
            $('#replyTime').datetimebox({
                value : '<fmt:formatDate value="${report.replyTime}" pattern="yyyy-MM-dd HH:mm:ss"  />',
                editable:false,
                type : "text"
            });
        }else if("1"==status){
            $('#replyContent').textbox({
                editable:false,
                multiline:true,
                type : "text"
            });
            $('#replyUserName').textbox({
                value : "${report.replyUserName}",
                editable:false,
                type : "text"
            });
            $('#replyTime').textbox({
                value : '<fmt:formatDate value="${report.replyTime}" pattern="yyyy-MM-dd HH:mm:ss"  />',
                editable:false,
                type : "text"
            });
        }
    }
    //回复消息
    function exceReply(){
        if($("#replyContent").val()=="" || $("#replyUserName").val()==""){
            commonObj.alert("请填写必填项!","warning");
            return ;
        }
        var formdata = $("#editForm").serialize();
        $.messager.progress();
        $.ajax({
            type: "POST",
            url: repley,
            data:formdata,
            success: function(data){
                successCallback(data);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                $.messager.progress("close");
            }
        });
    }
    //表单提交成功后的回调方法
    function successCallback(data){
        $.messager.progress("close");
        $("#accountTableId").datagrid('reload');
        commonObj.showResponse(data);
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
</script>