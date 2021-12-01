package recursion;

public class Triangle {

	private int width;

	public Triangle(int width) {
		this.width = width;
	}

	public int getArea() {
		if (width <= 0) // INVALID INPUT HANDLING
			return 0;
		else if (width == 1) // BASE CASE
			return 1;
		else {
			Triangle smallerTriangle = new Triangle(width - 1); // CONSTRUCTS A SIMPLER OBJECT
			int smallerArea = smallerTriangle.getArea(); // RECURSIVELY CALLS ITSELF UNTIL IT HITS THE BASE CASE
			return smallerArea + width;
		}
	}

	public static void main(String[] args) {
		Triangle t = new Triangle(10);

		long before = System.currentTimeMillis();

		int area = t.getArea();

		long after = System.currentTimeMillis();

		System.out.println("Area: " + area);
		System.out.println("Expected: 55");

		System.out.println();
		System.out.println("Took " + (after - before) + " ms");
	}

}
