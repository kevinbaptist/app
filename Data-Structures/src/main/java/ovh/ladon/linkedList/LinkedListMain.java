package ovh.ladon.linkedList;

import java.util.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList<String> letters = new LinkedList<>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		letters.add("D");

		letters.addFirst("Z");
		letters.addLast("X");
		letters.add(2, "F");

		System.out.println(letters.getFirst());

		System.out.println(letters.getLast());

		System.out.println(letters.size());

		System.out.println(letters);

		letters.removeFirst();
		letters.removeLast();
		System.out.println(letters);

		System.out.println(letters.contains("B"));//return true

		letters.clear();
		System.out.println(letters);//
	}
}
