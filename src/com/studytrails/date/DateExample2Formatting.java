package com.studytrails.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

public class DateExample2Formatting {

	@Test
	public void getDateFormatInstance() {
		// create a date object for testing
		Date date = new Date();
		// create a date instance using default style
		DateFormat format = DateFormat.getDateInstance();
		System.out.println(format.format(date)); // 29 Jul, 2013

		// create a dateinstance using short style
		format = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println(format.format(date));// 29/7/13

		// create a dateinstance using medium style (Default)
		format = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(format.format(date));// 29 Jul, 2013

		// create a dateinstance using full style (Default)
		format = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(format.format(date));// Monday, 29 July, 2013

		// create a dateinstance using long style (Default)
		format = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println(format.format(date));// 29 July, 2013

		// create time instance - default
		format = DateFormat.getTimeInstance();
		System.out.println(format.format(date));// 8:24:59 PM

		// create time instance - short
		format = DateFormat.getTimeInstance(DateFormat.SHORT);
		System.out.println(format.format(date));// 8:26 PM

		// create time instance - medium
		format = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		System.out.println(format.format(date));// 8:26:21 PM

		// create time instance - full
		format = DateFormat.getTimeInstance(DateFormat.FULL);
		System.out.println(format.format(date));// 8:26:21 PM IST

		// create time instance - long
		format = DateFormat.getTimeInstance(DateFormat.LONG);
		System.out.println(format.format(date));// 8:26:21 PM IST

		// create date time instance - default.
		format = DateFormat.getDateTimeInstance();
		System.out.println(format.format(date));// 29 Jul, 2013 8:27:22 PM

		// create date time instance - specify format and locale.
		format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.GERMAN);
		System.out.println(format.format(date));// Montag, 29. Juli 2013 20:57
												// Uhr IST

		// print a date in different timezone
		format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println(format.format(date));// Monday, 29 July, 2013 3:29:45
												// PM UTC

		try {
			// parsing date yyyy-MM-dd HH:mm:ss
			SimpleDateFormat simpleFormat = (SimpleDateFormat) DateFormat.getDateInstance();
			simpleFormat.applyPattern("yyyy-MM-dd HH:mm:ss");

			// parse date 2013-04-12 10:02:12
			date = simpleFormat.parse("2013-04-12 10:02:12");
			System.out.println(date); // Fri Apr 12 10:02:12 IST 2013

			// parsing "1 April 2013 at 10:00 AM EST"
			simpleFormat.applyPattern("dd MMMMM yyyy 'at' HH:mm a z");
			date = simpleFormat.parse("1 April 2013 at 10:00 AM EST");
			System.out.println(date);// Mon Apr 01 20:30:00 IST 2013
			System.out.println(simpleFormat.getTimeZone().getID());// America/New_York

			// parsing 1-Apr-13 23:22:00+500
			simpleFormat.applyPattern("dd-MMM-yy HH:mm:ssZ");
			date = simpleFormat.parse("1-Apr-13 23:22:00+0500");

			format.setTimeZone(simpleFormat.getTimeZone());
			System.out.println(format.format(date));// Monday, 1 April, 2013
													// 2:22:00 PM EDT

			// parse 2013-07-29T18:00:00-04:00 ISO 8601 format
			simpleFormat.applyPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
			date = simpleFormat.parse("2013-07-29T18:00:00-04:00");
			
			format.setTimeZone(simpleFormat.getTimeZone());
			System.out.println(format.format(date));//Monday, 29 July, 2013 6:00:00 PM EDT

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
