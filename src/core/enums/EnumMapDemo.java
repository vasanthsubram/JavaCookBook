package core.enums;

import java.util.EnumMap;

public class EnumMapDemo {

  public static void main(String[] args){
    EnumMap<DaysOfWeek, String> activities = new EnumMap<>(DaysOfWeek.class);
    activities.put(DaysOfWeek.MONDAY, "Swimming");
    activities.put(DaysOfWeek.TUESDAY, "Painting");
    activities.put(DaysOfWeek.WEDNESDAY, "Gymnastics");
    activities.put(DaysOfWeek.THURSDAY, "Flute");
    activities.put(DaysOfWeek.FRIDAY, "Pizza");
    activities.put(DaysOfWeek.SATURDAY, "Swimming");
    activities.put(DaysOfWeek.SUNDAY, "Lounging");

//    activities.put(null,null);      adding null throws NPE

    System.out.println(activities.get(DaysOfWeek.MONDAY));
    System.out.println(activities.get(DaysOfWeek.SUNDAY));

  }
}
