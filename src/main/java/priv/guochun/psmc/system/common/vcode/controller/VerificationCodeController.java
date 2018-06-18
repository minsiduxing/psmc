package priv.guochun.psmc.system.common.vcode.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.common.vcode.model.TabVerificationCode;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;

//http://127.0.0.1:8080/psmc/system/common/vcodeController.do?method=validateCode&type=2&code=123456


@Controller
@RequestMapping("/system/common/vcodeController")
public class VerificationCodeController extends MyController {

	
	protected static final  Logger logger  = LoggerFactory.getLogger(VerificationCodeController.class);
	
	@Autowired
	private VerificationCodeService verificationCodeService;
	 
	
	@RequestMapping(params="method=createCode")  
	@ResponseBody
	public void createCode(HttpServletRequest request,
	            HttpServletResponse response,long type) throws IOException{	
//			String custmerIp = request.getRemoteAddr();
//			TabVerificationCode vcode = verificationCodeService.createCode(type,custmerIp);
//	        String code = vcode.getCode();
//	        super.responseJson(MsgModel.buildDefaultSuccess(code), response);
	} 
	
	
	@RequestMapping(params="method=validateCode")  
	@ResponseBody
	public void validateCode(HttpServletRequest request,
	            HttpServletResponse response,String code,long type) throws IOException{	
//			MsgModel mm = verificationCodeService.validateCode(code, type);
//	        super.responseJson(mm, response);
	}


	public VerificationCodeService getVerificationCodeService() {
		return verificationCodeService;
	}


	public void setVerificationCodeService(
			VerificationCodeService verificationCodeService) {
		this.verificationCodeService = verificationCodeService;
	} 
	
	
	 
}
