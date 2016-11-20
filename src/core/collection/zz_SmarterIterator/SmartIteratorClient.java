package core.collection.zz_SmarterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SmartIteratorClient {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("A",111111111));
		list.add(new Employee("B",222222222));
		list.add(new Employee("C",333333333));
		list.add(new Employee("D",444444444));
		list.add(new Employee("D",444444444));
		
		Employee e =(Employee)SmartIterator.detect("B",list,"getName");
		System.out.println(e.getName());
		System.out.println(e.getSsn());
		
		Employee e3 =(Employee)SmartIterator.detect(111111111,list,"getSsn");
		System.out.println(e3.getName());
		System.out.println(e3.getSsn());
		
		Collection result=SmartIterator.select(444444444,list,"getSsn");
		for(Object e2: result){
			System.out.println(((Employee)e2).getName());
			System.out.println(((Employee)e2).getSsn());
		}
		
		System.out.println(SmartIterator.detect("B",null,"getName"));
		System.out.println(SmartIterator.detect("BLAH",list,"getName"));
		
		Collection result2=SmartIterator.collect(list,"getSsn");
		for(Object e2: result2){
			System.out.println(e2);
		}
		
	}		
		
}

class Employee{
	private String name;
	private int ssn;
	
	Employee(String newName, int ssn){
		name=newName;
		this.ssn=ssn;
	}
	
	public void setName(String newName){
		name=newName;
	}
	
	public String getName(){
		return name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
}
