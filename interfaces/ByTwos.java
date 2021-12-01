package interfaces;

public class ByTwos implements Series {
	int val;

	public ByTwos() {
		val = 0;
	}

	public int getNext() {
		// val and ERRORMESSAGE are variables define in Series
		if (val >= MAX) {
			System.out.println(ERRORMESSAGE);
		} else {
			val += 2;
		}
		return (val);
	}
}
