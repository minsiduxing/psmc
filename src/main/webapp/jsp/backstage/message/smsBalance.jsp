<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>短彩信余量查询</title>

</head>
<body>

		<ul class="addform-subcontent">
			<li class="li-input"><label for="" >短信群发剩余条数：</label>
				${tabMessagePool.smsGroup }
			</li>
			<li class="li-input" ><label for=""  >彩信群发剩余条数：</label>
				${tabMessagePool.mmsBalance }
			</li>
			<li class="li-input" ><label for="" >个性化短信剩余条数：</label>
				${tabMessagePool.smsCustom }
			</li>
		</ul>
<script type="text/javascript">
	
	
	
</script>
</body>
</html>