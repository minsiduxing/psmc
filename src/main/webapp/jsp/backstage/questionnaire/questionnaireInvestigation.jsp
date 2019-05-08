<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ include file="../../../common.jsp"%>
<head>
    <meta charset="utf-8">
    <title>问卷调查</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/sjhc_style.css" type="text/css" /> 
<body>
<div class="page_content">
    <img src="<%=request.getContextPath()%>/images/sjhc/top_bj.png" class="top_bj"/>
    <div class="question_content">
        <div class="title-text">
            <span>请对我们的服务评价</span>
        </div>
        <c:forEach items="${list}" var="subject" varStatus="status">
        	<c:if test="${subject.subjectType == 6}">
        		<div class="xh_list">
		            <div class="wb-6">${status.index + 1}.${subject.subjectName }：</div>
		            <div class="wb-6">
		                <div id="function-demo${status.index + 1 }" class="target-demo function-demo"></div>
		            </div>
		        </div>
        	</c:if>
        	<c:if test="${subject.subjectType == 2}">
        	  <p class="question_title">${status.index + 1}.${subject.subjectName }：</p>
        		<div class="radio_content">
		            <div class="wb-6">
		            	<c:forEach items="${subject.optionList}" var="option">
		            		<div class="radio_list">
			                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
			                    <input type="radio" class="radio_ipt" name="radio_s" value="${option.optionsValue }"/>
			                    <span>${option.optionsName }</span>
			                </div>
		            	</c:forEach>
		            </div>
		        </div>
        	</c:if>
        	<c:if test="${subject.subjectType == 5}">
        		<p class="question_title">${status.index + 1}.${subject.subjectName }：</p>
		        <textarea class="textarea_style"></textarea>
        	</c:if>
        </c:forEach>
        <div class="btn_style">保存</div>
        
        <%-- <div class="xh_list">
            <div class="wb-6">1.接待人员的态度：</div>
            <div class="wb-6">
                <div id="function-demo1" class="target-demo"></div>
            </div>
        </div>
        <div class="xh_list">
            <div class="wb-6">2.芳疗师的手法及服务：</div>
            <div class="wb-6">
                <div id="function-demo2" class="target-demo"></div>
            </div>
        </div>
        <div class="xh_list">
            <div class="wb-6">3.芳疗师的形象气质：</div>
            <div class="wb-6">
                <div id="function-demo3" class="target-demo"></div>
            </div>
        </div>
        <div class="xh_list">
            <div class="wb-6">4.环境设施与整体感受：</div>
            <div class="wb-6">
                <div id="function-demo4" class="target-demo"></div>
            </div>
        </div>
        <p class="question_title">5.您在做spa的过程中更希望：</p>
        <div class="radio_content">
            <div class="wb-6">
                <div class="radio_list">
                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
                    <input type="radio" class="radio_ipt" checked name="radio_s"/>
                    <span>放松休息</span>
                </div>
            </div>
            <div class="wb-6">
                <div class="radio_list">
                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
                    <input type="radio" class="radio_ipt" name="radio_s"/>
                    <span>聊天减压</span>
                </div>
            </div>
            <div class="wb-6">
                <div class="radio_list">
                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
                    <input type="radio" class="radio_ipt" name="radio_s"/>
                    <span>手法舒适</span>
                </div>
            </div>
            <div class="wb-6">
                <div class="radio_list">
                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
                    <input type="radio" class="radio_ipt" name="radio_s"/>
                    <span>项目功效</span>
                </div>
            </div>
        </div>
        <p class="question_title">6.您的意见与建议：</p>
        <textarea class="textarea_style"></textarea>
        <div class="btn_style">保存</div> --%>
    </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.raty.min.js"></script>
<script>
    $('.radio_list').click(function () {
        $('.radio_list').find('img').attr('src',basePath+'/images/sjhc/radio_no.png');
        $(this).find('img').attr('src',basePath+'/images/sjhc/radio_yes.png');
        $(this).find('input').prop("checked",true);
    });
    $(function() {
        $('.function-demo').raty({
            number: 5,//多少个星星设置
            score: 1,//初始值是设置
            targetType: 'number',//类型选择，number是数字值，hint，是设置的数组值
            path      : basePath+'/images/sjhc',
            cancelOff : 'star-off.png',
            cancelOn  : 'star-on.png',
            size      : 24,
            cancel    : false,
            targetKeep: true,
            precision : false,//是否包含小数
            click: function(score, evt) {
            	var id = $(this).attr('id');
            	$("#"+id).val(score);
                alert('ID: ' + $(this).attr('id') + "\nscore: " + score + "\nevent: " + evt.type);
            }
        });
    });

</script>
</body>
</html>
