package patterns.behavioural.state;

public class Delivered implements PackageState {
  //Singleton
  private static Delivered instance = new Delivered();

  private Delivered() {}

  public static Delivered instance() {
    return instance;
  }

  //Business logic
  @Override
  public void updateState(DeliveryContext ctx) {
    System.out.println("Package is delivered!!");
  }
}