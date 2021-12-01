package planet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlanetTester {
	public static ArrayList<Planet> solarSystem = new ArrayList<Planet>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean done = false;

		do {
			System.out.println("Creating a planet...");

			System.out.print("Enter name: ");
			String name = in.next();

			System.out.print("Enter gravity (relative to Earth): ");
			double gravity = in.nextDouble();

			System.out.print("Enter radius (km): ");
			double radius = in.nextDouble();

			System.out.print("Enter mass (10^24 kg): ");
			double mass = in.nextDouble();

			Planet staged = new Planet(name, gravity, radius, mass);
			solarSystem.add(staged);

			System.out.print("Done! New Planet (Y or N): ");
			String answer = in.next();

			if (answer.equalsIgnoreCase("n")) {
				done = true;
			}
		} while (!done);

		double weight = 0;

		try {
			System.out.print("Enter weight on Earth (lbs): ");
			weight = in.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Weight on Earth must be a number!");
			System.out.println("Error. Please restart the program!");
		} finally {
			System.out.println();
		}

		String input = "";

		try {
			System.out.print("Enter min, max, all, or a planet name: ");
			input = in.next();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Answer must be a string!");
			System.out.println("Error. Please restart the program!");
		} finally {
			System.out.println();

		}

		switch (input.toLowerCase()) {
		case "min":
			Planet min = solarSystem.get(0);

			for (int i = 0; i < solarSystem.size(); i++) {
				Planet current = solarSystem.get(i);

				if (current.getGravity() < min.getGravity()) {
					min = solarSystem.get(i);
				}
			}

			double weightOnMin = min.weightOnPlanet(weight);
			System.out.printf("%.2f %s %.2f %s %s %n", weight, "lbs on Earth is", weightOnMin, "lbs on", min.getName());
			break;

		case "max":
			Planet max = solarSystem.get(0);

			for (int i = 0; i < solarSystem.size(); i++) {
				Planet current = solarSystem.get(i);

				if (current.getGravity() > max.getGravity()) {
					max = solarSystem.get(i);
				}
			}

			double weightOnMax = max.weightOnPlanet(weight);
			System.out.printf("%.2f %s %.2f %s %s %n", weight, "lbs on Earth is", weightOnMax, "lbs on", max.getName());
			break;

		case "all":
			System.out.printf("%.2f %s %n", weight, "lbs on Earth:");
			System.out.println();

			int iteration = 0;
			while (iteration < solarSystem.size()) {
				Planet p = solarSystem.get(iteration);
				System.out.printf("%s %15.2f %s %n", p.getName(), p.weightOnPlanet(weight), "lbs");
				iteration++;
			}
			break;

		default:
			for (int i = 0; i < solarSystem.size(); i++) {
				Planet p = solarSystem.get(i);
				String name = p.getName();

				if (input.equalsIgnoreCase(name)) {
					System.out.printf("%.2f %s %.2f %s %s %n", weight, "lbs on Earth is equivalent to",
							p.weightOnPlanet(weight), "lbs on", name);
				}
			}
			break;
		}

		String planetToExamine = "";

		try {
			System.out.print("Enter a planet to examine more closely: ");
			planetToExamine = in.next();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Answer must be a string!");
			System.out.println("Error. Please restart the program!");
		} finally {
			System.out.println();
		}

		for (int i = 0; i < solarSystem.size(); i++) {
			Planet p = solarSystem.get(i);
			String n = p.getName();

			if (planetToExamine.equalsIgnoreCase(n)) {
				System.out.printf("%s %s: %n", "Examining", p.getName());
				System.out.printf("%s %21.2f %s %n", "Radius:", p.getRadius(), "(km)");
				System.out.printf("%s %23.2f %s %n", "Mass:", p.getMass(), "(10^24 kg)");
				System.out.printf("%s %21.2f %s %n", "Volume:", p.volume(), "(km^3)");
				System.out.printf("%s %15.2f %s %n", "Surface Area:", p.surfaceArea(), "(km^2)");
				System.out.printf("%s %15.2f %s %n", "Acceleration:", p.acceleration(), "(m/s)");
			}
		}

		System.out.println("Program complete.");
		in.close();
	}

}
