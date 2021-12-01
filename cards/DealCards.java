package cards;

public class DealCards {

	public static void main(String[] args) {
		Deck d = new Deck();

		d.initialize();
		d.shuffle();

		int numberOfCards = 0;

		while (!d.isEmpty()) {
			Card c = d.drawCard();
			System.out.println("Card: " + c.toString());
			numberOfCards++;
		}

		System.out.println(numberOfCards + " cards^");
	}

}
