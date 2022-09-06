package com.novare.atm.util;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * This is Date helper class to convert the Date into different formats.
 * 
 * @author malli
 *
 */
public final class DateUtil {

	public final static String DATE_FORMAT_PATTERN = "dd-MM-yyyy hh:mm:ss";

	private DateUtil() {
	}

	public static LocalDate toLocalDate(Date date) {
		return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	public static Date toDate(LocalDate date) {
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate toDate(String dateAsString) throws ParseException {
		return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
	}

	public static String toString(LocalDate date) throws ParseException {
		return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
	}

	public static String getNow() throws ParseException {
		return toString(LocalDate.now());
	}
}
