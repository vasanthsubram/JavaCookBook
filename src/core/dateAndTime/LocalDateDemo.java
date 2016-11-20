package core.dateAndTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class LocalDateDemo {

	public static void main(String[] args) {
		
	    LocalDate date1 = LocalDate.now();
	    System.out.println(date1); //2015-03-23
	    
	    LocalDate date2 = LocalDate.of(2013,Month.SEPTEMBER,10);
	    System.out.println(date2); //2013-09-10
	    
	    LocalDate date3 = LocalDate.of(2013, 3, 1);	////2013-03-01
	   
	    LocalDate date4 = LocalDate.parse("2007-12-03");	//2007-12-03
	    System.out.println(date4);
	    
	    LocalDate date5 = LocalDate.parse("1 Jan 2290",DateTimeFormatter.ofPattern("d MMM uuuu"));
	    System.out.println(date5);  //2290-01-01
	    
	    System.out.println(date3.get(ChronoField.DAY_OF_MONTH));	//1
	    System.out.println(date3.get(ChronoField.MONTH_OF_YEAR));	//3
	    System.out.println(date3.get(ChronoField.YEAR));	//2013
	    
	    System.out.println(date3.getDayOfMonth());	//1
	    
	    System.out.println(date3.MIN); //-999999999-01-01
	    System.out.println(date3.MAX); //+999999999-12-31

	    System.out.println(date2.isAfter(date3)); //true
	    System.out.println(date3.isLeapYear());  //false
	    
	    System.out.println(date3.lengthOfMonth()); //31
	    
	    System.out.println(date3.plusMonths(3).minusDays(1));  //2013-05-31
	 	}
}
