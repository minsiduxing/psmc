<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title></title>
<style type="text/css">
.my-label{
	text-align: left;
	width:150px;
}
table{border:solid #add9c0; border-width:1px 0px 0px 1px; font-size: 12px;
 color:#333; margin-left: 40px; margin-top:15px; line-height: 20px; width: 400px;}
 
td{border:solid #add9c0; border-width:0px 1px 1px 0px; padding-left:10px;}

</style>

</head>
<body>
<div >
		
		<table style="border:solid #333; border-width:1px 0px 0px 1px; font-size: 12px;
 color:#333; margin-left: 40px; margin-top:15px; line-height: 20px; width: 400px;">
			<c:forEach items="${list}" var="subject" varStatus="status">
				<tr>
					<td style="width:160px;border:solid #333; border-width:0px 1px 1px 0px; padding-left:10px;">${status.index + 1}. ${subject["subject_name"]}</td>
					<td style="border:solid #333; border-width:0px 1px 1px 0px; padding-left:10px;">${subject["res"]}</td>
				</tr>
			</c:forEach>
		</table>
</div>
	
</body>
</html>