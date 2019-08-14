package ovh.ladon.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
	public static void main(String[] args) {
		Queue<String> peopleInQueue = new LinkedList<>();

		peopleInQueue.add("Sam");
		peopleInQueue.add("Anna");
		peopleInQueue.add("Heidi");
		peopleInQueue.add("Susan");
		peopleInQueue.add("Charlotte");

		System.out.println(peopleInQueue);

		final String nextInQueue = peopleInQueue.peek();
		System.out.println("next: " + nextInQueue);

		for (int i = 0; i < peopleInQueue.size(); i++) {
			peopleInQueue.remove();
			System.out.println(peopleInQueue);
		}
	}
}
