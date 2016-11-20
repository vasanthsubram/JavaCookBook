package core.collection;

/**
 * <ol>
 * <li>Fixed size collection that keeps the order</li>
 * <li>To keep the collection fixed size, as new object is added over the limit, the oldest object is thrown out.</li>
 * <li>Elements cannot be removed the collection externally</li>
 * </ol>
 */

public class LeakyArray {

	private int limit;
	private Object[] collection;
	private int size=0;
	
	public LeakyArray(int newLimit){
		limit=newLimit;
		collection = new Object[limit];
	}

	public void add(Object element){
		if(size==limit){
			for(int i=0;i<limit-1;i++){
				collection[i]= collection[i+1];
			}
			collection[limit-1]=(element);
		} else{
			collection[size]=element;
			size++;
		}
	}
	
	public Object[] getCollection(){
		return collection;
	}
	
	public String toString(){
		StringBuffer buf= new StringBuffer();
		for(int i=0;i<size;i++){
			buf.append(collection[i].toString());
			buf.append("\n");
		}
		return buf.toString();
	}
	
	public static void main(String[] args) {
		int limit=3;
		LeakyArray bag = new LeakyArray(limit);
		bag.add("A");
		bag.add("B");
		bag.add("C");
		assert(bag.size==limit);
		bag.add("D");
		System.out.println(bag.toString());
		
		assert(bag.size==limit);
		bag.add("E");
		assert(bag.size==limit);
		System.out.println(bag.toString());
		assert(bag.collection[0]=="C");
		assert(bag.collection[1]=="D");
		assert(bag.collection[2]=="E");
	}
}
