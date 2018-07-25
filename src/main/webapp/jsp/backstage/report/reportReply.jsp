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
<form id="editForm" method="POST" class="newsForm" >
    <input type="hidden" id="reportUuid" name="reportUuid" value='${report.reportUuid}' readonly="readonly"/>
    <div class=" panel-default" style="margin-top:15px; border: 1px solid #ddd;">
        <div class="panel-heading">
            <label style="background-color:#006699; color: #ffffff">申报信息</label>
        </div>
        <table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:10px;">
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
                <td width="30%"><input  id="reportTime" name="newsTitle"  editable="false" style="width:70%;"/></td>
            </tr>
            <tr>
                <td class="tds">申报内容：</td>
                <td width="30%" colspan="4"><input  id="reportContent" name="newsTitle" style="width:86%; height: 200px; border-radius:5px; border: 1px solid #ccc;"   editable="false" /></td>
            </tr>
        </table>
    </div>
    <c:if test="${report.reportType =='help' || report.reportType =='repair'}">
        <div class=" panel-default" style=" border: 1px solid #ddd;">
            <div class="panel-heading">
                <label style="background-color:#006699; color: #ffffff">回复信息</label>
            </div>
            <table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:10px;">
                <tr>
                    <td class="tds">回复人：</td>
                    <td width="30%"><input  id="replyUserName" name="replyUserName" editable="false" value="${report.replyUserName}" style="width:70%;"/></td>
                    <td class="tds">回复时间：</td>
                    <td width="30%"> <input  id="replyTime" name="replyTime" editable="false" value="${report.replyTime}" style="width:70%;"/></td>
                </tr>
                <tr>
                    <td class="tds">回复内容：</td>
                    <td width="30%" colspan="4"> <input  id="replyContent" name="replyContent" class="easyui-textbox" editable="false" value="${report.replyContent}" style="height: 200px; width:86%; border-radius:5px; border: 1px solid #ccc;"/></td>
                </tr>
            </table>
        </div>
        <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
            <input id="submitbtn" type="button" class="easyui-linkbutton" onclick=" exceReply()" value="回复"/>
            <input id="button" type="reset" class="easyui-linkbutton" onclick="retList()"  value="返回列表"/>
        </div>
    </c:if>

</form>
<!--全屏模式-->
<div id="cover" ></div>
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
            value : "${report.reportContent}",
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
                value : "${report.replyContent}",
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
                value : "${report.replyContent}",
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
</script>