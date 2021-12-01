package subClassAndSuperClass;

public class Running extends Shoe {
	public final double weight;

	public Running(double weight, String brand, double size) {
		super(brand, size);
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Running [weight=" + weight + "]";
	}

}
