package priv.guochun.psmc.website.backstage.questionnaire.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabRealUrl;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabRealUrlService;

@Controller
@RequestMapping("/ru")
public class RealUrlController extends MyController{

	@Autowired
	private TabRealUrlService tabRealUrlService;
	
	@RequestMapping(params="method=url")
	public void url(Integer id) throws IOException, ServletException{
		TabRealUrl tabRealUrl = tabRealUrlService.queryRealUrlById(id);
		if(tabRealUrl != null) {
			super.redirect(tabRealUrl.getRealUrl(),this.response());
		}
	}
}
