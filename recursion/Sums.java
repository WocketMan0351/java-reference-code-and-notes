package recursion;

import java.util.ArrayList;

public class Sums {
	public static void main(String[] args) {
		int n = 3;
		int target = 6;

		ArrayList<Integer> list = new ArrayList<>();

		findNdigitNums(list, 0, n, target);

		int count = 0;
		for (int solution : list) {
			System.out.printf("%0" + n + "d ", solution);
			count++;
			if (count == 10) {
				System.out.println();
				count = 0;
			}
		}
	}

	public static void findNdigitNums(ArrayList<Integer> l, int result, int n, int target) {
		if (n > 0 && target >= 0)
			for (int d = 0; d <= 9; d++)
				findNdigitNums(l, result * 10 + d, n - 1, target - d);

		else if (n == 0 && target == 0)
			l.add(result);
	}
}