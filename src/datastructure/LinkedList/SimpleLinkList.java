package datastructure.LinkedList;

/**
 * Simple linked list
 * Add or delete a link at the beginning of the linked list
 *
 * @author subramav
 *
 */
class SimpleLinkList {
	private Link head;

	public SimpleLinkList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	// Inserts a new Link at the first of the list
	public void insert(int d1) {
		Link link = new Link(d1);
		link.next = head;
		head = link;
	}

	// Deletes the link at the first of the list
	public Link delete() {
		Link temp = head;
		head = head.next;
		return temp;
	}

	//reverse one link at a time
	//start from left. Keep references to 3 nodes(n1,n2,n3) in vars
	//reverse one link. Shift the references by one to the right (n2 becomes n1, n3 becomes, next of n3 becomes n3)
	public void reverse(){
		Link n1=head,n2,n3;
		n2=n1.next;
		n3=n2.next;
		n1.next=null;
		
		do{
			//reverse
			n2.next=n1;
			//shift references to the right
			n1=n2;
			n2=n3;
		} while((n3=n3.next) != null);
		
		//at this point n3 is null
		n2.next=n1;
		head=n2;
	}
	
	
	public void printList() {
		Link currentLink = head;
		System.out.print("List: ");
		while (currentLink != null) {
			currentLink.printLink();
			currentLink = currentLink.next;
		}
		System.out.println("");
	}


	 class Link {
		public int data;
		
		public Link next;

		public Link(int d1) {
			data = d1;
		}

		public void printLink() {
			System.out.print(data + " ");
		}
	}
	 
	 public static void main(String[] args) {
			SimpleLinkList list = new SimpleLinkList();

		 for(int i=0;i<10;i++){
			list.insert(i);
		 }
		 System.out.println("head = " + list.head.data);
			list.printList();
			list.reverse();
			list.printList();
			list.reverse();
			list.printList();

			while (!list.isEmpty()) {
				SimpleLinkList.Link deletedLink = list.delete();
				System.out.print("deleted: ");
				deletedLink.printLink();
				System.out.println("");
			}
			list.printList();
		}
}