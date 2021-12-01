package recursion;

import java.util.ArrayList;

public class Recursives {

	public static void main(String[] args) {
		System.out.println("Recursives - Cody Worthen\n");

		System.out.println("Factors:"); // E13.3
		System.out.printf("   %7d: %s%n", 24, factors(24));
		System.out.printf("   %7d: %s%n", 105, factors(105));
		System.out.printf("   %7d: %s%n%n", 3783780, factors(3783780));

		System.out.println("Binary:"); // E13.4
		System.out.printf("   %7d: %s%n", 24, toBinary(24));
		System.out.printf("   %7d: %s%n", 105, toBinary(105));
		System.out.printf("   %7d: %s%n%n", 3783780, toBinary(3783780));

		System.out.println("Reverse:"); // E13.5
		System.out.printf("   %s: %s%n", "Hello!", reverse("Hello!"));
		System.out.printf("   %s: %s%n", "Madam, I'm Adam", reverse("Madam, I'm Adam"));
		System.out.printf("   %s: %s%n", "amanaplanacanalpanama", reverse("amanaplanacanalpanama"));
		System.out.printf("   %s: %s%n%n", "This is a test of Double Reverse!!",
				reverse(reverse("This is a test of Double Reverse!!")));

		System.out.println("Polygon:"); // E13.12
		ArrayList<Double> points = new ArrayList<Double>();
		points.add(1.0);
		points.add(3.0);
		points.add(1.0);
		points.add(7.0);
		points.add(3.0);
		points.add(9.0);
		points.add(8.0);
		points.add(8.0);
		points.add(9.0);
		points.add(4.0);
		points.add(8.0);
		points.add(1.0);
		points.add(4.0);
		points.add(1.0);
		System.out.printf("   %f%n", polygon(points));
	}

	private static ArrayList<Integer> factors(int n) {
		return factors(n, 2);
	}

	private static ArrayList<Integer> factors(int n, int f) {
		if (n <= 1) {
			return new ArrayList<Integer>();
		} else if (n % f == 0) {
			ArrayList<Integer> factors = factors(n / f, f);
			factors.add(0, f);
			return factors;
		} else {
			return factors(n, f + 1);
		}
	}

	private static String toBinary(int n) {
		if (n <= 0) {
			return "";
		} else if (n % 2 == 0) {
			return toBinary(n / 2) + "0";
		} else {
			return toBinary(n / 2) + "1";
		}
	}

	private static String reverse(String s) {
		if (s.length() <= 1) {
			return s;
		} else {
			return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
		}
	}

	private static double polygon(ArrayList<Double> p) {
		double triangle = (Math.abs(p.get(0) * p.get(3) + p.get(2) * p.get(5) + p.get(4) * p.get(1)
				- p.get(1) * p.get(2) - p.get(3) * p.get(4) - p.get(5) * p.get(0))) / 2.0;

		if (p.size() == 6) {
			return triangle;
		} else {
			p.remove(2);
			p.remove(2);
			return triangle + polygon(p);
		}
	}
}
