package subClassAndSuperClass;

public class Shoe {
	public final String brand;
	public final double size;

	public Shoe(String brand, double size) {
		this.brand = brand;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shoe [brand=" + brand + ", size=" + size + "]";
	}

}
