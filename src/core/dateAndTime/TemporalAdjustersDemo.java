package core.dateAndTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersDemo {

	public static void main(String[] args) {

		LocalDate date1 = LocalDate.now();

		System.out.printf("first day of Month: %s%n",
				date1.with(TemporalAdjusters.firstDayOfMonth()));

		System.out.printf("first Monday of Month: %s%n",
				date1.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		
		System.out.printf("last day of Month: %s%n",
				date1.with(TemporalAdjusters.lastDayOfMonth()));
		
		System.out.printf("first day of next Month: %s%n",
				date1.with(TemporalAdjusters.firstDayOfNextMonth()));
		
		System.out.printf("first day of next Year: %s%n",
				date1.with(TemporalAdjusters.firstDayOfNextYear()));
		
		System.out.printf("first day of Year: %s%n",
				date1.with(TemporalAdjusters.firstDayOfYear()));
	}
}
