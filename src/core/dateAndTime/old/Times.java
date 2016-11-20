package core.dateAndTime.old;

import java.sql.Time;
import java.util.Date;

public class Times {

	public static void main(String[] args) {
		Time instant=new Time(System.currentTimeMillis());
		System.out.println(instant);
		System.out.println(Time.valueOf("45:19:41"));

                long t= System.currentTimeMillis();
                System.out.println(new Date(t).equals(new Date(t)));
	}
}
