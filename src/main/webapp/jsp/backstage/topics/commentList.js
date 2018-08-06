$(document).ready(function(){ 
	var option = {
		tabId:"commentList",
		toolbar:"toolbarIds",
		url:commentListUrl,
		columns:[[   
		          {field:'comment_uuid',title:'主键id',checkbox:true},
		          {field:'comment_person_name',title:'评论人',resizable:true},    
		          {field:'comment_content',title:'评论内容',formatter:function(value, row, index){
		        	  if(value.length > 40){
		        		  return value.substring(0,40) + "......";
		        	  }else{
		        		  return value;
		        	  }
		          }}, 
		          {field:'comment_date',title:'评论时间'}, 
		          {field:'comment_status',title:'评论状态',formatter: function (value, row, index) {
                     if(value=='1'){return "正常"; }
                     if(value=='2'){return "禁止评论"; }
                     if(value=='3'){return "已删除"; }
                                                  
                  }},
		          {field:'to_person_name',title:'评论目标人'}, 
		          {field:'topic_uuid',title:'主题id', hidden:true}, 
		          {field:'comment_person_uuid',title:'评论人id',hidden:true}, 
		          {field:'to_person_uuid',title:'目标人id',hidden:true}
		         ] 
		      ]
	};
	//初始化列表
	commonObj.initPaginationGrid(option);
});