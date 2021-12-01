package subClassAndSuperClass;

public class Walking extends Shoe {
	public final boolean goreTex;

	public Walking(boolean goreTex, String brand, double size) {
		super(brand, size); // must create a Shoe object first, since Walking is a subclass of Shoe
		this.goreTex = goreTex;
	}

	@Override
	public String toString() {
		return "Walking [goreTex=" + goreTex + "]";
	}

}
