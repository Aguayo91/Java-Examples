package com.studytrails.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DateExample1 {

	public void createDateAndPrintIt() {
		// create and prints the current date. It prints the data in the local
		// timezone
		System.out.println(new java.util.Date());
		// prints Sun Jul 28 20:09:36 IST 2013
		// get the number of milli seconds since epock
		System.out.println(new java.util.Date().getTime());
		// prints 1375022617792
	}

	public void createCalendarAndPrintIt() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		// java.util.GregorianCalendar[time=1375025205859,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
		// zone=sun.util.calendar.ZoneInfo[id="Asia/Calcutta",offset=19800000,dstSavings=0,useDaylight=false,transitions=6,lastRule=null],
		// firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2013,MONTH=6,WEEK_OF_YEAR=31,WEEK_OF_MONTH=5,DAY_OF_MONTH=28,
		// DAY_OF_YEAR=209,DAY_OF_WEEK=1,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=8,HOUR_OF_DAY=20,MINUTE=56,SECOND=45,MILLISECOND=859,ZONE_OFFSET=19800000,DST_OFFSET=0]
		System.out.println(cal.getTime());
		// prints Sun Jul 28 20:56:45 IST 2013
	}

	@Test
	public void manipulateCalendar() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());// Sun Jul 28 21:53:55 IST 2013
		// add a day
		cal.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(cal.getTime());// Mon Jul 29 21:53:55 IST 2013
		cal.add(Calendar.DAY_OF_WEEK, 1);
		System.out.println(cal.getTime());// Tue Jul 30 21:53:55 IST 2013
		cal.add(Calendar.HOUR, 1);
		System.out.println(cal.getTime());// Tue Jul 30 22:53:55 IST 2013
		cal.add(Calendar.HOUR_OF_DAY, 1);
		System.out.println(cal.getTime());// Tue Jul 30 23:53:55 IST 2013
		cal.add(Calendar.MINUTE, 100);
		System.out.println(cal.getTime());// Wed Jul 31 01:33:55 IST 2013
		// demonstrate leniency
		cal.add(Calendar.DAY_OF_MONTH, 32);
		System.out.println(cal.getTime());// Sun Sep 01 01:33:55 IST 2013
		
	}
	
	public void formatDateInMysqlFormat(){
		SimpleDateFormat format = new SimpleDateFormat("");
	}
}
