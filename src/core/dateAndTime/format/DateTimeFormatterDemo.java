package core.dateAndTime.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
	public static void main(String[] args) {
		
		//printing
		System.out.println(LocalDate.of(2015,1,1).toString()); //2015-01-01
		System.out.println(LocalDate.of(2015,1,1).format(DateTimeFormatter.ofPattern("d MMM yyyy"))); //1 Jan 2015
		
		
		//parsing
		LocalDate date5 = LocalDate.parse("1 Jan 2290",DateTimeFormatter.ofPattern("d MMM uuuu"));
	    System.out.println(date5);  //2290-01-01
	    
		LocalTime time = LocalTime.parse("10:15:30", DateTimeFormatter.ISO_TIME);
		System.out.println(time); //10:15:30
		
		LocalDate date = LocalDate.parse("20131206", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(date); //2013-12-06
		
		LocalDateTime dateTime1 = LocalDateTime.parse("Thu, 5 Jun 2014 05:10:40 GMT", DateTimeFormatter.RFC_1123_DATE_TIME);
		System.out.println(dateTime1); //2014-06-05T05:10:40
		
		LocalDateTime dateTime2 = LocalDateTime.parse("2014-11-03T11:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(dateTime2); //2014-11-03T11:15:30
		
		LocalDateTime dateTime3 = LocalDateTime.parse("2014-10-05T08:15:30+02:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		System.out.println(dateTime3); //2014-10-05T08:15:30
		
		
	}
} 