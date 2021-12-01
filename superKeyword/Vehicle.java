package superKeyword;

class Vehicle {
	int maxSpeed = 120;

	Vehicle() {
		System.out.println("Vehicle constructor");
	}

	public void vroom() {
		System.out.println("Vroom Vroom!");
	}
}

class Car extends Vehicle {
	int maxSpeed = 100;

	Car(int maxSpeed) {
		System.out.println("We are in the constructor");
		this.maxSpeed = maxSpeed;
	}

	public void vroom() {
		super.vroom();
	}
}

// super allows us to use methods/variables from the parent class.
// Car extends Vehicle, meaning car is a child of the parent class Vehicle
