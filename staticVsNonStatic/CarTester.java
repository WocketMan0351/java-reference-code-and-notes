package staticVsNonStatic;

public class CarTester {

	public static void main(String[] args) {
		System.out.println("There are " + Car.getCount() + " cars.");

		Car a = new Car("Black", "Tacoma");
		Car b = new Car("Blue", "Camry");

		System.out.println("There are " + Car.getCount() + " cars.");
	}

}
