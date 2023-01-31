package priv.guochun.psmc.system.util;

import org.apache.commons.lang.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	private static final Pattern pattern = Pattern.compile("\\{(.*?)\\}");
	private static Matcher matcher;

	public static String stringFormat(String sourStr, Map<String, Object> param) {
		String targetStr = sourStr;
		if (param == null)
			return targetStr;
		try {
			matcher = pattern.matcher(targetStr);
			while (matcher.find()) {
				String key = matcher.group();
				String keyclone = key.substring(1, key.length() - 1).trim();
				Object value = param.get(keyclone);
				if (value != null)
					targetStr = targetStr.replace(key, value.toString());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return targetStr;
	}

	public static List<String> getKey(String targetStr) {
		List<String> list  = new ArrayList<>();
		try {
			matcher = pattern.matcher(targetStr);
			while (matcher.find()) {
				String key = matcher.group();
				String keyclone = key.substring(1, key.length() - 1).trim();
				list.add(keyclone);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public static String stringFormat(String sourStr, Object obj) {
		String targetStr = sourStr;
		matcher = pattern.matcher(targetStr);
		if (obj == null)
			return targetStr;

		PropertyDescriptor pd;
		Method getMethod;
		// 匹配{}中间的内容 包括括号
		while (matcher.find()) {
			String key = matcher.group();
			String keyClone = key.substring(1, key.length() - 1).trim();
			try {
				pd = new PropertyDescriptor(keyClone, obj.getClass());
				getMethod = pd.getReadMethod();// 获得get方法
				Object value = getMethod.invoke(obj);
				if (value != null)
					targetStr = targetStr.replace(key, value.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return targetStr;
	}


	public static void main(String[] args){
		Map pam = new HashMap();
		pam.put("11","郭纯");
		System.out.println(MyStringUtil.stringFormat("我{gc}要测试",pam));
	}
}
