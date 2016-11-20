package core.dateAndTime.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;


public class DateTimeFormatterBuilderDemo {
	public static void main(String[] args) {
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
		DateTimeFormatter formatter = builder.appendLiteral("Date: ")
		    .appendValue(ChronoField.DAY_OF_MONTH)
		    .appendLiteral("-")
		    .appendValue(ChronoField.MONTH_OF_YEAR)
		    .appendLiteral("-")
		    .appendPattern("u")
		    .appendLiteral(" Time: ")
		    .appendValue(ChronoField.HOUR_OF_DAY)
		    .appendLiteral(":")
		    .appendText(ChronoField.MINUTE_OF_HOUR, TextStyle.NARROW_STANDALONE)
		    .toFormatter(); 
		    LocalDateTime dateTime  = LocalDateTime.now(); 
		    String str =  dateTime.format(formatter); 
		    System.out.println(str);	//Date: 25-3-2015 Time: 15:29
	}
} 