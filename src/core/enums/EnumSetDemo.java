package core.enums;

import java.util.EnumSet;

public class EnumSetDemo {
  public static void main(String[] args){

    EnumSet<DaysOfWeek> set = EnumSet.allOf(DaysOfWeek.class);

  //  set.add(null); adding null throws NPE

    System.out.println(set.toString());
  }
}
