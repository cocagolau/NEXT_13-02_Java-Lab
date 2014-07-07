package sis.test;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import sis_studentinfo.DateUtil;


public class DateUtilTest extends TestCase {
	public void testCreateDate () {
		Date date = new DateUtil().createDate(2013, 6,17);
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		assertEquals (2013, cal.get(Calendar.YEAR));
		assertEquals (Calendar.JULY, cal.get(Calendar.MONTH));
		assertEquals (17, cal.get(Calendar.DAY_OF_MONTH));
	}
}
