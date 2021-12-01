package recursion;

import java.util.Scanner;

public class TowersOfHanoi {
	private int totalDisks;
	private long moveNum = 0;
	private boolean verbose;

	public TowersOfHanoi(int disks, boolean v) {
		totalDisks = disks;
		verbose = v;
	}

	public TowersOfHanoi(int disks) {
		this(disks, true);
	}

	public long solve() {
		moveTower(totalDisks, 1, 3, 2);
		return moveNum;
	}

	private void moveTower(int numDisks, int start, int end, int temp) {
		if (numDisks == 1)
			moveOneDisk(start, end);
		else {
			moveTower(numDisks - 1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks - 1, temp, end, start);
		}
	}

	private void moveOneDisk(int start, int end) {
		moveNum++;

		if (verbose)
			System.out.println(moveNum + ": Move one disk from " + start + " to " + end);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("# of disks: ");
		int disks = in.nextInt();
		TowersOfHanoi t = new TowersOfHanoi(disks);

		System.out.println();

		t.solve();
	}
}
