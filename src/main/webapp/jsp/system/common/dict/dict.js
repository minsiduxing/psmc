	$(document).ready(function () {
		$('#sologTableId').treegrid({
			url:getTabDataUrl,
			toolbarId:"toolbarId",
			idField:'DICT_TYPE',
			treeField:'DICT_TYPE',
			animate:true,
			columns:[[
				{title: '字典类型', field: 'DICT_NO', align: 'center', width: $(this).width() * 0.2},
				{title: '字典类型ID', field: 'DICT_TYPE', align: 'center', width: $(this).width() * 0.2},
				{title: '字典值', field: 'DICT_ID', align: 'center', width: $(this).width() * 0.2},
				{title: '字典名', field: 'NAME', align: 'center', width: $(this).width() * 0.2},
				{title: '字典备注', field: 'REMARK', align: 'center', width: $(this).width() * 0.2}
			]]
		});
	});




