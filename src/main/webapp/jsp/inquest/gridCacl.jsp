<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<body id="body">
<table id="gridRulesTableId" style="width:100%"></table>
<script type="text/javascript">
	var basePath = $("#basePath").val();
    var version = '<%=request.getParameter("version").toString() %>';
    var gridUuid = '<%=request.getParameter("gridUuid").toString() %>';
    var getTabDataUrl = basePath+"/inquest/tabYcGridCalculationModelController.do";

    var  selectGridCalculationModelInfoListUrl ='<c:url value="'+getTabDataUrl+'"/>?method=selectGridCalculationModelInfoList&version='+version+'&queryParams%5BgridModelType%5D='+'<%=request.getParameter("gridModelType").toString() %>';

    var gridCmodelHanleCertCaclUrl = '<c:url value="'+getTabDataUrl+'"/>?method=gridCmodelHanleCertCacl';

    //表单提交成功后的回调方法
    function successCallback(data){
        $.messager.progress("close");
        data = JSON.parse(data);
        commonObj.alert(data.result.msg,"info");
    }


    function gridCmodelHanleCertCacl(gridCmodelUuid){
        $.messager.progress();
        $.ajax({
            type: "POST",
            url: gridCmodelHanleCertCaclUrl,
            data: "&gridCmodelUuid="+gridCmodelUuid+"&gridUuid="+gridUuid,
            success: function(data){
                successCallback(data);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                $.messager.progress("close");
            }
        });
    }


    var option = {
		tabId:"gridRulesTableId",
		url:selectGridCalculationModelInfoListUrl,
		columns:[[
			/**
			 * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
			 * width:parseInt($(this).width()*0.3)
			 */
            {field:'GRID_CMODEL_UUID',align:'center',title:'唯一标示',hidden:true},
            {field:'GRID_MTYPE_NAME',align:'center',title:"测算类别名称",width:$(this).width() * 0.2},
            {field:'GRID_CMODEL_NAME',align:'center',title:"店面位置特征",width:$(this).width() * 0.2},
            {field:'RULE_TYPE_NAME',align:'center',title:"计算方式",width:$(this).width() * 0.2},
            {field:'SORT',align:'center',title:"计算顺序"},
            {field:'RULE_FORMULA',align:'left',title:"计算公式",width:$(this).width() * 0.5},
            {field:'RULE_FORMULA_DESC',align:'left',title:"计算公式说明",width:$(this).width() * 0.5},
            {field:'oper',align:'left',title:"操作栏",width:$(this).width() * 0.1,formatter: function (value, row, index) {
                    return "<a href='javascript:void(0)' onclick='gridCmodelHanleCertCacl(&apos;" + row['GRID_CMODEL_UUID'] + "&apos;)'>测算</a>";
                }}
		]
		]
	};
	//初始化日志信息列表
	commonObj.initPaginationGrid(option);
</script>
</body>