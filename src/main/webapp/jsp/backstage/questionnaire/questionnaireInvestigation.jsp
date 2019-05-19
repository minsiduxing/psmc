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
        <%-- <c:forEach items="${list}" var="subject" varStatus="status">
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
        <div class="btn_style">保存</div> --%>
      <!-- --------------------------------------------------------------- -->  
       
        
        <form id="questionForm">
	        <div class="xh_list">
	            <div class="wb-6">1.接待人员的态度：</div>
	            <input type="hidden" name="resultList[0].subjectUuid" value="99ad2665ff2c409990e17df4c011119c">
	            <input type="hidden" name="resultList[0].evaluateInfoUuid" value="${evaluateInfoUuid }">
	            <div class="wb-6">
	                <div id="function-demo1" class="target-demo function-demo"></div>
	            </div>
	        </div>
	        <div class="xh_list">
	            <div class="wb-6">2.芳疗师的手法及服务：</div>
	            <input type="hidden" name="resultList[1].subjectUuid" value="856861c932374a2d8ed4eba6920c8f41">
	            <input type="hidden" name="resultList[1].evaluateInfoUuid" value="${evaluateInfoUuid }">
	            <div class="wb-6">
	                <div id="function-demo2" class="target-demo function-demo"></div>
	            </div>
	        </div>
	        <div class="xh_list">
	            <div class="wb-6">3.芳疗师的形象气质：</div>
	            <input type="hidden" name="resultList[2].subjectUuid" value="6b4226ac64124781b02208404ff245b0">
	            <input type="hidden" name="resultList[2].evaluateInfoUuid" value="${evaluateInfoUuid }">
	            <div class="wb-6">
	                <div id="function-demo3" class="target-demo function-demo"></div>
	            </div>
	        </div>
	        <div class="xh_list">
	            <div class="wb-6">4.环境设施与整体感受：</div>
	            <input type="hidden" name="resultList[3].subjectUuid" value="65f205463e244242828ac96cc96e31b4">
	            <input type="hidden" name="resultList[3].evaluateInfoUuid" value="${evaluateInfoUuid }">
	            <div class="wb-6">
	                <div id="function-demo4" class="target-demo function-demo"></div>
	            </div>
	        </div>
	        <p class="question_title">5.您在做spa的过程中更希望：</p>
	        	<input type="hidden" name="resultList[4].subjectUuid" value="d5690268600b4779be83128e7094cc4e">
	        	<input type="hidden" name="resultList[4].evaluateInfoUuid" value="${evaluateInfoUuid }">
	        <div class="radio_content">
	            <div class="wb-6">
	                <div class="radio_list">
	                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
	                    <input type="radio" class="radio_ipt" name="resultList[4].resultValue" value="放松休息"/>
	                    <span>放松休息</span>
	                </div>
	            </div>
	            <div class="wb-6">
	                <div class="radio_list">
	                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
	                    <input type="radio" class="radio_ipt" name="resultList[4].resultValue" value="聊天减压"/>
	                    <span>聊天减压</span>
	                </div>
	            </div>
	            <div class="wb-6">
	                <div class="radio_list">
	                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
	                    <input type="radio" class="radio_ipt" name="resultList[4].resultValue" value="手法舒适"/>
	                    <span>手法舒适</span>
	                </div>
	            </div>
	            <div class="wb-6">
	                <div class="radio_list">
	                    <img src="<%=request.getContextPath()%>/images/sjhc/radio_no.png"/>
	                    <input type="radio" class="radio_ipt" name="resultList[4].resultValue" value="项目功效"/>
	                    <span>项目功效</span>
	                </div>
	            </div>
	        </div>
	        <p class="question_title">6.您的意见与建议：</p>
	        <input type="hidden" name="resultList[5].subjectUuid" value="0459acf22f7a4ff0a48ba13d93253f54">
	        <input type="hidden" name="resultList[5].evaluateInfoUuid" value="${evaluateInfoUuid }">
	        <textarea class="textarea_style" id="textareaId" name="resultList[5].resultValue"></textarea>
        </form>
        
        <input type="hidden" id="questionnaireUuid" value="${questionnaireUuid }">
        <div ><input type="button" value="提交" class="btn_style" onclick="submitFn();"></div> 
    </div>
</div>

	<!--等待上传中-->
	<div class="up_load">
	    <div class="sk-double-bounce">
	        <div class="sk-child sk-double-bounce1"></div>
	        <div class="sk-child sk-double-bounce2"></div>
	    </div>
	    <p>提交中，请稍等</p>
	</div>
	<!--警告提示-->
	<div class="alert_warn">
	    <div class="warn_content">
	        <div class="alert_content"></div>
	        <div class="btn_click">确定</div>
	    </div>
	</div>


<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.raty.min.js"></script>
<script>
	var infoDo = basePath+"/website/backstage/QuestionnaireController.do";
	var submitQuestionnaireUrl = '<c:url value="'+infoDo+'"/>?method=submitQuestionnaire';
	var type1 = "<c:out value='${type1}'/>";
	var type2 = "<c:out value='${type2}'/>";
	var type3 = "<c:out value='${type3}'/>";
	var type4 = "<c:out value='${type4}'/>";
	var type5 = "<c:out value='${type5}'/>";
	var type6 = "<c:out value='${type6}'/>"; //星级评价
	
    $('.radio_list').click(function () {
        $('.radio_list').find('img').attr('src',basePath+'/images/sjhc/radio_no.png');
        $(this).find('img').attr('src',basePath+'/images/sjhc/radio_yes.png');
        $(this).find('input').prop("checked",true);
    });
    $(function() {
    	
    	for(var i=1; i<=type6; i++){
    		$('#function-demo'+i).raty({
                number: 5,//多少个星星设置
                score: 1,//初始值设置
                scoreName:"resultList["+(i-1)+"].resultValue",
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
                   // alert('ID: ' + $(this).attr('id') + "\nscore: " + score + "\nevent: " + evt.type);
                }
            });
    	}
        
    });
    
    function submitFn(){
    	var validate = true;                
    	
    	var radiosValue = $("input[name='resultList[4].resultValue']:checked").val();
    	if(radiosValue == null || radiosValue == ""){
    		validate = false;
    	}
    	if($("#textareaId").val() == null || $("#textareaId").val() == ""){
    		validate = false;
    	}
    	if(!validate){
    		$('.alert_content').html("请将问卷完成后再提交!");
			$('.alert_warn').show();
    		return;
    	} 
    	
    	var formstr = $('#questionForm').serialize();
    	$('.up_load').show();
		$.ajax({
			   type: "POST",
			   url: submitQuestionnaireUrl,
			   dataType:"json",
			   data:formstr,
			   success: function(data){
				   $('.up_load').hide();
				   if(data.res == 'success'){
					   $('.alert_content').html("提交成功！");
				   }else{
					   $('.alert_content').html(data.msg);
				   }
				   $('.alert_warn').show();
				   $('.btn_click').unbind().click(function () {
				        $('.alert_warn').hide();
				        window.location.href = "http://www.sjhcspa.com/";
				    })
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   $('.up_load').hide();
				   var status  = XMLHttpRequest.status;
				   var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");
				   if(sessionstatus=='timeout'){ 
					    $('.alert_content').html("请求超时，请稍后再试！");
						$('.alert_warn').show();
					    return;
				   }
				   if(status == 500){
						var responseText = XMLHttpRequest.responseText;
						$('.alert_content').html(responseText);
						$('.alert_warn').show();
						return;
				   }
				   $('.alert_content').html("系统错误，请联系管理员！");
				   $('.alert_warn').show();
			   }
		});
    }
    
    //表单提交成功后的回调方法
	function successCallback(data){
		$.messager.progress("close");
		$("#evaluateTableId").datagrid('reload');
		commonObj.showResponse(data);
	}
    
    //隐藏警告层
    $('.btn_click').click(function () {
        $('.alert_warn').hide();
    })
 
</script>
</body>
</html>
