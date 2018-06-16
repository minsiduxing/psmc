<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
<%@ include file="../../../common.jsp"%>
<body id="body">
<form id="editForm" method="POST" class="newsForm" >
    <input type="hidden" id="reportUuid" name="reportUuid" value='${report.reportUuid}' readonly="readonly"/>
    <ul >
        <li ><label>申报标题</label><br>
            <input  id="reportTitle" name="newsTitle"/>
        </li>
        <li><label>申报内容</label><br>
            <input  id="reportContent" name="newsTitle" style="height: 200px;width: 450px;" editable="false"/>
        </li>
        <li ><label>申报人姓名</label><br>
            <input  id="reportUserName" name="newsTitle"/>
        </li>
        <li ><label >申报时间</label><br>
            <input  id="reportTime" name="newsTitle"/>
        </li>
        <li ><label >回复内容</label><br>
            <input  id="replyContent" name="replyContent" class="easyui-textbox" style="height: 200px;width: 450px;" editable="false" value="${report.replyContent}"/>
        </li>
        <li ><label >回复人</label><br>
            <input  id="replyUserName" name="replyUserName" editable="false" value="${report.replyUserName}"/>
        </li>
        <li ><label >回复时间</label><br>
            <input  id="replyTime" name="replyUserName" editable="false" value="${report.replyTime}"/>
        </li>
    </ul>

    <div class="operButon">
        <input id="submitbtn" type="button" class="easyui-linkbutton" onclick=" exceReply()" value="回复"/>
        <input id="button" type="reset" class="easyui-linkbutton" onclick="retList()"  value="返回列表"/>
    </div>
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
        $('#reportUserName').textbox({
            value : "${report.reportUserName}",
            editable:false,
            type : "text"
        });
        $('#reportTime').textbox({
            value : '<fmt:formatDate value="${report.reportTime}" pattern="yyyy年MM月dd日HH点mm分ss秒" />',
            editable:false,
            type : "text"
        });
        $('#replyTime').textbox({
            value : '<fmt:formatDate value="${report.replyTime}" pattern="yyyy年MM月dd日HH点mm分ss秒" />',
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