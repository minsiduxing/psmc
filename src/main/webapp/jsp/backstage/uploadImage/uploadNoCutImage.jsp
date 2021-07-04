<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="../../../common.jsp"%>
    <title>Insert title here</title>
</head>
<body>
<div id="idPhotoEditWin" align="center">
    <form id="upload-file-no-cut" method="post" enctype="multipart/form-data" >
        <table  style="border:0; width: 580px;height: 500px">
            <tr style="height:40px;width: 560px">
                <td id="idTagFakeFileInput" align="left">
                    <div style="width:530px;margin-left: 14px;">
                        <input id="upload_btn" name="image" type="file" style="width:400px;border:1px solid #ececec;" value="" onchange="previewImageNoCut(this)"/>
                    </div>
                </td>

            </tr>
            <tr style="height:420px;width: 560px">
                <td align="center" >
                    <div id="idTagDivPhoto" style="width:400px;height:400px;border:1px solid #ececec;">
                        <img id = "targetView" src="<%=request.getContextPath()%>/images/touxiang_default.png" style="max-width:100%; max-height:100%; width:auto; height:auto;" class="jcrop-preview" alt="附件">
                    </div>
                </td>
            </tr>
            <tr style="height:30px;">
                <td align="center">
                    <table style="width:100%;height:30px;">
                        <tr>
                            <td align="right">
                                <input id="upload" type="button" class="easyui-linkbutton" value="上传" style="width:60px;height:35px;
                             	padding-top:3px;margin-right:10px;" onclick="imageNoCutUpload()">
                            </td>
                            <td align="left">
                                <input id="close" type="button" class="easyui-linkbutton" value="关闭" style="width:60px;height:35px;
                             	padding-top:3px;margin-right:10px;" onclick="closeNoCutDialog()">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script type="text/javascript">

</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/backstage/uploadImage/uploadNoCutImage.js"></script>
</html>