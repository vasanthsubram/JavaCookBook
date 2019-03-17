package patterns.behavioural.state;

public class Acknowledged implements PackageState {
  //Singleton
  private static Acknowledged instance = new Acknowledged();

  private Acknowledged() {}

  public static Acknowledged instance() {
    return instance;
  }

  @Override
  public void updateState(DeliveryContext ctx) {
    System.out.println("Package is acknowledged !!");
    ctx.setCurrentState(Shipped.instance());
  }
}