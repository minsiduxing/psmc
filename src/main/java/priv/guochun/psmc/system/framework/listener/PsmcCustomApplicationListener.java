package priv.guochun.psmc.system.framework.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import priv.guochun.psmc.system.framework.cxf.china.base.PsmcInterfaceServiceProcessChina;

public class PsmcCustomApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PsmcInterfaceServiceProcessChina psmcFirstValiateProcessChina;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //spring初始化完成调用（会调用两次，还有一次是mvc） 初始化psmc cxf的接口权限（从表获取）
        psmcFirstValiateProcessChina.initCxfallowedUri();
    }
}
