package priv.guochun.psmc.website.backstage.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 短信模板处理工具类
 * @author Administrator
 *
 */
public class MsgTemplateUtil {

	/**
	 * 动态替换模板内容
	 * @param templateContent 模板内容
	 * @param contentParamMap 替换参数
	 * @return
	 */
	public static String handleTemplate(String templateContent, Map<String, Object> contentParamMap){
		Scanner sc = new Scanner(templateContent);
        StringBuffer buf = new StringBuffer();
        try{
            Pattern p = Pattern.compile("[$]([^$]*?)[$]");
            while (sc.hasNext()) {
                System.out.println(sc.toString());
                Matcher m = p.matcher(sc.nextLine());
                while (m.find()) { //查找并替换参数
                    //从map中根据key获取值
                    m.appendReplacement(buf, contentParamMap.get(m.group(1)) != null ? contentParamMap.get(m.group(1)).toString() : "");
                }
                m.appendTail(buf);
            }
        }catch(Exception e){
        	
        }finally{
            sc.close();
        }
		return buf.toString();
	}
	
	public static void main(String[] args) {
		Map<String, Object> contentParamMap = new HashMap<String, Object>();
		contentParamMap.put("evaluateName", "张三");
		contentParamMap.put("consumptionDate", "2019-05-01");
		contentParamMap.put("consumptionAmount", 567.85);
		contentParamMap.put("surplusAmount", 1099.97);
		contentParamMap.put("surplusScore", 3675);
		String templateContent = "【四季花城】尊敬的$evaluateName$，您$consumptionDate$的消费金额为$consumptionAmount$元，剩余金额$surplusAmount$元，剩余积分$surplusScore$分。为提升品牌服务，诚邀您参与满意度测评，点击$visitShortUrl$ 可对本次体验作出评价，期待您的宝贵建议！";
		String str = handleTemplate(templateContent, contentParamMap);
		System.out.println(str);
	}
}
