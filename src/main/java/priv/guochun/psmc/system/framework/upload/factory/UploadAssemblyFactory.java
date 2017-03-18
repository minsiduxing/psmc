package priv.guochun.psmc.system.framework.upload.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.service.impl.BaseUploadAssembly;

public class UploadAssemblyFactory
{
    public final static  Logger logger  = LoggerFactory.getLogger(UploadAssemblyFactory.class.getName());
    private final static UploadAssemblyFactory instance  = new UploadAssemblyFactory();
    
    private UploadAssemblyFactory(){}
    
    public UploadAssemblyInterface createUploadAssembly(){        
        logger.debug("create init UploadAssemblyInterface:BaseUploadAssembly");
        return new BaseUploadAssembly();
    }
    
    public static UploadAssemblyFactory getInstance(){
        return instance;
    }
    
}
