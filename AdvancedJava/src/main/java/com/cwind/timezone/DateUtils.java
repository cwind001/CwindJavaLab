package com.cwind.timezone;

import java.text.*;
import java.util.*;
import java.util.Date;

public class DateUtils
{
	public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
	private static final DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
	
	public static String transform(Date sourceDate, DateFormat format,
			TimeZone sourceTimeZone, TimeZone targetTimeZone) {
		Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
		return DateUtils.getTime(new Date(targetTime), format);
	}
	
	public static String getTime(Date date, DateFormat dateFormat)
	{
		return formatter.format(date);
	}
}
