package staticVsNonStatic;

public class Car {
	private static int carCount = 0; // static variables are shared by every instance of the Class
	private String color;
	private String model;

	public Car(String color, String model) {
		this.color = color;
		this.model = model;
		carCount++;
	}

	public static int getCount() {
		return carCount;
	}
}
