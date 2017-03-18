/**
 * 扩展jquery easyui 基于jquery easyui-1.4.5版本
 * 
 * 
 */


/**
 * 校验扩展
 */
$.extend($.fn.validatebox.defaults.rules, {
	/**
	 * 正整数校验 
	 */
	rules_positiveNo: {
		validator: function(value, param){
			var rexp = new RegExp("^[0-9]*[1-9][0-9]*$"); 
		    return rexp.test(value);
		},
		message: '请输入一个正整数!'
    },
    /**
     * 手机号校验
     * 规则：现在只有13、15和18开头的11位手机号码。以1开头，第2位数字为3或5或8，后面接9位数字。
     */
    rules_mobilePhoneNo: {
		validator: function(value, param){
			var rexp = new RegExp("^[1][358][0-9]{9}$"); 
		    return rexp.test(value);
		},
		message: '请输入一个正确的手机号码!'
    },
    
    /**
     * 账号校验 
     * 用户名是最少6位,最多15位的数字、大小写字母、下划线的组合,且必须以大小写字母开头!
     */
    
    rules_accountName: {
		validator: function(value, param){
			var rexp = new RegExp("^[a-zA-Z][a-zA-Z0-9_]{3,14}$"); 
		    return rexp.test(value);
		},
		message: '用户名是最少4位,最多15位的数字、大小写字母、下划线的组合,且必须以大小写字母开头!'
    },
    
    /**
     * 密码校验 
     * 密码长度不能少于8个字符且必须由数字、字符、特殊字符三种中的两种组成!
     */
    
    rules_accountPass: {
		validator: function(value, param){
			var rexp = new RegExp("(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{7,}"); 
		    return rexp.test(value);
		},
		message: '密码长度不能少于8个字符且必须由数字、字符、特殊字符组成!'
    },
    
    /**
	 * 用户名唯一性校验
	 */
	rules_accountUnique: {
		validator: function(value, param){
			var flag = false;
			$.ajax({
				   url: basePath+"/authentication/accountController.do",
				   data: "method=accountUniqueValidate&accountName="+value+"&uuid="+$("#uuid").val(),
				   type: "GET",
				   async : false,
				   cache: false,
				   success: function(data){
					  data = JSON.parse(data);
					  if(data.res=='success'){
						  flag = true;  
					  }
				   },
				   error:function(XMLHttpRequest, textStatus, errorThrown){
					   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				   }
				 });
			return flag;
		},
		message: '用户名在系统中已存在!'
    },
    rules_roleUnique: {
		validator: function(value, param){
			var flag = false;	
            $.ajax({
                url: basePath + "/authentication/roleController.do",
                data: {
                    'method': 'roleUniqueValidate',
                    'roleNo': value,
                    'uuid':$("#uuid").val()
                    
                },
                type: "GET",
                async: false,
                cache: false,
                success: function(data) {
                    data = JSON.parse(data);
                    if (data.res == 'success') {
                        flag = true;
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                }
            });//ajax
            return flag;
		},
		message: '角色编码在系统中已存在!'
    }
});


