package planet;

public class Planet {
	final private double EARTHACCELERATION = 9.81;
	private String name; // name of planet
	private double gravity; // relative to Earth gravity = 1
	private double radius; // km
	private double mass; // kg (scientific notation)

	public Planet(String n, double g, double r, double m) {
		name = n;
		gravity = g;
		radius = r;
		mass = m;
	}

	/**
	 * Gets the name of the planet
	 * 
	 * @return a string
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the gravity of the planet relative to Earth's
	 * 
	 * @return a double
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * Gets the radius of the planet in km
	 * 
	 * @return a double
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * Gets the mass of the planet in kg (scientific notation)
	 * 
	 * @return a double
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * Computes the volume of the planet (assuming spherical)
	 * 
	 * @return a double
	 */
	public double volume() {
		return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}

	/**
	 * Computes the surface area of the planet
	 * 
	 * @return a double
	 */
	public double surfaceArea() {
		return 4.0 * Math.PI * Math.pow(radius, 2);
	}

	/**
	 * Computes the acceleration of gravity on the planet
	 * 
	 * @return a double
	 */
	public double acceleration() {
		return EARTHACCELERATION * gravity;
	}

	/**
	 * Computes the equivalent Earth weight on a planet
	 * 
	 * @param w a double (weight on Earth)
	 * @return a double
	 */
	public double weightOnPlanet(double w) {
		return w * gravity;
	}

	@Override
	public String toString() {
		return "Planet [EARTHACCELERATION=" + EARTHACCELERATION + ", name=" + name + ", gravity=" + gravity
				+ ", radius=" + radius + ", mass=" + mass + "]";
	}

}
