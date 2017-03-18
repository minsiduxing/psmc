<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
<%@ include file="common.jsp"%>
<title>请上传证书</title>

<meta charset="utf-8">
<meta http-equiv="description" content="license">


</head>

<body>
	<form id="submit_form" method="post" action="/psmc/license/load.do"
		enctype="multipart/form-data">
		<input type="file" name="file" id="file"> <input type="submit"
			value="上传">
	</form>

	<div id="feedback"></div>
	<!-- 响应返回数据容器 -->
</body>
<script>
 $(function(){
    var obj = getParam();
    if (isEmptyObject(obj)) {
        $("#feedback").text("license已过期");
        return;
    } 
    if (obj.auth!=null) {
    	$("#submit_form").text('证书失效！');
    	
	}else{
		$("#feedback").text(decodeURI(obj.msg));
	}
    
 });

 function getParam(){
    var raw = location.href.split('?')[1];
    var obj = {};
    if (raw != null) {
        var arr = raw.split("&");
        for (var i in arr) {
            var tmp = arr[i].split("=");
            obj[tmp[0]]=tmp[1];
        }
    }
    return obj;
 }

 function isEmptyObject(e) {  
    var t;  
    for (t in e)  
        return !1;  
    return !0  
}
</script>
</html>
