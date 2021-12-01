package interfaces;

// all variables declared in interfaces are public, static, and final

public interface Series {
	int MAX = 12;
	String ERRORMESSAGE = "Cannot go above value: " + MAX;

	int getNext();

	// keyword "default" lets Java know this interface method can have a body
	default void printStuff() {
		System.out.println("Buy BTC!");
		privateMethodDemo();
	}

	static void printMoreStuff() {
		System.out.println("There will only ever be 21,000,000 BTC");
	}

	private void privateMethodDemo() {
		System.out.println("Interfaces can have private methods!");
	}
}
