package sis_studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {
	
	public Date createDate (int year, int month, int date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.set (Calendar.YEAR, year);
		calendar.set (Calendar.MONTH, month);
		calendar.set (Calendar.DATE, date);
		
		return calendar.getTime ();
	}
	
	
}
