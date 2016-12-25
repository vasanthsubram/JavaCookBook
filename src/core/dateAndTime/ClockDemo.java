package core.dateAndTime;

import java.time.Clock;
import java.time.ZoneId;

/**
 * Created by vasanthakumarsubramanian on 12/23/16.
 */
public class ClockDemo {

    private static final ZoneId MOSCOW = ZoneId.of("Europe/Moscow");

    private static final ZoneId PARIS = ZoneId.of("Europe/Paris");

    public static void main(String args[]){

        Clock defaultZoneClock = Clock.systemDefaultZone();
        System.out.println(defaultZoneClock.instant());

        Clock clock= Clock.systemUTC();
        System.out.println(clock.instant());

        Clock paris = Clock.system(PARIS);
        System.out.println(paris.instant());

    }
}
