package DSandAlgo.circularLinkedList;

public class CircularLinikedList {
	private Node first;
	private Node last;
	public CircularLinikedList() {
		first = null;
		last = null;
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			last = newNode;
		}
		newNode.next = first;
		newNode = newNode;
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return 	first==null;
	}
}
