<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<body id="body">
<table id="gridRulesTableId" style="width:100%"></table>
<script type="text/javascript">
	var basePath = $("#basePath").val();

	var getTabDataUrl = basePath+"/system/common/sysOperLogController.do";
	getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=sysOperLogList';
	var option = {
		tabId:"gridRulesTableId",
		url:getTabDataUrl,
		columns:[[
			/**
			 * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
			 * width:parseInt($(this).width()*0.3)
			 */
			{field:'uuid',align:'center',title:'唯一标示',hidden:true},
            {field:'log_type_name',align:'center',title:"测算模型名称",width:$(this).width() * 0.2},
            {field:'oper_date',align:'center',title:"距离测算指标项(实时测算距离)",width:$(this).width() * 0.2},
            {field:'opername',align:'center',title:"距离测算公式",width:$(this).width() * 0.2},
            {field:'oper_input',align:'center',title:"距离测算公式描述",width:$(this).width() * 0.2},

            {field:'1',align:'center',title:"容量测算指标项(网格人口)",width:$(this).width() * 0.2},
            {field:'2',align:'center',title:"容量测算公式",width:$(this).width() * 0.2},
            {field:'3',align:'center',title:"容量零售点",width:$(this).width() * 0.2},

            {field:'4',align:'center',title:"总量测算指标(网格人口)",width:$(this).width() * 0.2},
            {field:'5',align:'center',title:"总量测算公式",width:$(this).width() * 0.2},
            {field:'6',align:'center',title:"总量测算公式描述",width:$(this).width() * 0.2},

            {field:'7',align:'center',title:"引用合理布局规定",width:$(this).width() * 0.2},
            {field:'8',align:'center',title:"测算顺序",width:$(this).width() * 0.2},
		]
		]
	};
	//初始化日志信息列表
	commonObj.initPaginationGrid(option);
</script>
</body>