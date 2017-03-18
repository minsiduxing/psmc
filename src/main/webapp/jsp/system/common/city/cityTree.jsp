<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script type="text/javascript">
var _chkStyle = "<%=request.getParameter("chkStyle").toString()%>";
var _rootPId = "<%=request.getParameter("rootPId").toString()%>";
var treeObj;
var setting = {
		view: {
			selectedMulti: false
		},
		check: {
			enable: true,
			chkStyle: _chkStyle,
			chkboxType: { "Y": "p", "N": "p" },
			radioType: "all"	
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "ID",
				pIdKey: "PID",
				rootPId: _rootPId
			},
			key:{
				name:"NAME"
			},
		},
		async: {
			enable: true,
			type : "get",
			url: basePath+"/system/common/cityController.do?method=getRegionJson",
			autoParam: ["ID=cityId"]
		}
	};

 		
$(document).ready(function(){
	 var _url =basePath+"/system/common/cityController.do?method=initRegion&cityId="+_rootPId;
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: _url,
	        success:function(data){
	        	treeObj = $.fn.zTree.init($("#regionTree"), setting, data); 
	        }  
	    });  
});

</script>
<ul id="regionTree" class="ztree"></ul>


