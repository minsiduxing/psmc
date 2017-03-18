package priv.guochun.psmc.system.framework.myspringview;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class DownloadByFileView implements View {

	
	private File dfile;
	private String filename;
    
    public DownloadByFileView(File dfile,String exportFileName) {
        this.dfile = dfile;
        this.filename = exportFileName;
    }


	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest arg1,
			HttpServletResponse response) throws Exception {
		
        // 避免下载时文件名乱码
		filename = URLEncoder.encode(filename, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        response.setContentType(getContentType());
        response.setContentLength((int) dfile.length());
        // 得到输入流
        FileInputStream in = new FileInputStream(dfile);
        BufferedInputStream bufIn = new BufferedInputStream(in);
        ServletOutputStream out = response.getOutputStream();
        // 下面是一个普通的流的复制 。。。忽略 .这样可以防止内存问题
        byte[] bs = new byte[1024];
        int len = 0;
        while ((len = bufIn.read(bs)) != -1) {
            out.write(bs);
        }
        bufIn.close();
        in.close();
        // 最后是流的关闭。
        out.flush();
        out.close();
    }
	

	@Override
	public String getContentType() {
		String ContentType;
	    String str = filename.substring(filename.indexOf("."),filename.length());
	    if(".asf".equals(str)){
	    	 ContentType = "video/x-ms-asf ";
	    }else if(".avi".equals(str)){
	    	ContentType = "video/avi ";
	    }else if(".avi".equals(str)){
	    	ContentType = "video/avi ";
	    }else if(".doc".equals(str)){
	    	ContentType = "application/msword ";
	    }else if(".zip".equals(str)){
	    	ContentType = "application/zip ";
	    }else if(".xls".equals(str)){
	    	ContentType = "application/vnd.ms-excel ";
	    }else if(".gif".equals(str)){
	    	ContentType = "image/gif ";
	    }else if(".jpg".equals(str)){
	    	ContentType = "image/jpeg ";
	    }else if(".xls".equals(str)){
	    	ContentType = "application/vnd.ms-excel ";
	    }else if(".xls".equals(str)){
	    	ContentType = "application/vnd.ms-excel ";
	    }else if(".xls".equals(str)){
	    	ContentType = "application/vnd.ms-excel ";
	    }else
	    	ContentType = "application/octet-stream ";
	    
	    return ContentType;
	}

}
