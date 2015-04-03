package com.cwind.timezone;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDateUtils {
	
	private final String SOURCE_TIMEZONE = "GMT+4";
	private final String TARGET_TIMEZONE = "GMT+8";
	private final String DEFAULT_FORMAT = "MM/dd/yyyy hh:mm:ss a";
	private DateFormat dateFormat;
	private TimeZone sourceTimeZone;
	private TimeZone targetTimeZone;
	
	@Before
	public void setUp() throws Exception
	{
		dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
		sourceTimeZone = TimeZone.getTimeZone(SOURCE_TIMEZONE);
		targetTimeZone = TimeZone.getTimeZone(TARGET_TIMEZONE);
	}

	@After
	public void tearDown() throws Exception
	{
	}
	
	@Test
	public void testTransformDateBetweenTimeZone(){
		Date startDate = new Date("07/16/2013 00:00:00");
		String transformedStartDate = DateUtils.transform(startDate, dateFormat, sourceTimeZone, targetTimeZone);
		assertEquals(transformedStartDate, "07/16/2013 04:00:00 AM");
		Date endDate = new Date("07/16/2013 23:59:59");
		String transformedEndDate = DateUtils.transform(endDate, dateFormat, sourceTimeZone, targetTimeZone);
		assertEquals(transformedEndDate, "07/17/2013 03:59:59 AM");
	}
	
	@Test
	public void testLongToDate() {
		long time = 1374004799999L;
		Date startDate = new Date(time);
		assertEquals(startDate.toString(), "Tue Jul 16 15:59:59 EDT 2013");
	}
	
	public static void main(String[] args){
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		Date date = new Date();
		System.out.println(date);
		
		TimeZone timeZone = TimeZone.getDefault();
		TimeZone timeZone2 = TimeZone.getTimeZone("GMT+8");
		System.out.println(timeZone);
		System.out.println(timeZone2);
		
		TimeZone.setDefault(timeZone2);
		calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		System.out.println(calendar.getTime().getTime());
		
		System.out.println("Offset1: "+timeZone.getRawOffset()+ " Offset2: "+timeZone2.getRawOffset());
	}
}
