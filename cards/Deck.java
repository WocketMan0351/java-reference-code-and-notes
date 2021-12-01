package cards;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
	}

	public void initialize() {
		String[] suits = { "Hearts", "Diamonds", "Spades", "Clubs" };

		for (String suit : suits) {
			for (int rank = 1; rank <= 13; rank++) {
				Card c = new Card();
				c.setSuit(suit);
				c.setRank(rank);
				cards.add(c);
			}
		}
	}

	public void shuffle() {
		final int MAX_SHUFFLE = 1000;

		for (int i = 0; i < MAX_SHUFFLE; i++) {
			int pickOne = (int) (Math.random() * cards.size());
			Card c = cards.get(pickOne);
			cards.remove(pickOne);
			cards.add(c);
		}
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}

	public Card drawCard() {
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}

	public int count() {
		return cards.size();
	}

}
