package priv.guochun.psmc.system.framework.upload.service.impl.;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import priv.guochun.psmc.system.framework.upload.base.PsmcBaseFileProcessService;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.util.FastdfsUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PsmcFastdfstProcessServiceImpl implements PsmcBaseFileProcessService {

    @Override
    public List<UploadFileModel> uploadFiles(Iterator<String> iter, MultipartRequest multipartRequest) throws IOException {
        List<UploadFileModel> files = new ArrayList<UploadFileModel>();
        while(iter.hasNext()){
            UploadFileModel model = new UploadFileModel();
            //取得上传文件
            MultipartFile file = multipartRequest.getFile(iter.next());
            //取得当前上传文件的文件名称
            String myFileName = file.getOriginalFilename();
            if(myFileName.trim() !="" &&myFileName.indexOf(".") != -1){
                String filename = myFileName.substring(0,myFileName.indexOf("."));
                String suffix = myFileName.substring(myFileName.indexOf(".")+1,myFileName.length());
                model.setFileRealName(filename);
                model.setSuffix(suffix);
            }
            byte[] fileB = file.getBytes();
            String [] result = FastdfsUtils.uploadFile(fileB,myFileName,fileB.length);
            model.setFile_upload_real_path(result[0]);
            files.add(model);
        }
        return files.size()>0?files:null;
    }

    public UploadFileModel uploadFile(Iterator<String> iter, MultipartRequest multipartRequest) throws IOException{
        List<UploadFileModel> uploadFiles = uploadFiles(iter,multipartRequest);
        return  uploadFiles !=null?uploadFiles.get(0):null;
    }
}
