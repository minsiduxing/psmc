package priv.guochun.psmc.system.framework.page.converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期转换程序
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2016</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2016-7-26
 */
public class DateConverter implements Converter<String, Date> {    
        @Override    
        public Date convert(String source) {    
            if(StringUtils.isBlank(source))
                return null;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);    
            try {    
                return dateFormat.parse(source);    
            } catch (ParseException e) {    
            	dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	dateFormat.setLenient(false);
            	try {
					return dateFormat.parse(source);
				} catch (ParseException e1) {
					dateFormat = new SimpleDateFormat("yyyy-MM");
	            	dateFormat.setLenient(false);
	            	try {
						return dateFormat.parse(source);
					} catch (ParseException e2) {
						e2.printStackTrace();
					}
				}
            }           
            return null;    
        }

        
}