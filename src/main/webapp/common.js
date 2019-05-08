var basePath = $("#basePath").val();

/**
 * 系统基础公共处理对象
 */
var commonObj = new Object();

/**
 * 属地组织树
 * @param chkStyle 单选radio/多选checkbox
 * @param rootPId 默认加载的根节点的id,如果不传递,则默认加载全省的.
 * @param Callback(ids,names) 回调函数,如果不传递回调函数，则程序自动给cityId、cityName赋值
 * ids:选中的id集合,如果是checkbox,ids则英文逗号","隔开
 * namess:选中的name集合,如果是checkbox,names则英文逗号","隔开
 */
commonObj.loadRegoinTree = function(chkStyle,rootPId,Callback){
	if(!rootPId){
		rootPId="00";
	}
	$("#regionTreeDiaLog").dialog({
		modal: true,
		closed: true,
        title: "属地组织树",
        resizable: true,
        width: 220,
        height: 400,
        cache: true,
        href:regionTreeDiaLogUrl+"?chkStyle="+chkStyle+"&rootPId="+rootPId,
        buttons:[{
			text:'确认',
			iconCls:'icon-save',
			handler:function(){
				var ids="";
				var names="";
				var treeObj = $.fn.zTree.getZTreeObj("regionTree");
				var nodes = treeObj.getCheckedNodes(true);
				var nodesLength = nodes.length;
				for(var i=0;i<nodesLength;i++){
					var node = nodes[i];
					ids+=node.ID;
					names+=node.NAME;
					if(i<nodesLength-1){
						ids+=",";
						names+=",";
					}
				}
				if(Callback){
					Callback(ids,names);
				}else{
					$("#cityId").val(ids).blur().focus();
					$("#cityName").val(names).blur().focus();
				}
				$('#regionTreeDiaLog').window('close');
			}
		},{
			text:'关闭',
			iconCls:'icon-no',
			handler:function(){
				$('#regionTreeDiaLog').window('close');
			}
		}]
    });
	$('#regionTreeDiaLog').window('open');
};

/**
 * 统一初始化分页组件 主要是为了保证表格样式的统一性
 * @param option{tabId:表格id,toolbar:按钮div的id,url:数据远程加载地址,columns:显示字段
 * idField:主键}
 * 
 */
commonObj.initPaginationGrid = function(option){
	$('#'+option.tabId).datagrid({
		title:"数据列表",
		columns:option.columns,
	    url:option.url,
	    autoRowHeight:false,
	    toolbar:"#"+option.toolbar,
	    pagination:true,
	    queryParams: {},  
	    rownumbers:true,
	    fitColumns:true,
	    autoRowHeight:false,
	    remoteSort:false,
	    resizeHandle:"both",
	    nowrap:false,
	    idField:option.idField,
	    striped:true,
	    ctrlSelect:true,
	    onLoadError:function(XMLHttpRequest, textStatus, errorThrown){
	    	commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
	    }
	}); 
	$('#'+option.tabId).datagrid('resize');
};


/**
 *  初始化数据字典的combobox
 *  @param id input id
 *  @param dictNo 数据字典编码
 *  @param defaultValue 默认选中的值
 *  @param isQuery 是否是查询使用，如果是查询则默认显示全部
 */
commonObj.initDictCombobox = function(id,dictNo,defaultValue,validate,isQuery){
	var url = initDictUrl+'&dictNo='+dictNo;
	$.ajax({ 
		url: url,
		dataType: 'json', 
		success: function(data){   
			// 修改ajax返回的值
			if(isQuery){
				data.unshift({'ID':'','NAME':'全部'});   //unshift方法添加到第一行，push方法添加到末尾
			}else{
//				if(!validate)
					data.unshift({'ID':'','NAME':'请选择'}); //非查询，则第一行增加请选择
			}
			$('#'+id).combobox({  
			    panelHeight:100,
			    data:data,        
			    valueField:'ID',    
			    textField:'NAME',
			    value:defaultValue,
			    required:validate,
			    editable:false
			});    
		}
	});
};

/**
 *  初始化部门的combobox
 *  @param id input id
 *  @param deptType 部门类型
 *  @param defaultValue 默认选中的值
 */
commonObj.initDeptCombobox = function(id,deptType, groupid,defaultValue,validate){
	var url = initDeptUrl+'&deptType='+deptType + '&groupid='+groupid;
	$.ajax({ 
		url: url,
		dataType: 'json', 
		success: function(data){   
			// 第一行增加请选择
			//data.unshift({'ID':'','NAME':'请选择'}); 
			$('#'+id).combobox({  
			    panelHeight:100,
			    data:data,
			    valueField:'ID',    
			    textField:'NAME',
			    value:defaultValue,
			    required:validate,
			    editable:false
			});    
		}
	});
};

/**
 *  初始化问卷的combobox
 *  @param id input id
 *  @param defaultValue 默认选中的值
 */
commonObj.initQuestionnaireCombobox = function(id,defaultValue,validate){
	var url = initQuestionnaireUrl;
	$.ajax({ 
		url: url,
		dataType: 'json', 
		success: function(data){   
			data.unshift({'ID':'','NAME':'请选择'}); 
			$('#'+id).combobox({  
			    panelHeight:100,
			    data:data,
			    valueField:'ID',    
			    textField:'NAME',
			    value:defaultValue,
			    required:validate,
			    editable:false
			});    
		}
	});
};

/**
 *easyui表单提交后的统一处理
 *@param data :{res:success/fail,rmsg:错误描述}
 */
commonObj.showResponse = function(data,callback){
	try{
		if(data=='timeout'){ 
	    	return false;
	    };
		if(allowedAlert(data)){
			return false;
		};
		if(callback){
			return callback(data);
		};
		data = JSON.parse(data);
		if(data.res=='success'){
			commonObj.alert("操作成功!","info");
		}else{
			if(data.rmsg !=null && data.rmsg!='' ){
				commonObj.alert("操作失败,["+data.rmsg+"]","warning");
			}else{
				commonObj.alert("操作失败,请联系管理员!","warning");
				console.warn("错误描述:"+data.rmsg);
			}
		}
	}catch(e){
		//为了打印出后台抛出的业务操作异常所以添加一下代码
		 if(data.error=="false"){
			commonObj.alert(data.msg,"warning");
		}else{
			commonObj.alert("系统错误,请联系管理员!","error");
		}
		//为了打印出后台抛出的业务操作异常所以添加一下代码
		console.info(" e:"+e.message);
	}
};

commonObj.alert = function(msg,icon){
	if("error" == icon){
		msg="系统错误,请联系管理员!";
		$.messager.alert('错误',msg,icon);
	}else if("info" == icon){
		$.messager.alert('消息',msg,icon);
	}else if("warning" == icon){
		$.messager.alert('警告',msg,icon);
	}else if("question" == icon){
		$.messager.alert('question',msg,icon);
	}else{
		$.messager.alert('消息',msg,icon);
	}
};

/**
 * 错误统一捕获处理
 */
commonObj.showError = function(XMLHttpRequest, textStatus, errorThrown){	
	var status  = XMLHttpRequest.status;
	var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");
    if(sessionstatus=='timeout'){ 
    	//如果超时，统一处理，此处直接返回
    	return;
    }
	if(status == 500){
		var responseText = XMLHttpRequest.responseText;
		allowedAlert(responseText);
		return;
	}
	commonObj.alert("系统错误,请联系管理员!","error");
};

function allowedAlert(text){
	if(text.indexOf("priv.guochun.psmc.authentication.aop.exception.NotAllowedException") !=-1){
		commonObj.alert("用户无权限进行该操作,请联系管理员进行授权!","warning");
		return true;
	}
	return false;
}

commonObj.isAuth = function(operateNo){
	var auth = false;
	if(operateNo == undefined || operateNo == null || operateNo == "")
		return auth;
	var _url =isAuthUrl+'?method=authenticationOperate&operateNo='+operateNo;
	$.ajax({
		async:false,
		cache:false,
		type:'POST',
		dataType:"text",
		context:document.body,
		url:_url,
		success:function(data){
			var dataObj = JSON.parse(data);
			if(dataObj.res == "success"){
				auth = true;
			}
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
		}
	});
	return auth;
};


$.ajaxSetup({ 
     complete:function(XMLHttpRequest,textStatus){   
        var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头,sessionstatus， 
            if(sessionstatus=='timeout'){   
                  //如果超时就处理 ，指定要跳转的页面  
                 var top = getTopWinow(); //获取当前页面的顶层窗口对象
                 alert("登录超时,请重新登录.");
                 top.location.href=XMLHttpRequest.getResponseHeader("sessionTimeoutUrl"); //跳转到登陆页面，可以修改为自己需要跳转的页面
             }   
     }   
});

/** 
 * 在页面中任何嵌套层次的窗口中获取顶层窗口 
 * @return 当前页面的顶层窗口对象 
 */
function getTopWinow(){  
  var p = window;  
  while(p != p.parent){  
      p = p.parent;  
  }  
  return p;  
}  
/*将表单数据转为json
出入要格式化的表单ID 不加 #，和后台要接受的json串名字_targetHiddenName，会在目标表单自动添加隐藏域
将json 字符串传到后台，后台用_targetHiddenName 接收 ，
如果不传 _targetJsonStrName 会返回一个json串，
_targetJsonStrName 会返回一个{_targetJsonStrName：{....}}的json串
*/
commonObj.transFormToJosn = function form2Json(_formid,_targetJsonStrName,_targetHiddenName) {

    var arr = $("#" + _formid).serializeArray()
    var jsonStr = "";
    if(_targetJsonStrName !=null && _targetJsonStrName !="" && _targetJsonStrName !="undefined" ){
	   jsonStr += '{"'+_targetJsonStrName+'":{';
    }else{
    	 jsonStr += '{';
    }
    for (var i = 0; i < arr.length; i++) {
        jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
    }
    jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
	if(_targetJsonStrName !=null && _targetJsonStrName !="" && _targetJsonStrName !="undefined" ){
		 jsonStr += '}}'
    }else{
    	 jsonStr += '}'
    }
    var json = JSON.parse(jsonStr);
   
    if(_targetHiddenName !=null && _targetHiddenName !="" && _targetHiddenName !="undefined" ){
    	  var _appendHiddenText = "<input type='hidden' name='"+_targetHiddenName+"' value='"+json+"'/>";
    	  $("#" + _formid).append(_appendHiddenText);
    }
    return json
}
//公共查询方法 点击查询查询按钮，传递grid的ID 和查询表单id 系统会将查询条件自动传递到后台
commonObj.query=function query(_gridId,_serchformId){
	    event.preventDefault();
	    $('#'+_gridId+'').datagrid('reload',commonObj.transFormToJosn(_serchformId,"queryParams",""));   //点击搜索
}