<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>勘验配置列表</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/inquest/waitQueueCfgList.js"></script>
<body id="body">
<!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%">
    <div title="信息查询" >
        <form id="searchform" method="POST" class="query-form" >
            <ul class="">
                <li class="li-input"><label for="" class="input-label">所属专卖局：</label>
                    <input id="orgCode" name="orgCode"/>
                </li>

            </ul>
        </form>
        <div class="query-oper">
            <a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('waitQueueCfgList','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
        </div>
    </div>
</div>
<!--信息查询结束  -->
<!--data grid  -->
<table id="waitQueueCfgList" style="width:100%"></table>


</body>
</html>

<script type="text/javascript">
    var basePath = $("#basePath").val();
    var inquestDo = basePath+"/inquest/tabYcWaitQueueCfgController.do";
    var selectWaitQueueCfgPageUrl ='<c:url value="'+inquestDo+'"/>?method=selectWaitQueueCfgPage';

    //----------------------------查询框初始化开始

    commonObj.initDictCombobox("orgCode","BELONG_TO_ZMJ","",false,true);
    //----------------------------查询框初始化结束
    //表单提交成功后的回调方法
    function successCallback(data){
        $.messager.progress("close");
        $("#waitQueueCfgList").datagrid('reload');
        commonObj.showResponse(data);
    }
    var uuids="";

</script>
