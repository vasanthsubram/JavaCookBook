package patterns.behavioural.chainOfCommand;

public class Client {
  public static void main(String[] args){


    SupportService managerSupport = new ManagerSupport(null);
    SupportService supervisorSupport = new SupervisorSupport(managerSupport);
    SupportService frontDeskSupport = new FrontDeskSupport(supervisorSupport);

    ServiceRequest request = new ServiceRequest();
    request.setType(ServiceLevel.LEVEL_ONE);
    frontDeskSupport.handleRequest(request);
    System.out.println(request.getConclusion());

    request = new ServiceRequest();
    request.setType(ServiceLevel.LEVEL_TWO);
    frontDeskSupport.handleRequest(request);
    System.out.println(request.getConclusion());

  }
}
