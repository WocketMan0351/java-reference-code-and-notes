package cards;

public class Card {
	private String suit;
	private int rank;

	public Card() {
		suit = "";
		rank = 0;

	}

	public void setSuit(String s) {
		suit = s;
	}

	public void setRank(int r) {
		if (r < 1 || r > 13) {
			System.out.println("Bad card rank! I'm making it a 2 instead.");
			rank = 2;
		} else {
			rank = r;
		}
	}

	public String toString() {
		String retVal = rankString(rank) + " of " + suit;
		return retVal;
	}

	private String rankString(int r) {
		switch (r) {
		case 1:
			return "Ace";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		default:
			return Integer.toString(rank);
		}
	}
}
