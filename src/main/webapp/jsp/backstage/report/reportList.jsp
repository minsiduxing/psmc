<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <c:if test="${type=='help'}">
        <title>申报信息列表页面</title>
    </c:if>
    <c:if test="${type=='report'}">
        <title>申报信息列表页面</title>
    </c:if>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/backstage/report/reportList.js"></script>
<body id="body">
<!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%">
    <div title="信息查询" >
        <form id="searchform" method="POST" class="query-form" >
            <ul class="">
                <input hidden="hidden" name="reportType"value="${type}"/>
                <li class="li-input"><label for="" class="input-label">申报标题：</label>
                    <input class="myinput" id="reportTitle" name="reportTitle"/>
                </li>
                <li class="li-input"><label for="" class="input-label">申报人	：</label>
                    <input class="myinput" id="reportUserName" name="reportUserName"/>
                </li>
                <li class="li-input"><label for="" class="input-label">状态：</label>
                    <input id="reportStaus" name="reportStaus" />
                </li>
                <li class="li-input"><label for="" class="input-label">申报电话	：</label>
                    <input class="myinput" id="reportTel" name="reportTel"/>
                </li>
                <li class="li-input"><label for="" class="input-label">申报日期：</label>
                    <input id="reportTimeBegin" name="reportTimeBegin" value=""></input>
                </li>
                <li class="li-input"><label for="" class="input-label">至</label>
                    <input id="reportTimeEnd" name="reportTimeEnd" />
                </li>
            </ul>
        </form>
        <div class="query-oper">
            <a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('reportList','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
        </div>
    </div>
</div>
<!--信息查询结束  -->
<!--data grid  -->
<table id="reportList" style="width:100%"></table>
<!--工具栏  -->
<div id="toolbarId">
<c:if test="${type=='report'}">
    <g:auth operateNo="<%=OperateContantsUtil.INFO_REPORT_DELETE%>">
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
    </g:auth>
    <%--<g:auth operateNo="<%=OperateContantsUtil.INFO_REPORT_REPLY%>">--%>
        <%--<a href="#" id="replyReport" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">回复</a>--%>
    <%--</g:auth>--%>
    <g:auth operateNo="<%=OperateContantsUtil.INFO_REPORT_DEAL%>">
        <a href="#" id="reportDeal" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">处理</a>
    </g:auth>
    <g:auth operateNo="<%=OperateContantsUtil.INFO_REPORT_ACCEPT%>">
        <a href="#" id="reportAccept" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">受理</a>
    </g:auth>
    <g:auth operateNo="<%=OperateContantsUtil.INFO_REPORT_RECORD%>">
        <a href="#" id="reportRecord" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">备案</a>
    </g:auth>
</c:if>
<c:if test="${type=='help'}">
    <g:auth operateNo="<%=OperateContantsUtil.INFO_HELP_DELETE%>">
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
    </g:auth>
    <g:auth operateNo="<%=OperateContantsUtil.INFO_HELP_REPLY%>">
        <a href="#" id="replyReport" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">回复</a>
    </g:auth>
</c:if>
</div>

</body>
</html>
<script type="text/javascript">
    var basePath = $("#basePath").val();
    //申报controller
    var reportDo = basePath+"/website/backstage/reportController.do";
    //获取数据Url
    var getReportList = '<c:url value="'+reportDo+'"/>?method=get_report_page&reportType=${type}';
    //申报回复、明细
    var getReportReply = '<c:url value="'+reportDo+'"/>?method=to_report&reportUuid=';
    //删除信息
    var removeRport =   '<c:url value="'+reportDo+'"/>?method=delete';
    //更新申报信息
    var updateRport =   '<c:url value="'+reportDo+'"/>?method=deal_report';
    //----------------------------查询框初始化开始
    $('#reportTitle').textbox({
    });
    $('#reportUserName').textbox({
    });
    $('#reportTel').textbox({
    });
    $('#reportTimeBegin').datetimebox({
    });
    $('#reportTimeEnd').datetimebox({
    });
    commonObj.initDictCombobox("reportStaus","REPORT_STAUS","",false,true);

    //----------------------------查询框初始化结束
</script>
