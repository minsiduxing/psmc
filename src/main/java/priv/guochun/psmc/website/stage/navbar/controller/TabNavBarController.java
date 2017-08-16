package priv.guochun.psmc.website.stage.navbar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import priv.guochun.psmc.system.framework.controller.MyController;
@Scope("prototype")
@Controller
@RequestMapping("/website/stage/navBarController")
public class TabNavBarController extends MyController {
	protected static final Logger logger = LoggerFactory.getLogger(TabNavBarController.class);
}
