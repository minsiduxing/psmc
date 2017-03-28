package priv.guochun.psmc.system.framework.excel;

import java.io.File;
import java.util.List;



public interface CreateExcelDataFileInterface {
	
	/**
	 * 在系统缺省目录创建一个excel文件并写入数据
	 * @param fileName
	 * @param dataList
	 * @param dataColumns
	 * @param dataTitles
	 * @return
	 */

	public File getExcelFile(String fileName,List<?> dataList,String[] dataColumns,String[] dataTitles);
	
	
}
