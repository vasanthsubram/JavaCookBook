package patterns.behavioural.flyweight;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Flyweight {

  // Integer.valueOf() always cache values in the range -128 to 127, inclusive, and may cache other values outside of this range.
  public static void main(String[] args){
    assertTrue(Integer.valueOf(10)==Integer.valueOf(10));
    assertTrue(Integer.valueOf(127)==Integer.valueOf(127));
    assertFalse(Integer.valueOf(128)==Integer.valueOf(128));


  }
}
