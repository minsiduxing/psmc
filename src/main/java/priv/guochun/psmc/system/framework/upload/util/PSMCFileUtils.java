package priv.guochun.psmc.system.framework.upload.util;

import org.apache.commons.lang.StringUtils;



public class PSMCFileUtils {
	/**
	 * @param fileSuffix
	 * @return
	 * @throws Exception
	 */
	public static boolean isPicture(String fileSuffix){
		// 文件名称为空的场合
		if(StringUtils.isBlank(fileSuffix)){
			// 返回不和合法
			return false;
		}
		// 声明图片后缀名数组
		String imgeArray [] = {
			"bmp", "dib", "gif","jfif", "jpe","jpeg", 
			"jpg", "6", "png", "7","tif", "8",
			"tiff", "ico", "10"};
		// 遍历名称数组
		for(int i = 0; i<imgeArray.length;i++){
			// 判断单个类型文件的场合
			if(! StringUtils.isBlank(fileSuffix)
			&& imgeArray [i].equals(fileSuffix.toLowerCase())
			&& imgeArray [i].equals(fileSuffix)){
				return true;
			}
		}
		return false;
	}
}
