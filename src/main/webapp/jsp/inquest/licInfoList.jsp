<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>许可证信息维护</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/inquest/licInfoList.js"></script>
<body id="body">
<!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%">
    <div title="信息查询" >
        <form id="searchform" method="POST" class="query-form" >
            <ul class="">
                <%--<li class="li-input"><label for="" class="input-label">勘验阶段：</label>
                    <input id="stageCode" name="stageCode"/>
                </li>--%>
                <li class="li-input"><label for="" class="input-label">许可证号：</label>
                    <input id="licNo" name="licNo"/>
                </li>
                <li class="li-input"><label for="" class="input-label">归属网格名称：</label>
                    <input id="gridName" name="gridName" />
                </li>
                <li class="li-input"><label for="" class="input-label">许可证状态：</label>
                    <input id="licStatus" name="licStatus" />
                </li>
            </ul>
        </form>
        <div class="query-oper">
            <a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('licInfoList','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
        </div>
    </div>
</div>
<!--信息查询结束  -->
<!--data grid  -->
<table id="licInfoList" style="width:100%"></table>


</body>
</html>

<script type="text/javascript">
    var basePath = $("#basePath").val();
    var inquestDo = basePath+"/inquest/tabYcLicInfoController.do";
    var selectLicInfoPageUrl ='<c:url value="'+inquestDo+'"/>?method=selectLicInfoPage';

    //----------------------------查询框初始化开始
    $('#licNo').textbox({
    });
    $('#gridName').textbox({
    });
    commonObj.initDictCombobox("licStatus","LIC_STATUS","",false,true);

    //----------------------------查询框初始化结束
    //表单提交成功后的回调方法
    function successCallback(data){
        $.messager.progress("close");
        $("#licInfoList").datagrid('reload');
        commonObj.showResponse(data);
    }
    var uuids="";

</script>
