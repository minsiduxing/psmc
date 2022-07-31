package priv.guochun.psmc.system.framework.upload.base;


import org.springframework.web.multipart.MultipartRequest;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public interface PsmcBaseFileProcessService {

    /**
     * 一次性上传多个文件，返回多个UploadFileModel结果
     * @param iter
     * @param multipartRequest
     * @return
     * @throws IOException
     */
    public List<UploadFileModel> uploadFiles(Iterator<String> iter, MultipartRequest multipartRequest) throws IOException;

    /**
     * 上传一个文件
     * @param iter
     * @param multipartRequest
     * @return
     * @throws IOException
     */
    public UploadFileModel uploadFile(Iterator<String> iter, MultipartRequest multipartRequest) throws IOException;
}
