package core.nested;

public class Outer {

  class Inner {
    public void show() {
      System.out.println("In a nested class method");
    }
  }

  public static void main(String[] args) {
    Outer.Inner in = new Outer().new Inner();
    in.show();
  }
}
