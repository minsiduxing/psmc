package priv.guochun.psmc.system.framework.upload.base;


import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface PsmcBaseFileProcessService {

    /**
     * 一次性上传多个文件，返回多个UploadFileModel结果
     * @param request
     * @return
     * @throws IOException
     */
    public List<UploadFileModel> uploadFiles(HttpServletRequest request) throws IOException;

    /**
     * 上传一个文件
     * @param request
     * @return
     * @throws IOException
     */
    public UploadFileModel uploadFile(HttpServletRequest request) throws IOException;
}
