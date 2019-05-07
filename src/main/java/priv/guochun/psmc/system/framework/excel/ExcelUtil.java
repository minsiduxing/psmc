package priv.guochun.psmc.system.framework.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.commons.lang.StringUtils;

public class ExcelUtil
{
	private String fileAllPath;
	private File file;
	private Workbook wb;
	private Sheet st;
	private InputStream is;
	private WritableWorkbook writeWb;

	public ExcelUtil(String fileAllPath)
	{
		this.fileAllPath = fileAllPath;
	}
	
	public ExcelUtil(File file)
	{
		this.file = file;
	}
	
	
	public Workbook getWorkbook()
		throws BiffException, IOException
	{
		
		if(wb!=null)
			return wb;
		
		if(file == null){
			file = new File(fileAllPath);
			if(!file.exists())
			file.createNewFile();
			
		}
		//is = new FileInputStream(file);
		wb = Workbook.getWorkbook(file);
		return wb;
	}
	
	public WritableWorkbook getWritableWorkbook()
	throws BiffException, IOException
	{
		if(writeWb!=null)
			return writeWb;
		
		if(wb == null){
			getWorkbook();
		}
		return writeWb = wb.createWorkbook(file);
	}
	
	
	public WritableSheet getWritableSheet(String arg0,int arg1)
	throws BiffException, IOException
	{
		if(writeWb == null){
			getWritableWorkbook();
		}
		return writeWb.createSheet(arg0, arg1);
		

	}
	

	public String getVersion()
	throws BiffException, IOException
	{
		if (wb == null)
			getWorkbook();
		return wb.getVersion();
	}

	public Sheet getSheet(int index)
		throws BiffException, IOException
	{
		if (wb == null)
			getWorkbook();
		st = wb.getSheet(index);
		return st;
	}

	public void close()
		throws IOException
	{
		
		if (writeWb != null){
			try {
				writeWb.close();
			} catch (WriteException e) {
				e.printStackTrace();
			}
			writeWb = null;
		}
	
		
		if (is != null){
			is.close();
			is = null;
		}
			
		if (wb != null){
			wb.close();
			wb = null;
		}
			
	}

	public String getCellValue(int i, int j)
	{
		Cell cell = st.getCell(i, j);
		String content = cell.getContents();
		if(!StringUtils.isBlank(content))
			return content;
		else
			return "";
	}
	
	//读取Excel内容
	public List<String[]> readExcel() {
		try {
			this.getWorkbook();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<String[]> list = new ArrayList<String[]>();
        for(int k=0; k<wb.getNumberOfSheets(); k++){
        	//获取sheet页
            Sheet sheet = wb.getSheet(k);
            //获得指定Sheet含有的行数
            int num = sheet.getRows();
            //循环读取数据
            for(int i=0;i<num;i++) {
                //得到第i行的数据..返回cell数组
                Cell[] cell = sheet.getRow(i);
                //装载读取数据的集合
                String[] results = new String[cell.length];
                for(int j = 0; j < cell.length; j++) {
                    results[j] = cell[j].getContents();
                }
                list.add(results);
            }
        }
        
        return list;
	}
	
	public static void main(String[] args) {
		ExcelUtil util = new ExcelUtil("C:\\Users\\Administrator\\Desktop\\消费信息.xls");
		try {
			System.out.println(util.getVersion());
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 List<String[]> listStr = util.readExcel();
		 if(listStr != null && !listStr.isEmpty()) {
            for(String[] strs : listStr) {
            	System.out.println(strs[0]+" "+strs[6]);
                
            }
        }
	}


	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public InputStream getIs()
	{
		return is;
	}

	public void setIs(InputStream is)
	{
		this.is = is;
	}

	public void setSt(Sheet st)
	{
		this.st = st;
	}

	public void setWb(Workbook wb)
	{
		this.wb = wb;
	}
}
