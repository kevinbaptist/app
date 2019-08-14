package ovh.ladon.stack;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		Stack<String> deckOfCards = new Stack<>();
		String card1 = "Jack : Diamonds";
		String card2 = "7 : Hearts";
		String card3 = "10 : Clubs";

		deckOfCards.push(card1);
		deckOfCards.push(card2);
		deckOfCards.push(card3);
		System.out.println(deckOfCards);

		final String topCard = deckOfCards.peek();
		System.out.println("Card on top:" +topCard);

		while (!deckOfCards.isEmpty()) {
			final String cardRemoved = deckOfCards.pop();
			System.out.println(cardRemoved);
		}
	}
}
