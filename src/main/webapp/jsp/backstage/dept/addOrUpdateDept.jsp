<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
	.tds{
		text-align:right;
		width:10%
	}
	
  </style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
  </head>
  <%@ include file="../../../common.jsp"%>
  <body id="body">
<form id="editForm" method="POST" class="newsForm" >
	<div class=" panel-default" style="margin-top:15px; border: 1px solid #ddd;">
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:10px;">
			<c:if test="${deptType == '1'}">
				<tr>
					<td class="tds">工作室名称：</td>
					<td width="30%"><input id="deptName" name="deptName" style="width:30%;" value="${dept.dept_name}"/></td>
				</tr>
				<tr>	
					<td class="tds">工作室简介：</td>
					<td width="100%" colspan="3">
						<textarea style="width:80%; border-radius:5px; border: 1px solid #ccc;" rows="5" cols="" id="deptIntroduction" name="deptIntroduction">${dept.dept_introduction}</textarea>
					</td>
				</tr>	
			</c:if>
			<c:if test="${deptType == '2'}">
				<tr>
					<td class="tds">协会名称：</td>
					<td width="30%"><input id="deptName" name="deptName" style="width:30%;" value="${dept.dept_name}"/></td>
				</tr>
				<tr>
					<td class="tds">协会简介：</td>
					<td width="100%" colspan="3">
						<textarea style="width:80%; border-radius:5px; border: 1px solid #ccc;" rows="5" cols="" id="deptIntroduction" name="deptIntroduction">${dept.dept_introduction}</textarea>
					</td>
				</tr>	
			</c:if>	
			<tr>
				<td class="tds" >规范管理办法：</td>
				<td width="100%" colspan="3">
					<textarea style="width:80%; border-radius:5px; border: 1px solid #ccc;" rows="5" cols="" id="deptRegulation" name="deptRegulation">${dept.dept_regulation}</textarea>
				</td>
			</tr>
			<tr>
				<td class="tds">风采展示：</td>
				<td colspan="3" width="100%">
					<!--非全屏模式-->
				    
				        <input id="hiddencontent" type="hidden" name="elegantDemeanour"/>
				        <div id="newsContent" class="newsContent"></div>
	               
				</td>
			</tr>
		</table>
	</div>
	 <input type="hidden" id="isEdit" name="isEdit" value="${isEdit}"/>
	 <input type="hidden" id="deptUuid" name="deptUuid" value="${dept.dept_uuid }"/>
	 <input type="hidden" id="deptType" name="deptType" value="${deptType}"/>
	 <input type="hidden" id="imagePath" name="imagePath" value="${dept.image_path }" />
	  <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
			<input id="submitbtn" type="button" class="easyui-linkbutton" onclick=" sbmit()" value="提交"/>
			<input id="reset" type="reset" class="easyui-linkbutton" onclick=" "  value="重置"/>
			<input id="button" type="reset" class="easyui-linkbutton" onclick=" retList() "  value="返回列表"/>
	</div>
	</form>
        <!--全屏模式-->
    <div id="cover" ></div>
  </body>
</html>
<script type="text/javascript">
var isEdit = $("#isEdit").val();

//图片上路经
var imageuploadsrc = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileUpload&oneLevelClassify='+$("#deptType").val();

//表单数据初始化---------------------------------------------------
var newscontent = '${dept.elegant_demeanour}';
var addUrl = '<c:url value="/website/backstage/TabDeptController.do"/>?method=saveOrUpdateDept';
var retrunUrl =  '<c:url value="/website/backstage/TabDeptController.do"/>?method=toDeptList&deptType='+$("#deptType").val();
function formInint(isEdit){
	if(isEdit == "query"){
		$("#submitbtn").hide();
		$("#reset").hide();
		$('input,textarea',$('#editForm')).attr('readonly',true);
	}
	
	$('#deptName').textbox({
		type:"text",
        required : true

	});
	$('#deptIntroduction').validatebox({
		type:"text",
        required : true
	});
	$('#deptRegulation').validatebox({
		type:"text",
        required : true
	});
}

</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/dept/addOrUpdateDept.js"></script>