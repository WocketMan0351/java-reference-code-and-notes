package recursion;

public class RecursiveExponent {

	public static void main(String[] args) {
		System.out.println(power(2, 4));
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		} else {
			return x * power(x, n - 1);
		}
	}

}
