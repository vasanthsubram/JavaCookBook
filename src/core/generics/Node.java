package core.generics;

public class Node<E> {
  private E data; // Data (1)
  private Node<E> next; // Reference to next node (2)

  Node(E data, Node<E> next) { // (3)
    this.data = data;
    this.next = next;
  }

  public void setData(E data) {
    this.data = data;
  } // (4)

  public E getData() {
    return this.data;
  } // (5)

  public void setNext(Node<E> next) {
    this.next = next;
  } // (6)

  public Node<E> getNext() {
    return this.next;
  } // (7)

  public String toString() { // (8)
    return this.data.toString() +
          (this.next == null ? "" : ", " + this.next.toString());
  }

  public static void main(String args[]) {
    //Node<E> n;

    Node<String> node = new Node<>("!", null);
    Node<String> next =  new Node<>("World", node);
    Node<String> next2 =  new Node<>("Hello ", next);
    System.out.println(next2);
  }
}
