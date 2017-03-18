package priv.guochun.psmc.system.framework.excel;


// Referenced classes of package com.linkage.sxyd.excel:
//			ExcelUtil

public class CreateExcelDataFileFactory
{

	public CreateExcelDataFileFactory()
	{
	}

	public static CreateExcelDataFileInterface CreateExcelDataFileClass()
	{
		return new PsmcCreateExcelDataFile();
	}
}
