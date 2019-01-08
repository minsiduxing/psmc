package priv.guochun.psmc.website.backstage.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.upload.factory.MyCommonsMultipartResolverFactory;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;

@Controller
@RequestMapping("/website/backstage/uploadImageController")
public class UploadImageController extends MyController{

	/**
	 * 打开图片上传界面
	 * @return
	 */
	@RequestMapping(params="method=toImageUplodDialog")
	public String toImageUplodDialog(){
		return "backstage/uploadImage/uploadImage";
	}
	
	@RequestMapping(params="method=uploadPhoto")
	@ResponseBody
	public void uploadPhoto() throws Exception {
        
        String x = this.request().getParameter("x");
        String y = this.request().getParameter("y");
        String h = this.request().getParameter("h");
        String w = this.request().getParameter("w");
        // 页面实际图片宽高
        String pheight = this.request().getParameter("boundx");
        String pweight = this.request().getParameter("boundy");

        // 切图参数
        int imageX = Integer.parseInt(x);
        int imageY = Integer.parseInt(y);
        int imageH = Integer.parseInt(h);
        int imageW = Integer.parseInt(w);
        int srcH = Integer.parseInt(pheight);
        int srcW = Integer.parseInt(pweight);
        MultipartFile imageFile = null;
        CommonsMultipartResolver multipartResolver =MyCommonsMultipartResolverFactory.getInstance().createCommonsMultipartResolver(this.request());
        //判断 request 是否有文件上传
	      if(multipartResolver.isMultipart(this.request())){  
	          //转换成多部分request    
	          MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)this.request();  
	          
	          //取得request中的所有文件名  
	          Iterator<String> iter = multiRequest.getFileNames();  
	          while(iter.hasNext()){
	              //取得上传文件  
	              imageFile = multiRequest.getFile(iter.next()); 
	          }
	      }
        String realPath = this.request().getSession().getServletContext().getRealPath("/");
        String resourcePath = "upload/";
        String fileName = getFileName(imageFile); 
        String tempFilePath = realPath + resourcePath + fileName;
        File tempFile = new File(tempFilePath);  
	    if (!tempFile.getParentFile().exists()) {  
	      tempFile.getParentFile().mkdir();  
	    }  
	    if (!tempFile.exists()) {  
	      tempFile.createNewFile();  
	    }  
	    //图片写到指定的临时位置
	    imageFile.transferTo(tempFile);
	    //裁剪图片并覆盖上传的原图
		String cutImagePath = this.imgCut(tempFilePath, tempFilePath, imageX, imageY, imageH, imageW, srcH, srcW);
		//将裁剪后的图片上传服务器，并删除临时图片
		String filePath = this.uploadCutImage(new File(cutImagePath));
	    super.responseJson(true,filePath, this.response());
    }
	
	/**
	 * 裁剪图片，覆盖原图
	 * @param srcImageFile
	 * @param result
	 * @param x
	 * @param y
	 * @param desWidth
	 * @param desHeight
	 * @param srcWidth
	 * @param srcHeight
	 * @return
	 */
	public String imgCut(String srcImageFile, String result, int x, int y, int desWidth, int desHeight, int srcWidth,
            int srcHeight) {
        try {
            Image img;
            ImageFilter cropFilter;
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            
            if (srcWidth >= desWidth && srcHeight >= desHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(desWidth, desHeight, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                
                ImageIO.write(tag, "JPG", new File(result));
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 上传裁剪后的图片到服务器
	 * @param imageFile
	 * @return
	 */
	public String uploadCutImage(File imageFile){
		UploadFileModel model = new UploadFileModel();
		String filepath = null;
		try {
			if(imageFile != null){
				String name = imageFile.getName();
				 String filename = name.substring(0,name.indexOf("."));
			     String suffix = name.substring(name.indexOf(".")+1,name.length());
			     model.setFileRealName(filename);
			     model.setSuffix(suffix);
			     model.setFile(imageFile);
			     String fileSystemName = filename;
			     model.setFileSystemName(fileSystemName);
			     String customFilePath = SystemPropertiesUtil.getCustomImagePath() + fileSystemName + "." + suffix;
			     String fileTempAllPath = SystemPropertiesUtil.getUploadTempPathPropertyValue() +fileSystemName+"."+suffix; 
			     String fileRealAllPath = SystemPropertiesUtil.getUploadPathPropertyValue()+customFilePath;
			     model.setFile_upload_real_path(fileRealAllPath);
			     model.setTemp_file_path(fileTempAllPath);
			     model.setCustom_file_path(customFilePath);
			}
			FtpUtil ftu = FtpUtil.getFtputil();
			filepath = ftu.uploadFile(model);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//图片上传后，删除临时文件
			imageFile.delete();
		}
        return filepath;
	}
	  //获得图片名字 
	  public String getFileName(MultipartFile file){ 
	   
	    String fileName = file.getOriginalFilename();  
	    String[] suffixNameArr = fileName.split("\\."); 
	    String suffixName = suffixNameArr[suffixNameArr.length-1]; 
	    return getTime() + "_" + System.currentTimeMillis() + "."+suffixName; 
	  } 
	    
	  public String getTime(){ 
	    Date date = new Date(); 
	    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式 
	    String nowTime = df.format(date).toString(); 
	    return nowTime; 
	  } 


}
    