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
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Huploadify${csssuffix}" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/jcrop/css/jquery.Jcrop${csssuffix}"/> --%>
  </head>
  <%@ include file="../../../common.jsp"%>
  <body id="body">
<form id="editForm" method="POST" class="newsForm" >
	<div class=" panel-default" style="margin-top:15px; border: 1px solid #ddd;">
		<table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:10px;">
			<tr>
				<td class="tds">信息名称：</td>
				<td width="25%"><input id="newsTitle" name="newsTitle" style="width:50%;" value="${info.news_title}"/></td>
				<td class="tds">信息创建人：</td>
				<td width="25%"><input id="newAutor" name="newAutor" style="width:50%;" value="${info.news_author}"/></td>
			</tr>
			<tr>
				<c:if test="${oneLevelClassify == '14'}">
					<td class="tds">信息分类：</td>
					<td width="25%"><input id="towLevelClassify" name="towLevelClassify" style="width:50%;"/></td>
				</c:if>
				<td class="tds">自定义配图：</td>
				<td width="25%">
	                <input type="radio" name="isCustom1" <c:if test="${dept.is_custom == '0'}">checked</c:if> value="0" style="width:5%;margin-right: 0">否</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input type="radio" name="isCustom1" <c:if test="${dept.is_custom == '1'}">checked</c:if> value="1" style="width:5%;margin-right: 0" onclick="openUploadDialog()">是</input>
	                <input type="hidden" id="isCustom" name="isCustom" value="${dept.is_custom}"/>
				</td>
			</tr>
			<tr>
				<td class="tds">信息内容：</td>
				<td colspan="3" width="100%">
					<!--非全屏模式-->
				    <div id="container">
				        <!--菜单栏-->
				        <div id="toolbar-container">
				            <div id="editor-toolbar"></div>
				            <div id="btn-container">
				               <!--  <button id="btn1">全屏</button> -->
				            </div>
				        </div>
				        <input id="hiddencontent" type="hidden" name="newsContent"/>
				        <div id="newsContent" class="newsContent">
				      
				       </div>
	                </div>
				</td>
				
			</tr>
		</table>
	</div>
	<div id="uploadImageDiv"></div>

		<!-- <ul >
			<li ><label>信息标题：</label>
				<input  id="newsTitle" name="newsTitle"></input>
			</li>
			<li ><label >信息内容</label><br>
			 非全屏模式
			    <div id="container">
			        菜单栏
			        <div id="toolbar-container">
			            <div id="editor-toolbar"></div>
			            <div id="btn-container">
			                <button id="btn1">全屏</button>
			            </div>
			        </div>
			        <input id="hiddencontent" type="hidden" name="newsContent"/>
			        <div id="newsContent" class="newsContent">
			      
			       </div>
                </div>
                </li>
			<li ><label>信息时间</label><br>
				<input id="newsDate" name="newsDate" editable="false" ></input></li>
			<li ><label >信息创建人：</label><br>
				<input  id="newAutor" name="newAutor"></input></li>
		</ul> -->
	 <input type="hidden" id="isEdit" name="isEdit" value="${isEdit}"/>
	 <input type="hidden" id="newsUuid" name=newsUuid value="${info.uuid }"/>
	 <input type="hidden" id="oneLevelClassify" name="oneLevelClassify" value="${oneLevelClassify}"/>
	 <%-- <input type="hidden" id="towLevelClassify" name="towLevelClassify" value='${param.towLevelClassify}' /> --%>
	 <input type="hidden" id="imagePath" name="imagePath" value="" />
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

var basePath = $("#basePath").val();
//上传路径
var uploadUrl = basePath+"/website/backstage/InfoReleaseController.do";
uploadUrl ='<c:url value="'+uploadUrl+'"/>?method=uploadPicture';
//获取图片路径
var getImag='<c:url value="/system/freamwork/fileUploadController.do"/>?method=getImage&filePath=';
var _url = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileDelete&filePath=';

//图片上路经
var imageuploadsrc = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileUpload&oneLevelClassify='+$("#oneLevelClassify").val();
//修改保存路径
var path = '<c:url value="'+ basePath+'/website/backstage/InfoReleaseController.do"/>?method=confirmPicture';
//表单数据初始化---------------------------------------------------
var newsTitle = "${info.newsTitle}";
var newscontent = '${info.news_content}';
var editnewssrc = "${info.thumbnail_image_url}";
var addUrl = '<c:url value="/website/backstage/InfoReleaseController.do"/>?method=saveOrUpdateInfoRelease';
var retrunUrl =  '<c:url value="/website/backstage/InfoReleaseController.do"/>?method=infoReleaseList&oneLevelClassify='+$("#oneLevelClassify").val();

//弹出图片上传窗口
var toImageUpload =  '<c:url value="/website/backstage/uploadImageController.do"/>?method=toImageUplodDialog';
//上传配图
var uploadPhoto = '<c:url value="/website/backstage/uploadImageController.do"/>?method=uploadPhoto';

//默认选中否
if($("#isCustom").val() == "" || $("#isCustom").val() == null){
	$("input[name='isCustom1']:eq(0)").attr("checked",'checked');
}
commonObj.initDictCombobox("towLevelClassify","INFO_TYPE","<c:out value="${info.towLevelClassify}"/>",true,false);

function formInint(isEdit){
	if(isEdit == "query"){
		$("#submitbtn").hide();
		$("#reset").hide();
		$('input,select',$('#editForm')).attr('readonly',true);
		$("#newsDate").attr("readonly", true);
		$("input[name='isCustom1']").attr("disabled",true);
	}else if(isEdit == "add"){
		var personName = "${sessionScope.user.personName}"
	    $("#newAutor").val(personName);
	}
	
	$('#newsTitle').textbox({
		type:"text",
        required : true

	});
	$('#newsDate').datetimebox({
		required : true,
		editable:false
	});
	$('#newAutor').textbox({
		type:"text",
        required : true
	});
}

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/wangEditor/wangEditor.min${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/uploadfy/jquery.Huploadify${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jcrop/js/browser${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/infoRelease/infoAddOrEdit.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/uploadImage/uploadImage.js"></script>