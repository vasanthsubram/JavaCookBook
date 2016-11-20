package core.system;

public class PrintClassLocation {
	  public static void main(String args[]){
	    java.net.URL u = PrintClassLocation.class.getResource("");
	    System.out.println("This class (PrintClassLocation) is located at : \n" + u);
	    }
	}
