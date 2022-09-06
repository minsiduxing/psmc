	$(document).ready(function () {
		$('#sologTableId').treegrid({
			url:getTabDataUrl,
			toolbarId:"toolbarId",
			idField:'ID',
			treeField:'ID',
			animate:true,
			columns:[[
				{title: '本级字典值', field: 'ID', align: 'center', width: $(this).width() * 0.1},
				{title: '本级字典名', field: 'NAME', align: 'center', width: $(this).width() * 0.3},
				{title: '本级字典类型编码', field: 'DICT_NO', align: 'center', width: $(this).width() * 0.3},
				{title: '字典备注', field: 'REMARK', align: 'center', width: $(this).width() * 0.3}
			]]
		});
	});




