<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传测试</title>
<style type="text/css">
#filelist{
 padding:10px;
}
#filelist td{
	margin-left:20px;
}
</style>
</head>
<body>
<%@ include file="../common.jsp"%>
<form action='<c:url value="/system/freamwork/fileUploadController"/>?method=fileUpload' method="post" enctype="multipart/form-data">
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
	var backSpan = '<a href="javascript:void(0);" onclick="backParent(\''+path+'\')">../</a>';
	if(path=="/"){
		parentdir ="/";
		workDir ="/";
		backSpan ="";
	}else
		{
			parentdir =path.substring(0, path.lastIndexOf("\/")+1);
		}
		workDir = parentdir+path.substring(path.lastIndexOf("\/")+1,path.length)+"/";
	console.info("p:"+path);
	console.info("w:"+workDir);
	console.info("pp:"+parentdir);
	var _url = '<c:url value="/system/freamwork/fileUploadController"/>?method=listFiles&filePath='+path; ;
	$.ajax({
			async:false,
			cache:false,
			type:'POST',
			dataType:"JSON",
			url:_url,
			success:function(data){
				var text = '<tr><th class="num">文件序号</th><th class="type">文件类型</th><th class="name">名称</th><th class="size">文件大小</th><th class="oper">文件操作</th></tr><tr><td>'+backSpan+'</td></tr>';
				var num =1;
				if(data){
					if(data.directorys){
						for(var i in data.directorys){
							var dir = data.directorys[i].fileRealName;
							var size = data.directorys[i].fileSize;
							var name = data.directorys[i].fileRealName;
							path = path.replace("//","/");
							var gtpram = ""+workDir+dir;
							text=text+'<tr><td>'+num+'</td><td>文件夹</td><td><a href="javascript:void(0);" onclick="getFileList(\''+gtpram+'\')">'+dir+'</a></td><td>'+size+'</td><td><a href="<c:url value="/system/freamwork/fileUploadController"/>?method=fileDelete&filePath='+path+"/"+name+'" onclick="return isDel()">删除</a><td></tr>';
							num = (num+1);
						}
					}
					if(data.files){
						for(var i in data.files){
							var size = data.files[i].fileSize;
							var name = data.files[i].fileRealName;
							path = path.replace("//","/");
							text=text+'<tr><td>'+num+'</td><td>文件</td><td>'+name+'</td><td>'+size+'</td><td><a href="<c:url value="/system/freamwork/fileUploadController"/>?method=fileDelete&filePath='+path+"/"+name+'" onclick="return isDel()">删除</a>||<a href="<c:url value="/system/freamwork/fileUploadController"/>?method=testFileDownload&filePath='+path+"/"+name+'">下载</a><td></tr>';
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
	getFileList(subDir);
}
function backParent(path){
	if(path){
	   getFileList(path.substring(0, path.lastIndexOf("\/")));
	}else{
		getFileList("/");
		}
	
}
</script>
</html>