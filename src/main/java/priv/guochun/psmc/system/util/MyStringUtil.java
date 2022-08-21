package priv.guochun.psmc.system.util;

import org.apache.commons.lang.StringUtils;

public class MyStringUtil {

	//逗号
	public final static String stringFormat_comma =",";

	//分号
	public final static String stringFormat_semicolon =";";



	/**
	 * 将一个,号分隔的字符串转换为('value')格式的字符串
	 * @param ids
	 * @return
	 */
	
	public static String StringFormatMethod(String ids){
		if(StringUtils.isBlank(ids))
			return null;
		StringBuffer newId = new StringBuffer();
		String[] strs = ids.split(stringFormat_comma);
		int strsLength = strs.length;
		newId.append("(");
		 for(int i=0;i<strsLength;i++){
			 newId.append("'"+strs[i]+"'");
			 if(i<strsLength-1){
				 newId.append(",");
			 }
		 }
		 newId.append(")");
		 return newId.toString();
		
	}
	
	public static void main(String[] args){
		System.out.println(MyStringUtil.StringFormatMethod("11,22,33,440"));
	}
}
