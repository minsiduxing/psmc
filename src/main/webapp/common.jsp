<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="priv.guochun.psmc.authentication.operate.OperateContantsUtil" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="kiben" content="no-cache">

<%@ page isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib  uri="http://prvi.guochun.com/mytag" prefix="g" %>  
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.5/themes/default/easyui${csssuffix}" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui-1.4.5/themes/icon${csssuffix}" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.5/jquery.easyui${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/common${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/extends/easyui-extends${jssuffix}"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form${jssuffix}"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/vlidate/dist/jquery.validate${jssuffix}"></script> --%>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/vlidate/dist/localization/messages_zh.min${jssuffix}"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/json2${jssuffix}"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/date/WdatePicker.js"></script> --%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/js/zTree_v3-master/css/zTreeStyle/zTreeStyle${csssuffix}" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/publish${csssuffix}" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/zTree_v3-master/js/jquery.ztree.core${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/zTree_v3-master/js/jquery.ztree.excheck${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/zTree_v3-master/js/jquery.ztree.exedit${jssuffix}"></script>


<input type="hidden" id="basePath" name="basePath" value="<%=request.getContextPath()%>"/>

<script type="text/javascript">
var basePath = $("#basePath").val();
//查询数据字典URL变量定义
var initDictUrl=basePath+"/system/common/dictController.do";
initDictUrl ='<c:url value="'+initDictUrl+'"/>?method=loadDict';
//查询属地树URL变量定义
var regionTreeDiaLogUrl =basePath+"/jsp/system/common/city/cityTree.jsp";
regionTreeDiaLogUrl ='<c:url value="'+regionTreeDiaLogUrl+'"/>';

var isAuthUrl =basePath + "/authentication/loginController.do";
isAuthUrl ='<c:url value="'+isAuthUrl+'"/>';


</script>

<!-- 属地控件的Div -->
<div id="regionTreeDiaLog"></div>

<!-- 角色选择控件 -->
<div id="roleDiaLog"></div>
