
import java.util.*;

class QueUsingStack {
	static class Queue {
		static Stack<Integer> firstStack = new Stack<Integer>();
		static Stack<Integer> secondStack = new Stack<Integer>();

		static void enQueue(int x) {

			while (!firstStack.isEmpty()) {
				secondStack.push(firstStack.pop());
			}

			firstStack.push(x);

			while (!secondStack.isEmpty()) {
				firstStack.push(secondStack.pop());
			}
		}

		static int deQueue() {
			if (firstStack.isEmpty()) {
				System.out.println("Q is Empty");
				System.exit(0);
			}

			int x = firstStack.peek();
			firstStack.pop();
			return x;
		}
	};

	public static void main(String[] args) {
		Queue verifyQueue = new Queue();
		System.out.println("Start enque");
		verifyQueue.enQueue(1);
		verifyQueue.enQueue(2);
		verifyQueue.enQueue(3);
		verifyQueue.enQueue(4);
		verifyQueue.enQueue(5);
		verifyQueue.enQueue(6);
		verifyQueue.enQueue(7);
		verifyQueue.enQueue(8);

		System.out.println("Start DQ");
		System.out.println(verifyQueue.deQueue());
		System.out.println(verifyQueue.deQueue());
		System.out.println(verifyQueue.deQueue());
		System.out.println(verifyQueue.deQueue());

		System.out.println("Again enque");
		verifyQueue.enQueue(9);
		verifyQueue.enQueue(9);
		verifyQueue.enQueue(9);
		verifyQueue.enQueue(9);
		System.out.println();
		System.out.println("again DQ");

		System.out.println(verifyQueue.deQueue());
		System.out.println(verifyQueue.deQueue());
	}
}
