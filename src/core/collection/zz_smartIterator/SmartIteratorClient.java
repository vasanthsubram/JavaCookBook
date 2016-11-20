package core.collection.zz_smartIterator;
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
		
		SmartIterator<Employee, String> si = new SmartIterator<Employee, String>();
		Employee e = (Employee) si.detect("B",list, new SmartIterator.BooleanBlock<Employee,String>(){
			public boolean value(Employee o, String target) {
				return(o.getName().equals(target));
			}
		});
		System.out.println(e.getName());
		System.out.println(e.getSsn());
		
		
		//******************** with the smart iterator
		Collection<Employee> e2 = (new SmartIterator<Employee, Integer>())
				.select(444444444, list,
						new SmartIterator.BooleanBlock<Employee, Integer>() {
			public boolean value(Employee o, Integer target) {
				return(o.getSsn()==(target));
			}
		});
		
		for(Employee o: e2){
			System.out.println(o.getName());
			System.out.println(o.getSsn());
		}
		
		
		//******************without the smart iterator
		Collection<Employee> e3 = new ArrayList<Employee>();
		for(Employee x: list){
			if(x.getSsn()==444444444){
				e3.add(x);
			}
		}
		//list.select[:e| e getSSn ==44444444]
		
		for(Employee o: e3){
			System.out.println(o.getName());
			System.out.println(o.getSsn());
		}
	
	
	//******************** with the smart iterator
	Collection<String> e4 = (new SmartIterator<Employee, String>()) .collect(list,
						new SmartIterator.DoBlock<Employee, String>() {
							public String value(Employee o) 
							{
								return(o.getName() + " " + o.getSsn());
							}
						}
	);
	
	for(String o: e4){
		System.out.println(o);
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
