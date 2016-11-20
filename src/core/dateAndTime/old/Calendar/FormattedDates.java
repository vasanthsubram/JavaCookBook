package core.dateAndTime.old.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormattedDates {

	public static void main(String[] args) throws Exception{

		SimpleDateFormat formatter = new SimpleDateFormat(
				"EEE, dd MMM yyyy HH:mm:ss:SSS");
		String formattedDate = formatter.format(System.currentTimeMillis());
		System.out.println("Today's Date and Time is: " + formattedDate);

		SimpleDateFormat formatter2 = new SimpleDateFormat(
				"yyyy-MM-dd.hh:mm:ss");
		String formattedDate2 = formatter2.format(System.currentTimeMillis());
		System.out.println("Today's Date and Time is: " + formattedDate2);

                SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date aDate = dayFormat.parse("2011-05-17");
                System.out.println(aDate);

	}

}
