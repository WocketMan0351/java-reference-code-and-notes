package comparableInterface;

public class Country implements Comparable {
	private String name;
	private double area;

	public Country(String name, double area) {
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public double getArea() {
		return area;
	}

	public int compareTo(Object otherObject) {
		Country other = (Country) otherObject;
		if (area < other.area)
			return -1;
		else if (area == other.area)
			return 0;
		else
			return 1;
	}

	public String toString() {
		return getClass().getName() + "Country [name=" + name + ", area=" + area + "]";
	}
}
