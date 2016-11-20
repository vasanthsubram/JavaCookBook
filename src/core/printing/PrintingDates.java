package core.printing;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrintingDates {
	public static void main(String[] args) {
		SimpleDateFormat formatter =new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss:SSS");
		String formattedDate = formatter.format(Calendar.getInstance().getTimeInMillis());
		System.out.println("Today's Date and Time is: " + formattedDate);

		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
		String formattedDate2 = formatter2.format(Calendar.getInstance().getTimeInMillis());
		System.out.println("Today's Date and Time is: " + formattedDate2);
		
		//C style - 
		 System.out.format("This thread id = %d \n", Thread.currentThread().getId());
		 
		 System.out.format("Local time: %tT \n", Calendar.getInstance());
		 System.out.format("Todays date: %tD \n", Calendar.getInstance());
		 System.out.format("Day of the week: %tA \n", Calendar.getInstance());
		 System.out.format("Current month: %tB \n", Calendar.getInstance());
		 System.out.format("Current time and date: %tc \n", Calendar.getInstance());
		 System.out.println(Calendar.getInstance().getTime());	    
	}
}
