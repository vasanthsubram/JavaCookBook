package collections.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReversedIterator<T> implements Iterable<T> {

  private List<T> list;
  
  public ReversedIterator(List<T> list){
    this.list = list;
  }
  
  //Iterator provided to clients of this class
  @Override
  public Iterator<T> iterator() {
    
    // Every time an iterator is requested we
    // define a new ListIterator that will be used to
    // iterate the list in the reverse order
    final ListIterator<T> iterator = list.listIterator(list.size());
    
    // The iterator returned to the caller will
    // work based on the ListIterator
    return new Iterator<T>(){

      // hasNext() and next() methods call in fact
      // the reverse operations in ListIterator
      
      @Override
      public boolean hasNext(){
        return iterator.hasPrevious();
      }

      @Override
      public T next(){
        return iterator.previous();
      }

      @Override
      public void remove() {
        iterator.remove();
      }

    };

  }
  
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("First");
		list.add("Second");
		list.add("Third");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

		ReversedIterator<String> reversedList = new ReversedIterator<String>(list);

		// for-each syntax
		for (String s : reversedList) {
            System.out.println(s);
        }
	}
}