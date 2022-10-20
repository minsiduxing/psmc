<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<body id="body">
<table id="gridRulesTableId" style="width:100%"></table>
<script type="text/javascript">
	var basePath = $("#basePath").val();

    var getTabDataUrl = basePath+"/inquest/tabYcGridCalculationModelController.do";
    getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=selectGridCalculationModelInfoList&version='+'<%=request.getParameter("version").toString() %>&queryParams%5BgridModelType%5D='+'<%=request.getParameter("gridModelType").toString() %>';

    var option = {
		tabId:"gridRulesTableId",
		url:getTabDataUrl,
		columns:[[
			/**
			 * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
			 * width:parseInt($(this).width()*0.3)
			 */
            {field:'GRID_CMODEL_UUID',align:'center',title:'唯一标示',hidden:true},
            {field:'GRID_MTYPE_NAME',align:'center',title:"测算类别名称",width:$(this).width() * 0.2},
            {field:'GRID_CMODEL_NAME',align:'center',title:"店面位置特征",width:$(this).width() * 0.2},
            {field:'RULE_FORMULA',align:'left',title:"计算公式",width:$(this).width() * 0.2},
            {field:'RULE_FORMULA_DESC',align:'left',title:"计算公式说明",width:$(this).width() * 1},
		]
		]
	};
	//初始化日志信息列表
	commonObj.initPaginationGrid(option);
</script>
</body>