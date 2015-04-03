package com.cwind.timezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatTest {

	static String DEFAULT_TIMEZONE = "GMT+8";
	static String DEFAULT_FORMAT = "dd-MM-yyyy HH:mm";

	public static Date ConverDateGMT(String convertString, String format,
			String sourceTimeZone, String targetTimeZone) throws ParseException {

		Date date = null;

		if (isEmpty(sourceTimeZone)) {
			sourceTimeZone = DEFAULT_TIMEZONE;
		}

		if (isEmpty(targetTimeZone)) {
			targetTimeZone = DEFAULT_TIMEZONE;
		}

		if (isEmpty(format)) {
			format = DEFAULT_FORMAT;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Long time = new Date(sdf.parse(convertString).getTime()).getTime();

		Long sourceRelativelyGMT = time
				- TimeZone.getTimeZone(sourceTimeZone).getRawOffset();

		Long targetTime = sourceRelativelyGMT
				+ TimeZone.getTimeZone(targetTimeZone).getRawOffset();

		date = new Date(targetTime);

		return date;

	}

	public static boolean isEmpty(String value) {
		boolean emptyFlg = false;
		if (null == value || value.trim().length() <= 0) {
			emptyFlg = true;
		}
		return emptyFlg;
	}
	
	public static void main(String[] args){
		try {
			Date date = DateFormatTest.ConverDateGMT("16-7-2013 00:00", DEFAULT_FORMAT, "GMT+4", DEFAULT_TIMEZONE);
			System.out.println(date.toString());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}