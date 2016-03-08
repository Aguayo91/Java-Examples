package com.studytrails.java8.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.JulianFields;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public class TimeBasics {

	public static void main(String[] args) {
		Instant now = Instant.now();
		// System.out.println(now);
		// prints the current time. note that the time is in UTC since no
		// timezone info is stored
		// long epoch = now.getEpochSecond();
		// System.out.println(now.getEpochSecond());
		// prints 1411110040. The number of seconds since java epoch
		// (1970-01-01T00:00:00Z)

		// Instant tomorrow = now.plus(1,ChronoUnit.DAYS);
		// System.out.println(tomorrow);

		Instant yesterday = now.minus(1, ChronoUnit.HALF_DAYS);
		// System.out.println(yesterday);

		// System.out.println(now.compareTo(tomorrow));

		// System.out.println(now.isAfter(yesterday));

		LocalDateTime localDateTime = LocalDateTime.now();
		// System.out.println(localDateTime);

		// System.out.println(localDateTime.atZone(ZoneId.of("America/New_York")).getClass());

		// System.out.println(DayOfWeek.from(localDateTime));

		// System.out.println(localDateTime.get(ChronoField.DAY_OF_YEAR));

		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		// System.out.println(zonedDateTime.until(ZonedDateTime.parse("2014-09-29T22:41:00-10:00"),
		// ChronoUnit.HOURS));
		System.out.println(zonedDateTime);
		System.out.println(zonedDateTime.toInstant());
		System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("America/Chicago")));
		System.out.println(zonedDateTime.withZoneSameLocal(ZoneId.of("America/Chicago")));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("'The' dd 'day of' MMM 'in year' YYYY 'and zone is' z")));

	}
}
