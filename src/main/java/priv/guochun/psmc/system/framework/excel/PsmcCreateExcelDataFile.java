package priv.guochun.psmc.system.framework.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.util.SystemPropertiesUtil;

public class PsmcCreateExcelDataFile implements CreateExcelDataFileInterface {

	
	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcCreateExcelDataFile.class);

	@Override
	public File getExcelFile(String fileName, List<?> dataList,
			String[] dataColumns, String[] dataTitles) {
		String fileUrl = SystemPropertiesUtil.getDownloadTempPathPropertyValue()+new Date().getTime()+fileName;
		
		logger.debug("create excel temp file path :"+fileUrl);
		
		WritableWorkbook wwb;
        FileOutputStream fos;
        
		File file = new File(fileUrl);

		try {
				fos = new FileOutputStream(file);
	            wwb = Workbook.createWorkbook(fos);
	            
				Iterator<?> it = dataList.iterator();
				
				int rows = 0;
				
				int k=0;
				
				int dataLength = Integer.parseInt(SystemPropertiesUtil.getPropertyValue("excel_export_length"));
				
				WritableSheet ws = null;
				
				WritableFont font1= new 
				WritableFont(WritableFont.TIMES,9,WritableFont.BOLD); 

				WritableCellFormat titleCellFormat = new WritableCellFormat(font1);
				//设置文字居中对齐方式;  
				titleCellFormat.setAlignment(Alignment.CENTRE);  
				//设置自动换行;  
				titleCellFormat.setWrap(true);  
				
				WritableCellFormat cellFormat = new WritableCellFormat(font1);
				//设置文字居中对齐方式;  
				cellFormat.setAlignment(Alignment.CENTRE);  
				//设置自动换行;  
				cellFormat.setWrap(true);  
				//jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##");
				
				
				Date fileWriteStartDate = new Date();
				
				
				
				while(it.hasNext()){
					Map<?,?> map = (Map<?,?>)it.next();
					int avglength = rows / dataLength;
					if( avglength == k ){
					    ws =wwb.createSheet("sheet"+k, k);
					   
					    logger.debug("每一个新的sheet页都要创建文件标题.....");
	                    for(int i=0;i<dataTitles.length;i++) {
	                        Label label = new Label(i,0,dataTitles[i]); 
	                        label.setCellFormat(titleCellFormat);
	                        ws.addCell(label);
	                    }
	                    k++;
	                    rows = 1; //初始化行数  每一个新建的sheet页的行数索引从1开始，因为第一行是标题
					}
					
					// 输出数据
					for (int j = 0; j < dataColumns.length; j++)
					{
					    Label label = new Label(j,rows, getContentByKey(map,dataColumns[j].toString()));  
					    
					    ws.addCell(label);
					}
					rows++;
				}
				if(ws != null)
				{
					wwb.write();
		            wwb.close();
				}
	            
	
				Date fileWriteEndDate = new Date();
				
				long second = (fileWriteStartDate.getTime() - fileWriteEndDate.getTime());
				float millSec = second/1000;
				float min = millSec/60;
				
				logger.debug("文件创建完毕，共花费"+second+"毫秒"+","+millSec+"秒,"+min+"分钟.");
			
		} catch (IOException e) {
			e.printStackTrace();
			logger.warn("excel file wirte error...."+fileUrl);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return file;
	}
	
	
	public String getContentByKey(Map map ,String key){
	    String result="";
	    if(map.containsKey(key)){
	        result = map.get(key)!=null?map.get(key).toString():"";
	    }
	    return result;
	}

}
