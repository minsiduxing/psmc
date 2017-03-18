package priv.guochun.psmc.system.framework.excel;

import java.io.File;
import java.io.IOException;

// Referenced classes of package com.linkage.sxyd.excel:
//			ExcelUtil

public class ExcelUtilFactory
{

	public ExcelUtilFactory()
	{
	}

	public static ExcelUtil createExcelUtil(String fileAllPath) throws IOException
	{
//		if(file !=null && !file.exists())
//			file.createNewFile();
		ExcelUtil excelUtil = new ExcelUtil(fileAllPath);
		return excelUtil;
	}
	
	public static ExcelUtil createExcelUtil(File file) throws IOException
	{
//		if(file !=null && !file.exists())
//			file.createNewFile();
		ExcelUtil excelUtil = new ExcelUtil(file);
		return excelUtil;
	}
}
