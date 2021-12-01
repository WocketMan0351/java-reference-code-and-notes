package arrays;
import java.util.Scanner;
import java.util.Arrays;

public class BTC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter year to calculate BTC supply: ");
		int year = in.nextInt();
		int size = (year - 2008) / 4;
		size += 1;
		
		double[] blockRewards = new double[size];
		for(int i = 0; i < blockRewards.length; i++) {
			blockRewards[i] = 50 * (Math.pow(0.5, i));
		}
		
		int[] years = new int[size];
		int counter = 2008;
		for (int i = 0; i < years.length; i++) {
			years[i] = counter;
			counter += 4;
		}
		
		double perDay = 7200;
		double[] btcPerDay = new double[size];
		for (int i = 0; i < btcPerDay.length; i++) {
			btcPerDay[i] = perDay;
			perDay = perDay * 0.5;
		}
		
		double[] endPercent = new double[size];
		for (int i = 0; i < endPercent.length; i++) {
			if (i - 1 >= 0) {
				endPercent[i] = 100 - blockRewards[i - 1];
			}
		}
		
		double[] lows = new double[size];
		lows[0] = 0;
		lows[1] = 2;
		lows[2] = 3150;
		lows[3] = 3750;
		
		double[] highs = new double[size];
		highs[0] = 32;
		highs[1] = 1150;
		highs[2] = 20000;
		highs[3] = 64999;
		
	    System.out.printf("%s %15s %12s %10s %9s %11s%n", "Year", "Block Reward","BTC per day", "% mined", "Low", "High");   
		
		for (int i = 0; i < blockRewards.length; i++) {
			System.out.printf("%d %12.2f %13.2f %11.2f %11.2f %11.2f %n", years[i], blockRewards[i], btcPerDay[i], endPercent[i], lows[i], highs[i]);
		}
	}
}
