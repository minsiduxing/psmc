<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>问卷信息编辑页面</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">
	<input type="hidden" id="questionnaireUuid" name="questionnaireUuid" value="<c:out value="${questionnaire.questionnaireUuid}"/>"/>

		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label">问卷名称：</label>
				<input class="myinput" id="questionnaireName" name="questionnaireName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">问卷版本：</label>
				<input class="myinput" id="version" name="version"></input>
			</li> 
			<li class="li-input"><label for="" class="input-label">是否启用：</label>
				<input id="isEnable" name="isEnable"></input></li>
		</ul>
	</form>
<script type="text/javascript">
	$(document).ready(function() {
		commonObj.initDictCombobox("isEnable","IF","<c:out value="${questionnaire.isEnable}"/>",true,false);
	});

</script>
</body>
</html>