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
<form id="innovationForm" method="POST" >

	<div class=" panel-default" style="margin-top:15px; border: 1px solid #ddd;">
       <div class="panel-heading">
          <label style="background-color:006699; color: #ffffff">单位信息</label>
       </div>
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:10px;">
			<tr>
				<td class="tds">所属单位名称：</td>
				<td width="30%"><input id="orgName" name="orgName" value="${info.org_name}" style="width:70%;"/></td>
				<td class="tds">申报负责人：</td>
				<td width="30%"><input id="declarePerson" name="declarePerson" value="${info.declare_person}" style="width:70%;"/></td>
			</tr>
			<tr>
				<td class="tds">联系电话：</td>
				<td width="30%"><input id="declarePhone" name="declarePhone" value="${info.declare_phone}" style="width:70%;"/></td>
				<td class="tds">电子邮箱：</td>
				<td width="30%"><input id="declareEmail" name="declareEmail" value="${info.declare_email}" style="width:70%;"/></td>
			</tr>
		</table>
	</div>
	
	<div class=" panel-default" style="margin-top:5px; border: 1px solid #ddd;">
		<div class="panel-heading">
            <label style="background-color:006699; color: #ffffff">第一完成人</label>
        </div>
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:10px;">
			<tr>
				<td class="tds">姓名：</td>
				<td width="30%"><input id="firstCompletePerson" name="firstCompletePerson" value="${info.first_complete_person}" style="width:70%;"/></td>
				<td class="tds">性别：</td>
				<td width="30%">
					<input id="sex" name="sex" value="" style="width:70%;"/>
				
				</td>
			</tr>
			<tr>
				<td class="tds">学历：</td>
				<td width="30%"><input id="education" name="education" value="${info.education}" style="width:70%;"/></td>
				<td class="tds">职务/技术职称：</td>
				<td width="30%"><input id="job" name="job" value="${info.job}" style="width:70%;"/></td>
			</tr>
			<tr>
				<td class="tds">所属单位部门：</td>
				<td width="30%"><input id="deptUuid" name="deptUuid" value="" style="width:70%;"/></td>
				<td class="tds">专业及特长：</td>
				<td width="30%"><input id="major" name="major" value="${info.major}" style="width:70%;"/></td>
			</tr>
			<tr>
				<td class="tds">职业身份：</td>
				<td width="30%">
					<input id="occupation" name="occupation" value="" style="width:70%;"/>
				</td>
				<td class="tds">其他完成人：</td>
				<td width="30%"><input id="otherCompletePerson" name="otherCompletePerson" value="${info.other_complete_person}" style="width:70%;"/></td>
			</tr>
		</table>
	</div>
	<div class=" panel-default" style="margin-top:5px;border: 1px solid #ddd;">
		<div class="panel-heading">
            <label style="background-color:006699; color: #ffffff">成果信息</label>
        </div>
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:10px;" >
			<tr>
				<td class="tds">成果名称：</td>
				<td width="30%"><input id="achievementName" name="achievementName" value="${info.achievement_name}" style="width:70%;"/></td>
				<td class="tds">体现形式：</td>
				<td width="30%">
					<input id="achievementForm" name="achievementForm" value="" style="width:70%;"/>
				</td>
			</tr>
			<tr>
				<td class="tds">实现价值：</td>
				<td width="30%"><input id="realizedValue" name="realizedValue" value="${info.realized_value}" style="width:70%;"/></td>
				<td class="tds">应用推广：</td>
				<td width="30%"><input id="applicationGeneralize" name="applicationGeneralize" value="${info.application_generalize}" style="width:70%;"/></td>
			</tr>
			
			<tr>
				<td class="tds">成果内容：</td>
				<td width="100%" colspan="3">
					<!--非全屏模式-->
				    <div id="container">
				        <!--菜单栏-->
				        <div id="toolbar-container" style="width:88.4%;">
				            <div id="editor-toolbar"></div>
				            <div id="btn-container">
				               <!--  <button id="btn1">全屏</button> -->
				            </div>
				        </div>
				        <input id="hiddencontent" type="hidden" name="achievementContent"/>
				        <div id="newsContent" class="newsContent" style="width:88.4%;"> 
				      
				       </div>
	                </div>
					<%-- <textarea style="width:88.5%; border-radius:5px; border: 1px solid #ccc;" rows="5" cols="" id="achievementContent" name="achievementContent">${info.achievement_content}</textarea> --%>
				</td>
			</tr>	
			<tr>
				<td class="tds">创新时间：</td>
				<td width="30%"><input id="innovationDate" name="innovationDate" value="${info.innovation_date}" style="width:70%;"/></td>
				<td class="tds">推荐单位意见：</td>
				<td width="30%"><input id="recommendRemark" name="recommendRemark" value="${info.recommend_remark}" style="width:70%;"/></td>
			</tr>
			<tr>
				
				<td class="tds">推荐时间：</td>
				<td width="30%"><input id="recommendDate" name="recommendDate" value="${info.recommend_date}" style="width:70%;"/></td>
				<td class="tds">局工会审核意见：</td>
				<td width="30%"><input id="auditRemark" name="auditRemark" value="${info.audit_remark}" style="width:70%;"/></td>
			</tr>
			<tr>
				<td class="tds">审核时间：</td>
				<td width="30%"><input id="auditDate" name="auditDate" value="${info.audit_date}" style="width:70%;"/></td>
				<td class="tds">自定义配图：</td>
				<td width="30%">
	                <input type="radio" name="isCustom1" <c:if test="${info.is_custom == '0'}">checked</c:if> value="0" style="width:5%;margin-right: 0">否</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input type="radio" name="isCustom1" <c:if test="${info.is_custom == '1'}">checked</c:if> value="1" style="width:5%;margin-right: 0" onclick="openUploadDialog()">是</input>
	                <input type="hidden" id="isCustom" name="isCustom" value="${info.is_custom}"/>
				</td>
			</tr>
		</table>
	</div>
		 
		 <input type="hidden" id="isEdit" name="isEdit" value="${isEdit}"/>
		 <input type="hidden" id="innovationUuid" name="innovationUuid" value="${info.innovation_uuid}"/>
		 <input type="hidden" id="imagePath" name="imagePath" value="${info.image_path}" />
		 <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
		   <input id="submitbtn" type="button" class="easyui-linkbutton" onclick="save()" value="提交"/>
		   <input id="reset" type="reset" class="easyui-linkbutton" onclick=" "  value="重置"/>
		   <input id="button" type="button" class="easyui-linkbutton" onclick="retList()"  value="返回列表"/></td>
		 </div>
		 
	</form>
    <div id="uploadImageDiv" style="display: none;">
		 <%@ include file="../uploadImage/uploadImage.jsp"%>
	</div>
  </body>
</html>
<script type="text/javascript">

var addUrl = '<c:url value="/website/backstage/ExcellentInnovationController.do"/>?method=saveOrUpdate';
var retrunUrl =  '<c:url value="/website/backstage/ExcellentInnovationController.do"/>?method=innovationList';
//图片上路经
var imageuploadsrc = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileUpload&oneLevelClassify=11';
//获取图片路径
var getImag='<c:url value="/system/freamwork/fileUploadController.do"/>?method=getImage&filePath=';
//上传配图
var uploadPhoto = '<c:url value="/website/backstage/uploadImageController.do"/>?method=uploadPhoto';
var newsContent = '${info.achievement_content}';

var groupid = "${sessionScope.user.tabPerson.groupid}";
commonObj.initDictCombobox("sex","SEX","<c:out value="${info.sex}"/>",true,false);
commonObj.initDictCombobox("occupation","ACCUPATION","<c:out value="${info.occupation}"/>",true,false);
commonObj.initDictCombobox("achievementForm","ACHIEVEMENT_FORM","<c:out value="${info.achievement_form}"/>",true,false);
commonObj.initDeptCombobox("deptUuid","1", groupid,"<c:out value="${info.dept_uuid}"/>",true);

//默认选中否
if($("#isCustom").val() == "" || $("#isCustom").val() == null){
	$("input[name='isCustom1']:eq(0)").attr("checked",'checked');
}

//如果是查看，不能编辑表单，隐藏按钮
if($("#isEdit").val() == 'query'){
	$("#submitbtn").hide();
	$("#reset").hide();
	$('input,select,textarea',$('#innovationForm')).attr('readonly',true);
	$("input[name='isCustom1']").attr("disabled",true);
}else if($("#isEdit").val() == 'add'){
	var personName = "${sessionScope.user.personName}";
	var phone = "${sessionScope.user.personTelephone}";
	var email = "${sessionScope.user.personEmail}";
	var groupName = "${sessionScope.user.groupName}";
     $("#declarePerson").val(personName);
     $("#declarePhone").val(phone);
     $("#declareEmail").val(email);
     $("#orgName").val(groupName);
}

$('#orgName').textbox({
	type : "text",
	required : true
});
$('#declarePerson').textbox({
	type : "text",
	required : true
});
$('#declarePhone').textbox({
});
$('#declareEmail').textbox({
});
$('#firstCompletePerson').textbox({
	type : "text",
	required : true
});

$('#education').textbox({
});
$('#job').textbox({
});
$('#deptName').textbox({
	type : "text",
	required : true
});
$('#major').textbox({
});
$('#otherCompletePerson').textbox({
});
$('#achievementName').textbox({
	type : "text",
	required : true
});
$('#realizedValue').textbox({
	type : "text",
	required : true
});
$('#applicationGeneralize').textbox({
	type : "text",
	required : true
});
$("#achievementContent").validatebox({
	required: true,    
    validType: "text"
});

$('#recommendRemark').textbox({});
$('#auditRemark').textbox({});
$('#innovationDate').datetimebox({
    editable:false,
	required : true
});
$('#recommendDate').datetimebox({
	editable:false,
	required : true
});
$('#auditDate').datetimebox({
	editable:false,
	required : true
});

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/wangEditor/wangEditor.min${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadfy/jquery.Huploadify${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jcrop/js/browser${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/innovation/addOrUpdateInnovation.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/uploadImage/uploadImage.js"></script>