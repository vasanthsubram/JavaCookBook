package core.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;

public class ConversionDemo {

	public static void main(String[] args) {
		Year y = Year.of(2015);
		LocalDate d =y.atDay(90);
		System.out.println(d);
		
		YearMonth ym = YearMonth.of(2015,3);
		System.out.println(ym);
		LocalDate date =ym.atDay(2);
		System.out.println(date.getMonth());
		System.out.println(date.getYear());
		System.out.println(date.atStartOfDay());
		
		LocalDateTime dt =date.atTime(2,20,35);
		System.out.println(dt);
		
	}
}
