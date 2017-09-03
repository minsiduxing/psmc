package priv.guochun.psmc.system.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	// DATE，日期 DATE_TIME，时间
    
    public final static String dateFormat_contants = "yyyy-MM-dd";
    public final static String dateFormat2_contants = "yyy/MM/dd";
    public final static String dateFormat3_contants = "yyyy-MM-dd HH:mm:ss";
    public final static String dateFormat4_contants = "yyyy年MM月dd日";
    public final static String monthFormat_contants = "yyyy-MM";
    
    public final static String oracle_dateFormat_contants = "yyyy-MM-dd hh24:mi:ss";
    
    
	public final static SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormat_contants);
	public final static SimpleDateFormat otherFormat = new SimpleDateFormat(dateFormat2_contants);
	public final static SimpleDateFormat timeFormat = new SimpleDateFormat(dateFormat3_contants);
	public final static SimpleDateFormat chineseFormat = new SimpleDateFormat(dateFormat4_contants);

	
	
	public static String getDateString(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static String getDateString(Date date) {
		if (date == null) {
			return null;
		}
		String time = dateFormat.format(date);
		return time;
	}
	
	public static String getDateString(Timestamp time) {
		if (time == null) {
			return null;
		}
		Date date = new Date(time.getTime());
		return dateFormat.format(date);
	}



	
	public static Date getDate(String dateStr,String format) throws ParseException {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		Date time = null;
		SimpleDateFormat dd = new SimpleDateFormat(format);
		try {
			time = dd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}
		return time;
	}
	

	
	public static long getCurrentDateTime() {
	    return System.currentTimeMillis() ;
	}

	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * <p>
	 * Description: 获取指定日期N年以后的日期
	 * <p>
	 * 
	 * @param date
	 *            日期
	 * @param yeas
	 *            多少年以后
	 * @return 日期字符串
	 * @author hanlin 2014-10-16
	 */
	public static String getDateByAfterYear(Date date, int yeas) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + yeas);
		return getDateString(calendar.getTime());
	}
	
	public static Date getDateByAfterMonth(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
		return calendar.getTime();
	}

	public static Date getDateByLastMonth(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - month);
		return calendar.getTime();
	}
	
	
	
	
	/**
	 * <p>
	 * Description: 获取指定日期N天以后的日期
	 * <p>
	 * 
	 * @param date
	 *            日期
	 * @param days
	 *            多少天以后
	 * @return 日期
	 * @author hanlin 2014-10-31
	 */
	public static java.sql.Date getDateByAfterDays(Date date, BigDecimal days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days.intValue());
		return new java.sql.Date(calendar.getTime().getTime());
	}

	
	public static void main(String []args){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.get(calendar.YEAR));
		System.out.println(calendar.get(calendar.MONTH));
		date = getDateByLastMonth(date,1);
		calendar.setTime(date);
		System.out.println(calendar.get(calendar.YEAR));
		System.out.println(calendar.get(calendar.MONTH));
	}

	/**
	 * <p>Description:获取当前年份<p>
	 * @return
	 * @author wanglei 2017年8月22日
	 */
	public static String getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		String year = cal.get(Calendar.YEAR) + "";
		return year;
	}

	/**
	 * <p>Description:获取当年月份<p>
	 * @param flagZero
	 * @return
	 * @author wanglei 2017年8月22日
	 */
	public static String getCurrentMonth(boolean flagZero) {
		Calendar cal = Calendar.getInstance();
		int m = cal.get(Calendar.MONTH) + 1;
		String month = m + "";
		if (flagZero && m < 10) {
			month = "0" + month;
		}
		return month;
	}

	/**
	 * <p>Description:获取当前天<p>
	 * @param flagZero
	 * @return
	 * @author wanglei 2017年8月22日
	 */
	public static String getCurrentDay(boolean flagZero) {
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DAY_OF_MONTH);
		String day = d + "";
		if (flagZero && d < 10) {
			day = "0" + day;
		}
		return day;
	}
	/**
	 * <p>Description:获取当前时间戳<p>
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public static Timestamp getCurrentTimstamp(){
		return new Timestamp(System.currentTimeMillis());
	}
}
