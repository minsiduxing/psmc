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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/news/news${csssuffix}" type="text/css">
</head>
<%@ include file="../../common.jsp"%>
<body id="body">
<form id="inquestItemForm" method="POST" >

    <div class=" panel-default" style="margin-top: 30px; border: 1px solid #ddd;">
        <div class="">
            <table class="table table-hover" style="font-size:12px; width:75%; border-collapse:separate; border-spacing:20px;" >
                <tr>
                    <td class="tds"><label style="color: #fa3641">*</label>勘验阶段：</td>
                    <td width="30%"><input id="stageCode" name="stageCode" value="${info.stageCode}" style="width:70%;"/></td>
                    <td class="tds"><label style="color: #fa3641">*</label>题目类型：</td>
                    <td width="30%"><input id="questionType" name="questionType" value="${info.questionType}" style="width:70%;"/></td>
                </tr>
                <tr>
                    <td class="tds"><label style="color: #fa3641">*</label>所属组织：</td>
                    <td width="30%"><input id="orgCode" name="orgCode" value="${info.orgCode}" style="width:70%;"/></td>
                    <td class="tds"><label style="color: #fa3641">*</label>提示信息：</td>
                    <td width="30%"><input id="tipsInfo" name="tipsInfo" type="text" value="${info.tipsInfo}" style="width:70%;"/></td>
                </tr>
                <tr>
                    <td class="tds"><label style="color: #fa3641">*</label>是否受特殊群体影响：</td>
                    <td width="30%">
                        <input type="radio" name="isAffectedBsg" <c:if test="${info.isAffectedBsg == false}">checked</c:if> value="false" style="width:5%;margin-right: 0">否</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="isAffectedBsg" <c:if test="${info.isAffectedBsg == true}">checked</c:if> value="true" style="width:5%;margin-right: 0" >是</input>
                    </td>
                    <td class="tds"><label style="color: #fa3641">*</label>是否进行距离测算：</td>
                    <td width="30%">
                        <input type="radio" name="isAffectedJlcl" <c:if test="${info.isAffectedJlcl == false}">checked</c:if> value="false" style="width:5%;margin-right: 0">否</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="isAffectedJlcl" <c:if test="${info.isAffectedJlcl == true}">checked</c:if> value="true" style="width:5%;margin-right: 0" >是</input>
                    </td>
                </tr>
                <tr>
                    <td class="tds"><label style="color: #fa3641">*</label>是否进行饱和度测算：</td>
                    <td width="30%">
                        <input type="radio" name="isAffectedBhdcs" <c:if test="${info.isAffectedBhdcs == false}">checked</c:if> value="false" style="width:5%;margin-right: 0">否</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="isAffectedBhdcs" <c:if test="${info.isAffectedBhdcs == true}">checked</c:if> value="true" style="width:5%;margin-right: 0" >是</input>
                    </td>
                    <td class="tds"><label style="color: #fa3641">*</label>是否负面清单：</td>
                    <td width="30%">
                        <input type="radio" name="isNegative" <c:if test="${info.isNegative == '0'}">checked</c:if> value="0" style="width:5%;margin-right: 0">否</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="isNegative" <c:if test="${info.isNegative == '1'}">checked</c:if> value="1" style="width:5%;margin-right: 0">是</input>
                    </td>
                </tr>
                <tr>
                    <td class="tds"><label style="color: #fa3641">*</label>题目内容：</td>
                    <td width="30%" colspan="3">
                         <textarea style="width:88.5%; border-radius:5px; border: 1px solid #ccc;" rows="10" cols="" id="questionName" name="questionName">${info.questionName}</textarea>
                    </td>
                </tr>
                <tr>
                    <td class="tds">展示配图：</td>
                    <td width="30%">
                        <input type="hidden" id="displayAtlas" name="displayAtlas" value="${info.displayAtlas}"/>
                        <input type="hidden" id="attachmentUuids" name="attachmentUuids" value="${info.attachmentUuids}"/>
                        <input id="image" name="image" type="file" style="width:60%;border-radius:5px; border: 1px solid #ccc; margin-right: 10px;"/>
                        <input style="width:50px; height: 25px;" id="upload" class="easyui-linkbutton" onclick="imageUpload();" value="上传"/>
                        <div id="pic">
                            <table id="picTable" width="80%">
                                <c:forEach var="att" items="${attachmentList}" varStatus="status">
                                    <tr id="${att.attachment_uuid }">
                                        <td ><a href="javascript:imgShow('${att.file_prefix }${att.file_path}')">${att.file_real_name}.${att.file_suffix} </a></td>
                                        <td ><input style="width:50px; height: 25px;" class="easyui-linkbutton" onclick="deleteImage('${att.attachment_uuid}', '${att.file_prefix }${att.file_path}')" value="删除"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="tds">展示视频：</td>
                    <td width="30%">
                        <input type="hidden" id="displayVidio" name="displayVidio" value="${info.displayVidio}"/>
                        <input id="video" name="video"  type="file" style="width:60%;border-radius:5px; border: 1px solid #ccc; margin-right: 10px;"/>
                        <input style="width:50px; height: 25px;" id="uploadVideo" class="easyui-linkbutton" onclick="videoUpload();" value="上传"/>
                        <div id="videoDiv">
                            <table id="videoTable" width="80%">
                                <tr>
                                    <td colspan="2"><label id="videoName">${info.videoName}</label></td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <input type="hidden" id="isEdit" name="isEdit" value="${isEdit}"/>
    <input type="hidden" id="itemUuid" name="itemUuid" value="${info.itemUuid}"/>
    <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
        <input id="submitbtn" type="button" class="easyui-linkbutton" onclick="save()" value="提交"/>
        <input id="button" type="button" class="easyui-linkbutton" onclick="retList()"  value="返回列表"/></td>
    </div>

</form>
<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:10000;width:100%;height:100%;display:none;">
    <div id="innerdiv" style="position:absolute;">
        <img id="bigimg" style="border:5px solid #fff;" src="" />
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    var basePath = $("#basePath").val();
    var inquestDo = basePath+"/inquest/tabYcInquestItemCfgController.do";
    var addUrl = '<c:url value="'+inquestDo+'"/>?method=saveOrUpdateInquestItem';
    var retrunUrl =  '<c:url value="'+inquestDo+'"/>?method=ycInquestItemCfgList';
    //图片上路经
    var uploadUrl = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileUploadByPC';
    var uploadVideoUrl = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=fileUploadVideo';
    //删除图片附件
    var deleteAttachment = '<c:url value="/website/backstage/tabAttachmentController.do"/>?method=deleteAttachment';
    var imageShowUrl = '<c:url value="/system/freamwork/fileUploadController.do"/>?method=showImg';
    commonObj.initDictCombobox("stageCode","STAGE_CODE","<c:out value="${info.stageCode}"/>",true,false,"");
    commonObj.initDictCombobox("questionType","QUESTION_TYPE","<c:out value="${info.questionType}"/>",true,false,"");
    commonObj.initDictCombobox("orgCode", "BELONG_TO_ZMJ","<c:out value="${info.orgCode}"/>",true,false,"");

    $('#tipsInfo').textbox({
        type : "text",
        required : true
    });

    $('#questionName').validatebox({
        required: true,
        validType: "text"
    });

    //默认选中否
    if($("input[name='isAffectedBsg']").val() == "" || $("input[name='isAffectedBsg']").val() == null){
        $("input[name='isAffectedBsg']:eq('false')").attr("checked",'checked');
    }
    if($("input[name='isAffectedJlcl']").val() == "" || $("input[name='isAffectedJlcl']").val() == null){
        $("input[name='isAffectedJlcl']:eq('false')").attr("checked",'checked');
    }
    if($("input[name='isAffectedBhdcs']").val() == "" || $("input[name='isAffectedBhdcs']").val() == null){
        $("input[name='isAffectedBhdcs']:eq('false')").attr("checked",'checked');
    }
    if($("input[name='isNegative']").val() == "" || $("input[name='isNegative']").val() == null){
        $("input[name='isNegative']:eq('false')").attr("checked",'checked');
    }

    if($("#isEdit").val() == 'query'){
        $("#submitbtn").hide();
        $("#reset").hide();
        $('input,select,textarea',$('#inquestItemForm')).attr('disabled',true);
        $("#button").attr("disabled",false);
    }




</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/inquest/addYcInquestItem.js">
</script>