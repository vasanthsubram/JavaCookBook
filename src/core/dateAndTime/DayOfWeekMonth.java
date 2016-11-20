package core.dateAndTime;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayOfWeekMonth {
	public static void main(String[] args) {
		System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));	//THURSDAY
		
		DayOfWeek dow = DayOfWeek.MONDAY;
		Locale locale = Locale.getDefault();
		System.out.println(dow.getDisplayName(TextStyle.FULL, locale)); //Monday
		System.out.println(dow.getDisplayName(TextStyle.NARROW, locale)); //M
		System.out.println(dow.getDisplayName(TextStyle.SHORT, locale)); //Mon
		
		
		Month month = Month.AUGUST;
		System.out.println(month.getDisplayName(TextStyle.FULL, locale)); //August
		System.out.println(month.getDisplayName(TextStyle.NARROW, locale)); //A
		System.out.println(month.getDisplayName(TextStyle.SHORT, locale)); //Aug
		
		System.out.printf("%d%n", Month.JANUARY.maxLength()); //31
		System.out.printf("%d%n", Month.FEBRUARY.maxLength());  //29
		System.out.printf("%d%n", Month.APRIL.maxLength());  //30
		
		
	}
}
