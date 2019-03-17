package patterns.behavioural.chainOfCommand;

public class ManagerSupport implements SupportService {
  private SupportService next = null;

  public ManagerSupport(SupportService next){
    this.next=next;
  }

  @Override
  public void handleRequest(ServiceRequest request) {
    if(request.getType() == ServiceLevel.LEVEL_THREE) {
      request.setConclusion("Manager solved level three reuqest !!");
    } else {
      if(next != null){
        next.handleRequest(request);
      } else {
        throw new IllegalArgumentException("No handler found for :: " + request.getType());
      }
    }
  }
}
