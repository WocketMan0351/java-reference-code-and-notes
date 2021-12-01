package basics;
import java.util.Scanner;

public class Balloon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Diameter (inches): ");
		double diameter = in.nextDouble();
		double radius = diameter / 2.0;
		double volume1 = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		
		System.out.println("Volume (cubic inches): " + volume1);
		
		double diameter2 = diameter + 1;
		double radius2 = diameter2 / 2.0;
		double volume2 = (4.0 / 3.0) * Math.PI * Math.pow(radius2, 3);
		double growth = volume2-volume1;
		
		System.out.println("Increasing diameter by 1 inch...");
		System.out.println("Results in a growth of " + growth);
				
	}
}
