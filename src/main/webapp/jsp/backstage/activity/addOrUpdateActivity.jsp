<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  	.ibox {
	    clear: both;
	    margin-bottom: 25px;
	    margin-top: 0;
	    padding: 0
	}
	.tds{
		text-align:right;
		width:15%
	}
	
  </style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Huploadify${csssuffix}" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/jcrop/css/jquery.Jcrop${csssuffix}"/> --%>
  </head>
  <%@ include file="../../../common.jsp"%>
  <body id="body">
<form id="activityForm" method="POST" >

	<div class=" panel-default" style="margin-top: 30px; border: 1px solid #ddd;">
        <div class="">
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:20px;" >
			<tr>
				<td class="tds">活动名称：</td>
				<td width="30%"><input id="activityName" name="activityName" value="${info.activity_name}" style="width:70%;"/></td>
				<td class="tds">活动开始时间：</td>
				<td width="30%"><input id="startDate" name="startDate" value="${info.start_date}" style="width:70%;"/></td>
			</tr>
			<tr>
				<td class="tds">活动结束时间：</td>
				<td width="30%"><input id="endDate" name="endDate" value="${info.end_date}" style="width:70%;"/></td>
				<td class="tds">报名截止时间：</td>
				<td width="30%"><input id="signUpEndDate" name="signUpEndDate" value="${info.sign_up_end_date}" style="width:70%;"/></td>
				
			</tr>
			<tr>
				<td class="tds">所属协会：</td>
				<td width="30%"><input id="deptUuid" name="deptUuid" value="" style="width:70%;"/></td>
				<td class="tds">活动配图：</td>
				<td width="30%"><input type="button" value="上传图片" style="width:70%;" onclick="openUploadDialog()"/></td>
			<tr>
				<td class="tds">活动内容：</td>
				<td width="30%" colspan="3">
					<textarea style="width:88.5%; border-radius:5px; border: 1px solid #ccc;" rows="10" cols="" id="activityContent" name="activityContent">${info.activity_content}</textarea>
				</td>
			</tr>	
		</table>
		</div>
	</div>
		<div id="uploadImageDiv"></div>
		<input type="hidden" id="isEdit" name="isEdit" value="${isEdit}"/>
		 <input type="hidden" id="activityUuid" name="activityUuid" value="${info.activity_uuid}"/>
		 <input type="hidden" id="imagePath" name="imagePath" value="" />
		 <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
		   <input id="submitbtn" type="button" class="easyui-linkbutton" onclick="save()" value="提交"/>
		   <input id="reset" type="reset" class="easyui-linkbutton" onclick=" "  value="重置"/>
		   <input id="button" type="button" class="easyui-linkbutton" onclick="retList()"  value="返回列表"/></td>
		 </div>
		 
	</form>
    
  </body>
</html>
<script type="text/javascript">
var basePath = $("#basePath").val();
var infoDo = basePath+"/website/backstage/TabActivityManageController.do";
var addUrl = '<c:url value="/website/backstage/TabActivityManageController.do"/>?method=addOrUpdate';
var retrunUrl =  '<c:url value="/website/backstage/TabActivityManageController.do"/>?method=activityList';

//弹出图片上传窗口
var toImageUpload =  '<c:url value="/website/backstage/uploadImageController.do"/>?method=toImageUplodDialog';
//上传图片
var uploadPhoto = '<c:url value="/website/backstage/uploadImageController.do"/>?method=uploadPhoto';
var groupid = "${sessionScope.user.tabPerson.groupid}";
commonObj.initDeptCombobox("deptUuid","2", groupid,"<c:out value="${info.dept_uuid}"/>",true);

if($("#isEdit").val() == 'query'){
	$("#submitbtn").hide();
	$("#reset").hide();
	$('input,select,textarea',$('#activityForm')).attr('readonly',true);
}
$('#activityName').textbox({
	type : "text",
	required : true
});
$("#activityContent").validatebox({
	required: true,    
    validType: "text"
});

$('#startDate').datetimebox({
	editable:false,
	required : true
});
$('#endDate').datetimebox({
	editable:false,
	required : true
});
$('#signUpEndDate').datetimebox({
	editable:false,
	required : true
});

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/wangEditor/wangEditor.min${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadfy/jquery.Huploadify${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/activity/addOrUpdateActivity.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/uploadImage/uploadImage.js"></script>