package core.numbers;

import java.util.Random;

public class RandomNumber {

  public static void main(String[] args){
    Random random = new Random();

    System.out.println(random.nextInt());
    random.ints(5).forEach(x -> System.out.println(x));

    double d = random.nextDouble();
    System.out.println(randomNumberBetween(2000, 2550));
  }


  static int randomNumberBetween(int min, int max){
    double  d = Math.random();
    return (int)(d * (max-min) + min);
  }
}
