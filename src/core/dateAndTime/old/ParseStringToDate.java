package core.dateAndTime.old;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class ParseStringToDate {

	public static void main(String[] args) throws ParseException {

		String dateString = "Jan 12, 1952 ";
		DateFormat df = DateFormat.getDateInstance();

		Date date = df.parse(dateString);
		System.out.println("Date from string -> " + date);

		DateFormat dflong = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.FULL);

		DateFormat dfshort = DateFormat.getDateTimeInstance(DateFormat.SHORT,
				DateFormat.SHORT);

		DateFormat dfmedium = DateFormat.getDateInstance(DateFormat.MEDIUM);

		Date d1 = dflong.parse("January 12, 2005 5:59:00 PM PST");
		Date d2 = dfshort.parse("5/2/05 9:34 AM");
		Date d3 = dfmedium.parse("Jul 12, 2005");

		System.out.printf("Long Date/time is %s \n", dflong.format(d1));
		System.out.printf("Short Date/time is %s \n", dfshort.format(d2));
		System.out.printf("Medium Date is %s \n", dfmedium.format(d3));
	}
}
