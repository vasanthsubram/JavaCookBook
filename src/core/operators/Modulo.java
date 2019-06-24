package core.operators;

public class Modulo {
  public static void main(String[] args) {
    int value=0;

    for(int i=0;i<50;i++){
      value = (value +1) % 31;
      System.out.println(value);
    }
  }
}
