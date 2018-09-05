var commentListdialog;

//表单dialog初始化方法
function initDialog(){
	commentListdialog = $("#commentListDialogDiv").dialog({
		modal: true,
		closed: true,
	    width: 850,
	    height: 500,
	    resizable:true,
	    cache: false
	});
}

//打开评论列表dialog
function openCommentListDialog(topicUuid){
	if(!commentListdialog){
		initDialog();
	}
	commentListdialog.panel({title:"信息详情"});
//	commentListdialog.panel({iconCls:'icon-save'});
	commentListdialog.panel({href:toTopicsDetail+'&topicUuid='+topicUuid});
	commentListdialog.window("open");
}

