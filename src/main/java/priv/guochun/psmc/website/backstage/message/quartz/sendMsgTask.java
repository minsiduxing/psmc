package priv.guochun.psmc.website.backstage.message.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import priv.guochun.psmc.website.backstage.message.service.TabMessagePoolService;

@Component
public class sendMsgTask {
	
	@Autowired
	private TabMessagePoolService tabMessagePoolService;
	
	//@Scheduled(cron = "0 48 * * * ? ") // 
    public void taskCycle() {
        tabMessagePoolService.sendMsg();
    }
}
