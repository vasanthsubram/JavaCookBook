package streams.customFunctionalInterface;

public class Main {

  public static void main(String[] args){
    Converter<String, Integer> converter = (from) ->  Integer.valueOf(from);
    System.out.println(converter.convert("123"));
  }
}


