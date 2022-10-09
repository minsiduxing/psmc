<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<body id="body">
<table id="gridRulesTableId2" style="width:100%"></table>
<script type="text/javascript">
	var basePath = $("#basePath").val();

	var getTabDataUrl = basePath+"/system/common/sysOperLogController.do";
	getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=sysOperLogList';
	var option = {
		tabId:"gridRulesTableId2",
		url:getTabDataUrl,
		columns:[[
			/**
			 * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
			 * width:parseInt($(this).width()*0.3)
			 */
			{field:'uuid',align:'center',title:'唯一标示',hidden:true},
			{field:'log_type',hidden:true},
			{field:'log_type_name',align:'center',title:"一级分类",width:$(this).width() * 0.2},
			{field:'log_sub_type',hidden:true},
			{field:'log_sub_type_name',align:'center',title:"二级分类",width:$(this).width() * 0.2},
			{field:'bussiness_uuid',align:'center',title:'业务ID',hidden:true},
			{field:'operid',hidden:true},
			{field:'opername',align:'center',title:"操作人",width:$(this).width() * 0.2},
			{field:'oper_date',align:'center',title:"操作时间",width:$(this).width() * 0.2},
			{field:'oper_input',align:'center',title:"输入",width:$(this).width() * 0.2},
			{field:'oper_output',align:'center',title:"输出",width:$(this).width() * 0.2},
			{field:'oper_result_desc',align:'center',title:"操作描述",width:$(this).width() * 0.2},
			{field:'oper_result',align:'center',title:"操作结果",width:$(this).width() * 0.2}
		]
		]
	};
	//初始化日志信息列表
	commonObj.initPaginationGrid(option);
</script>
</body>