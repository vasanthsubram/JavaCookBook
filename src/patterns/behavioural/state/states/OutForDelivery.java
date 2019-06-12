package patterns.behavioural.state.states;

import patterns.behavioural.state.DeliveryContext;
import patterns.behavioural.state.PackageState;

public class OutForDelivery implements PackageState {
  //Singleton
  private static OutForDelivery instance = new OutForDelivery();

  private OutForDelivery() {}

  public static OutForDelivery instance() {
    return instance;
  }

  //Business logic and state transition
  @Override
  public void updateState(DeliveryContext ctx) {
    System.out.println("Package is out for delivery !!");
    ctx.setCurrentState(Delivered.instance());
  }
}