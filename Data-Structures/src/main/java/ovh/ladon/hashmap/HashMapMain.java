package ovh.ladon.hashmap;

import java.util.HashMap;

public class HashMapMain {
	public static void main(String[] args) {
		HashMap<String, Integer> wordToNum = new HashMap<>();

		//This is a very bad example, because this could be done with enum
		wordToNum.put("ONE", 1);
		wordToNum.put("TWO", 2);
		wordToNum.put("THREE", 3);
		wordToNum.put("FOUR", 4);

		System.out.println(wordToNum.get("THREE"));

		System.out.println(wordToNum.values());

		System.out.println(wordToNum.keySet());

		//Common use of hashMaps: which character is the most repeated


	}
}
