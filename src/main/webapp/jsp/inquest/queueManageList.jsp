<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>区域坐标维护</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/inquest/queueManageList.js"></script>
<body id="body">
<!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%">
    <div title="信息查询" >
        <form id="searchform" method="POST" class="query-form" >
            <ul class="">
                <li class="li-input"><label for="" class="input-label">经营者姓名：</label>
                    <input id="managerName" name="managerName"/>
                </li>
                <li class="li-input"><label for="" class="input-label">企业名称：</label>
                    <input id="companyName" name="companyName" />
                </li>
                <li class="li-input"><label for="" class="input-label">归属网格名称：</label>
                    <input id="gridName" name="gridName" />
                </li>
                <li class="li-input"><label for="" class="input-label">申请状态：</label>
                    <input id="applyStatus" name="applyStatus" />
                </li>
                <li class="li-input"><label for="" class="input-label">是否优先：</label>
                    <input id="isPriority" name="isPriority" />
                </li>
            </ul>
        </form>
        <div class="query-oper">
            <a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('queueManageList','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
        </div>
    </div>
</div>
<!--信息查询结束  -->
<!--data grid  -->
<table id="queueManageList" style="width:100%"></table>


</body>
</html>

<script type="text/javascript">
    var basePath = $("#basePath").val();
    var inquestDo = basePath+"/inquest/tabYcQueueManageController.do";
    var selectQueueManagePageUrl ='<c:url value="'+inquestDo+'"/>?method=selectQueueManagePage';

    //----------------------------查询框初始化开始
    $('#managerName').textbox({
    });
    $('#companyName').textbox({
    });
    $('#gridName').textbox({
    });

    commonObj.initDictCombobox("applyStatus","APPLY_STATUS","",false,true);
    commonObj.initDictCombobox("isPriority","IF","",false,true);
    //----------------------------查询框初始化结束
    //表单提交成功后的回调方法
    function successCallback(data){
        $.messager.progress("close");
        $("#queueManageList").datagrid('reload');
        commonObj.showResponse(data);
    }
    var uuids="";

</script>
