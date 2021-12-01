package barChartCreator;

import java.awt.Color;
import java.awt.Graphics;

public class Bar {
	private String label;
	private double value;

	public static final int HEIGHT = 15;

	public Bar(String label, double value) {
		this.label = label;
		this.value = value;
	}

	public void draw(Graphics g, int y, double scale, boolean selected) {
		final int GAP = 2;

		if (selected) {
			g.setColor(Color.RED);
		}

		g.fillRect(0, y, (int) (value * scale), HEIGHT);
		g.setColor(Color.WHITE);
		g.drawString(label, GAP, y + HEIGHT - GAP);
		g.setColor(Color.BLACK);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double newValue) {
		value = newValue;
	}
}
