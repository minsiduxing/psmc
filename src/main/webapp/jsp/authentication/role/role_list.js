var basePath = $("#basePath").val();

var editdialog;
var resourceSetdialog;
var privilegeSetdialog;
//表单校验

function progress() {
    var result = $('#editForm').form("validate");
    if (Boolean(result)) {
        $.messager.progress();
        return true;
    } else {
        return false;
    }
}
//表单提交成功后的回调方法
function successCallback(data) {
    $.messager.progress("close");
    $("#roleTableId").datagrid('reload');
    commonObj.showResponse(data);
}

//表单dialog初始化方法
function initDialog() {
    editdialog = $("#editdialogDiv").dialog({
        modal: true,
        closed: true,
        width: 450,
        height: 280,
        resizable: true,
        cache: false,
        buttons: [{
            text: '保存',
            iconCls: 'icon-save',
            handler: function() {
                $('#editForm').form({
                    url: saveRoleUrl,
                    onSubmit: function() {
                        return progress();
                    },
                    success: function(data) {
                        successCallback(data);
                    }

                });
                $('#editForm').submit();
            }
        }]

    });
}

$(function() {
    var option = {
        tabId: "roleTableId",
        toolbar: "toolbarId",
        url: getRoleTabDataUrl,
        columns: [
            [
                /**
                 * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
                 * width:parseInt($(this).width()*0.3)
                 */
                { field: 'UUID', align:'center',title: '账号唯一ID', checkbox: true,width:$(this).width() * 0.2 },
                { field: 'ROLE_NO', align:'center',title: '角色编码',width:$(this).width() * 0.2 },
                { field: 'ROLE_NAME', align:'center',title: '角色名称',width:$(this).width() * 0.2 },
                { field: 'CREATOR', align:'center',title: '创建者',width:$(this).width() * 0.2 },
                { field: 'CREATE_TIME', align:'center',title: '创建时间',width:$(this).width() * 0.2, sortable: true,formatter:function(value,row,index){
                	return value;
                } },
                { field: 'REMARK', align:'center',title: '角色描述',width:$(this).width() * 0.2 }
            ]
        ]
    };
    //初始化用户信息列表
    commonObj.initPaginationGrid(option);

    $("#add").click(function() {
        if (!editdialog) {
            initDialog();
        }
        editdialog.panel({ align:'center',title: "新增" });
        editdialog.panel({ iconCls: 'icon-save'});
        editdialog.panel({ href: addRoleUrl });
        editdialog.window("open");
    });


    $("#edit").click(function() {
        var rows = $("#roleTableId").datagrid('getChecked');
        if (rows.length == 1) {
            var uuid = rows[0].UUID;
            var _url = editRoleUrl+"&uuid=" + uuid;
            if (!editdialog) {
                initDialog();
            }
            editdialog.panel({ align:'center',title: "修改" });
            editdialog.panel({ iconCls: 'icon-edit' });
            editdialog.panel({ href: _url });
            editdialog.window("open");

        } else {
            commonObj.alert("请选择一条记录!", "warning");
        }
    });

    $("#remove").click(function() {
        var rows = $("#roleTableId").datagrid('getChecked');
        if (rows.length > 0) {
            var arr = [];
            for (var i in rows) {
                arr.push(rows[i].UUID);
            }
            var ids = arr.join(',');
            var _url = removeRoleUrl +"&uuids=" + ids;
            $.messager.progress();
            $.ajax({
                type: "POST",
                url: _url,
                success: function(data) {
                    successCallback(data);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        } else {
            commonObj.alert("请选择至少一条记录!", "warning");
        }
        $.messager.progress("close");
    });
    
    $("#resourceSet").click(function() {
        var rows = $("#roleTableId").datagrid('getChecked');
        if (rows.length == 1) {
            var uuid = rows[0].UUID;
            var _url = roleResourceSetUrl+"?rootPId=e51a8663876f4a3394bb194d89d96735&chkStyle=checkbox&roleUuid=" + uuid;
            resourceSetdialog = $("#resourceSetdialogDiv").dialog({
            	modal: true,
        		closed: true,
                width: 320,
                height: 420,
                draggable:true,
                minimizable:true,
                maximizable:true,
                shadow:true,
                border:'thick',
                cache: false,
                buttons: [{
                    text: '保存',
                    iconCls: 'icon-save',
                    handler: function() {
                    	var ids="";
                    	var names ="";
                    	var treeObj = $.fn.zTree.getZTreeObj("resourceBelongRoleTree");
                    	var nodes = treeObj.getCheckedNodes(true);
                    	var nodesLength = nodes.length;
                    	for(var i=0;i<nodesLength;i++){
        					var node = nodes[i];
        					ids+=node.UUID;
        					names+=node.RESOURCE_NAME;
        					if(i<nodesLength-1){
        						ids+=",";
        						names+=",";
        					}
        				}
                    	$.messager.progress(); 
                    	$.ajax({
         				   type: "POST",
         				   data:"roleUuid="+uuid+"&resourceIds="+ids,
         				   url: roleResourceConfigUrl,
         				   success: function(data){
         					    $.messager.progress("close");
         					    commonObj.showResponse(data);
         				   },
         				   error:function(XMLHttpRequest, textStatus, errorThrown){
         					   $.messager.progress("close");
         					   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
         				   }
         				});
                    }
                }]
            });
            resourceSetdialog.panel({ align:'center',title: "资源配置" });
            resourceSetdialog.panel({ iconCls: 'icon-edit' });
            resourceSetdialog.panel({ href: _url });
            resourceSetdialog.window("open");
            

        } else {
            commonObj.alert("请选择一条记录!", "warning");
        }
    });
    
    
    
    $("#privilegeSet").click(function() {
        var rows = $("#roleTableId").datagrid('getChecked');
        if (rows.length == 1) {
            var uuid = rows[0].UUID;
            var _url = privilegeSetUrl+"?rootPId=e51a8663876f4a3394bb194d89d96735&chkStyle=radio&roleUuid=" + uuid;
            privilegeSetdialog = $("#privilegeSetdialogDiv").dialog({
            	modal: true,
        		closed: true,
                width: 800,
                height: 420,
                draggable:true,
                minimizable:true,
                maximizable:true,
                shadow:true,
                border:'thick',
                cache: false,
                href:_url,
                align:'center',title: "业务操作配置",
                method:"get"
            });
            privilegeSetdialog.window("open");
            
        } else {
            commonObj.alert("请选择一条记录!", "warning");
        }
    });
    
    
    

});
