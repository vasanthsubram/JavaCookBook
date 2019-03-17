package patterns.behavioural.chainOfCommand;

public class SupervisorSupport implements SupportService {

  private SupportService next = null;

  public SupervisorSupport(SupportService next){
    this.next=next;
  }

  @Override
  public void handleRequest(ServiceRequest request) {
    if(request.getType() == ServiceLevel.LEVEL_TWO) {
      request.setConclusion("Supervisor solved level two reuqest !!");
    } else {
      if(next != null){
        next.handleRequest(request);
      } else {
        throw new IllegalArgumentException("No handler found for :: " + request.getType());
      }
    }
  }
}