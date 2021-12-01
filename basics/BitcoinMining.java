package basics;

import java.util.Scanner;

public class BitcoinMining {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("BTC currently mined per month: ");
		double minedPerMonth = in.nextDouble();
		
		System.out.print("Months mined: ");
		int months = in.nextInt();
		
		System.out.print("Monthly DA (%): ");
		int dA = in.nextInt();
		double difficultyAdjustment = dA / 100.0;
		
		double totalBTC = 0;
		
		for (int i = 0; i < months; i++) {
			double btc = minedPerMonth * (Math.pow(1 - difficultyAdjustment, i));
			totalBTC += btc;
		}
		
		
		System.out.println();
		System.out.printf("%s %d %s %.3f %s %n", "BTC mined @", months, "month(s):", totalBTC, "BTC");
	}
}
