package priv.guochun.psmc.system.framework.excel;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Excelvalidate
{

	public Excelvalidate()
	{
	}

	public static boolean isNull(String value)
	{
		return value == null || value.equals("") || value.equals("null");
	}

	public static boolean startCheck(String reg, String string)
	{
		boolean tem = false;
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(string);
		tem = matcher.matches();
		return tem;
	}

	public static boolean checkNr(String nr)
	{
		String reg = "^\\d+$";
		return startCheck(reg, nr);
	}

	public static boolean checkNf(String nr)
	{
		String reg = "^\\d+(\\.\\d+)?$";
		return startCheck(reg, nr);
	}

	public static boolean checkNfCard(String nr)
	{
		String reg = "^\\d{17}(\\d|x)$";
		return startCheck(reg, nr);
	}

	public static void main(String nr[])
	{
		System.out.println(checkNfCard("61010319860712045x"));
	}
}
