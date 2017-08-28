<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传测试</title>
</head>
<body>
<%@ include file="../common.jsp"%>
<form action='<c:url value="/system/freamwork/fileUploadController"/>?method=testFileUpload' method="post" enctype="multipart/form-data">
<input type="file" name ="file1" />
<input type = "submit" value="上传"/>

</form>
<br>
<hr>
<center>
<table id="filelist">

</table>
</center>
<!-- 图片测试-->
<%-- 
<img alt="测试图片" src='<c:url value="/system/freamwork/fileUploadController"/>?method=getImage&filePath=/log/psmc-upload/image/1503827969232-1503758893527-IMG_20140205_140419.jpg'>
 --%>
</body>
<script type="text/javascript">
var parentdir ;
var workDir ;
$(document).ready(function(){
	getFileList("\/");
});
//获取文件列表
function getFileList(path){
	$('#filelist').text("");
	if(path=="/"){
		parentdir ="/";
		workDir ="/";
	}else{
		parentdir =path.substring(0, path.lastIndexOf("\/")+1);
		if(!parentdir.substr(parentdir.length-1,1)=="/" &&parentdir!="/"){
			parentdir =parentdir.substring(0, parentdir.lastIndexOf("\/"))+"/";
		}
		workDir = parentdir+path.substring(path.lastIndexOf("\/")+1,path.length )+"/";
	}
	
	
	console.info(parentdir);
	var _url = '<c:url value="/system/freamwork/fileUploadController"/>?method=listFiles&filePath='+path; ;
	$.ajax({
			async:false,
			cache:false,
			type:'POST',
			dataType:"JSON",
			url:_url,
			success:function(data){
				var text = '<tr><th>文件序号</th><th>文件类型</th><th>名称</th><th>文件大小</th><th>文件操作</th></tr><tr ><td><a href="javascript:void(0);" onclick="getFileList(\''+parentdir+'\')">../</a></td></tr>';
				var num =1;
				if(data){
					if(data.directorys){
						for(var i in data.directorys){
							var dir = data.directorys[i]+"";
							var gtpram = ""+workDir+dir;
							text=text+'<tr><td>'+num+'</td><td>文件夹</td><td><a href="javascript:void(0);" onclick="getFileList(\''+gtpram+'\')">'+dir+'</a></td><td></td><td><a href="#">删除</a><td></tr>';
							num = (num+1);
						}
					}
					if(data.files){
						for(var i in data.files){
							text=text+'<tr><td>'+num+'</td><td>文件</td><td>'+data.files[i]+'</td><td></td><td><a href="<c:url value="/system/freamwork/fileUploadController"/>?method=testFileDelete&filePath='+path+data.files[i]+'" onclick="return isDel()">删除</a>||<a href="<c:url value="/system/freamwork/fileUploadController"/>?method=testFileDownload&filePath='+path+data.files[i]+'">下载</a><td></tr>';
							num = (num+1);
						}
					}
					
					$('#filelist').append(text);
				}
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {
				commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			}
		});
}
function isDel(){
	if(window.confirm("确定删除文件吗？删除则不可恢复！")){
		return true;
	}else{
		return false;
	}
	
}
function getsub(subDir){
	getFileList(subDir)
}
</script>
</html>