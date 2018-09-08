<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>
<body id="body">
<form id="innovationForm" method="POST" >
		<input type="hidden" id="topicUuid" name="topicUuid" value=${topicUuid }>
		<input type="hidden" id="blockUuid" name="blockUuid" value=${blockUuid }>
        <table class="table table-hover" align="center" style="font-size:12px; width:70%; border-collapse:separate; border-spacing:10px;">
            <tr>
                <td align="center" style="font-size:16px;">
                	<span>${topic.topic_name }</span>
                </td>
            </tr>
            <tr>
                <td align="center" style="color: #8C8C8C">
                	<span>${topic.create_date }</span>
                </td>
            </tr>
            <tr>
                <td ><p style="text-indent: 2em;">${topic.topic_content }</p></td>
            </tr>
            <tr>
                <td align="right"><span>${topic.create_person_name}</span><span style="margin-left: 10px; margin-right: 5px;">${topic.telephone }</span></td>
            </tr>
            <tr>
            	<td  align="center">
		        	<c:forEach var="att" items="${attachmentList}" varStatus="status">
		        		<a style="margin-left:10px;" href="javascript:imgShow('${att.file_prefix }${att.file_path}')"" >${att.file_real_name}.${att.file_suffix}</a>
		        	</c:forEach>
            	</td>
            </tr>
        </table>
        
        <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:10000;width:100%;height:100%;display:none;">
		    <div id="innerdiv" style="position:absolute;">
		        <img id="bigimg" style="border:5px solid #fff;" src="" />
		    </div>
		</div>
		
		<div id="toolbarId3">
			<a href="#" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lock2" onclick="lockComment()">屏蔽</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo"  plain="true" id="undo2" onclick="undoComment()">撤销屏蔽</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove2" onclick="removeComment()">删除</a>
		</div>
		<table id=commentList style="width:100%"></table>

</form>
	<script type="text/javascript">
		var commentDo = basePath+"/website/backstage/tabCommentController.do";
		var commentListUrl ='<c:url value="'+commentDo+'"/>?method=tabCommentList';
		var pauseCommentUrl = '<c:url value="'+commentDo+'"/>?method=pauseComment';
		var deleteCommentUrl = '<c:url value="'+commentDo+'"/>?method=deleteComment';
		var undoCommentUrl = '<c:url value="'+commentDo+'"/>?method=undoComment';
		    
		$(document).ready(function() {
			var topicUuid = $("#topicUuid").val();
			var blockUuid = $("#blockUuid").val();
			$("#toolbarId3").hide();
			if(blockUuid == '01' || blockUuid == '02'){
				$("#toolbarId3").show();
				initDialogDataGrid(topicUuid);
			}
		});
		
		function imgShow(imgUrl){
		    $("#bigimg").attr("src", imgUrl);//设置#bigimg元素的src属性
		    /*获取当前点击图片的真实大小，并显示弹出层及大图*/
		    $("<img/>").attr("src", imgUrl).load(function(){
		    	
		        var windowW = $(window).width();//获取当前窗口宽度
		        var windowH = $(window).height();//获取当前窗口高度
		        var realWidth = this.width;//获取图片真实宽度
		        var realHeight = this.height;//获取图片真实高度
		        var imgWidth, imgHeight;
		        var scale = 0.6;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放
		        if(realHeight>windowH*0.9) {//判断图片高度
		            imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
		            imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
		            if(imgWidth>windowW*0.9) {//如宽度扔大于窗口宽度
		                imgWidth = windowW*scale;//再对宽度进行缩放
		            }
		        } else if(realWidth>windowW*0.9) {//如图片高度合适，判断图片宽度
		            imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
		            imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度   
		        } else {//如果图片真实高度和宽度都符合要求，高宽不变
		            imgWidth = realWidth;
		            imgHeight = realHeight;
		        }
		 
		        $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放
		        var w = (windowW-imgWidth)/2;//计算图片与窗口左边距
		        var h = (windowH-imgHeight)/2;//计算图片与窗口上边距
		        $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性
		        $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
		 
		    });
		 
		    $("#outerdiv").click(function(){//再次点击淡出消失弹出层
		        $(this).fadeOut("fast");
		    });
		 
		}

		function zoomImg(realHeight, realWidth, windowH, windowW){
			var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放
	        if(realHeight>windowH*scale) {//判断图片高度
	            imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放
	            imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度
	            if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度
	                imgWidth = windowW*scale;//再对宽度进行缩放
	            }
	        } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度
	            imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放
	            imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度   
	        } else {//如果图片真实高度和宽度都符合要求，高宽不变
	            imgWidth = realWidth;
	            imgHeight = realHeight;
	        }
		}
		
		
		
		function initDialogDataGrid(topicUuid){
			var option = {
					tabId:"commentList",
					toolbar:"toolbarId3",
					striped:true,
					url:commentListUrl + "&topicUuid="+topicUuid,
					columns:[[   
					          {field:'comment_uuid',title:'主键id',checkbox:true},
					          {field:'comment_person_name',title:'评论人',resizable:true,align:'center',sortable:true},    
					          {field:'comment_content',title:'评论内容',halign:'center',sortable:true,width:'420px'}, 
					          {field:'comment_date',title:'评论时间',align:'center',sortable:true}, 
					          {field:'comment_status',title:'评论状态',align:'center',sortable:true,formatter: function (value, row, index) {
			                     if(value=='1'){return "正常"; }
			                     if(value=='2'){return "已屏蔽"; }
			                     if(value=='3'){return "已删除"; }
			                                                  
			                  }},
					          {field:'to_person_name',title:'评论目标人',align:'center',sortable:true}, 
					          {field:'topic_uuid',title:'主题id', hidden:true}, 
					          {field:'comment_person_uuid',title:'评论人id',hidden:true}, 
					          {field:'to_person_uuid',title:'目标人id',hidden:true}
					         ] 
					      ]
				};
				//初始化列表
				commonObj.initPaginationGrid(option);
				$("#commentList").datagrid("getPanel").panel("setTitle","评论列表");
		}
		
		//屏蔽
		function lockComment(){
			var rows = $("#commentList").datagrid('getChecked');
			var rlength = rows.length;
			var ids="";
			if (rlength > 0){		
				for(var i=0;i<rlength;i++){
					var rowObj = eval(rows[i]);
					var commentUuid = rowObj.comment_uuid;
					var commentStatus = rowObj.comment_status;
					if(commentStatus==2){
						commonObj.alert('存在已经屏蔽的信息!',"warning");
						return ;
					}
					ids+=commentUuid;
					if(i<rlength-1)
						ids+=",";
				}
				
				$.messager.confirm('提示', '确认屏蔽选中的评论信息吗?', function(r){
					if (r){
					var _url = pauseCommentUrl+"&commentUuids="+ids;
					$.messager.progress(); 
					$.ajax({
						   type: "POST",
						   url: _url,
						   success: function(data){
							   successCallback(data);
						   },
						   error:function(XMLHttpRequest, textStatus, errorThrown){
							   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
							   $.messager.progress("close");
						   }
						});
				
			}});
			}else{
				commonObj.alert('请至少选择一条信息!',"warning");
				return ;
			}
			$.messager.progress("close");
			event.preventDefault();
		}
		
		
		//删除
		function removeComment(){
			var rows = $("#commentList").datagrid('getChecked');
			var rlength = rows.length;
			var ids="";
			if (rlength > 0){		
				for(var i=0;i<rlength;i++){
					var rowObj = eval(rows[i]);
					var commentUuid = rowObj.comment_uuid;
					ids+=commentUuid;
					if(i<rlength-1)
						ids+=",";
				}
				
				$.messager.confirm('提示', '确认删除选中的信息吗?', function(r){
					if (r){
					var _url = deleteCommentUrl+"&commentUuids="+ids;
					$.messager.progress(); 
					$.ajax({
						   type: "POST",
						   url: _url,
						   success: function(data){
							   successCallback(data);
						   },
						   error:function(XMLHttpRequest, textStatus, errorThrown){
							   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
							   $.messager.progress("close");
						   }
						});
				
			}});
			}else{
				commonObj.alert('请至少选择一条信息!',"warning");
				return ;
			}
			$.messager.progress("close");
			event.preventDefault();
		}
		
		//撤销
		function undoComment(){
			var rows = $("#commentList").datagrid('getChecked');
			var rlength = rows.length;
			var ids="";
			if (rlength > 0){		
				for(var i=0;i<rlength;i++){
					var rowObj = eval(rows[i]);
					var commentUuid = rowObj.comment_uuid;
					var commentStatus = rowObj.comment_status;
					if(commentStatus==1){
						commonObj.alert('存在状态正常的信息!',"warning");
						return ;
					}
					ids+=commentUuid;
					if(i<rlength-1)
						ids+=",";
				}
				
				$.messager.confirm('提示', '确认选中的信息执行撤销操作吗?', function(r){
					if (r){
					var _url = undoCommentUrl+"&commentUuids="+ids;
					$.messager.progress(); 
					$.ajax({
						   type: "POST",
						   url: _url,
						   success: function(data){
							   successCallback(data);
						   },
						   error:function(XMLHttpRequest, textStatus, errorThrown){
							   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
							   $.messager.progress("close");
						   }
						});
				
			}});
			}else{
				commonObj.alert('请至少选择一条信息!',"warning");
				return ;
			}
			$.messager.progress("close");
			event.preventDefault();
		}
		
		
		//表单提交成功后的回调方法
		function successCallback(data){
			$.messager.progress("close");
			$("#commentList").datagrid('reload');
			commonObj.showResponse(data);
		}
		
	</script>
</body>
</html>
