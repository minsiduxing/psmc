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
	<form id="upload-file" method="post" enctype="multipart/form-data" >  
     <table  style="border:0; width: 580px;height: 500px">
         <tr style="height:40px;width: 560px">
              <td id="idTagFakeFileInput" colspan="2" align="left">
              	<div style="width:530px;margin-left: 14px;">
              		<input id="upload_btn" name="image" type="file" style="width:400px;border:1px solid #ececec;" value="" onchange="previewImage(this)"/>  
		         	 <!-- 图片长宽高隐藏域 -->
		             <input type="hidden" id="x" name="x" /> 
		             <input type="hidden" id="y" name="y" /> 
		             <input type="hidden" id="w" name="w" /> 
		             <input type="hidden" id="h" name="h" />
		             <input type="hidden" id="boundx" name="boundx" >
		             <input type="hidden" id="boundy" name="boundy" >
              	</div>
              </td>
                    
         </tr>
         <tr style="height:420px;width: 560px">
             <td align="center" >
                 <div id="idTagDivPhoto" style="width:400px;height:400px;border:1px solid #ececec;">
                     <img id = "target" src="<%=request.getContextPath()%>/images/touxiang_default.png" style="max-width:100%; max-height:100%; width:auto; height:auto;" class="jcrop-preview" alt="附件">
                 </div>
             </td>
             <td  align="center">
                 
                 <div id="preview-panel" style="width:130px;height:140px;border:0px solid green;margin-top:100px;">
                 	<div>预览：</div>
                      <div class = "previewDiv" style="width: 130px;height: 130px;overflow: hidden;border:1px solid #ececec" >
                            <img id = "preview" src="<%=request.getContextPath()%>/images/touxiang_default.png" width="130px" height="130px" class="jcrop-preview" alt="预览" >
                      </div>
                 </div>
             </td>
         </tr>
         <tr style="height:30px;">
             <td colspan="2" align="center">
                 <table style="width:100%;height:30px;">
                     <tr>
                         <td align="right">
                             <input id="upload" type="button" class="easyui-linkbutton" value="上传" style="width:60px;height:30px;
                             	padding-top:3px;margin-right:10px;" onclick="imageUpload()">
                         </td>
                         <td align="left">
                             <input id="close" type="button" class="easyui-linkbutton" value="关闭" style="width:60px;height:30px;
                             	padding-top:3px;margin-right:10px;" onclick="closeDialog()">
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
<script type="text/javascript" src="uploadImage.js"></script>
</html>