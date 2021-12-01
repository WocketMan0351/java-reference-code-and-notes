package interfaces;

// inherits everything from Series and also adds a new method getPrev(), declared in SeriesSub interface

public class ByThrees implements SeriesSub {
	int val;

	public ByThrees() {
		val = 0;
	}

	public int getNext() {
		val += 3;
		return val;
	}

	public void printStuff() {
		System.out.println("ByThree's printStuff() method (overriding)");
	}

	public int getPrev() {
		val -= 3;
		return val;
	}
}
