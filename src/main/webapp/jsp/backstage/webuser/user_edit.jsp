<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>用户编辑页面</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">
<input type="hidden" id="uuid" name="uuid" value="<c:out value="${user.uuid}"/>"></input>
<input type="hidden" id="password" name="password" value="<c:out value="${user.password}"/>"></input>
		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label">用户账号：</label>
				<input class="myinput" id="userId" name="userId"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">用户姓名：</label>
				<input class="myinput" id="userName" name="userName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">身份证号：</label>
				<input class="myinput" id="idCard" name="idCard"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">手机号码：</label>
				<input class="myinput" id="phone" name="phone"></input>
			</li>
		</ul>
	</form>
<script type="text/javascript">
	var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};

	function isCardID(sId){   
	    var iSum=0 ;  
	    var info="" ;  
	    if(!/^\d{17}(\d|x)$/i.test(sId)) return "你输入的身份证长度或格式错误";   
	    sId=sId.replace(/x$/i,"a");   
	    if(aCity[parseInt(sId.substr(0,2))]==null) return "你的身份证地区非法";   
	    sBirthday=sId.substr(6,4)+"-"+Number(sId.substr(10,2))+"-"+Number(sId.substr(12,2));   
	    var d=new Date(sBirthday.replace(/-/g,"/")) ;  
	    if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))return "身份证上的出生日期非法";   
	    for(var i = 17;i>=0;i --) iSum += (Math.pow(2,i) % 11) * parseInt(sId.charAt(17 - i),11) ;  
	    if(iSum%11!=1) return "你输入的身份证号非法";   
	    return true;   
	}   

	var basePath = $("#basePath").val();
	var oper = "${oper}";
	$(document).ready(
		function() {
			$.extend($.fn.validatebox.defaults.rules, {     
				idcared: {     
			        validator: function(value,param){    
			            var flag= isCardID(value);  
			            return flag==true?true:false;    
			        },     
			        message: '不是有效的身份证号码'    
			    }     
			}); 
			$('#userId').textbox({
				value : "${user.user_id}",
				type : "text",
				required : true
			});
			
			$('#userName').textbox({
				value : "${user.user_name}",
				type : "text",
				required : true
			});
			
			$('#idCard').textbox({
				value : "${user.id_card}",
				type : "text",
				required : true,
				validType : [ 'idcared' ]
			});
			$('#phone').textbox({
				value : "${user.phone}",
				type : "text",
				required : true,
				validType : [ 'rules_mobilePhoneNo' ]
			});
			
			var oper = "${oper}";
			if ("save" == oper){
				$("#password").val(hex_md5("123456"));
			}
		});
	
	
	
</script>
</body>
</html>