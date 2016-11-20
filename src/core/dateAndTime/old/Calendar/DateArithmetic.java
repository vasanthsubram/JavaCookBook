package core.dateAndTime.old.Calendar;

import java.util.Calendar;

public class DateArithmetic {

	public static void main(String[] args) {
		
		Calendar now =Calendar.getInstance();
		
		Calendar later = Calendar.getInstance();
		later.add(Calendar.DAY_OF_MONTH, 2);
                System.out.println(later.getTime());

                Calendar earlier = Calendar.getInstance();
                earlier.add(Calendar.DAY_OF_MONTH, -2);
                System.out.println(earlier.getTime());
		
		
		System.out.println(now.compareTo(later));
                System.out.println(now.compareTo(earlier));
		
		//Calculating the Difference Between Two Dates (that are in the same year)
		System.out.println(later.get(Calendar.DAY_OF_YEAR)- now.get(Calendar.DAY_OF_YEAR));
                System.out.println(earlier.get(Calendar.DAY_OF_YEAR)- now.get(Calendar.DAY_OF_YEAR));
		
	}

}
