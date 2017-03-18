package priv.guochun.psmc.system.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class TimestampUtil {

	
	public static Timestamp createTimestamp(String datestr,String format) throws ParseException{
		return new Timestamp(DateUtil.getDate(datestr,format).getTime());
	}
	
	
	public static Timestamp createTimestamp(Date date){
		return new Timestamp(date.getTime());
	}
	
	public static Timestamp createCurTimestamp(){
		return new Timestamp(new Date().getTime());
	}
	
}
