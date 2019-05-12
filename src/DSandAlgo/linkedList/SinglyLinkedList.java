package DSandAlgo.linkedList;

public class SinglyLinkedList {
	private Node first;
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}
	
	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("List ( First --> Last");
		
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		
		System.out.println();
	}
	
}
