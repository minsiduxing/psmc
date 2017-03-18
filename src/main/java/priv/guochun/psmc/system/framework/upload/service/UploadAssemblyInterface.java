package priv.guochun.psmc.system.framework.upload.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;


public interface UploadAssemblyInterface {
    
    public   List<UploadFileModel> getFiles(HttpServletRequest request) throws IllegalStateException, IOException;
    
    public   UploadFileModel getFile(HttpServletRequest request) throws IllegalStateException, IOException;
    
}
