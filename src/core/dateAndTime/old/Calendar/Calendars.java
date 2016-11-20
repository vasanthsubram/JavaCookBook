package core.dateAndTime.old.Calendar;

import java.util.Calendar;
import java.util.Date;

public class Calendars {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		Date todaysDate = c.getTime();
		System.out.println("Todays date -> " + todaysDate);

		System.out.println("Year	 	 = " +c.get(Calendar.YEAR));

                 //is it wednesday today
                System.out.println(c.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY);

                //is it 4 PM
                System.out.println( c.get(Calendar.HOUR_OF_DAY)==16);
                
		//Month -> Jan =0, Feb=1 etc.,
		System.out.println("Month	 	 = " +c.get(Calendar.MONTH)); 
		System.out.println("Day of month = " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Date		 = " +c.get(Calendar.DATE));
		//sunday=1, Monday=2
		System.out.println("Day of week  = " +c.get(Calendar.DAY_OF_WEEK));
		System.out.println("Day of Year  = " +c.get(Calendar.DAY_OF_YEAR));
		
		System.out.println("Hour		 = " +c.get(Calendar.HOUR));
		//24 hour clock
		System.out.println("Hour (24)	 = " +c.get(Calendar.HOUR_OF_DAY)); 
		System.out.println("Minute	 	 = " +c.get(Calendar.MINUTE));
		
		System.out.println("Second	 	 = " +c.get(Calendar.SECOND));
		
		System.out.println(c.getTimeZone());
		
		System.out.println(c.getTime().getClass());
    
		//reset calendar to beginning of time
		c.clear();
		System.out.println(c.getTime());

	}

}
