package ovh.ladon.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
	private static List<String> listWordsToExclude = List.of("the", "a", "or", "an", "it", "and", "but", "is", "are", "of", "on", "to", "was", "were", "in", "that", "i", "your", "his", "their", "her", "you", "me", "all");

	public static String findMostRepeatedWord(String s) {
		HashMap<String, Integer> wordsCounter = new HashMap<>();
		final String[] wordsInArray = s.trim().split("[ \\n\\t\\r.,;:!?()]");
		Arrays.stream(wordsInArray)
				.forEach(word ->{
					final String wordWithoutPonctuation = word.toLowerCase();
					if (wordWithoutPonctuation.length() == 0) {
						return;
					}
					if (listWordsToExclude.contains(wordWithoutPonctuation)) {
						return;
					}
					if (wordsCounter.containsKey(wordWithoutPonctuation)) {
						wordsCounter.put(wordWithoutPonctuation, wordsCounter.get(wordWithoutPonctuation) + 1);
					}else {
						wordsCounter.put(wordWithoutPonctuation, 1);
					}
				});
		String wordMostRepeated = "";
		int countMostRepeated = 0;
		for (String key : wordsCounter.keySet()) {
			final Integer value = wordsCounter.get(key);
			if (value > countMostRepeated) {
				wordMostRepeated = key;
				countMostRepeated = value;

			}
		}
		return wordMostRepeated;
	}

}
