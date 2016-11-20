package core.dateAndTime;

import java.time.temporal.ChronoUnit;

public class ChronoUnitDemo {

	public static void main(String[] args) {
		System.out.println(ChronoUnit.MINUTES); //Minutes
		System.out.println(ChronoUnit.MINUTES.getDuration().getSeconds()); //60
		
		System.out.println(ChronoUnit.DAYS.getDuration().getSeconds());  //86400
		
		System.out.println(ChronoUnit.YEARS.getDuration().getSeconds());  //31556952
	}
}
