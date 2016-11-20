package core.thread.timers;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleTimerDemo {

    public static void main(String[] args) throws Exception {

        int delay = 5000; // delay for 5 sec.
        int period = 1000; // repeat every sec.

        Timer timer = new Timer();

//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                System.out.println("done");
//            }
//        }, delay, period);

            timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("done");
            }
        }, delay, period);
    }
}
