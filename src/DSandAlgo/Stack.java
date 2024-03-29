package DSandAlgo;

public class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new long[maxSize];
		this.top = -1;
	}
	public void push(long j) {
		top++;
		stackArray[top] = j;
	}
	public long pop() {
		int old_top = top;
		top--;
		return stackArray[old_top];
	}
	public long peak() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
		return (maxSize-1 == top);
	}
}
