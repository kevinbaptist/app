package ovh.ladon.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
	private static List<String> listWordsToExclude = List.of("the", "a", "or", "an", "it", "and", "but", "is", "are", "of", "on", "to", "was", "were", "in", "that", "i", "your", "his", "their", "her", "you", "me", "all");

	/**
	 * @return most repeated word. In case of draw, the first word will be returned*/
	public static String findMostRepeatedWord(String s) {
		HashMap<String, Integer> wordsCounter = new HashMap<>();
		List<String> wordsOrder =new LinkedList<>();
		final String[] wordsInArray = s.trim().split("[ \\n\\t\\r.,;:!?()]");
		Arrays.stream(wordsInArray)
				.forEach(word ->{
					final String wordWithoutPonctuation = word.toLowerCase();
					if (wordWithoutPonctuation.length() == 0 || listWordsToExclude.contains(wordWithoutPonctuation)) {
						return;
					}

					if (wordsCounter.containsKey(wordWithoutPonctuation)) {
						wordsCounter.put(wordWithoutPonctuation, wordsCounter.get(wordWithoutPonctuation) + 1);
					}else {
						wordsCounter.put(wordWithoutPonctuation, 1);
						wordsOrder.add(wordWithoutPonctuation);
					}
				});
		String wordMostRepeated = "";
		int countMostRepeated = 0;
		for (String key : wordsCounter.keySet()) {
			final Integer value = wordsCounter.get(key);
			if (value > countMostRepeated) {
				wordMostRepeated = key;
				countMostRepeated = value;
			} else if (value == countMostRepeated) {
				if (wordsOrder.indexOf(key) < wordsOrder.indexOf(wordMostRepeated)) {
					wordMostRepeated = key;
					countMostRepeated = value;
				}
			}
		}
		return wordMostRepeated;
	}

}
